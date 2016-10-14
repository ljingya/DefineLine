package com.example.shuiai.defineline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author shuiai@dianjia.io
 * @Company 杭州木瓜科技有限公司
 * @date 2016/10/14
 */

public class DefineLineView extends View {
    /**
     * view的宽
     */
    private int width;
    /**
     * View的高
     */
    private int height;
    /**
     * 存放Y轴文字的数组
     */
    private String[] textY;
    /**
     * 存放X轴文字的数组
     */
    private String[] textX;
    /**
     * 文字大小
     */
    private float textFontSize = 20;

    public DefineLineView(Context context) {
        super(context);
    }

    public DefineLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DefineLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (MeasureSpec.EXACTLY == widthMode) {
            width = widthSize;
        } else {
            throw new IllegalArgumentException("width is exactly mode！");
        }
        if (MeasureSpec.EXACTLY == heightMode) {
            height = heightSize;
        } else {
            throw new IllegalArgumentException("height is exactly mode！");
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mPaint = new Paint();
        mPaint.setTextSize(textFontSize);
        mPaint.setColor(Color.RED);
        /**
         * 画Y轴
         */
        int[] pointY = new int[textY.length];//保存y轴文字的坐标
        //计算每个刻度的间距
        int discY = (int) ((height - textFontSize * textY.length) / textY.length);
        //测量文字的高度
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        int yheight = (int) Math.ceil(fm.descent - fm.ascent);
        for (int i = 0; i < textY.length; i++) {
            canvas.drawText(textY[i], 0, discY * i + yheight, mPaint);
            pointY[i] =discY * i + yheight;
        }
        /**
         * 画X轴
         */

    }

    public void setTextY(String[] textY) {
        this.textY = textY;
    }
}
