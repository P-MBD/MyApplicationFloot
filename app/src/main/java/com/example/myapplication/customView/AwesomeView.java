package com.example.myapplication.customView;

import android.content.Context;
import android.graphics.Typeface;

import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by Android on 3/8/2018.
 */

public class AwesomeView extends AppCompatTextView {
    public AwesomeView(Context context) {
        super(context);
        setView(context);
    }

    public AwesomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);
    }

    public AwesomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);
    }

   void setView(Context context){
       Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/fontawesome-webfont.ttf");
       setTypeface(typeface);
   }

}
