-- liquibase formatted sql

-- changeset Pavel:4
insert into demojoin.customers
(id, name, surname, age, phone_number, email)
values (1, 'Alexey', 'smirnov', 30, '801(6988)211-92-09', 'alexey1@mail.com'),
       (2, 'pavel', 'sokolov', 23, '81(280)445-34-51', 'pavel@mail.com'),
       (3, 'alexeY', 'tarasov', 40, '53(22)001-12-04', 'alexey2@mail.com'),
       (4, 'alexEY', 'kuhto', 45, '0(1223)244-79-82', 'alexey3@mail.com'),
       (5, 'elena', 'sokolova', 29, '05(36)542-66-49', 'elena@mail.com')
on conflict (id) do nothing;

-- changeset Pavel:5
insert into demojoin.orders
(id, date, customer_id, product_name, amount)
values (1, '2026-03-12', 1, 'milk', 2),
       (2, '2026-04-05', 2, 'cheese', 3),
       (3, '2026-04-22', 3, 'beer', 6),
       (4, '2026-05-14', 4, 'chicken', 1),
       (5, '2026-05-30', 5, 'water', 1)
on conflict (id) do nothing;

-- changeset Pavel:6
SELECT setval('demojoin.customers_id_seq', (SELECT MAX(id) FROM demojoin.customers));
SELECT setval('demojoin.orders_id_seq', (SELECT MAX(id) FROM demojoin.orders));