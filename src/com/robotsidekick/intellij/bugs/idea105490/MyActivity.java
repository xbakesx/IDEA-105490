package com.robotsidekick.intellij.bugs.idea105490;

import android.app.Activity;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MyActivity extends Activity
{
    private static final String TAG = MyActivity.class.getSimpleName();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.e(TAG, "drawable: " + getResources().getDrawable(R.drawable.android_button).getClass().getSimpleName());

        LayerDrawable layers = (LayerDrawable) getResources().getDrawable(R.drawable.android_button);
        layers.setDrawableByLayerId(R.id.unread_count_text, new TextDrawable(this, "10+"));
        ((ImageButton) findViewById(R.id.android_image_button)).setImageDrawable(layers);

    }
}
