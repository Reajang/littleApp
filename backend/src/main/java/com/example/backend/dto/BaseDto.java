package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseDto {
    /**
     * Идентификатор
     */
    @EqualsAndHashCode.Include
    protected UUID id;
    /**
     * Дата создания
     */
    protected Instant createDate;
    /**
     * Дата последнего редактирования
     */
    protected Instant editDate;
}
