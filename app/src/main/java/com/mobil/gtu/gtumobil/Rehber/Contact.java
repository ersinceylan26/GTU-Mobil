package com.mobil.gtu.gtumobil.Rehber;

public class Contact
{
    String name;
    String unvan;
    String tel;
    String mail;

    public Contact(String name, String unvan, String tel,String mail) {
        this.name = name;
        this.unvan = unvan;
        this.tel = tel;
        this.mail=mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
