package com.weng.wilma.common;

import javax.persistence.Query;

import com.weng.wilma.model.Item;

public class Pagination{

    private Query query;
    private Integer perPage;
    private Integer total;

    public Pagination(){
    }

    public void setQuery(Query query){
        this.query = query;
    }
    
    public Query getQuery(){
        return this.query;
    }
    public void setTotal(Integer total){
        this.total = total;
    }

    public Page getPage(Integer pageNumber){
        Integer from = (pageNumber - 1) * perPage;
        Integer to; 
        Integer lastPage = total / perPage;
        if(total % perPage > 0){
            lastPage+= 1;
        }
        Page paginate = new Page();
        paginate.setData(getQuery().setFirstResult(from).setMaxResults(perPage).getResultList());
        paginate.setTotal(total).setLastPage(lastPage);
        paginate.setCurrentPage(pageNumber).setPerPage(perPage);
        to = from + getQuery().setFirstResult(from).setMaxResults(perPage).getResultList().size();
        from+=1;
        paginate.setFrom(from).setTo(to);

        return paginate;
    }

    public Pagination paginate(Integer perPage){
        this.perPage = perPage;
        return this;
    }
}