

For every class in Java, there are two default methods from `java.lang.Object` that can (and often should) be overridden:
1. `toString()` - This method is generally used for debugging and logging readable outputs. By default it returns the hash address of an object (I guess). We override this so that we can log or print the contents of an object.
2. `hashCode()` - This method is used for returning the hash code of the object. This hash code is used in hash-based collections like `HashSet` and `HashMap`. This hash code enables the compiler in identifying if two objects are equal or not.  
