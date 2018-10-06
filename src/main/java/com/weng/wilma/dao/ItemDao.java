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
    public Paging paginate(Integer page){
        Paging paginate = new Paging();
        Integer perPage = 15;
        Integer from = (page - 1) * perPage;
        Integer to;
        Integer lastPage;
        Integer total = Integer.parseInt(entityManager.createNativeQuery("Select count(*) as count from items").getSingleResult().toString());
        lastPage = total / perPage;
        if(total % perPage > 0){
            lastPage+= 1;
        }
        String hql = "FROM Item item ORDER BY item.description";
        Query query = entityManager.createQuery(hql).setFirstResult(from).setMaxResults(perPage);
        List<Item> items = query.getResultList();
        paginate.setData(items);
        paginate.setTotal(total);
        paginate.setCurrentPage(page).setPerPage(perPage).setLastPage(lastPage);
        to = from + perPage;
        from+=1;
        paginate.setFrom(from).setTo(to);
        return paginate;
    }
   
}