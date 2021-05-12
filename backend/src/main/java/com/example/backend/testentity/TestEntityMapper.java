package com.example.backend.testentity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TestEntityMapper {

    TestEntityMapper INSTANT = Mappers.getMapper(TestEntityMapper.class);

    TestEntityDto map(TestEntity entity);

    TestEntity map(TestEntityDto dto);
}
