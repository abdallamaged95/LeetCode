# Write your MySQL query statement below


select p.product_id, round(if(sum(price * units) / sum(units) is null, 0, sum(price * units) / sum(units)), 2) as average_price
from prices p
left join unitsSold u on u.product_id = p.product_id 
    and u.purchase_date between p.start_date and p.end_date
group by p.product_id;

-- select p.product_id, count(u.units)
-- from prices p
-- left join unitsSold u on u.product_id = p.product_id 
--     and u.purchase_date between p.start_date and p.end_date
-- group by p.product_id;