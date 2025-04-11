

Steps you can take to solve problems effectively: 
0. Make sure you completely understand the problem statement and its constraints to come up with a solution. 
1. Find a brute force solution. 
2. Identify the edge cases and handle them.
3. Write down pseudo code to ensure your solution is a fit.
4. Compute the time and space complexity for the problem.
5. Optimize your code by identifying patterns and minimizing extra steps.
6. Write down the final solution. 
7. Test and validate using custom inputs.


## **Let's take a look at an interesting example and understand how we can apply these steps!**
---
## **Problem Statement:** 
## Write a program that reads multiple files in parallel using multithreading. Each thread should read one file and print its content.
---
## **Solution:** 

### **Step 0:** Ask yourself, "Do you completely understand the problem statement to come up with a solution? What are the constraints?"  

#### There are 2 possibilities: 

#### **Possibility 1:** You don't know / You're not able to remember: 
*"Wow, multithreading and reading files, I don't clearly know how that works, well, let me start exploring how it's done and practice until I am ready to come back and solve this problem!"*
#### **OR**
#### **Possibility 2:** You are starting to remember...

After quick thinking, I was able to recall using Runnable for starting new threads and running processes. Here, the process should be reading each file parallelly and printing its content. 
*I am confident about the multithreading part because I remember creating new threads using Runnable.*

> Somewhere in my mind: 
```java
public class FileReaderTask implements Runnable {

	private String filePath;

	public ParallelFileReader(String filePath) {
		this.filePath = filePath;
	}
	
	@Override 
	public void run() {
		readFile(filePath);
	}
 }
 
```

*Hmmm... but, how do I read files?* 
*(a wild thought arrives) A-ha! Now I remember! I can use `FileReader` to read the files and use `BufferedReader` to read each line one-by-one.* 

 > Somewhere in my mind, I was able to recall this pattern..
 
```java
public class ReadFileExample {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}
}
```

>**Note:**  The trick is to be able to recognize and visualize these patterns in your head from your previous experiences to integrate them together in one solution : 
> 1. Multithreading using `Runnable`
> 2. Reading the files using `FileReader`
> 3. Parsing the file content using `BufferedReader`
> 4. Printing it line by line using the `readLine()` and `System.out.println()` methods.

(another wild thought arrives) `ExecutorService`, the advanced concurrency concept!
I am sure `ExecutorService` is something that could make this easier, I am not able to think how. Well, let's park that aside, I have already have an approach, let's work on that first! 
# 🚧

> **Note:** It won't be picture perfect in your head sometimes, but if you believe that you can express it in code, that's enough! While writing the pseudo code you will get more clarity.



> **Note:** You'll get some wild thoughts along the way you solve problems. There are two types of ideas when it comes to these wild thoughts.
> 1. Ones which make your current solution better.
> 2. Ones which you think can make your current solution better, but may take up time.
> 
>   make sure you park the 2nd type of ideas aside as they have the potential but could also delay our already workable solution!


#### **Wait!! it's not over! What are the constraints?** 

*Let me re-read the problem statement...*

> Write a program that reads multiple files in parallel using multithreading. Each thread should read one file and print its content.

Don't you think the problem statement is ambiguous? 

Even if a problem statement might look simple, there are hidden constraints to a problem.
Ask clarifications questions to ensure that your proposed solution is a fit to the given problem statement.

If there aren't any constraints expected, you can write a solution in your own preferred way!
But that's rarely the case, real-world does demand constraints...

// Do I need to fix this line? 
In order to understand what the constraints might be, let's visit the following clarification questions that the problem could've demanded.

1. Do the input files contain text? 
> *Since, we're going to read files and print content, it's highly likely that the input files will be text or document files. Asking this question ensures that I am clear with what kind of input the problem is expecting.* 

2. What do I pass as the input parameter? 
> *I will ask this question to be sure what the data type of the input is expected. This question will strengthen my grasp of the problem and enable me to understand the data structure expected as the input parameter.* 

3. Should the contents from the files be printed in a particular order, or is it okay if they appear in the order of thread completion?
> *This question ensures that if order matters, I might need to implement  a mechanism to preserve it.*

4. What should the program do if one or more files are not found or cannot be read? Should it skip, retry or terminate? 
> *This help in designing robust error handling and ensures clarity on how to manage exceptions.*

