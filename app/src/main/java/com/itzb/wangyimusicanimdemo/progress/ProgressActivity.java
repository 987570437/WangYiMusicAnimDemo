package com.itzb.wangyimusicanimdemo.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyProgress(this));
    }
}
