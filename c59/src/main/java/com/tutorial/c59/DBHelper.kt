package com.tutorial.c59

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "testdb", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val studentSql ="""
            create table tb_member(
                _id integer primary key autoincrement,
                name not null,
                email,
                phone)
            """
        p0?.execSQL(studentSql)
        p0?.execSQL("insert into tb_member (name, email, phone) values ('kangmin','rkdals0203@naver.com','01012345678')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table tb_student")
        onCreate(p0)
    }
}