/*
 * Copyright (c) 2017.
 * Create by PirateBrook 2017 / 17-12-18 下午5:18
 * Last Modified 17-12-18 下午5:18
 *
 */

package com.piratebrook.deadline.model.entity.user;

import android.graphics.Color;

import com.piratebrook.deadline.model.entity.AbsEntity;

import java.util.Date;

/**
 * Created by wyy on 2017-12-18.
 */

public class UserEvent extends AbsEntity {

    int color;
    private int icon;
    private String title;
    private Date time;

    public UserEvent(int color, int icon, String title, Date time) {
        this.color = color;
        this.icon = icon;
        this.title = title;
        this.time = time;
    }

    public UserEvent(int icon, String title) {
        this(Color.DKGRAY, icon, title, new Date());
    }

    public int getColor() {
        return color;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public Date getTime() {
        return time;
    }
}
