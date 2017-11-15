package com.example.pancho.contactidean.model.remote;

import com.example.pancho.contactidean.entities.RandomUser;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import static com.example.pancho.contactidean.util.CONSTANTS.PATH;

/**
 * Created by Francisco on 10/18/2017.
 */

public class Remote {

    private static final String TAG = "Remote";
    private IRemote iremote;

    public Remote(IRemote iremote){
        this.iremote = iremote;
    }


    /** Get remote data using retrofit call */
    //Receive user if we want to search a user here
    public void getRandomUserCall(Retrofit retrofit){
        IResponse iResponse = retrofit.create(IResponse.class);
        iremote.sendCall(iResponse.getSeatGeekdata());
    }

    /** Get remote data using rxjava observable */
    public void getRandomUserObs(Retrofit retrofit){
        IResponse iResponse = retrofit.create(IResponse.class);
        iremote.sendObservable(iResponse.getSeatGeekObservable());
    }

    public interface IResponse{

        @GET(PATH)
        Call<RandomUser> getSeatGeekdata();

        @GET(PATH)
        Observable<RandomUser> getSeatGeekObservable();

    }
}
