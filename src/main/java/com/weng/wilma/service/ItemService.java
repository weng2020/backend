package com.weng.wilma.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weng.wilma.common.Paging;
import com.weng.wilma.dao.ItemDao;
import com.weng.wilma.model.Item;

@Service
@Transactional
public class ItemService implements BaseService<Item>{

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<Item> findAll(){
        return itemDao.findAll();
    }

    @Override
    public List<Item> findBy(String value){
        return itemDao.findBy(value);
    }

    public Paging paginate(Integer page){
        return itemDao.paginate(page);
    }
 
}