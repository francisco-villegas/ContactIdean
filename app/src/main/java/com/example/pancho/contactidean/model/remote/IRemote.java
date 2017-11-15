package com.example.pancho.contactidean.model.remote;

import com.example.pancho.contactidean.entities.RandomUser;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by Francisco on 10/18/2017.
 */

public interface IRemote {

    void sendCall(Call<RandomUser> call);

    void sendObservable(Observable<RandomUser> randomObservable);
}
