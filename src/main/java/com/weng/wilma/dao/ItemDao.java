package com.weng.wilma.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.weng.wilma.common.Page;
import com.weng.wilma.common.Pagination;
import com.weng.wilma.common.ResultList;
import com.weng.wilma.model.Item;


@Repository
public class ItemDao implements BaseDao<Item>{

    @PersistenceContext	
	private EntityManager entityManager;	
    @Autowired
    private Pagination pagination;

    // @Override
    public Page paginate(Integer page, String filter){
        String hql = "FROM Item item where item.description LIKE :desc ORDER BY item.description";
        Query query = entityManager.createQuery(hql).setParameter("desc", "%"+ filter.trim() + "%");

        pagination.setQuery(query).paginate(15);

        return pagination.getPage(page);
    }

    @Override
    public List<Item> findAll(){
        ResultList<Item> r = new ResultList<Item>();
        
        return r.searchBy(Item.class, "description", "gran",entityManager).get();
    }

    @Override
    public List<Item> findBy(String value){
        String hql = "Select * from items where item_desc like '%" + value + "%'";

        return entityManager.createNativeQuery(hql, Item.class).getResultList();
    }

  
   
}