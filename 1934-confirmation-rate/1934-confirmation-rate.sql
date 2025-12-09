


select user_id, round(
    (
    select count(action)
    from signups
    left join confirmations c on c.user_id = s.user_id and action = 'confirmed'
    where signups.user_id = s.user_id
    ) / (
    select count(*)
    from signups
    left join confirmations c using (user_id)
    where signups.user_id = s.user_id
    ), 2) as confirmation_rate
from signups s;
