
1. Multi-character wildcard `%`
2. Single-character wildcard `_`
3. Escape pattern using `ESCAPE`

| Pattern             | Meaning                                     | Example Matches          |
| ------------------- | ------------------------------------------- | ------------------------ |
| `swar%'             | Starts with 'swar'                          | swaraj, swar tarang      |
| '%swar'             | Ends with 'swar'                            | divaswar, brook swar     |
| '%swar%'            | Contains 'swar' anywhere                    | all of the above         |
| 'swar__'            | 'swar' + exactly 2 characters after         | swar12, swaraj           |
| 'swar_'             | 'swar' + exactly 1 character after          | swar1, swarX             |
| '_war%'             | Any 1 character before 'war', then anything | Pwarinho, kwargs         |
| '%\\_%' ESCAPE '\\' | Literal underscore anywhere                 | version_1, song_name_etc |


**Wildcards:**
- `%` = 0 or more characters  
- `_` = exactly 1 character (letter, number, space, symbol)  
- `\` = escape character to treat `%` or `_` literally
