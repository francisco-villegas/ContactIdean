package com.example.pancho.contactidean.model.remote;

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
//    public void getSeatGeekCall(Retrofit retrofit, String query){
//        IResponse iResponse = retrofit.create(IResponse.class);
//        iremote.sendCall(iResponse.getSeatGeekdata(CLIENT_ID, CLIENT_SECRET, query));
//    }
//
//    /** Get remote data using rxjava observable */
//    public void getSeatGeekObs(Retrofit retrofit, String query){
//        IResponse iResponse = retrofit.create(IResponse.class);
//        iremote.sendObservable(iResponse.getSeatGeekObservable(CLIENT_ID, CLIENT_SECRET, query));
//    }

//    public interface IResponse{
//
//        @GET(PATH)
//        Call<SeatGeek> getSeatGeekdata(@Query(CLIENT_ID_WORD) String CLIENT_ID, @Query(CLIENT_SECRET_WORD) String CLIENT_SECRET, @Query(Q_WORD) String query);
//
//        @GET(PATH)
//        Observable<SeatGeek> getSeatGeekObservable(@Query(CLIENT_ID_WORD) String CLIENT_ID, @Query(CLIENT_SECRET_WORD) String CLIENT_SECRET, @Query(Q_WORD) String query);
//
//    }
}
