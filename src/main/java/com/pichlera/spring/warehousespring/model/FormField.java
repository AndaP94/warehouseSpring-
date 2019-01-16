package com.pichlera.spring.warehousespring.model;

public class FormField {

    private String searchName;
    private long id;

    public FormField(String searchName, long id) {
        this.searchName = searchName;
        this.id = id;
    }

    public FormField() {
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
