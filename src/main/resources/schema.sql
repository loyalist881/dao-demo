create schema if not exists demojoin;

create table if not exists demojoin.CUSTOMERS
(
    id           bigserial primary key,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    age          int,
    phone_number varchar(20),
    email        varchar(100)
);

create table if not exists demojoin.ORDERS
(
    id           bigserial primary key,
    date         date not null,
    customer_id  bigint references demojoin.customers (id),
    product_name varchar(50),
    amount       int
);