package com.example.backend.testentity;

import com.example.backend.domains.BaseEntity_;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TestEntitiesSpecification {

    public Specification<TestEntity> search(TestEntitySearchCriteria searchCriteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!searchCriteria.getUuids().isEmpty()) {
                predicates.add(root.get(BaseEntity_.ID).in(searchCriteria.getUuids()));
            }
//            И т.д.
            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
