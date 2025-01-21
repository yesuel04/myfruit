package com.myfruit.pms.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PageDto {
    private int page;
    private int limit;
    private int totalPages;
    private int totalElements;
    private List<ItemDto> items;

}
