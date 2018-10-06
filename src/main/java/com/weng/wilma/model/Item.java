package com.weng.wilma.model;

import javax.persistence.*;

@Entity
@Table(name= "items")
public class Item{

    @Id
    @Column(name = "item_code", length= 50, nullable = false)
    private String code;

    @Column(name = "item_desc", length = 100, nullable = false)
    private String description;

    @Column(name = "unit", length = 45, nullable = false)
    private String unit;

    @Column(name = "u_price", columnDefinition = "Decimal(9,2)")
    private Double price;

    @Column(name = "pcs", columnDefinition = "Double default '1'")
    private Double pcs;

    @Column(name = "out", length = 1)
    private String out;

    @Column(name = "status", columnDefinition= "Int(1) default '1'")
    private Integer status;

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getDescription(){
        return description;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getUnit(){
        return unit;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }

    public void setPcs(Double pcs){
        this.pcs = pcs;
    }

    public Double getPcs(){
        return pcs;
    }

    public void setOut(String out){
        this.out = out;
    }

    public String getOut(){
        return out;
    }

    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return status;
    }

    public Item(){

    }

}