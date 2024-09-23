-- USED_GOODS_BOARD // 게시판 정보
-- USED_GOODS_USER // 게시판 사용자 정보

-- status 완료된 거래중 총 금액(sum)이 70만원 이상이여야함
-- 회원 id, 닉네임, 총거래금액, 총거래금액 기준 오름차
select A.writer_id, B.nickname, sum(A.price) total_sales
from USED_GOODS_BOARD A, USED_GOODS_USER B 
where 1=1 and A.writer_id = B.user_id and A.status = 'DONE'
group by A.writer_id, B.nickname
having sum(A.price) >= 700000
order by 3