5. Are there any constraints on file sizes? For extremely large files, should we read the entire content at once, or would a buffered/streaming approach be preferred? 
> *This clarifies whether memory consumption could be an issue and if a more nuanced reading strategy is needed.*

6. Are there any specific requirements regarding resource management, like closing files or cleaning up threads, especially in case of errors? 
> *This reinforces best practices for resource management.* 

7. Is it acceptable to use advanced threading frameworks (like ExecutorService) or should we stick to plain Thread/Runnable implementations? 
> *This determines the level of abstraction expected for the multithreading part. This approach also helps in reading large sized files or large number files.* 

8. Is it necessary to validate our solution? How should we validate that all threads have completed successfully before the program terminates? Is it okay to simply wait for all threads, or should we implement additional logging or confirmation? 
> *This question ties with the Testing/Validation step to ensure program's completeness.*


#### **Expectation**: Does the problem involve asking each and every question mentioned above? 

#### **Reality**: Not exactly, but the more questions you are able to ask shows how well you can solve the problem that's been asked! 


To keep things simple, **let's consider there aren't any constraints.** 

---
### **Step 1:** Find a Brute Force Solution

// Can I express it better for the readers to understand? 
By realizing that we can achieve parallel execution by creating new threads using the `Runnable` interface and that we can use `FileReader` to get the file which we can further parse using `BufferedReader`, we are ready with our brute force solution.


> **Note:** Even if you might remember a better way to solve a certain problem along the way, stick to your brute force solution as it is more likely to lead you to solution first. You can then try the seemingly better way later! 
> 
> Remember the proverb, *"A bird in the hand is worth two in the bush"*.
> 
> The bird in hand is our brute force solution, although the two in the bush could be better solutions to our problem, we need to get the brute force solution working first. 
> 
> Why we need to get a working solution first? 
> Because the world needs reliable, functioning solutions. 
> As they provide immediate value, reduce risks, and form the foundation for continuous improvement. 
> Once you have the base ready, you can always improve it later. 


**An afterthought of self-appreciation:** 

*"Phew! If I wasn't confident about understanding the problem statement to come up with a solution, it would've taken me forever to solve it. I'm glad I know these concepts."*

In the next step, we have to think critically to make sure our solution handles everything that could go wrong.

---
### **Step 2:** Identify the edge cases and handle them

Time to think negatively. In problem solving, negative thinking has its pros! 
You just have to think about how our solution can fail. 
#### 1. What if the directory doesn't exist?

- **Situation:**  
    The directory where the files are expected to reside might be missing.
- **Handling Approach:**
    - Check for the existence of the directory before processing.
    - If the directory is not found, log an error (e.g., "FATAL File path doesn't exist") and terminate the program gracefully.

#### 2. What if the files don't exist?

- **Situation:**  
    Some or all of the specified files may not be present in the directory.
- **Handling Approach:**
    - For each file, verify its existence before attempting to read it.
    - If a file is missing, log a warning (e.g., "WARN The file 'fooBar.txt' was not found. Skipping this file...") and skip processing that file.

#### 3. What if the file read operation fails?

- **Situation:**  
    Even if the file exists, an I/O error might occur while reading it.
- **Handling Approach:**
    - Implement error handling that catches I/O exceptions.
    - Optionally, add a retry mechanism: if reading fails, log an error (e.g., "ERROR Unable to read 'foobar.txt'") and then log a warning before retrying (e.g., "WARN Retrying reading 'foobar.txt'...").
    - After a fixed number of retries, move on and ensure that the program continues processing.

#### 4. What if the thread execution fails?

- **Situation:**  
    A thread might not terminate as expected or might encounter issues during execution.
- **Handling Approach:**
    - Ensure that threads are monitored and properly joined after their tasks complete.
    - If a thread fails to close or terminate correctly, log an error (e.g., "ERROR Thread failed to close").
    - Clean up resources associated with the thread to prevent resource leaks.

#### What if the input is null or empty?

- **Situation:**  
    The input, such as a list of file names, may be null or empty.
- **Handling Approach:**
    - Validate the input at the start of the program.
    - If the input is null or empty, log an informative message (e.g., "INFO No files provided. Exiting...") and exit the program gracefully.


