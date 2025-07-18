Requirements:

1. Users should be able to track their expense with other users.
2. Users should be able to create groups and start tracking expenses.
3. Multiple people can pay up in an expense. Also, amount can be split up unequally in an expense. Consider this example: Users involved A,B,C Expense amount: 2000 A B C Paid amount: 1500 500 0 Owed amount: 500 500 1000 Here A paid 1500 and B paid 500. But A and B consumed worth 500 where as C consumed worth 1000.
4. An expense will also have its currency, description and an optional bill image attribute.
5. Users should be able to able to settle up their balances with minimum number of transactions using the settle up feature.


--- 

## Solution


```sql

CREATE TABLE users (
	id BIGINT PRIMARY KEY, 
	name VARCHAR(255) NOT NULL,
	phone VARCHAR(20),
	email VARCHAR(255) UNIQUE, 
	created_at TIMESTAMP,
	updated_at TIMESTAMP
);


CREATE TABLE groups (
	id BIGINT PRIMARY KEY, 
	name VARCHAR(255),
	admin_id BIGINT REFERENCES users(id),
	created_by BIGINT REFERENCES users(id),
	created_at TIMESTAMP,
	updated_at TIMESTAMP
);

CREATE TABLE group_users (
	id BIGINT PRIMARY KEY,
	user_id BIGINT REFERENCES users(id),
	group_id BIGINT REFERENCES groups(id),
	user_role VARCHAR(10) CHECK (user_role IN ('ADMIN', 'MEMBER')),
	created_at TIMESTAMP, 
	updated_at TIMESTAMP,
	UNIQUE (user_id, group_id)
);


CREATE TABLE expenses (
	id BIGINT PRIMARY KEY, 
	group_id BIGINT REFERENCES groups(id),
	description TEXT, 
	total_amount DOUBLE PRECISION,
	created_at TIMESTAMP,
	updated_at TIMESTAMP
);


CREATE TABLE expense_splits (
	id BIGINT PRIMARY KEY, 
	expense_id BIGINT REFERENCES expenses(id),
	user_id BIGINT REFERENCES users(id),
	paid_amount DOUBLE PRECISION,
	owed_amount DOUBLE PRECISION, 
	created_at TIMESTAMP, 
	updated_at TIMESTAMP
);


CREATE TABLE transactions (
	id BIGINT PRIMARY KEY, 
	from_user_id BIGINT REFERENCES users(id),
	to_user_id BIGINT REFERENCES users(id),
	amount DOUBLE PRECISION NOT NULL,
	created_at TIMESTAMP,
	updated_at TIMESTAMP
);

CREATE TABLE balance_sheet (
	id BIGINT PRIMARY KEY, 
	from_user_id BIGINT REFERENCES users(id),
	to_user_id BIGINT REFERENCES users(id),
	balance_amout DOUBLE PRECISION
);

```