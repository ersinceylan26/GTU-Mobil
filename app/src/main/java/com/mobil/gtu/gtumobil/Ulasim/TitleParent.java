package com.mobil.gtu.gtumobil.Ulasim;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;

/**
 * Created by ersin on 14.04.2018.
 */

public class TitleParent implements ParentObject
{

    private UUID _id;
    private String title;

    public TitleParent(String title){
        this.title=title;
        _id= UUID.randomUUID();
    }

    @Override
    public List<Object> getChildObjectList() {
        return null;
    }

    @Override
    public void setChildObjectList(List<Object> list) {

    }

    private List<Object> mChilderList;

    public List<Object> getmChilderList() {
        return mChilderList;
    }

    public void setmChilderList(List<Object> mChilderList) {
        this.mChilderList = mChilderList;
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
