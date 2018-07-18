package com.forevc.hongbao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ChartView extends View {

    public ChartView(Context context) {
        super(context);
    }

    public ChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth() - 20;
        int height = canvas.getHeight() - 20;

        Paint paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);

        canvas.drawCircle(10, height-30, 10, paint);
        canvas.drawCircle(width/4, 3*height /4, 10, paint);
        canvas.drawCircle(2*width/4, 2*height /4, 10, paint);
        canvas.drawCircle(3*width/4, height /4, 10, paint);
        canvas.drawCircle(width-10, 10, 10, paint);

        canvas.drawLine(10, height-30, width/4, 3*height/4, paint);

        paint.setTextSize(40);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawText("7.15", 50, height-30, paint);
        canvas.drawText("7.16", width/4, height-30, paint);
        canvas.drawText("7.17", 2*width/4, height-30, paint);
        canvas.drawText("7.18", 3*width/4, height-30, paint);
        canvas.drawText("7.19", width-100, height-30, paint);
    }

}








