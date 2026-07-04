
# 1

![[Pasted image 20260606114944.png]]


# Problem Code: 

```jsx
import "./App.css";
import SearchComponent from "./SearchComponent";

function App() {
  return (
    <div className="App">
      <SearchComponent />
    </div>
  );
}

export default App;
```

```jsx
import { useState } from "react";

const dataList = [

  { id: 1, name: "Apple" },
  { id: 2, name: "Banana" },
  { id: 3, name: "Cherry" },
  { id: 4, name: "Date" },
  { id: 5, name: "Elderberry" },
];

  

function SearchComponent() {
  const [query, setQuery] = useState("");
  const [filteredData, setFilteredData] = useState(dataList);

  return (
    <div>
      <input
        type="text"
        value={query}
      />
      <ul>
      </ul>
    </div>
  );
}

export default SearchComponent;
```

# Solution: 

```jsx
import { useState, useEffect } from "react";

const dataList = [
  { id: 1, name: "Apple" },
  { id: 2, name: "Banana" },
  { id: 3, name: "Cherry" },
  { id: 4, name: "Date" },
  { id: 5, name: "Elderberry" },
];

  

function SearchComponent() {
  const [query, setQuery] = useState("");
  const [filteredData, setFilteredData] = useState(dataList);

  useEffect(() => {
    const timer = setTimeout(() => {
      if (query.trim() === "") {
        setFilteredData(dataList);
      } else {
        const filtered = dataList.filter((item) =>
          item.name.toLowerCase().includes(query.toLowerCase())
        );

        setFilteredData(filtered);
      }
    }, 300);

    return () => clearTimeout(timer);
  }, [query]);

  return (
    <div>
      <input
        type="text"
        value={query}
        onChange={(e) => setQuery(e.target.value)}
      />
      <ul>    
        {filteredData.map((item) => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default SearchComponent;
```

---
# 2

![[Pasted image 20260606115453.png]]

# Problem Code

```jsx
import React, { useState } from "react";

  
function CommentBox() {
  const [comment, setComment] = useState("");
  const maxLength = 200; 

  const handleChange = (event) => {
    setComment(event.target.value);
  };

  return (
    <div>
      <textarea value={comment} onChange={handleChange} maxLength={maxLength} />
      <p>{maxLength - comment.length} characters left</p>
    </div>
  );
}

  
export default CommentBox;
```

# Solution 

```jsx
import React, { useState, memo } from "react";

const CharacterCount = memo(({ remainingCharacters }) => {
  return <p>{remainingCharacters} characters left</p>;
});

function CommentBox() {
  const [comment, setComment] = useState("");
  const maxLength = 200;

  const handleChange = (event) => {
    setComment(event.target.value);
  };

  const remainingCharacters = maxLength - comment.length;

  return (
    <div>
      <textarea
        value={comment}
        onChange={handleChange}
        maxLength={maxLength}
      />

      <CharacterCount
        remainingCharacters={remainingCharacters}
      />
    </div>
  );
}

export default CommentBox;
```

---
# 3. 

![[Pasted image 20260606120112.png]]


![[Pasted image 20260606120130.png]]

# Problem Code: 

```jsx
import { useState, useEffect } from "react";
import { fetchBio } from "./api.js";

export default function Page() {
  const [person, setPerson] = useState("Alice");
  const [bio, setBio] = useState(null);

  useEffect(() => {
    setBio(null);
    fetchBio(person).then((result) => {
      setBio(result);
    });
  }, [person]);

  return (
    <>
      <select
        value={person}
        onChange={(e) => {
          setPerson(e.target.value);
        }}>
        <option value="Alice">Alice</option>
        <option value="Bob">Bob</option>
        <option value="Taylor">Taylor</option>
      </select>
      <hr />
      <p>
        <i>{bio ?? "Loading..."}</i>
      </p>
    </>
  );
}
```

# Solution 

```jsx
import { useState, useEffect } from "react";
import { fetchBio } from "./api.js";

export default function Page() {
  const [person, setPerson] = useState("Alice");
  const [bio, setBio] = useState(null);

  useEffect(() => {
    let ignore = false;

    setBio(null);

    fetchBio(person).then((result) => {
      if (!ignore) {
        setBio(result);
      }
    });

    return () => {
      ignore = true;
    };
  }, [person]);

  return (
    <>
      <select
        value={person}
        onChange={(e) => {
          setPerson(e.target.value);
        }}
      >
        <option value="Alice">Alice</option>
        <option value="Bob">Bob</option>
        <option value="Taylor">Taylor</option>
      </select>

      <hr />

      <p>
        <i>{bio ?? "Loading..."}</i>
      </p>
    </>
  );
}
```




---
# 4

![[Pasted image 20260606120346.png]]


![[Pasted image 20260606120358.png]]




---
# 5
![[Pasted image 20260606122210.png]]

![[Pasted image 20260606122218.png]]

---
# 6

![[Pasted image 20260606122050.png]]

---
# 7
![[Pasted image 20260606122115.png]]

![[Pasted image 20260606122120.png]]

---

# 8
![[Pasted image 20260606121956.png]]

---
