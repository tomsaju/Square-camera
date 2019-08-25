package com.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.camera2.sample.R;
import com.rd.PageIndicatorView;

import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity {

    private DemoInfiniteAdapter adapter;
    private LoopingViewPager viewPager;
    private PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        viewPager = findViewById(R.id.viewpager);
        ArrayList<Integer> datalist = new ArrayList<>();
        datalist.add(R.drawable.image1);
        datalist.add(R.drawable.image2);
        datalist.add(R.drawable.image3);
        adapter = new DemoInfiniteAdapter(this, datalist, true);
        viewPager.setAdapter(adapter);

         pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(viewPager.getIndicatorCount());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       //pass the lifecycle to make the slider aware of lifecycle to avoid memory leak and handling the pause/destroy/resume
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewPager.resumeAutoScroll();
    }

    @Override
    protected void onPause() {
        viewPager.pauseAutoScroll();
        super.onPause();
    }
}
