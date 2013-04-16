package com.robotsidekick.intellij.bugs.idea105490;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/**
 * Created with IntelliJ IDEA.
 * User: alex
 * Date: 4/16/13
 * Time: 12:18 PM
 */
public class TextDrawable extends Drawable
{
    private static final String TAG = TextDrawable.class.getSimpleName();

    private final String text;
    private final float offsetX;
    private final float offsetY;
    private final Paint paint;

    public TextDrawable(final Context context, final String text) {

        this.text = text;

        this.paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(20f);
        paint.setAntiAlias(true);
        paint.setFakeBoldText(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);


        offsetY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, context.getResources().getDisplayMetrics());
        offsetX = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 13, context.getResources().getDisplayMetrics());
    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawText(text, canvas.getClipBounds().right - offsetX, canvas.getClipBounds().top + offsetY, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}