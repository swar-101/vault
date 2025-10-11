
`IntStream` is part of Java Streams, and yes, streams can be parallelized. But the **real reason** `IntStream` exists is to **avoid boxing/unboxing** when working with primitive `int`s.

```java
Stream<Integer> s = Stream.of(1,2,3); // involves boxing
IntStream is = IntStream.of(1,2,3);   // no boxing
```

So `IntStream` (and `LongStream`, `DoubleStream`) are specialized for primitives. They’re both:
- **Memory-efficient** (store raw ints).
- **CPU-efficient** (no pointer indirection, no boxing overhead).
- Still give you Stream operations (`map`, `filter`, `reduce`, etc).




