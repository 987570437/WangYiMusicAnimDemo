package com.itzb.wangyimusicanimdemo.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyProgress extends View {
    private Context mContext;
    private Paint mPaint;
    private Path mPath;
    private PathMeasure mPathMeasure;
    private float mLength;
    private float mAnimatorValue;
    private Path dst;

    public MyProgress(Context context) {
        this(context, null);
    }

    public MyProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        //画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#FF4081"));
        mPaint.setStrokeWidth(10f);
        mPaint.setStyle(Paint.Style.STROKE);
        //Path
        dst = new Path();
        mPath = new Path();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mPath.addCircle(getWidth()/2, getWidth()/2, getWidth()/4, Path.Direction.CW);//加入一个半径为100圆

        mPathMeasure = new PathMeasure(mPath, true);
        mLength = mPathMeasure.getLength();

        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.addUpdateListener(animation -> {
            mAnimatorValue = (float) animation.getAnimatedValue();
            invalidate();
        });
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        dst.reset();
        float distance = mLength * mAnimatorValue;
//        distance     start  disant -0
        float start = (float) (distance - ((0.5 - Math.abs(mAnimatorValue - 0.5)) * mLength));
//   ( distance-0.5*mLength)   start   distance
//mPath  1  dst  2
        mPathMeasure.getSegment(start, distance, dst, true);
        canvas.drawPath(dst, mPaint);
    }
}