By addressing these potential edge cases, you ensure that your solution can handle unexpected situations robustly.

---


### **Step 3:** Write down pseudo code to ensure your solution is a fit.

In order to ensure our pseudo code does most of the critical work, we adapt a "fail-first" or also known as "fail-fast" approach: 
#### The Fail-fast strategy

The **fail-first** approach (often called **fail-fast**) is a strategy where you check for errors or invalid conditions as early as possible in your code. If something is wrong, you handle the error immediately—often by terminating the process or returning early—instead of letting the program continue in an uncertain state. 

Let's assume a few things as our constraints for now: 
1. The input will be list of file names: `{"file1.txt", "file2.txt", "file3.txt"}`
2. The folder from where we'll get this is `C:\readFiles`

Let's handle all the edge cases from **Step 2**.

1. **If directory doesn't exist**, we'll terminate the program saying that the file path doesn't exist and terminate the program.
	- **Why?**
		*No directory means no files, without the directory our program need a termination point, we do this gracefully while exiting the program as soon as it doesn't find the target directory.*
	- **How will I handle?**
		*I remember a pattern where I used `java.io.File` is used to create a file object. I remember I can check if a file path exists and also check if it's a directory!* 
		```java
		boolean isDirectoryPresent(String directoryPath) {
			File targetDirectory = new File(directoryPath);
			if (targetDirectory.exists() && targetDirectory.isDirectory()) {
				return true;
			} else {
				return false;
			}
		}
		```
		*We can simplify this as follows:*
		```java
		boolean isDirectoryPresent(String directoryPath) {
			File targetDirectory = new File(directoryPath);
			return targetDirectory.exists() && targetDirectory.isDirectory();
		}
		```
	
	- **Where will I handle?**
		*I'll check this before starting each thread. This ensures that my program will first check if the directory even exists! I'll use the above function somewhere like...*
		```java

		// ...
		if (!isDirectoryPresent(directoryPath)) {
			System.out.println("ERROR The file path " + directoryPath + " doesn't exist. Terminating...);		
			return;
		}
		
		// if directory is present it's good to start threads
		thread.start();
		// ...
		```

2. If the file name is null or empty, we'll print a message saying the file name is null or empty respectively and continue execution. 
	- **Why?** 
		*A null or an empty element means the file doesn't exist. We know from our constraints that the input consists of file names along with their extensions, for e.g. `file1.txt`, etc. We continue execution to make sure at least other files are processed and read successfully by the program.*
	- **How and where will I handle?** 
		*At some point in the code I know I'll need to iterate over each file name, i.e. elements of the input array to start processing. 
		As soon as I iterate over an element, the first check I'll do is check if the current element is null or empty, it should look something like this:*

	```java 
		for (fileName: filesNames) {
			if (fileName == null || fileName.isEmpty()) {
				System.out.println("WARN Encountered a null or empty file name. Skipping this entry...");
				continue;
			}
			
			// further processing
		}	
	
	```
	
3. If the file name is not found in the file path, we'll print a message saying the file name was not found in the specified path.
4. If 


> **Note:** These snippets only represent visualization of what the actual code might look like.
>  This is something that will possibly happen in your head while writing pseudo code. Knowing exactly where you'll handle an edge case can be tricky sometimes. Trust the process! continue writing the pseudo code and you'll naturally realize where handling a certain edge case makes the most sense! 


Let's write the pseudo code Java style!

```java
// Pseudo-code: Class to read a single file using a Runnable task
class FileReaderTask implements Runnable {

    // Base folder path where files are located
    directory = "C:/readFiles"

    // File name (e.g., "file1.txt")
    fileName

    // Constructor to initialize the file name
    constructor(fileName) {
        this.filePath = fileName
    }

    // Entry point for the thread
    run() {
        filePath = directory + "/" + fileName
        
		if(!isFilePresent(filePath)) {
			print("The file" + fileName + "doesn't exist.");
		}

        printContent(entireFilePath)
    }

    // Function to read and print file content line by line
    printContent(path) {
        try {
            // Open file using BufferedReader (abstracted)
            bufferedReader = openBufferedReader(path)
            while ((line = bufferedReader.readLine()) is not null) {
                print(line)
            }
            // Resource cleanup handled automatically (like try-with-resources)
        } catch (IOException e) {
            print("There was an error: " + e)
        }
    }


	boolean isFilePresent(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
}

// Main pseudo-code entry point
class Main {
    main() {
        // Define list of file names
        filePaths = ["file1.txt", "file2.txt", "file3.txt"]

        // For each file name, create and start a new thread running FileReaderTask
        for each file in filePaths {
            task = new FileReaderTask(file)
            thread = new Thread(task)
            thread.start()
        }
    }
}
```

