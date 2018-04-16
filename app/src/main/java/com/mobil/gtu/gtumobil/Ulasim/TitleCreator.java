package com.mobil.gtu.gtumobil.Ulasim;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ersin on 14.04.2018.
 */

public class TitleCreator {

    static TitleCreator _titleCreator;
    List<TitleParent> _titleParents;

    public TitleCreator(Context context) {
        _titleParents=new ArrayList<>();

        TitleParent title = new TitleParent(String.format("17B (Pendik Yönü)"));
        _titleParents.add(title);
        title = new TitleParent(String.format("17B (Gebze Yönü)"));
        _titleParents.add(title);
        title = new TitleParent(String.format("490 (KYK Yönü)"));
        _titleParents.add(title);
        title = new TitleParent(String.format("17B (GTÜ Yönü)"));
        _titleParents.add(title);
        List<Object> childList = new ArrayList<>();
        childList.add(new TitleChild("Add to contacts","SendMessage"));
        title.setChildObjectList(childList);
        title = new TitleParent(String.format("Ring (Danışma Hareket)"));
        _titleParents.add(title);
        title = new TitleParent(String.format("Kimya (Danışma Hareket)"));
        _titleParents.add(title);


    }

    public static TitleCreator get(Context context){

        if(_titleCreator==null)
            _titleCreator=new TitleCreator(context);
        return _titleCreator;
    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}
