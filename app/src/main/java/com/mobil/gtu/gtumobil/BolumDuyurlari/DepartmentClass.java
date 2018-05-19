package com.mobil.gtu.gtumobil.BolumDuyurlari;

public class DepartmentClass
{
    String departmentName;

    public DepartmentClass(String facultyName) {
        this.departmentName = facultyName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String facultyName) {
        this.departmentName = facultyName;
    }
}
