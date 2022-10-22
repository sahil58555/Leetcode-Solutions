# Write your MySQL query statement below
select name as Customers
from customers
where (id,name) not In (
    
    select customers.id,name 
    from customers,orders
    where customers.id = orders.customerId
)