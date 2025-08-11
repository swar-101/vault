
**Problem Description**

SCALER organizes a series of contests aimed at helping learners enhance their coding skills. Each learner can participate in multiple contests, and their participation is represented by integers in an array. 
The goal is to identify how frequently each learner has participated in these contests. This information will help SCALER determine which learners are participating at the least, allowing them to provide targeted support and encouragement. 


Given an array **A** that represents the participants of various contests, where each integer corresponds to a specific learner, and an array **B** containing the learners from whom you want to check participation frequency, your task is to find the frequency of each learner from array **B** in the array A and return a list containing all these frequencies. 


---

A = \[1, 2, 1, 1\]
B = \[1, 2\]


1. Create an empty map: Use `learnerId` as key and `frequency` as value
2. Iterate over A
3. Accumulate frequencies to their respective keys
4. Declare an empty array of size B. 
5. Iterate over B.
6. Use these elements to get the value by using the map's keys and add them to this list
7. Return the list. 


