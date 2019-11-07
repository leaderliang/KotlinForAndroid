package com.android.kotlinbase.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.kotlinbase.BaseApplication;
import com.android.kotlinbase.R;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/11/07 15:24
 */
public class CacheUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context = BaseApplication.currentApplication();

    private static SharedPreferences SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

    public static void save(String key, String value) {
        SP.edit().putString(key, value).apply();
    }

    public static String get(String key) {
        return SP.getString(key, null);
    }
}
