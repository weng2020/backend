package com.weng.wilma.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.stereotype.Repository;
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
   
}