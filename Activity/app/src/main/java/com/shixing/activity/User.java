package com.shixing.activity;

import java.io.Serializable;

/**
 * Created by shixing on 2017/9/7.
 */

public class User  implements Serializable{
    public String name;
    public int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
