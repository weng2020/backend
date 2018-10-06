package com.weng.wilma.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.stereotype.Repository;

import com.weng.wilma.common.Paging;
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

    @Override
    public Paging<Item> paginate(Integer page){
        Paging<Item> paginate = new Paging<Item>();
        Integer from = (page - 1) * 10;
        Integer to;
        Integer lastPage;
        Integer total = Integer.parseInt(entityManager.createNativeQuery("Select count(*) as count from items").getSingleResult().toString());
        lastPage = total / 10;
        if(total % 10 > 0){
            lastPage+= 1;
        }
        List<Item> items = entityManager.createNativeQuery("Select * from items order by item_desc limit 10 offset " + from + "", Item.class).getResultList();
        paginate.setData(items);
        paginate.setTotal(total);
        paginate.setCurrentPage(page).setPerPage(10).setLastPage(lastPage);
        if(from <= 0){
            from = 1;
            to = 10;
        }else{
            to = from + 10;
        }
        paginate.setFrom(from).setTo(to);
        return paginate;
    }
   
}