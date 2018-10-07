package com.weng.wilma.common;
import java.util.List;
public class Page{
    private Integer total;
    private Integer current_page;
    private List<?> data;
    private Integer from;
    private Integer to;
    private Integer last_page;
    private Integer per_page;

    public Page setTotal(Integer total){
        this.total = total;
        return this;
    }

    public Integer getTotal(){
        return total ;
    }

    public Page setCurrentPage(Integer curr_page){
        this.current_page = curr_page;
        return this;
    }

    public Integer getCurrentPage(){
        return current_page;
    }

    public void setData(List<?> o){
        data = o;
    }

    public List<?> getData(){
        return data;
    }

    public Page setFrom(Integer from){
        this.from = from;
        return this;
    }

    public Integer getFrom(){
        return from;
    }

    public Page setTo(Integer to){
        this.to = to;
        return this;
    }

    public Integer getTo(){
        return to;
    }

    public Page setLastPage(Integer lastPage){
        this.last_page = lastPage;
        return this;
    }

    public Integer getLastPage(){
        return last_page;
    }

    public Page setPerPage(Integer perPage){
        this.per_page = perPage;
        return this;
    }


}