package com.example.backend.testentity;

import org.springframework.data.domain.Page;

import java.util.UUID;

public interface TestEntityService {
    Page<TestEntityDto> findAll(TestEntitySearchCriteria searchCriteria);

    TestEntityDto getById(UUID id);

    TestEntityDto create(TestEntityDto dto);
}
