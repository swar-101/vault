# Bitwise Operators

### 1. Bitwise AND `&`
*Returns 1 only if both bits are 1.*  

|  A  |  B  | A & B |     |
| :-: | :-: | :---: | --- |
|  0  |  0  |   0   |     |
|  0  |  1  |   0   |     |
|  1  |  0  |   0   |     |
|  1  |  1  |   1   |     |
*Analogy:* Like a double-key lock—it opens only when both keys are present.
#analogy

### 2. Bitwise OR `|`
*Returns 1 if at least one bit is 1.*  

|  A  |  B  | A \| B |
| :-: | :-: | :----: |
|  0  |  0  |   0    |
|  0  |  1  |   1    |
|  1  |  0  |   1    |
|  1  |  1  |   1    |
*Analogy:* Like a team effort—just one member is enough to get things going.
#analogy 
### 3. Bitwise XOR `^`
*Returns 1 if the bits differ.*  

|  A  |  B  | A ^ B |
| :-: | :-: | :---: |
|  0  |  0  |   0   |
|  0  |  1  |   1   |
|  1  |  0  |   1   |
|  1  |  1  |   0   |
*Analogy:* Like a mismatch detector—it only signals when things don't match.
#analogy 
### 4. Bitwise NOT `~`
*Flips each bit (0 becomes 1, 1 becomes 0).*  

|  A  | ~A  |
| :-: | :-: |
| 00  | 11  |
| 01  | 10  |
| 10  | 01  |
| 11  | 00  |
*Analogy:* Like a mirror that inverts your image.
#analogy 