-- 코드를 입력하세요
-- NAME에 el이 들어감
-- 아이디와 이름 출력 , 이름 순으로 조회
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE NAME LIKE '%EL%'
AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME ASC