> While writing the pseudo code it is alright to rearrange stuff, but make it quick because we also need to write syntactically correct Java code and make improvements.


*Hmm.. I see that I haven't handled thread execution properly. 
I also need to ensure that all the threads are closed successfully and if any threads fails execution I need to catch it.* 

*I remember we can't close threads directly, they don't have a `close()` method like `BufferedReader` does. I remember a pattern where I used `thread.join()`! This is typically called for thread cleanups.
When `thread.join()` is called, the main thread waits until each child thread has finished execution and then returns itself.
If `thread.join()` fails, it throws `InterruptedException`, so I'll put this in a try catch block after I've started all the threads that read each file.  


Let's change the main class to include this.

```
class Main {
	main() {
	 filePaths = ["file1.txt", "file2.txt", "file3.txt"]
        // For each file name, create and start a new thread running FileReaderTask
        for each file in filePaths {
            task = new FileReaderTask(file)
            thread = new Thread(task)
            
            thread.start()
        }

		try {
			thread.join();
		} catch (InterruptedException e) {
			print("A thread was interrupted while waiting to join");
		}

		// once thread.join() executes successfully
		print("All threads have completed, and thread cleanup is successful.");
	}
}
```






---
### **Step 4: Compute the time and space complexity for the problem.**

Even if the problem seems straightforward, it's a good practice to analyze the complexity. Here's how you might think about it:
#### **Time Complexity**

- **Reading Each File:**  
    _Imagine you're reading a book line by line. If the book has L lines, you'll spend time proportional to L to read it completely._
    - Reading one file takes **O(L)** time.
    
