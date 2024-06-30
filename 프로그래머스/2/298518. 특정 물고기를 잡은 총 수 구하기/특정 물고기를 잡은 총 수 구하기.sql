-- 코드를 작성해주세요
select count(A.ID) FISH_COUNT
from FISH_INFO A, FISH_NAME_INFO B where 1=1
and A.FISH_TYPE = B.FISH_TYPE
and FISH_NAME in ('BASS', 'SNAPPER')