// package com.weng.wilma.service;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.weng.wilma.common.Paging;
// import com.weng.wilma.dao.StockDao;
// import com.weng.wilma.model.Stock;

// @Service
// @Transactional
// public class StockService implements BaseService<Stock>{

//     @Autowired
//     private StockDao stockDao;

//     @Override
//     public List<Stock> findAll(){
//         return stockDao.findAll();
//     }

//     @Override
//     public List<Stock> findBy(String value){
//         return stockDao.findBy(value);
//     }

//     @Override
//     public Paging<Stock> paginate(Integer page){
//         return stockDao.paginate(page);
//     }
// }