package com.example.backend.configuration;

import com.example.backend.testentity.GraphQLDataFetchers;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Configuration
public class GraphQLConfiguration {

    @Value("classpath:graphql/schema.graphqls")
    private Resource graphqlSchema;

    public GraphQLConfiguration(GraphQLDataFetchers graphQLDataFetchers) {
        this.graphQLDataFetchers = graphQLDataFetchers;
    }

    private final GraphQLDataFetchers graphQLDataFetchers;

    @Bean
    public GraphQL graphQL() {
        String sdl;
        try (Reader reader = new InputStreamReader(graphqlSchema.getInputStream(), StandardCharsets.UTF_8)) {
            sdl = FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException("Can not read file classpath:graphql/schema.graphqls", e);
        }
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        return GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("testEntity", graphQLDataFetchers.getTestEntityById())
//                        .dataFetcher("testEntities", graphQLDataFetchers.getTestEntitiesPage())

                )
//                .type(newTypeWiring("Book")
//                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                .build();
    }
}
