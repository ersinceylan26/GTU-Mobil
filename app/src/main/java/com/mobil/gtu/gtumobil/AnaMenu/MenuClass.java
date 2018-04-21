package com.mobil.gtu.gtumobil.AnaMenu;

public class MenuClass {

    boolean isSelected;
    String menuName;

    public MenuClass(boolean isSelected, String userName) {
        this.isSelected = isSelected;
        this.menuName = userName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

}
