select count(id) fish_count from fish_info
group by length
having length is null;