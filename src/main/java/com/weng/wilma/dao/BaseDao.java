package com.weng.wilma.dao;
import java.util.List;

import com.weng.wilma.common.Paging;

public interface BaseDao<T>{
    List<T> findBy(String o);
    List<T> findAll();
    Paging paginate(Integer o);
}