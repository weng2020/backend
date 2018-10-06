// package com.weng.wilma.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import com.weng.wilma.service.StockService;
// import com.weng.wilma.model.Stock;
// import java.util.List;

// @RestController
// @RequestMapping("api/stocks")
// public class StockController{

//     @Autowired
//     private StockService stockService;

//     @GetMapping("search")
//     public ResponseEntity<List<Stock>> findAll(){
//         List<Stock> list = stockService.findAll();
//         return new ResponseEntity<List<Stock>>(list, HttpStatus.OK);
//     }
//     @RequestMapping(value="search/{stock}", method = RequestMethod.GET)
//     public ResponseEntity<List<Stock>> getStocks(@PathVariable("stock") String stock){
//         List<Stock> list = stockService.findBy(stock);
//         return new ResponseEntity<List<Stock>>(list, HttpStatus.OK);
//     }
// }