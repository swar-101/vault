
### Multiple Joins VS Nested Subqueries

Example:

- Tables:
	- `employees`
		- Columns: 
			- `employee_id` (PK)
			- `first_name`
			- `last_name`
			- `department_id` (FK)
	
	- `departments`
		- Columns: 
			- `department_id` (PK)
			- `department_name`
			- `location_id` (FK)
	- `locations`
		- Columns:
			- `location_id` (PK)
			- `city`

Write an SQL query to retrieve all employees whose department is located in "Seattle".
- The result should include the columns: `employee_id`, `first_name`, `last_name` and `job_id`.
- The result should be sorted by `employee_id` in ascending order. 
---

#### Using Multiple Joins 

```sql
SELECT e.employee_id, e.first_name, e.last_name, e.job_id
FROM employees e
JOIN departments d ON d.employee_id = e.employee_id
JOIN locations l ON l.location_id = d.location_id
WHERE l.city = 'Seattle'
ORDER BY e.employee_id ASC; 
```


#### Using Nested Subqueries

```sql
SELECT employee_id, first_name, last_name, job_id
FROM employees
WHERE department_id IN (
	SELECT department_id 
	FROM departments 
	WHERE location_id IN (
		SELECT location_id
		FROM locations 
		WHERE city = 'Seattle'
	)
)
ORDER BY employee_id ASC;
```


#### *Which is better?*

- **Joins** are generally more performant because the **SQL Optimizer** can build a single execution plan and use indexes efficiently. They're ideal when you need columns from multiple tables.
- **Subqueries** are often easier to read when you're just filtering rows based on another table, but can be less efficient if nested deeply. 

**Rule of thumb:** use joins when combining data, subqueries when filtering by a condition.

There's a better way to make it readable and performant
Read : [[CTE]] 


