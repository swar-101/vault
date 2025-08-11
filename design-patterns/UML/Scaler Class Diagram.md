Requirements:

1. Learners are grouped together in batches.
2. Lectures are scheduled for batches and are taken by a instructor.
3. Each batch runs on a schedule like MWF Morning (lectures happen on Monday-Wednesday-Friday at 7:00 AM), TTS Evening (lecutures happen on Tuesday-Thursday-Saturday at 9:00 PM) etc.
4. Lectures are scheduled as per a batch's schedule.
5. After every lecture ends, students rate the lecture, this rating is used to calculate an instructors avg rating.
6. A learner can move to changes batches in between via course pause or other means. Thus a learner can have multiple previous batches but at max 1 current batch. We need to track learners entry and exit dates for all the previous batches so that we only show them those class's recordings which they have actually attended or they were supposed to attend.


--- 

## Solution

```java

abstract class BaseModel {
	-id : long
	-createdAt: LocalDateTime
	-updatedAt: LocalDateTime
}

enum BatchType {
	MWF_MORNING(DAYS=[MONDAY, WEDNESDAY, FRIDAY], TIME=7:00),
	TTS_EVENING(DAYS=[TUESDAY, THURSDAY, SATURDAY], TIME=21:00)
}

class Batch extends BaseModel {
	-type: BatchType
	-startDate: LocalDateTime
	-endDate: LocalDateTime
}

enum StudentStatus {
	ACTIVE, COURSE_PAUSE
}

class Student extends BaseModel {
	-name: String
	-email: String
	-phoneNumber: String
	-status: StudentStatus
}

class LearnerBatchHistory extends BaseModel {
	-student: Student
	-batch: Batch
	-entryDate: LocalDateTime
	-exitDate: LocalDateTime
}

class Instructor extends BaseModel {
	-name: String
	-email: String
	-phoneNumber: String
	-averageRating: double
	-totalRatings: int
}

class Lecture extends BaseModel {
	-title: String
	-instructor: Instructor
	-batch: Batch
	-startTime: LocalDateTime
	-endTime: LocalDateTime
}

enum Score {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
}

class Rating extends BaseModel {
	-lecture: Lecture
	-instructor: Instructor
	-student: Student
	-score: Score
}

enum ResponseStatus {
	SUCCESS, FAILURE
}

class BatchChangeResponse {
	-responseStatus: ResponseStatus
}

class BatchService {
	+changeBatch(studentId: long, fromBatchId: long, toBatchId: long): BatchChangeResponse
}

class LectureRatingResponse {
	-responseStatus: ResponseStatus
}

class RatingService {
	+rateLecture(learnerId: long, lectureId: long, score: Score): LectureRatingResponse
}
```