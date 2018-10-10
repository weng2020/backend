package com.weng.wilma.common;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ResultList<T>{

    private Query query;

    public ResultList(){}

    public ResultList<T> search(Class<T> c, EntityManager entityManager){
        String hql = "FROM " + c.getSimpleName();
        this.query = entityManager.createQuery(hql, c);
        return this;
    }


    public List<T> get(){
        return query.getResultList();
    }

    public ResultList<T> searchBy(Class<T> c, String field, String value, EntityManager entityManager){
        String hql = "FROM " + c.getSimpleName() + " " + c.getSimpleName().toLowerCase() + " WHERE "+ c.getSimpleName().toLowerCase() +"." + field + " LIKE :val";
        this.query = entityManager.createQuery(hql, c).setParameter("val", "%"+value.trim()+"%");
        return this;
    }

    public Integer count(){
        return this.query.getResultList().size();
    }
}