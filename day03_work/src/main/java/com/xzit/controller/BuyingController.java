package com.xzit.controller;

import com.xzit.service.GroupBuying;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyingController {
    GroupBuying groupBuying;

    @Autowired
    public BuyingController(GroupBuying groupBuying) {
        this.groupBuying = groupBuying;
    }

    @GetMapping("/buy")
    public Object buyVegetable(){
        groupBuying.buy();
        return "ok";
    }
}
