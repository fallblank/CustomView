package com.github.fallblank.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button larger,smaller;
    Circle circle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle = (Circle) findViewById(R.id.circle);
        larger = (Button) findViewById(R.id.btn_larger);
        larger.setOnClickListener(this);
        smaller = (Button) findViewById(R.id.btn_smaller);
        smaller.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_larger:
                circle.addSide();
                break;
            case R.id.btn_smaller:
                circle.subSide();
                break;
            default:
                break;
        }
    }
}
