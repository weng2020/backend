package com.weng.wilma.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.weng.wilma.service.ItemService;
import com.weng.wilma.common.Paging;
import com.weng.wilma.model.Item;
import java.util.List;

@RestController
public class ItemController{

    @Autowired
    private ItemService itemService;

    @GetMapping("api/items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> list = itemService.findAll();
		return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }
    
    @RequestMapping(value="api/items/search/{item}", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItems(@PathVariable("item") String item){
        List<Item> list = itemService.findBy(item);
        return new ResponseEntity<List<Item>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="api/items/page/{page}", method = RequestMethod.GET)
    public ResponseEntity<Paging<Item>> getItems(@PathVariable("page") Integer page){
        Paging<Item> list = itemService.paginate(page);
        return new ResponseEntity<Paging<Item>>(list, HttpStatus.OK);
    }
}