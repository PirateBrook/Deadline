/*
 * Copyright (c) 2017.
 * Create by PirateBrook 2017 / 17-12-18 下午4:32
 * Last Modified 17-12-18 下午4:32
 *
 */

package com.piratebrook.deadline.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.piratebrook.deadline.R;
import com.piratebrook.deadline.base.AppBaseActivity;
import com.piratebrook.sdk.widget.fly.FlyRefreshLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by wyy on 2017-12-18.
 */

public class UserActivity extends AppBaseActivity implements FlyRefreshLayout.OnPullRefreshListener {

    private FlyRefreshLayout mFlyLayout;
    private RecyclerView mListView;


    @Override
    public void onRefresh(FlyRefreshLayout view) {

    }

    @Override
    public void onRefreshAnimationEnd(FlyRefreshLayout view) {

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
        }

        @Override
        public int getItemCount() {
            return 0;
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
