package com.weng.wilma.dao;
import java.util.List;


public interface BaseDao<T>{
    List<T> findBy(String o);
    List<T> findAll();
    // Paging paginate(Integer o);
}