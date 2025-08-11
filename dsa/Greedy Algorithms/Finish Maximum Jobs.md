a.k.a. activity selection problem

You're given `N` jobs with start time and end time. 
You can only do one job at a time, and you need to find the maximum number of non-overlapping jobs you can do.

Given an array `A` denoting the start time of the jobs and an array `B` denoting the finish time of the jobs. 

**Problem Constraints**
1 <= N = 10<sup>5</sup>
1 <= A\[i\] < B\[i\] <= 10<sup>9</sup>

---

Greedy choice:

We always pick the job that finishes earliest because, 

> The earlier we free ourselves up, the more time we have to do more jobs after. 


1. Pair up each job with its start and end time. 
2. Sort all jobs by end time. 
3. Initialize `count = 1` and track `lastEnd = end time of first job`
4. Iterate through remaining jobs: 
	- If `start[i] >= lastEnd` -> select job -> update `count` and `lastEnd`.


