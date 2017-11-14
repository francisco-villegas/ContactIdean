package com.example.pancho.contactidean.view;

/**
 * Created by Pancho on 11/10/2017.
 */

public class ViewModel implements Contract.ViewModel {
    private Contract.View view;

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
