/*
 * Copyright (c) 2017.
 * Create by PirateBrook 2017 / 17-12-18 下午5:13
 * Last Modified 17-12-18 下午5:13
 *
 */

package com.piratebrook.deadline.model;

import com.piratebrook.deadline.model.entity.AbsEntity;

/**
 * Created by wyy on 2017-12-18.
 */

public abstract class BaseModelController<T extends AbsEntity> {

    public boolean addEntity(T entity) {
        return false;
    }

    public abstract T getEntity();

    public abstract boolean deleteEntity(T entity);

    public abstract boolean updateEntity(T entity);


}
