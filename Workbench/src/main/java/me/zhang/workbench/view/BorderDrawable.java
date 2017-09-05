package me.zhang.workbench.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * Created by Zhang on 9/5/2017 7:21 PM.
 */
public class BorderDrawable extends Drawable {

    private Paint mPaint;
    private int mColor;
    private int mBorderWidth;
    private int mBorderRadius;

    private RectF mRectF;
    private Path mPath;

    public BorderDrawable(int color, int borderWidth, int borderRadius) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);

        mPath = new Path();
        mPath.setFillType(Path.FillType.EVEN_ODD);

        mRectF = new RectF();

        mColor = color;
        mBorderWidth = borderWidth;
        mBorderRadius = borderRadius;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mPath.reset();

        mPath.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Path.Direction.CW);
        mRectF.set(bounds.left + mBorderWidth, bounds.top + mBorderWidth,
                bounds.right - mBorderWidth, bounds.bottom - mBorderWidth);
        mPath.addRoundRect(mRectF, mBorderRadius, mBorderRadius, Path.Direction.CW);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        mPaint.setColor(mColor);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

}
