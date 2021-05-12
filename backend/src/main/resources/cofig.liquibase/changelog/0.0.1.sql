--liquibase formatted sql

--changeset garin:12_05_2021-001
--comment: Тестовая сущность
CREATE TABLE IF NOT EXISTS test_entity
(
    id UUID not null primary key,
    create_date timestamp with time zone default now(),
    edit_date timestamp with time zone default now(),
    content VARCHAR(5000)
);
comment on table test_entity is 'Тестовая сущность';
comment on column test_entity.id is 'Идентификатор';
comment on column test_entity.create_date is 'Дата добавления';
comment on column test_entity.edit_date is 'Дата редактирования';
comment on column test_entity.content is 'Какое-то содержание';
-- rollback drop table if exists test_entity;
