package com.iketang.icouse;

import android.os.Environment;

/**
 * 项目名称 icouse
 * <p/>
 * Created by hexiaomin on 2016/3/25.
 */
public class IcString {


    public static String BASE_DOMAIN = "demo2.bw-xt.com";

    public static String LOGSEVER = "http://" + BASE_DOMAIN ;

    public static String HOME_PAGE = "http://" + BASE_DOMAIN +"/";


    public static String BASE_FOLDER_PATH = "/Android/data/com.bwxt.needs/Need";

    public static String BASE_PATH = Environment.getExternalStorageDirectory() + BASE_FOLDER_PATH;

    public static String BASE_VIDEO_PATH = Environment.getExternalStorageDirectory() + BASE_FOLDER_PATH;

    public static String IMAGE_PATH = BASE_PATH + "/image";

    public static String VIDEO_PATH = BASE_PATH + "/video";

    public static String APK_PATH = BASE_PATH + "/apk/";




    public static final String[] MAIN_TITLES = new String[]{
            "首页推荐", "分区导航", "新番专题", "文章专区"};





}
