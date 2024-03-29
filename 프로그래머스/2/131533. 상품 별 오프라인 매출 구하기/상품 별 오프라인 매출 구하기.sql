-- 코드를 입력하세요
SELECT A.PRODUCT_CODE, SUM(A.PRICE*B.SALES_AMOUNT) AS SALES
FROM PRODUCT A 
INNER JOIN OFFLINE_SALE B
USING (PRODUCT_ID)
GROUP BY PRODUCT_CODE, PRICE
ORDER BY 2 DESC, 1
;