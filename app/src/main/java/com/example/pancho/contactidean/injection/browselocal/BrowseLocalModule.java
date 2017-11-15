package com.example.pancho.contactidean.injection.browselocal;

import com.example.pancho.contactidean.view.ViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class BrowseLocalModule {

    @Provides
    ViewModel providesViewModel(){

        return new ViewModel();
    }
}
