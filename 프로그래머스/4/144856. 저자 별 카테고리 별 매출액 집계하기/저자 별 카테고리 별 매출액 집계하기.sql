-- 도서정보, 저자정보, 도서판매량정보
-- 2022년 1월의 저자별, 카테고리별 매출액


SELECT A.AUTHOR_ID, B.author_name, A.category, sum(C.sales * A.price) sales
from BOOK A, AUTHOR B, BOOK_SALES C where 1=1
and a.author_id = b.author_id 
and a.book_id = c.book_id
and to_char(c.sales_date, 'yyyy-MM') = '2022-01'
group by a.author_id, b.author_name, a.category order by 1,3 desc;

