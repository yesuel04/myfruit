package com.myfruit.pms.service;

import com.myfruit.pms.dto.ItemDto;
import com.myfruit.pms.dto.PageDto;
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
                () -> new IllegalStateException("파일을 찾을 수 없습니다.")
        );
    }

    public PageDto getItemList(int page, int limit){
        int offset = (page - 1) * limit;
        //갯수(limit)가 size 인 item 목록
        List<ItemDto> items = itemMapper.getItemList(limit, offset);
        //총갯수
        int totalElements = itemMapper.countTotal();
        //총페이지
        int totalPages = (int) Math.ceil((double) totalElements / limit);

        PageDto pageDto = new PageDto(page, limit, totalPages, totalElements, items);

        //page, size, items, totalPages 를 클라이언트에 전달
        return pageDto;
    }

    public void modify(ItemDto itemDto){
        itemMapper.updateItem(itemDto);
    }

    public void remove(int id){
        itemMapper.deleteItem(id);
    }


    public void modifyItem(ItemDto itemDto) {
        itemMapper.updateItem(itemDto);
    }

    public void removeItem(int id) {
        itemMapper.deleteItem(id);
    }
}
