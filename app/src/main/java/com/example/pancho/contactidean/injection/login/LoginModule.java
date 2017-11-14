package com.example.pancho.contactidean.injection.login;

import com.example.pancho.contactidean.view.ViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    ViewModel providesViewModel(){

        return new ViewModel();
    }
}
