package com.example.pancho.contactidean.injection.viewmodel;

import com.example.pancho.contactidean.model.remote.Remote;
import com.example.pancho.contactidean.view.ViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Francisco on 10/18/2017.
 */

@Module
public class ViewModelModule {

    private ViewModel viewModel;

    public ViewModelModule(ViewModel mainPresenter) {
        this.viewModel = mainPresenter;
    }

    @Provides
    Remote providesRemote(){

        return new Remote(viewModel);
    }
}