- **Multiple Files in Parallel:**  
    _Now, think of having N books and several friends each reading one book at the same time. In the ideal world, you all finish your books concurrently in O(L) time, not O(N * L)._
    - If there are N files, and each is processed in its own thread, the ideal overall processing time per file remains **O(L)** when done concurrently.
    - **Worst-case Scenario:** If threads run sequentially (or if parallelism isn't perfect), the total time could be **O(N * L)**.
    
- **Thread Creation:**  
    _Starting each thread has its own overhead, but it's like gathering your friends together—it’s usually a quick process compared to reading the books._
    
    - Creating N threads typically adds **O(N)** overhead, which is often negligible compared to the file reading time.

// Write the calculation here:

Mathematically, 

---

#### **Space Complexity**

- **Reading Files:**  
    _Picture yourself reading one page at a time instead of carrying an entire book in your hands. That's what happens when you use `BufferedReader` to read line by line._
    
> The extra space per file is **O(1)**, aside from the space needed to hold each line temporarily.

- **Overall Memory Use:**  
    _Even if each of your friends uses a little memory while reading, the total memory isn't enormous if each is only holding one page at a time. But if you sum it all up for N friends, it's still manageable._
    
    - The space complexity is **O(1)** per thread, or **O(N)** if you count the memory for each thread independently.

_Remember, even though our built-in functions hide many details, thinking through these complexities helps you spot potential bottlenecks. If the number of files grows huge or file sizes increase, understanding these performance characteristics is key to building scalable solutions._



> **Note:** By carefully analyzing these complexities, you gain a deeper insight into how your program performs and where you might need to optimize. Always keep questioning every detail—it's the pathway to mastering problem solving!

The above pseudocode in **Step 3**, is a fine solution to the problem statement. 

---
### **Step 5: Optimize your code by identifying patterns and minimizing extra steps.**

*Why do we even need to optimize it?? Isn't this enough for a solution?* 
*I was able to come up with a solution. I was able to write brute force solution. I took care of the edge cases where my code could fail.* 

*It turns out, this isn't enough for our solution if there are additional constraints.*

Let's see what the constraints might look like: 

1. **Large Number of Files:**  
    _Imagine having to read just 3 files versus 10,000 files. When you have a large number, creating a new thread for each file can overwhelm your system. A fixed thread pool (via ExecutorService) manages the workload more efficiently by reusing a limited number of threads._
    
2. **Increasing File Sizes:**  
    _For small files, reading line by line is fine. But as file sizes grow, the time taken for each read operation increases. A more systematic solution can better manage I/O tasks, ensuring that threads are optimally allocated to balance the load._
    
3. **Limited System Resources:**  
    _Every thread consumes memory and CPU cycles. With too many threads running concurrently, your system may run out of resources. ExecutorService helps by capping the number of active threads, reducing overhead and preventing resource exhaustion._
    
4. **Efficient Thread Management:**  
    _Manually starting and managing threads with Runnable can work for small-scale problems, but as complexity grows, you need a smarter way to distribute tasks, handle thread lifecycle, and gracefully shutdown the system. ExecutorService provides built-in methods for these operations, improving reliability and maintainability._
    
5. **Predictability and Scalability:**  
    _A more systematic solution gives you control over the number of concurrent threads, which leads to predictable performance. As your application scales up, having a controlled environment for parallel tasks is crucial for achieving consistent performance._


Now that I have a working solution using simple Threads and Runnable, it's time to consider optimization. 

When file sizes grow or the number of files increases, creating a new Thread for each file with Runnable can become inefficient—there's overhead in creating and managing many threads.

*Imagine trying to organize a group discussion with one conversation per person versus having a moderator who assigns tasks to a fixed group of experts. The moderator (ExecutorService) manages the workload more efficiently!*

_In essence, when constraints like the number of files, file sizes, and limited resources start to challenge the simplicity of a basic `Runnable` approach, it’s time to embrace a more robust solution. 

*Let's open our barricade!* 
# 🚧

_`ExecutorService` not only optimizes performance under these conditions but also makes our code easier to manage and scale._

*Imagine trying to organize a group discussion with one conversation per person versus having a moderator who assigns tasks to a fixed group of experts. The moderator (ExecutorService) manages the workload more efficiently!*


- **Why ExecutorService?**  
    Instead of manually creating and managing threads, `ExecutorService` lets you work with a thread pool—a fixed set of threads that can be reused to process many tasks. This approach reduces overhead and improves performance when dealing with a large number of files or when file sizes demand faster processing.
    
- **How Does It Help?**  
    With `ExecutorService`, you can submit tasks (like file reading operations) to be executed by available threads in the pool. This not only simplifies thread management but also ensures that your system doesn't get overwhelmed by creating too many threads at once.


*Let's jump back to the pattern I remember about `ExecutorService` and write what I had in mind.*

```java
ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

for (fileName: fileNames) {
	executor.submit(new FileReaderTask(fileName));
}

executor.shutdown();
executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS);
```


*I see there are two things that I need to configure:*
1. *`NUMBER_OF_THREADS`*
2. *`TIMEOUT`*

> **Note:** It's  

Let's understand how we can configure them: 
We can configure the `NUMBER_OF_THREADS` depending on the what the priority is. 
This priority depends on what the world wants and it can vary depending on the use case.

Configuring how many threads we need to assign to the `ExecutorService` basically depends on identifying where our tasks are primarily I/O-bound or CPU-bound operations.   

In order to solve this problem at this scale, let's understand these concepts better: 

- **CPU-Bound Operations:** 
	**Analogy:** 
		*Imagine you’re doing a complex puzzle that requires intense concentration and calculation. Every second counts, and your mind is fully engaged in solving it.*
	**Definition:**
		CPU-bound tasks spend most of their time performing computations. The task fully utilizes the CPU because it's processing data or performing calculations.
	**Implication for Threads:** 
		For CPU-bound tasks, creating more threads than the number of available CPU cores can actually slow things down due to context switching (the overhead of switching between tasks). In these cases, matching the thread count to the number of cores is usually best.		 

- **I/O-Bound Operations:**

	**Analogy:** 
	*Imagine you're waiting for a package to be delivered. Most of your time is spent waiting for the courier, not actually opening or handling the package.*

	**Definition:**
	 Similarly, I/O-Bound tasks spend most of their time waiting for input/output operation (like reading a file, accessing a database or just making a network call) which is potentially a simple operation and not heavy on the CPU at all.
	 
	**Implication for Threads:**
	 Because the CPU isn't fully occupied during these waits, you can have more threads than CPU cores. More threads help keep the system busy by processing other tasks while one thread waits for I/O.
	 
In our example, the problem requires reading from a directory and printing it to the console, the operation is comparatively smaller compared to the CPU space. 

**Q. Is it possible if each file size is large we'd go to CPU-bound task?**


*I can definitely say that we have a I/O-based operation at scale.*



**TIMEOUT in `executor.awaitTermination()`:**  
_The TIMEOUT value is how long you’re willing to wait for all your file reading tasks to finish after telling the executor to shut down. You should set it based on your expectations—if your files usually finish processing in a minute, you might set TIMEOUT to 2 minutes. This helps catch any tasks that might be stuck or taking too long, ensuring your program doesn't wait forever._


	
The `executor.awaitTermination()` has TIMEOUT which, ???


---
### **Step 6: Write down the final solution.**


---
### **Step 7: Test and validate using custom inputs.**



---













Let's consider the following requirements for our problem:

1. All the files are text files in `.txt` format.
2. The input data type is a list of file names that are present in the folder `C:/testFiles`. An example of an input parameter is as follows: `{"test1.txt", "test2.txt", "test3.txt", "test4.txt"}`
3. The order doesn't matter, it's okay to execute them in the order of thread completion. Print the following message once the program starts: `INFO Execution Intitiated`
4. Error handling:  
- If the folder path is not found, terminate the program. Print the following message before terminating the program: `FATAL Folder path doesn't exist. Terminating...`
- If a file is not found, skip that file after printing a message: `WARN The file 'fooBar.txt' was not found. Skipping this file...`
-  If the program was unable to read one or more files retry reading it twice and continue execution. 
	- Print the following message: `ERROR Unable to read 'foobar.txt'`
	- Print the following message before retrying: `WARN Retrying reading 'foobar.txt'...` 
	- Once the program is ready to continue execution print the following message: `INFO Resuming Execution`
5. The file size won't exceed more than 1 MB. No need for memory optimization in case of large files. 
6. Ensure proper cleanup:
   - Close all opened files.
   - Ensure all threads have terminated cleanly.
     - If any thread fails to terminate or clean up its resources, print:
       "ERROR Thread failed to close"
   - Once cleanup is complete and all threads have terminated, print:
       "INFO Execution Complete"1. No need for advanced frameworks, just use `Thread` or `Runnable`. 
7. You can download and unzip [[this]] folder to download test files and move it to `C:/testFiles` and validate if everything works as intended by using the following inputs.
```java 
// Test these inputs to validate everything works as intended

// Prompt: Please find the elements such that read fail and not found fail case (basically all cases are covered.) 
// Also: Please let me know what I should keep in my C:/testFiles folder to make sure everything is validated

```

---

Let's break down our problem into smaller chunks: 

1. Verify if the folder path exists; if not, terminate.
2. If yes, print the execution message.
3. For each file name in the list, create a new thread using Runnable. 
4. 

The Missing link: 
Since we want to ensure all the threads are closed before completing the execution, create a new list of threads, we'll store each thread in this list and that they're closed before execution completes.

Let's write our pseudo code: 

```
void executeParallelFileReader(String[] fileNames) {
	folderPath = "C:/testFiles/"
	
	if (!folderPathExists(folderPath)) {
		sout "FATAL File path doesn't exist"
		return; 
	}	

	sout "INFO Execution Initialized"

	for fileName: fileNames {
		// load the file using FileInputStream 
		file = new FileInputBuffer("filePath + fileName");
		if (file.isEmpty()) {
			print "WARN The file " + fileName + " doesn't exist. Skipping this file..."
			return 
		}

		readFile(fileName)
}

void readFile(String fileName) {
	maxRetries = 2
	attempt = 0 

	while (attempt <= maxRetries) {
		
	
	}

}
	maxRetries = 2
		attempt = 0 

		while (attempt >= maxRetries) {
			try {
				content = readFile(); 
				print "-----" + fileName" + "-----"
				print content
				print "----------------------------" 

			} catch (ReadingException e) {
				print "ERROR Unable to read '" + fileName + "'"
				attempt ++
			}
		}
	}
```