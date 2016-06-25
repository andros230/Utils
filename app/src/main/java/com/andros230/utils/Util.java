package com.andros230.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * Created by andros230 on 2016/6/25.
 */
public class Util {
    private static final String PREFERENCES_NAME = "com_andros230_utils";

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

    /**
     * Gps是否打开
     *
     * @param context
     * @return
     */
    public static boolean isGpsEnabled(Context context) {
        LocationManager locationManager = ((LocationManager) context.getSystemService(Context.LOCATION_SERVICE));
        List<String> accessibleProviders = locationManager.getProviders(true);
        return accessibleProviders != null && accessibleProviders.size() > 0;
    }

    /**
     * 保存数据对象到 SharedPreferences。
     *
     * @param context 应用程序上下文环境
     */
    public static void writeAccess(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", "name222");
        editor.commit();
    }

    /**
     * 从 SharedPreferences 读取数据信息。
     *
     * @param context 应用程序上下文环境
     */
    public static String readAccess(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        String name = pref.getString("name", "");
        return name;
    }

    /**
     * 清空 SharedPreferences 中的数据信息。
     * @param context 应用程序上下文环境
     */
    public static void clear(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

}
