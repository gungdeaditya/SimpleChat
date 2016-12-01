package com.gdeaditya.simplechat;

import android.app.Application;

import com.qiscus.sdk.Qiscus;

/**
 * Created by gungde on 01/12/16.
 */
public class ChatInit extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Qiscus.init(this, "DRAGONFLY");
    }
}
