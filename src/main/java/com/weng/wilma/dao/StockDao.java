package com.weng.wilma.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import org.springframework.stereotype.Repository;
import com.weng.wilma.model.Stock;

@Repository
public class StockDao implements BaseDao<Stock>{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Stock> findAll(){
        String hql = "Select * from stocks limit";
        List<Stock> list = entityManager.createNativeQuery(hql, Stock.class).getResultList();
        return list;
    }

    @Override
    public List<Stock> findBy(String value){
        String hql = "Select * from stocks s join items i on s.item_code = i.item_code where i.item_desc like '%" + value + "%'";
        List<Stock> list = entityManager.createNativeQuery(hql, Stock.class).getResultList();
        return list;
    }
   
}
