package com.example.viewpageerrordemo;

import android.os.Bundle;
import android.view.View;

import com.example.viewpageerrordemo.ui.main.PlaceholderFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.viewpageerrordemo.ui.main.SectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/***
 * 同一fragemnt多实例化结合viewpage Demo
 *
 * @Create by shay
 * @Date 2020.12.10*/
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager());
        //添加
        for (int i = 0; i < 9; i++){

            sectionsPagerAdapter.addFragment(PlaceholderFragment.newInstance(i));
        }

        //预加载页数量
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "悬浮按钮", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}