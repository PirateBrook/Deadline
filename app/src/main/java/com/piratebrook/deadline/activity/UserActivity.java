/*
 * Copyright (c) 2017.
 * Create by PirateBrook 2017 / 17-12-18 下午4:32
 * Last Modified 17-12-18 下午4:32
 *
 */

package com.piratebrook.deadline.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.piratebrook.deadline.R;
import com.piratebrook.deadline.anim.SimpleItemAnimator;
import com.piratebrook.deadline.base.AppBaseActivity;
import com.piratebrook.deadline.dto.UserEvent;
import com.piratebrook.sdk.widget.fly.FlyRefreshLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wyy on 2017-12-18.
 */

public class UserActivity extends AppBaseActivity implements FlyRefreshLayout.OnPullRefreshListener {

    private FlyRefreshLayout mFlyLayout;
    private RecyclerView mListView;

    private ItemAdapter mAdapter;

    private ArrayList<UserEvent> mUserEvents = new ArrayList<>();
    private Handler mHandler = new Handler();
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataSet();
        setContentView(R.layout.activity_user);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mFlyLayout = (FlyRefreshLayout) findViewById(R.id.fly_layout);

        mFlyLayout.setOnPullRefreshListener(this);

        mListView = (RecyclerView) findViewById(R.id.list);

        mLayoutManager = new LinearLayoutManager(this);
        mListView.setLayoutManager(mLayoutManager);
        mAdapter = new ItemAdapter(this);

        mListView.setAdapter(mAdapter);

        mListView.setItemAnimator(new SimpleItemAnimator());

        View actionButton = mFlyLayout.getHeaderActionButton();
        if (actionButton != null) {
            actionButton.setOnClickListener(v -> mFlyLayout.startRefresh());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initDataSet() {
        mUserEvents.add(new UserEvent(
                Color.parseColor("#76A9FC"),
                R.mipmap.ic_assessment_white_24dp,
                "Meeting Minutes",
                new Date(2014 - 1900, 2, 9)));
        mUserEvents.add(new UserEvent(
                Color.GRAY,
                R.mipmap.ic_folder_white_24dp,
                "Favorites Photos",
                new Date(2014 - 1900, 1, 3)));
        mUserEvents.add(new UserEvent(
                Color.GRAY,
                R.mipmap.ic_folder_white_24dp,
                "Photos",
                new Date(2014 - 1900, 0, 9)));
    }

    private void addItemData() {
        UserEvent userEvent = new UserEvent(Color.parseColor("#FFC970"),
                R.mipmap.ic_smartphone_white_24dp,
                "Magic Cube Show",
                new Date());
        mUserEvents.add(0, userEvent);
        mAdapter.notifyItemInserted(0);
        mLayoutManager.scrollToPosition(0);
    }

    @Override
    public void onRefresh(FlyRefreshLayout view) {
        View child = mListView.getChildAt(0);
        if (child != null) {
            bounceAnimateView(child.findViewById(R.id.item_icon));
        }

        mHandler.postDelayed(() -> mFlyLayout.onRefreshFinish(), 2000);
    }

    private void bounceAnimateView(View view) {
        if (view == null) {
            return;
        }

        Animator swing = ObjectAnimator.ofFloat(view, "rotationX", 0, 30, -20, 0);
        swing.setDuration(400);
        swing.setInterpolator(new AccelerateInterpolator());
        swing.start();
    }

    @Override
    public void onRefreshAnimationEnd(FlyRefreshLayout view) {
        addItemData();
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        private LayoutInflater mInflater;
        private DateFormat mDataFormat;

        public ItemAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
            mDataFormat = SimpleDateFormat.getDateInstance(DateFormat.DEFAULT, Locale.ENGLISH);
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.view_list_item, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            final UserEvent userEvent = mUserEvents.get(position);
            ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
            drawable.getPaint().setColor(userEvent.color);
            holder.icon.setBackground(drawable);
            holder.icon.setImageResource(userEvent.icon);
            holder.title.setText(userEvent.title);
            holder.subTitle.setText(mDataFormat.format(userEvent.time));
        }

        @Override
        public int getItemCount() {
            return mUserEvents.size();
        }
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;
        TextView subTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.item_icon);
            title = itemView.findViewById(R.id.item_title);
            subTitle = itemView.findViewById(R.id.item_subtitle);
        }
    }
}
