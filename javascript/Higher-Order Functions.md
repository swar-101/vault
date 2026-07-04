
What's callback? Is it calling something back? 


Q. How would you use `.reduce()` to combine them into a single sentence string "I love JS"? 

```js
const words = ["I", "love", "JS"];
```

```js

const message = words.reduce((a, b) => a.concat(" ").concat(b), `${a}`);
console.log(message); // "I love JS"
```



Implement a `map()` variant that also filters out elements where `fn` returns `undefined`.




