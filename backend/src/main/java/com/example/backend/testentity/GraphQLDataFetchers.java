package com.example.backend.testentity;

import graphql.schema.DataFetcher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class GraphQLDataFetchers {

    private final TestEntityService testEntityService;

//    public DataFetcher<TestEntityDto> getTestEntitiesPage() {
//        return dataFetchingEnvironment -> {
//            dataFetchingEnvironment.
//        }
//    }

    public DataFetcher<TestEntityDto> getTestEntityById() {
        return dataFetchingEnvironment -> {
            UUID id = dataFetchingEnvironment.getArgument("id");
            return testEntityService.getById(id);
        };
    }
}
