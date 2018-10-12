package com.weng.wilma.common;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ResultList<T>{
    private String hql;
    private Query query;
    private EntityManager entityManager;

    public ResultList(){}

    public ResultList(Class<T> c, EntityManager entityManager){
        this.hql = "FROM " + c.getSimpleName();
        this.entityManager = entityManager;
    }

    public ResultList<T> where(String field, String operator, String value){
        this.hql += " WHERE " + field + " " + operator + ":val";
        if(operator.toLowerCase() != "like"){
            this.query = entityManager.createQuery(hql).setParameter("val", value);
        }else{
            this.query = entityManager.createQuery(hql).setParameter("val", "%" + value.trim() + "%");
        }
        return this;
    }

    public List<T> get(){
        if(!(hql.indexOf("WHERE") >= 0)){
            return entityManager.createQuery(hql).getResultList();
        }
      return query.getResultList();
    }



}