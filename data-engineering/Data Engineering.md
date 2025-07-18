1. Introduction to Data Engineering
	- The 6 Vs of Big Data
	- Data Storage Methods: OLTP and OLAP
	- [[Key Components]]
		- Ingestion Layer
		- Processing Layer
		- Storage Layer
		- Query and Analysis Layer
2. Big Data Architecture
	- Data Ingestion And Processing
		- Kafka As A Queue System
		- Real-time Data Processing
	- Systems And Technologies For Big Data
		- MySQL and Kafka Integration
		- Data Lake
		- Data Warehouse
		- OLTP Systems
		- OLAP Systems
		
 3. Hadoop Ecosystem And Fundamentals Of Distributed Systems
	 - Basic Structure Of HDFS
		 - Data Node
		 - Name Node
		 - Chunks
	- Replication Factor In HDFS
	- HDFS Operations And Commands
	- Handling Failures In HDFS
		- Data Node Failure
		- Name Node Failure
	- Advanced Concpets
		- Quorum Journal Nodes
		- Zookeeper
	- Configurations Through hdfs-site.xml
	
4. Data Modeling 
	- Challenges in HDFS 1.0
	- Name Node Replication
	- Basics Of Data Modeling 
	- Dimensions
	- Fact Tables
	- Schema Types
		- [[Star Schema]]
		- Snowflake Schema
		- Galaxy Schema
	- Slowly Changing Dimensions (SCD)
		- SCD 0
		- SCD 1
		- SCD 2
		- SCD 3
		- SCD 4 
		- Hybrid SCD
5. Hive Architecture
	- Apache Hive Architecture
	- CLI : Beeline
	- JDBC / ODBC
	- Hive UI / Hive Web Interface
	- Hive Thrift Server 
	- Thrift Protocol
	- Abstract Syntax Tree
	- [[Map Reduce]]
	- Legacy Hive: Easy To Learn
	- Hive On Spark: Better CLI Interface
6. Store Data Efficiently In Big Data
	- Static Partitioning 
	- Dynamic Partitioning
	- Data Storage Using HDFS and Hive Data Location
	- Common File Formats in Hive
		- Text File
		- CSV
		- Sequence File
		- ORC (Optimized Row Columnar)
		- Parquet
		- JSON
		- Avro
	- Practical Considerations
	- Performance Implications

7. Hive QL
	- Managed Tables
	- External Tables
	- CTE (Common Table Expressions)
	- Temporary Tables
	- Views
	- Temporary Tables VS Views
	- Window Functions 
		- Lead
		- Lag
		- Nth_value
		- First_value
	- Paritioning In SQL Tables
	- Case Study: Uber Eats
		- Data Modeling
		- Dimensions
		- Monthly Average Delivery Time Per City
		- Customers Who Have Placed More Than 10 Orders In The Last Three Months Using Views
	- Writing Hive Queries 2x Faster
		- Hive Skew Join Optimization
		- Bucketing 
		- Small Files Problem
		- File Formats And Their Advantages
		- Join Strategies
			- Reduce-Side Join
			- Broadcast Join
		- Cost Based Optimization And Vectorization
			- Query Vectorization
			- CBO (Cost Based Optimization)
		- Common Issues And Debugging Techniques
			- Out Of Memory Errors
			- Identifying Bottlenecks
	- Limitations of Hive Engine And Strategies To Overcome Them
		- Responsibility For Compression
		- File Format Limitations
		- Compressions Algorithms
		- Configuration For Compression
		- Predicate Pushdown And Partition Tuning 
		- Shortcomings of Hive And Role Of Spark
		- Important Considerations
			- Execution Engines
			- Out Of Memory Errors
			- Planning And Optimization
8. Map Reduce Framework
	- YARN
		- Resource Manager
		- Node Manager
		- YARN Scheduling
			- FIFO Schedulers
			- Capacity Scheduling
			- Fair Scheduling
			- [[Dominant Resource Fairness]]
	- Zookeeper
	- The Block Replication Algorithm

 9. Tez And Hive On Spark
	 - Execution Engines
	 - Apache Tez
	 - Apache Spark
	 - Query Execution: DAG and Operator Trees
	 - Tez VS Spark Execution Plans

10. YARN Architecture
	- Resource Manager
	- Node Manager
	- Application Master
	- Containers
	- Strategies And Best Practices
		- Resource Utilization
		- Handling Failures
		- Scalability And Flexibility
	- Benefits of YARN
	- [[Fact and Dimension]]
	- Resource Allocations And Optimizations
		- CPU Allocation
		- Dynamic Resource Allocation

11. Big Data SQL Interview Questions
	- Five Concepts In Hive
		- File Merging In Hive
		- Handling Skewed Data In Joins
		- Map Reduce Tasks
		- Join Operations And Optimizations
		- Data Format And Compression 
		- Queries And Enhancements
12. Understanding Spark Architecture
	- Driver Program
	- Cluster Manager
	- Executors
	- Key Concepts In Spark
		- Lazy Evaluation
		- Dataframe 
		- Spark SQL 
		- Directed Acyclic Graph
		- Catalyst Optimizer
		- Execution Modes
			- Local Mode
			- Standalone Mode
			- Cluster Mode
	- Practical Example: Word Count Application
	- Hands-on with PySpark
	- Best Practices
13. Setup Spark Environment, Thrift Server, Beeline, SHS
	- Spark SQL 
	- Dataframes
	- Configuring Spark Environment
	- Spark Event Logs And Monitoring 
		- Monitoring Tools
	- Understanding Spark Architecture
	- Catalyst Optimizer and Tungsten Execution Engine
	- Dataframe API and DSL
	- Data Processing With Spark
		- Operations On Data Frames
		- Converting RDDs to DataFrames
		- SparkSession
	- PySpark Best Practices
		- Understanding Data Pipelines
		- Setting Up Environment
		- Using Documentation
14. AWS Redshift
	- [[Distribution Styles]]
	- [[Massively Parallel Processing]] MPP
	- [[Leader Nodes & Compute Nodes]]