# Write your MySQL query statement below
select distinct P.email
from Person as P, Person as T
where P.id != T.id and P.email = T.email
