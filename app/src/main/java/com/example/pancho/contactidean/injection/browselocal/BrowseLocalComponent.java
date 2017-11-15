package com.example.pancho.contactidean.injection.browselocal;

import com.example.pancho.contactidean.injection.CustomScope;
import com.example.pancho.contactidean.injection.sharedpreferences.SharedPreferencesComponent;
import com.example.pancho.contactidean.view.browselocal.BrowseLocalView;

import dagger.Component;

@CustomScope
@Component(dependencies = SharedPreferencesComponent.class,modules = BrowseLocalModule.class)
public interface BrowseLocalComponent {

    void inject(BrowseLocalView browseLocalView);

}
