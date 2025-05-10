
Prefix Sum Array is calculated for problems which include frequent Range Queries.



```java
public class PrefixSum {

	public int[] prefixSum(int[] a) {
		int[] prefixSumArray = new int[a.length];		
		prefixSumArray[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			prefixSumArray[i] = prefixSum[i - 1] + a[i];
		}
		return a;
	}
}
```


```java
public class PrefixSum {

	public ArrayList<Integer> prefixSum(ArrayList<Integer> a) {
		ArrayList<Integer> prefixSumArray = new ArrayList<>();
		prefixSumArray.add(a.get(0));

		for (int i = 1; i < a.size(); i++) {
			int sum = prefixSumArray.get(i - 1) + a.get(i);
			prefixSumArray.add(sum);
		}
		
		return prefixSumArray;
	}
}
```

