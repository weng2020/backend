package com.weng.wilma.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.weng.wilma.common.Page;
import com.weng.wilma.common.Pagination;
import com.weng.wilma.model.Item;


@Repository
public class ItemDao implements BaseDao<Item>{

    @PersistenceContext	
	private EntityManager entityManager;	

    @Override
    public List<Item> findAll(){
        return entityManager.createNativeQuery("Select * from items limit 50", Item.class).getResultList();
    }

    @Override
    public List<Item> findBy(String value){
        String hql = "Select * from items where item_desc like '%" + value + "%'";

        return entityManager.createNativeQuery(hql, Item.class).getResultList();
    }

    // @Override
    public Page paginate(Integer page, String filter){
       
        String hql = "FROM Item item where item.description LIKE :desc ORDER BY item.description";
        Query query = entityManager.createQuery(hql).setParameter("desc", "%"+ filter + "%");

        Pagination pag = new Pagination();
        pag.setQuery(query);
        pag.paginate(10);

        return pag.getPage(page);
    }
   
}