package com.example.pancho.contactidean.injection.viewmodel;

import com.example.pancho.contactidean.injection.remote.RemoteModule;
import com.example.pancho.contactidean.view.ViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Francisco on 10/18/2017.
 */

@Singleton
@Component(modules = {ViewModelModule.class, RemoteModule.class} )
public interface ViewModelComponent {

    void insert(ViewModel mainPresenter);
}
