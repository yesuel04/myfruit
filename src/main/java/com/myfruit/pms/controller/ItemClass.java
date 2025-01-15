package com.myfruit.pms.controller;

import com.myfruit.pms.gto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemClass {

    @GetMapping("/create")
    public String create(){
        return "/shop/create-item";
    }

    @PostMapping
    // item = "애플"
    public void createItem(@ModelAttribute ItemDto itemDto){
        System.out.println(itemDto.getItem());
    }
}
