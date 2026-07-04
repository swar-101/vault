## 🎯 SQL Contest Cheat Sheet v1.0

_(Built for: Fast Recall + Contest Traps Avoidance)_

---

### 🧱 1. SELECT & WHERE Basics

**Concept:** `SELECT` chooses columns, `WHERE` filters rows before grouping.

✅ Example

```sql
SELECT name, age 
FROM students
WHERE age >= 18;
```

⚠️ Gotcha

- `WHERE` cannot be used with aggregates (`COUNT`, `SUM`, etc.) — use `HAVING` for that.
    

---

### 🧮 2. GROUP BY + HAVING

**Concept:** Aggregates per group → `GROUP BY`.  
**Filter aggregated results → HAVING`.

✅ Example

```sql
SELECT grade, COUNT(*) AS num_students
FROM students
GROUP BY grade
HAVING COUNT(*) > 1;
```

⚠️ Gotcha

- `HAVING` works **after** grouping.
    
- `WHERE` filters **before** grouping.
    

---

### 🔗 3. LEFT JOIN Logic (Contest Favorite Trap)

**Concept:** Returns all rows from left table + matched ones from right table.

✅ Correct Example

```sql
SELECT s.name, sc.score AS math_score
FROM students s
LEFT JOIN scores sc 
  ON s.student_id = sc.student_id 
  AND sc.subject = 'Math';
```

⚠️ Gotcha

- Don’t put `sc.subject = 'Math'` in `WHERE` → it nullifies the LEFT JOIN and drops unmatched rows.
    
- `IFNULL()` or `COALESCE()` can replace NULLs for display:
    
    ```sql
    COALESCE(sc.score, 0) AS math_score
    ```
    

---

### 🧩 4. Subqueries

**Concept:** Use one query inside another to filter, compare, or aggregate.

✅ Example

```sql
SELECT name
FROM students
WHERE student_id IN (
    SELECT student_id 
    FROM scores 
    WHERE score > 90
);
```

⚠️ Gotcha

- Always match columns between inner and outer queries (`student_id`, not `score`).
    
- Subqueries inside `IN` should return a **single column**.
    

---

### 🧠 5. Aggregate Functions Refresher

| Function | Purpose        | Example       |
| -------- | -------------- | ------------- |
| COUNT()  | Number of rows | `COUNT(*)`    |
| SUM()    | Total value    | `SUM(salary)` |
| AVG()    | Average        | `AVG(score)`  |
| MIN()    | Lowest value   | `MIN(age)`    |
| MAX()    | Highest value  | `MAX(score)`  |

⚠️ Gotcha

- Aggregates ignore NULL values except `COUNT(*)`, which counts them as rows.
    

---

### ⚙️ 6. ORDER BY & LIMIT

**Concept:** Sort results, optionally limit rows.

✅ Example

```sql
SELECT name, score
FROM scores
ORDER BY score DESC
LIMIT 5;
```

⚠️ Gotcha

- `ORDER BY` happens **after** SELECT.
    
- Always mention column names, not aliases in `WHERE`.
    

---

### 🧬 7. Aliases (AS)

**Concept:** Rename columns or tables temporarily for readability.

✅ Example

```sql
SELECT s.name, sc.score AS final_score
FROM students AS s
JOIN scores AS sc ON s.student_id = sc.student_id;
```

⚠️ Gotcha

- Table aliases don’t persist outside the query.
    

---

### 🧱 8. NULL Handling

**Concept:** NULL ≠ 0 ≠ ''.

✅ Example

```sql
SELECT name
FROM students
WHERE age IS NULL;
```

⚠️ Gotcha

- Use `IS NULL` / `IS NOT NULL`, never `= NULL`.
    
- Replace NULLs: `COALESCE(column, default_value)`
    

