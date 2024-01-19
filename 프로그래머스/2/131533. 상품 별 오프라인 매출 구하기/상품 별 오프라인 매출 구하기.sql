-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, (p.PRICE * T1.AMOUNT) AS SALES
FROM PRODUCT p
JOIN
(SELECT PRODUCT_ID, SUM(SALES_AMOUNT) AS AMOUNT
FROM OFFLINE_SALE
GROUP BY PRODUCT_ID) AS T1
ON p.PRODUCT_ID = T1.PRODUCT_ID
ORDER BY 2 DESC,1
;