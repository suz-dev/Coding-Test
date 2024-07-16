select date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, user_id, sum(sales_amount) as sales_amount
from online_sale 
where year(sales_date) = '2022' and month(sales_date) = '03'
group by 1, 2, 3

union all

select date_format(sales_date, '%Y-%m-%d') as sales_date, product_id, NULL, sum(sales_amount) as sales_amount
from offline_sale 
where year(sales_date) = '2022' and month(sales_date) = '03'
group by 1, 2, 3

order by 1, 2, 3
;