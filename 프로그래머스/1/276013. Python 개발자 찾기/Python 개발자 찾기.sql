-- DEVELOPER_INFOS 
select id, email, first_name, last_name
from DEVELOPER_INFOS where 1=1
and (skill_1 in ('Python') or skill_2 in ('Python') or skill_3 in ('Python'))
order by 1
