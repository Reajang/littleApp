package com.example.backend.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseEntity {

    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    protected UUID id;

    /**
     * Дата и время создания записи
     */
    @Basic(optional = false)
    @Column(name = "create_date", nullable = false)
    protected Instant createDate;

    /**
     * Дата и время последнего обновления записи
     */
    @Basic(optional = false)
    @Column(name = "edit_date", nullable = false)
    protected Instant editDate;

    @PreUpdate
    @PrePersist
    public void preSave() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }

        Instant now = Instant.now();
        if (this.createDate == null) {
            this.createDate = now;
        }
        this.editDate = now;
    }
}
