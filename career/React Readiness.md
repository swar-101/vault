# React Assessment Readiness Bucket List v1.0

## Goal

Build confidence through deliberate practice.

Learning process:

Discover Gaps  
↓  
Practice  
↓  
Understand WHY  
↓  
Reimplement from memory  
↓  
Move On

---

# Bucket A — Todo App Foundations (Priority P0)

Goal: Build Todo App independently.

## Components

-  Create a functional component.
    
-  Understand: Component = reusable UI function.
    
-  Split UI into smaller components.
    

SCL Target: 2+

---

## JSX

-  Render variables using `{}`. ✅
    
-  Render lists using `.map()`.  ✅
    
-  Use unique `key` props.  ✅
    
-  Use conditional rendering (`&&`, ternary). ✅
    

SCL Target: 2+

---

## Props

-  Pass data from parent to child. ✅
    
-  Understand one-way data flow. ✅
    

SCL Target: 2+

---

## useState

-  Create state variables. ✅
    
-  Update primitive state.
    
-  Update array state.
    
-  Update object state.
    
-  Understand: State = memory that triggers rerenders.
    

SCL Target: 2+

---

## Event Handling

-  Use `onClick`.
    
-  Use `onChange`.
    
-  Handle form submission.
    
-  Connect events → state updates → UI updates.
    

SCL Target: 2+

---

# Todo App V1

Features:

-  Add Task
    
-  Delete Task
    
-  Mark Complete
    
-  Render task count
    

Goal:

"I can build a basic Todo App without external help."

Target: SCL 2+

---

# Bucket B — Hooks & Effects (Priority P1)

## useEffect

Understand:

"When X changes, do Y."

Practice:

-  Run effect on mount (`[]`)
    
-  Run effect when dependency changes (`[x]`)
    
-  Explain cleanup functions.
    

SCL Target: 2

---

## Cleanup Functions

Practice:

-  Clear timers.
    
-  Prevent stale async updates.
    

Pattern:

```js
return () => {
  // cleanup
}
```

SCL Target: 2

---

## Functional State Updates

Understand why this can fail:

```js
setCount(count + 1)
```

Use:

```js
setCount(prev => prev + 1)
```

Practice:

-  Counter increment example.
    
-  Explain stale state.
    

SCL Target: 2

---

# Bucket C — Assessment Patterns (Priority P1)

## Debouncing

Pattern:

useEffect  
+  
setTimeout  
+  
clearTimeout

Practice:

-  Build debounced search.
    
-  Explain why cleanup is necessary.
    

SCL Target: 2+

---

## Race Conditions in Effects

Understand:

-  Older requests can finish later.
    
-  Cleanup prevents stale updates.
    

Pattern:

```js
let ignore = false;

return () => {
  ignore = true;
}
```

Practice:

-  User profile fetch example.
    

SCL Target: 2

---

# Bucket D — React Optimization (Priority P2)

## React.memo

Understand:

-  Why components rerender.
    
-  What React.memo optimizes.
    
-  Shallow comparison concept.
    

Practice:

-  Prevent unnecessary child rerenders.
    

SCL Target: 1.5+

---

## React.lazy + Suspense

Understand:

-  Code splitting.
    
-  Smaller initial bundle size.
    

Practice:

-  Lazy load a component.
    

SCL Target: 1.5+

---

# Bucket E — Hidden JavaScript Concepts (Priority P1)

## Closures

Understand:

-  Why state can become stale.
    
-  How useEffect captures values.
    

SCL Target: 2

---

## Promises / Async Behavior

Understand:

-  Promise lifecycle.
    
-  async / await.
    
-  Order of completion vs order of initiation.
    

SCL Target: 2+

---

## Event Loop Basics

Understand:

-  setTimeout behavior.
    
-  Why debouncing works.
    

SCL Target: 1.5+

---

## Reference Equality

Understand:

-  Why React.memo sometimes fails.
    

SCL Target: 1.5+

---

# Bucket F — Redux Toolkit (Priority P3)

## createSlice

-  Create a slice.
    
-  Export actions.
    

SCL Target: 1

---

## createAction

-  Understand action creators.
    

SCL Target: 1

---

## createAsyncThunk

Understand:

-  pending
    
-  fulfilled
    
-  rejected
    

Practice:

-  Simulate loading states.
    

SCL Target: 1.5+

---

# Todo App V2 (Integration)

Enhancements:

-  Search tasks
    
-  Debounced search
    
-  Loading states
    
-  Error states
    

Goal:

"I can combine multiple React concepts together."

Target: SCL 2+

---

# Review Rule

For each item:

SCL 0 → Never seen before

SCL 1 → Recognize with help

SCL 2 → Can implement with minor hints

SCL 3 → Can teach confidently

Only move on after reaching SCL 2.