-- # Write your MySQL query statement below


-- select user_id, count(*) 
-- from (
--     select user_id, action
--     from signups s
--     left join confirmations c using (user_id)
-- ) e 
-- group by user_id;

select outer_s.user_id, ROUND((
    select count(c.user_id)
    from signups s
    left join confirmations c on s.user_id = c.user_id and action = 'confirmed'
    where s.user_id = outer_s.user_id
)
/ (
    select count(*)
    from signups s
    left join confirmations c on c.user_id = s.user_id
    where s.user_id = outer_s.user_id
), 2) as confirmation_rate
from signups outer_s;