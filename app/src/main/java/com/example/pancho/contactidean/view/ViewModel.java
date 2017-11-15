package com.example.pancho.contactidean.view;

import com.example.pancho.contactidean.entities.DaoSession;
import com.example.pancho.contactidean.entities.RandomUser;
import com.example.pancho.contactidean.entities.User;
import com.example.pancho.contactidean.entities.UserDao;
import com.example.pancho.contactidean.injection.remote.RemoteModule;
import com.example.pancho.contactidean.injection.viewmodel.DaggerViewModelComponent;
import com.example.pancho.contactidean.injection.viewmodel.ViewModelModule;
import com.example.pancho.contactidean.model.remote.IRemote;
import com.example.pancho.contactidean.model.remote.Remote;

import org.greenrobot.greendao.query.DeleteQuery;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Pancho on 11/10/2017.
 */

public class ViewModel implements Contract.ViewModel, IRemote {
    private Contract.View view;

    @Inject
    public Remote remote;

    @Inject
    public Retrofit retrofit;

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void attachRemote(){
        DaggerViewModelComponent
                .builder()
                .viewModelModule(new ViewModelModule(this))
                .remoteModule(new RemoteModule())
                .build()
                .insert(this);
    }

    @Override
    public void FetchRandomUser() {
        remote.getRandomUserObs(retrofit);
    }

    @Override
    public void sendCall(Call<RandomUser> call) {

    }

    @Override
    public void sendObservable(Observable<RandomUser> randomObservable) {
        randomObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<RandomUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RandomUser value) {
                        User user = new User(value.getResults().get(0).getPicture().getLarge(),value.getResults().get(0).getName().getFirst() + " " + value.getResults().get(0).getName().getLast(),value.getResults().get(0).getEmail(),value.getResults().get(0).getPhone());
                        view.sendInfo(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /**
     * Make a query to verify if the name exists
     *      If exists then it means that it has a like
     **/
    @Override
    public void localquery(DaoSession daoSession, User user) {
        view.sendResult(daoSession.queryBuilder(User.class)
                .where(UserDao.Properties.Name.eq(user.getName()))
                .list());
    }

    /**
     * Verify if the element is checked or not to add/remove it from the db
     **/
    @Override
    public void saveChecked(DaoSession daoSession, boolean checked, User user) {
        if(checked)
            daoSession.insert(user);
        else {
            final DeleteQuery<User> tableDeleteQuery = daoSession.queryBuilder(User.class)
                    .where(UserDao.Properties.Name.eq(user.getName()))
                    .buildDelete();
            tableDeleteQuery.executeDeleteWithoutDetachingEntities();
            daoSession.clear();
        }
    }

    @Override
    public void getUsers(DaoSession daoSession) {
        List<User> users = daoSession.loadAll(User.class);
        view.sendUsers(users);
    }
}
