# Write your MySQL query statement below
select *
from Cinema
where id & 1 = 1 and description != 'boring'
Order by rating desc