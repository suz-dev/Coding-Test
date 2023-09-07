-- 코드를 입력하세요
select b.category, sum(bs.sales) as '판매량'
from book b, book_sales bs
where b.book_id = bs.book_id 
and month(sales_date) = '01' and year(sales_date) = '2022'
group by b.category
order by b.category;