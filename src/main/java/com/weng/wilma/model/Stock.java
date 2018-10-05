package com.weng.wilma.model;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 11, nullable = false)
    private Integer stockId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_code")
    private Item item;

    @Column(name = "supplier_id", columnDefinition = "INT(11) default '2'")
    private Integer supplierId;

    @Column(name = "warehouse", length = 45, columnDefinition = "default 'Main'")
    private String warehouse;

    @Column(name = "reorder", nullable = false)
    private Double reorder;

    public void setStockId(Integer id){
        this.stockId = id;
    }

    public Integer getStockId(){
        return stockId;
    }

    public void setItem(Item item){
        this.item = item;
    }

    public Item getItem(){
        return item;
    }

    public void setSupplierId(Integer id){
        this.supplierId = id;
    }

    public Integer getSupplierId(){
        return supplierId;
    }

    public void setWarehouse(String warehouse){
        this.warehouse = warehouse;
    }

    public String getWarehouse(){
        return warehouse;
    }

    public void setReorder(Double reorder){
        this.reorder = reorder;
    }

    public Double getReorder(){
        return reorder;
    }


    
}