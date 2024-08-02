-- 출하id가 같으면 다 같지만, 맛이 같은 아이스크림이여도 출하id는 다르다.
select flavor from 
(
    select a.flavor, sum(a.total_order + b.total_order) result from july a, first_half b
    where a.flavor = b.flavor
    group by a.flavor
    order by 2 desc
) c
where 1=1 and rownum<=3
;