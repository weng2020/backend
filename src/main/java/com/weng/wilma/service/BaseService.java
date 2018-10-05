package com.weng.wilma.service;
import java.util.List;
public interface BaseService<T>{
    List<T> findAll();
    List<T> findBy(String o);

}