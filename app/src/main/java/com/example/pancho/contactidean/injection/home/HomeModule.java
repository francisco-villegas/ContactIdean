package com.example.pancho.contactidean.injection.home;

import com.example.pancho.contactidean.view.ViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    ViewModel providesViewModel(){

        return new ViewModel();
    }
}
