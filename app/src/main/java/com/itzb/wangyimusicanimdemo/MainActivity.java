package com.itzb.wangyimusicanimdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.itzb.wangyimusicanimdemo.music.MusicActivity;
import com.itzb.wangyimusicanimdemo.progress.ProgressActivity;
import com.itzb.wangyimusicanimdemo.ripple.RippleActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_ripple).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, RippleActivity.class)));
        findViewById(R.id.bt_loading).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, ProgressActivity.class)));
        findViewById(R.id.bt_music).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, MusicActivity.class)));

    }
}
