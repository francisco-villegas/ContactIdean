package com.example.pancho.contactidean.view;

import com.example.pancho.contactidean.BasePresenter;
import com.example.pancho.contactidean.BaseView;

/**
 * Created by Pancho on 11/10/2017.
 */

public interface Contract {

    interface View extends BaseView {


    }

    interface ViewModel extends BasePresenter<View> {

    }
}
