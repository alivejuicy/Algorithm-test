-- 코드를 입력하세요
select A.member_name, B.review_text, to_char(B.review_date, 'yyyy-mm-dd') review_Date
from member_profile A, rest_review B
where 1=1 
and A.member_id = B.member_id
and A.member_id in 
(
    select member_id from rest_review
    group by member_id 
    having count(member_id) = 
    (
        select max(count(member_id)) from rest_review
        group by member_id
    )   
)
order by 3,2