package com.example.isys.encontraunir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AberturaActivity extends AppCompatActivity implements Runnable{

    Thread thread;
    Handler handler;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        handler = new Handler();
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run(){
        i= 1;

        try {
            while (i<150){ //tempo de abertura
                Thread.sleep(15);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        i++; //progress bar se tiver
                    }
                });
            }

        }catch (Exception e){

        }
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }
}
