package com.example.admin.listviewwithimage;

import java.io.Serializable;

/**
 * Created by admin on 3/22/16.
 */
public class Contact implements Serializable
{

    String name;
    String phone;
    int photo;
    String desc ;

    // constructor
    public Contact(String name, String phone, int photo, String desc){
        this.name = name;
        this.phone = phone;
        this.photo = photo;
        this.desc = desc;
    }


}
