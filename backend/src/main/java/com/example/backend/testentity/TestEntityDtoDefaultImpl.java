package com.example.backend.testentity;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class TestEntityDtoDefaultImpl implements TestEntityService {

    private final TestEntityRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<TestEntityDto> findAll(TestEntitySearchCriteria searchCriteria) {
        return repository.findAll(
                TestEntitiesSpecification.search(searchCriteria),
                PageRequest.of(searchCriteria.getPageNumber(), searchCriteria.getPageSize())
        ).map(TestEntityMapper.INSTANT::map);
    }

    @Override
    @Transactional(readOnly = true)
    public TestEntityDto getById(UUID id) {
        return repository.findById(id)
                .map(TestEntityMapper.INSTANT::map)
                .orElseThrow();
    }

    @Override
    @Transactional
    public TestEntityDto create(TestEntityDto dto) {
        TestEntity saved = repository.save(TestEntityMapper.INSTANT.map(dto));
        return TestEntityMapper.INSTANT.map(saved);
    }
}
