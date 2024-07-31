-- fish_info, fish_name_info
select count(a.fish_type) fish_count, b.fish_name
from fish_info a, fish_name_info b 
where 1=1 and a.fish_type = b.fish_type
group by b.fish_name order by count(a.fish_type) desc ;