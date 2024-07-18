-- ID, FISH_TYPE, LENGTH, TIME
-- 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜

select id, length from fish_info
order by length desc, id asc limit 10


