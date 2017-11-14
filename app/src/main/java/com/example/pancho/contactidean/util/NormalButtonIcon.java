package com.example.pancho.contactidean.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class NormalButtonIcon extends android.support.v7.widget.AppCompatButton {

    public NormalButtonIcon(Context context) {
        super(context);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fontawesome.ttf");
        setTypeface(tf);
    }

    public NormalButtonIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fontawesome.ttf");
        setTypeface(tf);
    }

    public NormalButtonIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fontawesome.ttf");
        setTypeface(tf);
    }


}
