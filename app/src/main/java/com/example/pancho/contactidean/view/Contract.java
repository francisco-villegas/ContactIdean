package com.example.pancho.contactidean.view;

import com.example.pancho.contactidean.BasePresenter;
import com.example.pancho.contactidean.BaseView;
import com.example.pancho.contactidean.entities.DaoSession;
import com.example.pancho.contactidean.entities.User;

import java.util.List;

/**
 * Created by Pancho on 11/10/2017.
 */

public interface Contract {

    interface View extends BaseView {

        void sendInfo(User user);

        void sendResult(List<User> list);

        void sendUsers(List<User> users);
    }

    interface ViewModel extends BasePresenter<View> {

        void attachRemote();

        void FetchRandomUser();

        void localquery(DaoSession daoSession, User user);

        void saveChecked(DaoSession daoSession, boolean buttonState, User user);

        void getUsers(DaoSession daoSession);
    }
}
