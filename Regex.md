
`^`  Start of the string
`$` end of the string 


`\d{10}` 10 digits

`1\d{10}` 1 followed by 10 digits



`^1?\s?` optional leading 1 (country code) and an optional space


```js
(\(\d{3}\)|\d{3})
```

area code: either `(555)` or `555`

