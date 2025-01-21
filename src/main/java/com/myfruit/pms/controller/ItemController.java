package com.myfruit.pms.controller;

import com.myfruit.pms.dto.ItemDto;
import com.myfruit.pms.dto.PageDto;
import com.myfruit.pms.mapper.ItemMapper;
import com.myfruit.pms.service.ItemService;
import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemService itemService;

    @GetMapping("/create")
    public String create(){
        return "/shop/create-item";
    }

    @PostMapping
    @ResponseBody
    // item = "애플"
    public void createItem(@RequestBody ItemDto itemDto){
        System.out.println(itemDto.getItem());
        itemService.createItem(itemDto);
    }

    @GetMapping("/{id}")
//    @ResponseBody
    public String getItem(@PathVariable("id") int id, Model model){
        try{
            ItemDto itemDto = itemService.getItem(id);
            model.addAttribute("item", itemDto);
        } catch (IllegalStateException e) {
            model.addAttribute("message", e.getMessage());
            return "/common/error/404";
        }
        return "shop/detail";
    }

    // 요청URL 형식: /items?page=1&limit=10
    @GetMapping
    public String getItems(@RequestParam(name="page", defaultValue = "1") int page,
                           @RequestParam(name="limit", defaultValue = "5") int limit,
                           Model model) {
        PageDto pageDto = itemService.getItemList(page, limit);
        model.addAttribute("pageDto", pageDto);

        return "shop/list";
    }

    //modify 나 edit 를 사용한다
    @GetMapping("/{id}/edit")
    public String getItem2(@PathVariable("id") int id, Model model){
        try{
            ItemDto itemDto = itemService.getItem(id);
            model.addAttribute("item", itemDto);
        } catch (IllegalStateException e) {
            model.addAttribute("message", e.getMessage());
            return "/common/error/404";
        }
        return "shop/modify";
    }

    @PostMapping("/{id}/modify")
    @ResponseBody
    public void modifyItem(@RequestBody ItemDto itemDto){
        System.out.println(itemDto.getItem());
        itemService.modifyItem(itemDto);
    }

    @GetMapping("/{id}/remove")
    public String removeItem(@PathVariable("id") int id){
        itemService.removeItem(id);

        return "redirect:/items";
    }


    // 타임리프를 사용할 때는 GET 과 POST 만 사용 가능.

    // 생성 페이지 GET /items/create
    // 생성 POST /items
    // 상세보기 GET /items/{id}
    // 목록 GET /items
    // 수정페이지 GET /items/{id}/modify
    // 수정 POST /items/{id}
    // 삭제 GET /items/{id}/remove


    //Form 을 사용할 때는 GET, POST, PUT, DELETE 를 사용.

    // 생성 페이지 GET /items/create
    // 생성 POST /items
    // 상세보기 GET /items/{id}
    // 목록 GET /items
    // 수정 PUT /items/{id}/modify
    // 삭제 DELETE /items/{id}/delete
}
