-- liquibase formatted sql

-- changeset Pavel:1
create schema if not exists demojoin;

-- changeset Pavel:2
create table if not exists demojoin.CUSTOMERS
(
    id           bigserial primary key,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    age          int,
    phone_number varchar(20)
);

-- changeset Pavel:3
create table if not exists demojoin.ORDERS
(
    id           bigserial primary key,
    date         date not null,
    customer_id  bigint references demojoin.customers (id),
    product_name varchar(50),
    amount       int
);