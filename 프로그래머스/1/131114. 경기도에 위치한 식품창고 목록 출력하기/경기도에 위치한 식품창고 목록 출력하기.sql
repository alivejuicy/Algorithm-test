-- 식품창고, food_warehouse
-- 아이디, 이름, 주소, 전화번호, 냉동시설 여부(y,n,null)

select warehouse_id, warehouse_name, address, decode(freezer_yn, null, 'N',freezer_yn) freezer_yn
from food_warehouse
where 1=1 and address like '%경기도%'
order by 1