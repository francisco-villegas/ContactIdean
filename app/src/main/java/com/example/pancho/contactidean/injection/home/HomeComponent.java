package com.example.pancho.contactidean.injection.home;

import com.example.pancho.contactidean.injection.CustomScope;
import com.example.pancho.contactidean.injection.sharedpreferences.SharedPreferencesComponent;
import com.example.pancho.contactidean.view.home.HomeView;

import dagger.Component;

@CustomScope
@Component(dependencies = SharedPreferencesComponent.class,modules = HomeModule.class)  //@Component(modules = 1.class,2.class) separated by commas for 2 or more modules
public interface HomeComponent {

    void inject(HomeView homeView);

}
