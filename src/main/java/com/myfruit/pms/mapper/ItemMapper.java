package com.myfruit.pms.mapper;

import com.myfruit.pms.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
//    ItemDto itemDto = new ItemDto();
//    itemDto.setItem('딸기');
    void insertMapper(ItemDto itemDto);
}
