# Write your MySQL query statement below
with T as (
    select customer_number,count(*) as count
    from Orders
    group by customer_number 
)

select customer_number
from T
where count = (
    
    select Max(count)
    from T
)



