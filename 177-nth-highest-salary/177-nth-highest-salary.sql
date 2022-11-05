CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

    set n = N - 1;
  RETURN (
      # Write your MySQL query statement below.
    
      
      select distinct salary
      from Employee
      Order By salary desc
      limit n,1
  );
END