package com.example.backend.testentity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
public class TestEntitySearchCriteria {

    private Set<UUID> uuids;
    private LocalDate fromCreateDate;
    private LocalDate toCreateDate;

    private LocalDate fromEditDate;
    private LocalDate toEditDate;

    private String contentContains;

    private Integer pageNumber;
    private Integer pageSize;
}
