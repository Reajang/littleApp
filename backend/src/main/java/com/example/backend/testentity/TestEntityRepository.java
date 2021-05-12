package com.example.backend.testentity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, UUID>, JpaSpecificationExecutor<TestEntity> {
}
