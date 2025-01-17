package com.myfruit.pms.mapper;

import com.myfruit.pms.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {
    //인터페이스 라서 메서드 이름만 있음.

    //insert 하기
    void insertItem(ItemDto itemDto);

    //하나만 select
    Optional<ItemDto> getItemById(int id);

    //여러개 List 를 select 하기
    List<ItemDto> getItemList();

    //update 하기
    void updateItem(ItemDto itemDto);

    //delete 하기
    void deleteItem(int id);

}
