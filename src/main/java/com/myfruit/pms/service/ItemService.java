package com.myfruit.pms.service;

import com.myfruit.pms.dto.ItemDto;
import com.myfruit.pms.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    //메서드 구문
    //접근제어자 리턴타입 메서드 이름(매개 변수) {}

    public void createItem(ItemDto itemDto){
        itemMapper.insertItem(itemDto);
    }

    public ItemDto getItem(int id) {
//        Optional<ItemDto> item = itemMapper.getItemById(id);
//        item.orElseThrow();
//        return item;
        return itemMapper.getItemById(id).orElseThrow(
                () -> new IllegalArgumentException("파일을 찾을 수 없습니다.")
        );
    }

    public List<ItemDto> getItemList(){
        return itemMapper.getItemList();
    }

    public void modify(ItemDto itemDto){
        itemMapper.updateItem(itemDto);
    }

    public void remove(int id){
        itemMapper.deleteItem(id);
    }



}
