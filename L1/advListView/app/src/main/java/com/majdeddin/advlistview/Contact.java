package com.majdeddin.advlistview;

/**
 * Created by MajdEddin on 3/21/16.
 */
public class Contact {

    private String name;
    private String phone;
    private int image;

    public Contact(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    public int getImage() {
        return image;
    }

}
