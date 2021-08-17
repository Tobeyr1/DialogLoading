package com.tobey.sample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @Package: com.tobey.sample
 * @ClassName: App
 * @Author: Tobey_r1
 * @CreateDate: 2021/5/12 16:29
 * @Description: java类作用描述
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/5/12 16:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class App extends Application {
    private static RefWatcher sRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        sRefWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher() {
        return sRefWatcher;
    }
}
