select count(id) fish_count, month(time) month from fish_info
group by month(time)
having count(id) > 0 
order by month(time)