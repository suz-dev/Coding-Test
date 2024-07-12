SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * BS.SALES) AS TOTAL_PRICE
FROM BOOK B 
RIGHT JOIN BOOK_SALES BS
ON B.BOOK_ID = BS.BOOK_ID
INNER JOIN AUTHOR A
ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE DATE_FORMAT(SALES_DATE, "%Y-%m") = "2022-01"
GROUP BY 1, 3
ORDER BY 1, 3 DESC
;
