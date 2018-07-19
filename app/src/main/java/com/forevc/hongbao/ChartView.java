package com.forevc.hongbao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.forevc.util.DateUtil;
import com.forevc.util.NumUtil;

import java.nio.FloatBuffer;

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

        final int padding = 80;

        int width = canvas.getWidth() - 2*padding;
        int height = canvas.getHeight() - padding;

        // 最低点坐标
        float bottom_y = canvas.getHeight() - 30;

        // 圆点和直线x坐标
        float x1 = padding;
        float x2 = width/4 + padding;
        float x3 = 2*width/4 + padding;
        float x4 = 3*width/4 + padding;
        float x5 = width + padding;

        // 获取最新股价
        float[] price = new float[5];
        price[0] = 0.125665f;
        price[1] = 0.135675f;
        price[2] = 0.135765f;
        price[3] = 0.256665f;
        price[4] = 0.565665f;

        float maxPrice = NumUtil.max(price);
        float minPrice = NumUtil.min(price);
        float totalLength = maxPrice - minPrice;

        // y坐标
        float y1 = height - 30 - (height-padding) * (price[0] - minPrice)/totalLength;
        float y2 = height - 30 - (height-padding) * (price[1] - minPrice)/totalLength;
        float y3 = height - 30 - (height-padding) * (price[2] - minPrice)/totalLength;
        float y4 = height - 30 - (height-padding) * (price[3] - minPrice)/totalLength;
        float y5 = height - 30 - (height-padding) * (price[4] - minPrice)/totalLength;

        // 设置画笔
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);

        canvas.drawCircle(x1, y1, 6, paint);
        canvas.drawCircle(x2, y2, 6, paint);
        canvas.drawCircle(x3, y3, 6, paint);
        canvas.drawCircle(x4, y4, 6, paint);
        canvas.drawCircle(x5, y5, 6, paint);

        canvas.drawLine(x1, y1, x2, y2, paint);
        canvas.drawLine(x2, y2, x3, y3, paint);
        canvas.drawLine(x3, y3, x4, y4, paint);
        canvas.drawLine(x4, y4, x5, y5, paint);

        // 添加文字
        paint.setTextSize(40);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawText(DateUtil.today(-4), x1 - padding/2, bottom_y, paint);
        canvas.drawText(DateUtil.today(-3), x2 - padding/2, bottom_y, paint);
        canvas.drawText(DateUtil.today(-2), x3 - padding/2, bottom_y, paint);
        canvas.drawText(DateUtil.today(-1), x4 - padding/2, bottom_y, paint);
        canvas.drawText(DateUtil.today(0), x5 - padding/2, bottom_y, paint);

        canvas.drawText(Float.toString(price[0]), x1 - 80, y1 - 20, paint);
        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(Float.toString(price[4]), x5, y5 - 10, paint);
    }

}








