package com.mobil.gtu.gtumobil.Etkinlik;

/**
 * Created by ersin on 15.04.2018.
 */

public class EtkinlikNoMoreClass
{
    private String etkinlikBasligi;
    private String etkinlikTarihi;

    public EtkinlikNoMoreClass(String s, String s1) {
        etkinlikBasligi=s;
        etkinlikTarihi=s1;
    }

    public String getEtkinlikBasligi() {
        return etkinlikBasligi;
    }

    public void setEtkinlikBasligi(String etkinlikBasligi) {
        this.etkinlikBasligi = etkinlikBasligi;
    }

    public String getEtkinlikTarihi() {
        return etkinlikTarihi;
    }

    public void setEtkinlikTarihi(String etkinlikTarihi) {
        this.etkinlikTarihi = etkinlikTarihi;
    }
}
