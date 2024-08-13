package com.example.myapplication.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by Android on 3/8/2018.
 */

public class PersianTextView extends AppCompatTextView {


    public PersianTextView(Context context) {
        super(context);
        setFont(context);
    }

    public PersianTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public PersianTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context) {

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/BYekan.ttf");
        setTypeface(typeface);


    }
}
