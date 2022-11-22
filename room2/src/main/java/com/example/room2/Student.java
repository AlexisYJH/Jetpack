package com.example.room2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author AlexisYin
 */
@Entity(tableName = "student")
public class Student {

    //必须要有一个主键，必须设置PrimaryKey标签，否则报错
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
    public int age;

    //V2.0
    //@ColumnInfo(name = "sex", typeAffinity = ColumnInfo.INTEGER)
    //V4.0
    @ColumnInfo(name = "sex", typeAffinity = ColumnInfo.TEXT)
    public String sex;

    @ColumnInfo(name = "bar_data", typeAffinity = ColumnInfo.INTEGER)
    public int barData;

    //添加Ignore标签，避免成为表中的一列
    @Ignore
    public boolean flag;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Ignore
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Ignore
    public Student(int id) {
        this.id = id;
    }
}
