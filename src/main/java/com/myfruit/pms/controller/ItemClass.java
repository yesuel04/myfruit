package com.myfruit.pms.controller;

import com.myfruit.pms.dto.ItemDto;
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
    @ResponseBody
    // item = "애플"
    public void createItem(@RequestBody ItemDto itemDto){
        System.out.println(itemDto.getItem());
    }
}
