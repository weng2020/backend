package com.weng.wilma.service;
import java.util.List;

import com.weng.wilma.common.Paging;
public interface BaseService<T>{
    List<T> findAll();
    List<T> findBy(String o);
}