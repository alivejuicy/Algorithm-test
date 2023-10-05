-- 비율 구하기
-- 회원정보 :회원 ID, 성별, 나이, 가입일
-- 판매정보: 판매 ID, 상품ID, 판매량, 판매일, 회원ID(FK)
-- 동시구매 없음

-- 2021년에 가입한 전체 회원(A) 중 상품 구매한 회원 수(B), 구매한 회원 비율 (A/B)-> 년,월별로 출력
-- 비율은 소수 두번째에서 반올림 년 기준 오름차순, 월 오름차순

SELECT YEAR(B.SALES_DATE) AS YEAR,
MONTH(B.SALES_DATE) AS MONTH,

COUNT(DISTINCT B.USER_ID) AS PUCHASED_USERS,
-- 상품을 구매한 회원 수(중복 제거 -> 구매 여러번 했을 수도 잇으니까)

-- 상품 구매한 회원 비율 (구매 회원 수 / 2021년에 가입한 회원)
ROUND(COUNT(DISTINCT B.USER_ID) / (SELECT COUNT(DISTINCT USER_ID) FROM USER_INFO WHERE JOINED LIKE '2021%' GROUP BY YEAR(JOINED)), 1) AS PUCHASED_RATIO

-- 2021년에 가입한 회원 정보만 A, 판매 내역 B 조인
FROM (SELECT USER_ID FROM USER_INFO WHERE JOINED LIKE '2021%') A JOIN ONLINE_SALE B
ON A.USER_ID = B.USER_ID
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH
-- 2021년에 상품 구매한 회원들만 모여짐
-- 주의할 점 : 가입은 2021년도지만 상품 구매 시기는 다를 수 있음, 상품 구매 시기 년 월을 출력토록


