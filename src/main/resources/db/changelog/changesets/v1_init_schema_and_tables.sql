-- liquibase formatted sql

-- changeset Pavel:1
create schema if not exists demojoin;

-- changeset Pavel:2
create table if not exists demojoin.customers
(
    id           serial primary key,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    age          smallint,
    phone_number varchar(20)
    );

-- changeset Pavel:3
create table if not exists demojoin.orders
(
    id           serial primary key,
    date         date not null,
    customer_id  int references demojoin.customers (id),
    product_name varchar(50),
    amount       int
    );