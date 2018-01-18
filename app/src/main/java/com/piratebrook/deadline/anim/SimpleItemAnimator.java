/*
 * Copyright (c) 2017.
 * Create by PirateBrook 2017 / 17-12-27 下午12:00
 * Last Modified 17-12-27 下午12:00
 *
 */

package com.piratebrook.deadline.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.piratebrook.deadline.R;

import jp.wasabeef.recyclerview.animators.BaseItemAnimator;

/**
 * Created by wyy on 2017-12-27.
 */

public class SimpleItemAnimator extends BaseItemAnimator {

    @Override
    protected void preAnimateAddImpl(RecyclerView.ViewHolder holder) {
        super.preAnimateAddImpl(holder);
        View icon = holder.itemView.findViewById(R.id.item_icon);
        icon.setRotationX(30f);
        View right = holder.itemView.findViewById(R.id.item_right);
        right.setPivotX(0);
        right.setPivotY(0);
        right.setRotationY(90);
    }

    @Override
    protected void animateRemoveImpl(RecyclerView.ViewHolder holder) {

    }

    @Override
    protected void animateAddImpl(RecyclerView.ViewHolder holder) {
        View target = holder.itemView;
        View icon = target.findViewById(R.id.item_icon);
        Animator swing = ObjectAnimator.ofFloat(icon, "rotationX", 45, 0);
        swing.setInterpolator(new OvershootInterpolator(5));

        View right = target.findViewById(R.id.item_right);
        Animator rotateIn = ObjectAnimator.ofFloat(right, "rotationY", 90, 0);
        rotateIn.setInterpolator(new DecelerateInterpolator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(getAddDuration());
        animatorSet.playTogether(swing, rotateIn);

        animatorSet.start();
    }
}
