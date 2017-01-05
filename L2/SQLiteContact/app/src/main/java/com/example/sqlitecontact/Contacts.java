package com.example.sqlitecontact;

public class Contacts {

    private int id;
    private String cName;
    private String cPhone;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    @Override
    public String toString() {

        return "ID= " + id + " Name: " + cName + " Phone: " + cPhone;
    }


}
