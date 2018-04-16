package com.mobil.gtu.gtumobil.Rehber;

public class Contact
{
    String name;
    String unvan;
    String tel;

    public Contact(String name, String unvan, String tel) {
        this.name = name;
        this.unvan = unvan;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
