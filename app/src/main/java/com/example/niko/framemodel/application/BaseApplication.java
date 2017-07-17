package com.example.niko.framemodel.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.framelib.BuildConfig;
import com.example.framelib.utils.Tools.LogUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**

 * Created by niko on 2017/1/11.
 */

public class BaseApplication extends Application {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {
        if (BuildConfig.LOG_DEBUG) {
            LogUtil.init(true, Log.VERBOSE);
        } else {
            LogUtil.init(false);
        }

        Fresco.initialize(mContext);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);
    }

}
