select demojoin.orders.product_name
from demojoin.customers
         inner join demojoin.orders
                    on demojoin.customers.id = demojoin.orders.customer_id
where name ilike :name;