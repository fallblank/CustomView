package com.github.fallblank.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

/**
 * Created by fallb on 2015/11/24.
 */
public class Circle extends View {

    private int mColor;
    private Context mContext;
    private float mRadius;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.Circle,0,0);
        try {
            //
            mColor = a.getColor(R.styleable.Circle_background_color,0x000000);
            mRadius = a.getDimension(R.styleable.Circle_radius,16);
        }finally {
            a.recycle();
        }
    }

    public void addSide() {
        mRadius+=5.0;
        invalidate();
        requestLayout();
    }

    public void subSide(){
        if (mRadius>=5.0){
            mRadius-=5.0;
            invalidate();
            requestLayout();
        }else {
            Toast.makeText(mContext,"smaller enough!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(mColor);
        canvas.drawCircle(0,0,mRadius,paint);
    }
}
