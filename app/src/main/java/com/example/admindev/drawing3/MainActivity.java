package com.example.admindev.drawing3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.width;


public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button btnAddPhoto,btnEdit;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // imageView=(ImageView)findViewById(R.id.pic2)

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.download);
       // bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(30);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        ImageView imageView = (ImageView) findViewById(R.id.pic2);

        bitmap = Bitmap.createScaledBitmap(bitmap, imageView.getWidth(), imageView.getHeight(), true);
        Bitmap mutableBitmap= bitmap.copy(Bitmap.Config.ARGB_8888,true);
        canvas = new Canvas(mutableBitmap);
        canvas.drawBitmap(mutableBitmap, 0, 0, null);
        canvas.drawCircle(100, 100, 100, paint);
        imageView.setImageBitmap(mutableBitmap);

    }

 


}

