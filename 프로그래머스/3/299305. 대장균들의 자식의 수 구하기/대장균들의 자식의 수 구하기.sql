-- 코드를 작성해주세요
select  t1.ID, count(t2.ID) CHILD_COUNT
from ECOLI_DATA t1 left join ECOLI_DATA t2 -- where 1=1
on t1.ID = t2.PARENT_ID
group by 1 order by 1