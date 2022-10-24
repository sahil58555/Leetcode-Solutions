# Write your MySQL query statement below
Select w2.id 
from Weather w1,Weather w2
where w1.id != w2.id and DATEDIFF(w1.recordDate,w2.recordDate) = -1 and w1.temperature < w2.temperature
