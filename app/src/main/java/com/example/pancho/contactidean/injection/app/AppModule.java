package com.example.pancho.contactidean.injection.app;

import android.app.Application;

import com.example.pancho.contactidean.entities.DaoMaster;
import com.example.pancho.contactidean.entities.DaoSession;
import com.example.pancho.contactidean.model.local.DbOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.example.pancho.contactidean.util.CONSTANTS.DB_NAME;


/**
 * Created by Francisco on 10/18/2017.
 */

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application providesApp(){
        return application;
    }

    @Singleton
    @Provides
    DaoSession providesDAO(){
        return new DaoMaster(new DbOpenHelper(application, DB_NAME).getWritableDb()).newSession();
    }

}
