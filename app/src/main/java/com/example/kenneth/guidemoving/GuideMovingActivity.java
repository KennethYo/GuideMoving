package com.example.kenneth.guidemoving;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class GuideMovingActivity extends FragmentActivity {

    private ViewPager vp_guide;
    private LinearLayout ll_dots;
    private View btn_go_start;
    private CarAnimView iv_car;
    private GuideFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guide_moving);

        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        ll_dots = (LinearLayout) findViewById(R.id.ll_dots);
        btn_go_start = findViewById(R.id.btn_go_start);
        iv_car = (CarAnimView) findViewById(R.id.iv_car);

        adapter = new GuideFragmentAdapter(getSupportFragmentManager());
        initDots(adapter.getCount());
        vp_guide.setAdapter(adapter);

        vp_guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                for (int i = 0; i < ll_dots.getChildCount(); i++) {
                    if (i == arg0) {
                        ll_dots.getChildAt(i).setSelected(true);
                    } else {
                        ll_dots.getChildAt(i).setSelected(false);
                    }
                }
                // 最后一页显示立即开始
                if (arg0 == (adapter.getCount() - 1)) {
                    btn_go_start.setVisibility(View.VISIBLE);
                } else {
                    btn_go_start.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                iv_car.onPageScrolled(adapter.getCount(), arg0, arg1);
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /** 初始化指示器 */
    private void initDots(int count) {
        for (int j = 0; j < count; j++) {
            ll_dots.addView(LayoutInflater.from(getApplicationContext()).inflate(
                    R.layout.layout_dot, null));
        }
        ll_dots.getChildAt(0).setSelected(true);
    }
}
