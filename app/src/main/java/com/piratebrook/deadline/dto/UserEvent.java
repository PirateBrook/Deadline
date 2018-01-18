/*
 * Copyright (c) 2017.
 * Create by PirateBrook 2017 / 17-12-19 下午2:34
 * Last Modified 17-12-18 下午8:56
 *
 */

package com.piratebrook.deadline.dto;

import java.util.Date;

/**
 * Created by wyy on 2017-12-18.
 */

public class UserEvent {
    public int color;
    public int icon;
    public String title;
    public Date time;

    public UserEvent(int color, int icon, String title, Date time) {
        this.color = color;
        this.icon = icon;
        this.title = title;
        this.time = time;
    }
}
