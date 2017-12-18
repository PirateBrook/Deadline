/*
 * Copyright (c) 2017.
 * Create by PirateBrook 2017 / 17-12-18 下午5:35
 * Last Modified 17-12-18 下午5:35
 *
 */

package com.piratebrook.deadline.model;

import com.piratebrook.deadline.model.entity.user.UserEvent;

/**
 * Created by wyy on 2017-12-18.
 */

public class UserEventController extends BaseModelController<UserEvent> {

    private UserEventController(UserEvent userEvent) {

    }

    @Override
    public UserEvent getEntity() {
        return null;
    }

    @Override
    public boolean deleteEntity(UserEvent entity) {
        return false;
    }

    @Override
    public boolean updateEntity(UserEvent entity) {
        return false;
    }
}
