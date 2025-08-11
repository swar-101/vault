Design schema for Scaler with the following requirements:

1. Learners are grouped together in batches.
2. Lectures are scheduled for batches and are taken by a instructor.
3. Each batch runs on a schedule like MWF Morning (lectures happen on Monday-Wednesday-Friday at 7:00 AM), TTS Evening (lecutures happen on Tuesday-Thursday-Saturday at 9:00 PM) etc.
4. Lectures are scheduled as per a batch's schedule.
5. After every lecture ends, students rate the lecture, this rating is used to calculate an instructors avg rating.
6. A learner can move to changes batches in between via course pause or other means. Thus a learner can have multiple previous batches but at max 1 current batch. We need to track learners entry and exit dates for all the previous batches so that we only show them those class's recordings which they have actually attended or they were supposed to attend.

---

## Solution

```sql

CREATE TABLE student (
	id BIGINT PRIMARY KEY, 
	name VARCHAR(255), 
	phone VARCHAR(20) UNIQUE,
	email VARCHAR(255) UNIQUE
);

CREATE TABLE instructor (
	id BIGINT PRIMARY KEY,
	name VARCHAR(255), 
	phone VARCHAR(20) UNIQUE,
	email VARCHAR(255) UNIQUE,
	average_rating DOUBLE PRECISION, 
	total_ratings BIGINT
);

CREATE TYPE batch_type_enum AS ENUM (
	'MWF MORNING',
	'TTS EVENING'
);


CREATE TYPE student_status_enum AS ENUM (
	'ON COURSE PAUSE',
	'ACTIVE'
);

CREATE TABLE batch (
	id BIGINT PRIMARY KEY,
	batch_type batch_type_enum, 
	status student_status_enum,
	start_date TIMESTAMP, 
	end_date TIMESTAMP
);

CREATE TABLE lecture (
	id BIGINT PRIMARY KEY, 
	title VARCHAR(100), 
	batch_id BIGINT REFERENCES batch(id),
	instructor_id BIGINT REFERENCES instructor(id),
	start_time TIMESTAMP,
	end_time TIMESTAMP
);

CREATE TABLE learner_batch_history (
	id BIGINT PRIMARY KEY, 
	student_id BIGINT REFERENCES student(id),
	batch_id BIGINT REFERENCES batch(id),
	entry_date TIMESTAMP,
	exit_date TIMESTAMP
);

CREATE TABLE rating (
	id BIGINT PRIMARY KEY, 
	lecture_id BIGINT REFERENCES lecture(id), 
	instructor_id BIGINT REFERENCES instructor(id), 
	student_id BIGINT REFERENCES student(id),
	score INT CHECK (score BETWEEN 1 AND 5)
);

```

