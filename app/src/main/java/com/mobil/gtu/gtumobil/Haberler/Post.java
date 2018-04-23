package com.mobil.gtu.gtumobil.Haberler;


import java.io.Serializable;

public class Post implements Serializable {


    private String title;
    private String link;
    private String imgLink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        imgLink = imgLink;
    }



    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", imgLink='" + imgLink + '\'' +
                '}';
    }

    public Post(){
        this.link = "";
        this.title = "";
        this.imgLink = "";
    }


    public Post(String title, String link, String imgLink){
        this();
        this.title = title;
        this.link = link;
        this.imgLink = imgLink;
    }
}
