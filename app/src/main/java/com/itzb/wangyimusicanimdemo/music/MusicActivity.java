package com.itzb.wangyimusicanimdemo.music;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.itzb.wangyimusicanimdemo.R;
import com.itzb.wangyimusicanimdemo.music.view.BackgourndAnimationRelativeLayout;
import com.itzb.wangyimusicanimdemo.music.view.DiscView;

import java.util.ArrayList;
import java.util.List;

public class MusicActivity extends AppCompatActivity implements DiscView.MusicLitener {

    private List<Integer> mMusicDatas = new ArrayList<>();
    private BackgourndAnimationRelativeLayout backgourndAnimationRelativeLayout;
    DiscView mDisc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        mDisc = (DiscView) findViewById(R.id.discview);
        mDisc.setMusicLitener(this);
        backgourndAnimationRelativeLayout = findViewById(R.id.rootLayout);
        mMusicDatas.add(R.drawable.ic_music1);
        mMusicDatas.add(R.drawable.ic_music2);
        mMusicDatas.add(R.drawable.ic_music3);
        mMusicDatas.add(R.drawable.ic_music1);
        mMusicDatas.add(R.drawable.ic_music2);
        mMusicDatas.add(R.drawable.ic_music3);
        mMusicDatas.add(R.drawable.ic_music1);
        mMusicDatas.add(R.drawable.ic_music2);
        mMusicDatas.add(R.drawable.ic_music3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDisc.setMusicDataList(mMusicDatas);
    }

    @Override
    public void onMusicPicChanged(int redID) {

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), redID), 10, 10, true);
        Bitmap blurBitmap = BitmapUtil.blur(this,scaledBitmap , 1);

//        for (int i = 0; i < 100; i++) {
//            blurBitmap = BitmapUtil.blur(this, blurBitmap, 25);
//        }

        Glide.with(this)
                .load(blurBitmap)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        backgourndAnimationRelativeLayout.setForeground(resource);
                    }
                });
    }
}
