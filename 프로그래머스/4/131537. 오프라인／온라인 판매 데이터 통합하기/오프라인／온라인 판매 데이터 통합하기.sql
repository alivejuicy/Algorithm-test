-- 코드를 입력하세요
-- online_sale_id, user_id, product_id, sales_amount, sales_date
-- offline_sale_id, product_id, sales_amount, sales_date
SELECT to_char(sales_date, 'yyyy-MM-dd') sales_date, product_id, user_id, sales_amount
from online_sale where 1=1 
and to_char(sales_date, 'yyyyMMdd') >= '20220301' 
and to_char(sales_date, 'yyyyMMdd')<= '20220331'

union

SELECT to_char(sales_date, 'yyyy-MM-dd') sales_date, product_id, null user_id, sales_amount
from offline_sale where 1=1 
and to_char(sales_date, 'yyyyMMdd') >= '20220301' 
and to_char(sales_date, 'yyyyMMdd')<= '20220331'
order by 1,2,3