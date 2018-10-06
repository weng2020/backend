package com.weng.wilma.common;
import java.util.List;
public class Paging<T>{
    private Integer total;
    private Integer current_page;
    private List<T> data;
    private Integer from;
    private Integer to;
    private Integer last_page;
    private Integer per_page;

    public Paging<T> setTotal(Integer total){
        this.total = total;
        return this;
    }

    public Integer getTotal(){
        return total ;
    }

    public Paging<T> setCurrentPage(Integer curr_page){
        this.current_page = curr_page;
        return this;
    }

    public Integer getCurrentPage(){
        return current_page;
    }

    public void setData(List<T> o){
        data = o;
    }

    public List<T> getData(){
        return data;
    }

    public Paging<T> setFrom(Integer from){
        this.from = from;
        return this;
    }

    public Integer getFrom(){
        return from;
    }

    public Paging<T> setTo(Integer to){
        this.to = to;
        return this;
    }

    public Integer getTo(){
        return to;
    }

    public Paging<T> setLastPage(Integer lastPage){
        this.last_page = lastPage;
        return this;
    }

    public Integer getLastPage(){
        return last_page;
    }

    public Paging<T> setPerPage(Integer perPage){
        this.per_page = perPage;
        return this;
    }

}