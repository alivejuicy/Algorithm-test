-- 코드를 작성해주세요
select A.item_id, A.item_name, A.rarity 
from item_info A where 1=1 and not exists 
(select 1 
 from item_tree 
 where A.item_id = parent_item_id
)

order by A.item_id desc

