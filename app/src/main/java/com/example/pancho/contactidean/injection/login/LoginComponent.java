package com.example.pancho.contactidean.injection.login;

import com.example.pancho.contactidean.view.login.LoginView;

import dagger.Component;

@Component(modules = LoginModule.class)  //@Component(modules = 1.class,2.class) separated by commas for 2 or more modules
public interface LoginComponent {

    void inject(LoginView loginView);

}
