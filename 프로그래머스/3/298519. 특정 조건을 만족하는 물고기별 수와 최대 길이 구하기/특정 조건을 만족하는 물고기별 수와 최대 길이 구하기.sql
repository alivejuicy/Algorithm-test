-- id, 종류, 길이, 날짜
select count(id) fish_count, max(length) max_length, fish_type
from fish_info A where 1=1
group by fish_type
having avg(
    case 
        when length is null or length <= 10 
        then 10
        else length 
    end) >= 33
order by fish_type