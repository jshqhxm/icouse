package com.iketang.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by xiaomin on 2016/7/6.
 */

@Database(name= AppDatabase.NAME , version= AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME= "iKetang";

    public static final int VERSION =1;
}
