package com.codekul.ecommerce.controller;

import com.codekul.ecommerce.domain.Product;
import com.codekul.ecommerce.tool.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.*;

/**
 * Created by aniruddha on 7/8/16.
 */

@RestController
public class ProductController {

    @Autowired
    private FileTool tool;

    @GetMapping(value = "/ecom/products",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getProducts(){
        ResponseEntity<Map<String,Object>> entity = null;

        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(10l);
        product1.setDescription("This is good product");
        product1.setImage("image1.png");
        product1.setName("Pen");
        product1.setPrice(10d);
        products.add(product1);

        Product product2 = new Product();
        product2.setId(11l);
        product2.setDescription("This is good product");
        product2.setImage("image2.png");
        product2.setName("Mobile");
        product2.setPrice(10_000d);
        products.add(product2);

        Map<String,Object> map = new HashMap<>();
        map.put("products",products);
        products.forEach(product -> map.put(""+product.getId(),product));

        entity = new ResponseEntity<>(map, HttpStatus.OK);

        return entity;
    }

    @PostMapping(value = "/productImage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Map<String,Object>> uploadProductImage(@RequestParam MultipartFile file){

        ResponseEntity<Map<String,Object>> entity = null;
        Map<String,Object> map = new HashMap<>();

        try {
            tool.writeFile(file.getOriginalFilename(),file);
            map.put("sts","success");
            map.put("msg","product image uploaded successfully :) ");
            entity = new ResponseEntity<>(map, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();

            map.put("sts","failure");
            map.put("msg","problem in uploading image :( ");
            entity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
