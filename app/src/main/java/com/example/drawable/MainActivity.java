package com.example.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }

    private class CustomView extends View {
        public CustomView(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas) {
            int width = getWidth();
            int height = getHeight();

            ShapeDrawable rect= new ShapeDrawable(new RectShape());
//            rect.setBounds(width/6, height/4,width*5/6, height*5/6);
            rect.setBounds(width/6, height/8, width*5/6, height*2/8);
            rect.getPaint().setColor(Color.GRAY);
            rect.draw(canvas);

            GradientDrawable circle = (GradientDrawable) getResources().getDrawable(R.drawable.circle);
//            circle.setBounds(width/4, height/4, width*3/4, height*3/4);
            circle.setBounds(width/6, height/2, width*5/6, height);
            circle.draw(canvas);

            BitmapDrawable bmp = (BitmapDrawable) getResources().getDrawable(R.drawable.icon_128);
            int bmpWidth = bmp.getIntrinsicWidth();
            int bmpHeight = bmp.getIntrinsicHeight();
            bmp.setBounds((width - bmpWidth)/2, (height - bmpHeight)/2,(width + bmpWidth)/2,(height - bmpHeight)/2 + bmpHeight);
            bmp.draw(canvas);

            Paint textPaint = new Paint();
            textPaint.setColor(Color.RED);
            textPaint.setTextSize(120);
            textPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("BMI", width/2, height*1/5, textPaint);
        }
    }
}