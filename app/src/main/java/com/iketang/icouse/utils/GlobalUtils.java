package com.iketang.icouse.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiaomin on 2016/3/27.
 */
public class GlobalUtils {


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;

        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;

        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取版本号和版本次数
     */
    public static String getVersionCode(Context context, int type) {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            if (type == 1) {
                return String.valueOf(pi.versionCode);
            } else {
                return pi.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getScreenHeight(Activity context) {
        if (context == null) {
            return 0;
        }
        return context.findViewById(android.R.id.content).getHeight();
    }

    /**
     * 获取设备信息
     */
    public static String getDeviceInfo(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return ("\nDeviceId(IMEI) = " + tm.getDeviceId()) + "\nDeviceSoftwareVersion = " + tm.getDeviceSoftwareVersion() + "\nLine1Number = " + tm.getLine1Number() + "\nNetworkCountryIso = " + tm.getNetworkCountryIso() + "\nNetworkOperator = " + tm.getNetworkOperator() + "\nNetworkOperatorName = " + tm.getNetworkOperatorName() + "\nNetworkType = " + tm.getNetworkType() + "\nPhoneType = " + tm.getPhoneType() + "\nSimCountryIso = " + tm.getSimCountryIso() + "\nSimOperator = " + tm.getSimOperator() + "\nSimOperatorName = " + tm.getSimOperatorName() + "\nSimSerialNumber = " + tm.getSimSerialNumber() + "\nSimState = " + tm.getSimState() + "\nSubscriberId(IMSI) = " + tm.getSubscriberId() + "\nVoiceMailNumber = " + tm.getVoiceMailNumber();
    }

    /**
     * 获取设备android id
     */
    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取系统时间 格式为："yyyy/MM/dd"
     */
    public static String getCurrentDate() {
        Date d = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");

        return sf.format(d);
    }

    /**
     * 时间戳转换成字符窜
     */
    public static String getDateToString(long time) {
        Date d = new Date(time);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");

        return sf.format(d);
    }

    public static String getDateToStringWithYDHM(long time) {
        Date d = new Date(time);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("MM月dd日 HH:mm");

        return sf.format(d);
    }

    /**
     * 将字符串转为时间戳
     */
    public static long getStringToDate(String time) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }


}
