

```js
function createCounter() {
	let count = 0;
	
	function increment(count) {
		count++;
	} 
	
	function decrement(count) {
		count--;
	}
	
	function reset() {
		count = 0; 
	}
	
	return {
		increment,
		decrement,
		reset
	}
}
```



```js
const createCounter = () -> {
	let count = 0; 
	
	const increment = (count) => count++;
	const decrement = (count) => count--;
	const reset = () => count = 0;
	
	return { increment, decrement, reset };  
};

const counter = createCounter();
console.log(counter.increment()); // 1
console.log(counter.increment()); // 2
console.log(counter.decrement()); // 1
console.log(counter.reset());     // 0
```

