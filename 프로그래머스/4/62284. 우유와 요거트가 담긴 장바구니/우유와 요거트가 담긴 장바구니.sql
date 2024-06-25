-- product_info
-- id, cart_id, name, price


SELECT distinct A.cart_id 
from cart_products A, 
(select cart_id, count(id) ID, sum(price) price
    from cart_products where 1=1 and name in ('Milk','Yogurt')
    group by cart_id
) B
where 1=1 
and A.cart_id = B.cart_id
and B.id = 2 and B.price = 4860
order by A.cart_id
