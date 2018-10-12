package com.weng.wilma.common;

public class SearchField{
    private String field;
    private String value;

    public SearchField(String field){
        this.field = field;
    }
    public void setField(String field){
        this.field = field;
    }

    public String getField(){
        return this.field;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    
}