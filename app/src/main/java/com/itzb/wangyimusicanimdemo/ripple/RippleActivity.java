package com.itzb.wangyimusicanimdemo.ripple;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.itzb.wangyimusicanimdemo.R;

public class RippleActivity extends AppCompatActivity {

    private ImageView imageView;
    RippleAnimationView rippleAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);
        imageView = (ImageView) findViewById(R.id.ImageView);
        rippleAnimationView = (RippleAnimationView) findViewById(R.id.layout_RippleAnimation);

        imageView.setOnClickListener(view -> {
            if (rippleAnimationView.isAnimationRunning()) {
                rippleAnimationView.stopRippleAnimation();
            } else {
                rippleAnimationView.startRippleAnimation();
            }
        });

    }
}
