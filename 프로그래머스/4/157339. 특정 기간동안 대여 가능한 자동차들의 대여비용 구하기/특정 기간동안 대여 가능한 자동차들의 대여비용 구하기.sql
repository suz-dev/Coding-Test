SELECT rental.CAR_ID, rental.CAR_TYPE, ROUND((rental.daily_fee * (1 - discount.discount_rate * 0.01) * 30),0) AS FEE
FROM car_rental_company_car rental 
join car_rental_company_rental_history history on rental.car_id = history.car_id
join car_rental_company_discount_plan discount on rental.car_type = discount.car_type

where history.car_id not in (
    select car_id
    from car_rental_company_rental_history
    WHERE start_date <= '2022-11-30' AND end_date >= '2022-11-01'
)

and discount.duration_type = '30일 이상' 
group by 1
having rental.car_type in ('세단', 'SUV') and (fee >= 500000 and fee < 2000000)
order by 3 desc, 2, 1 desc
;