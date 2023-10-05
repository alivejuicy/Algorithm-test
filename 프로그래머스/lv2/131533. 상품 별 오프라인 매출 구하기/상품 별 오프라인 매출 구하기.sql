-- 판매중인 상품 product, 판매 정보를 담은 offline_sale
-- 상품 아이디, 코드, 판매가
-- 상품코드 8자리, 앞 2자리 카테고리 코드
-- 오프라인 상품판매 아이디, 상품 아이디, 판매량, 판매일

-- 상품 코드 별 매출액(판매가 * 판매량) 합계 출력

SELECT P.PRODUCT_CODE, SUM(P.PRICE * O.SALES_AMOUNT) AS SALES
-- 상품 코드와 매출액
FROM PRODUCT P JOIN OFFLINE_SALE O
-- INNER JOIN으로 교집합(판매 정보가 있으며 판매중인 상품)
ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
ORDER BY SALES DESC, P.PRODUCT_CODE
    
    

