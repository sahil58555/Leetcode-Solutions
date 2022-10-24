# Write your MySQL query statement below
select player_id,Min(event_date) as first_login
from Activity
Group By player_id