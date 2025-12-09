select project_id, round(sum(experience_years) / count(p.employee_id), 2) as average_years
from project p
join employee e on e.employee_id = p.employee_id
group by project_id;