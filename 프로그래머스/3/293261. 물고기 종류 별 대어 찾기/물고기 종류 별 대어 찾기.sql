-- 코드를 작성해주세요
-- id, 어종, 길이, 낚은 날짜


select A.ID as ID, B.FISH_NAME as FISH_NAME, A.LENGTH as LENGTH
from FISH_INFO A, FISH_NAME_INFO B
where 1=1
and A.FISH_TYPE = B.FISH_TYPE
and A.FISH_TYPE in 
    (select FISH_TYPE from FISH_INFO group by FISH_TYPE 
     having LENGTH = MAX(LENGTH)  )
order by ID