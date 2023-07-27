# python deque method
*이미 [파이썬 코테 관련 라이브러리 팁](https://github.com/JAEYEONsss/TIL/blob/main/TIP/Python/library.md) 에서 deque에 대해서 정리했지만, 메소드에 관한 설명이 빈약하여 다시 한 번 정리하고자 한다.

## append(x) => deque의 오른쪽으로 원소 삽입
```python
from collections import deque

test = deque()
test.append("a") # deque(['a'])
test.append("b") # deque (['a', 'b'])
``` 

## appendleft(x) => deque의 왼쪽으로 원소 삽입 
```python
from collections import deque

test = deque()
test.append("a") # deque(['a'])
test.append("c") # deque(['a','c'])
test.appendleft("b") # deque (['b', 'a', 'c'])
```  

## clear() => deque의 모든 원소를 삭제
```python
from collections import deque

test = deque()
test.append("a") # deque(['a'])
test.append("c") # deque(['a','c'])
test.appendleft("b") # deque (['b', 'a', 'c'])

test.clear() # deque([])
```  

## count(x) => deque에서 x와 같은 값의 갯수
```python
from collections import deque

test = deque()
test.append("a") # deque(['a'])
test.append("c") # deque(['a','c'])
test.appendleft("a") # deque (['a', 'a', 'c'])

print(test.count("a")) # 2
```  

## extend(iterable) => iterable 한 값을 파라미터로 넣으면 해당 값들이 하나씩  deque의 오른쪽으로 붙음
```python
from collections import deque

test = deque()
test.append("a") # deque(['a'])
test.extend("bcd") # deque(['a',b', 'c', 'd'])
test.appendleft("bcd") # deque (['bcd', 'a', 'a', 'c']
```  

## extendleft(iterable) => iterable 한 값을 파라미터로 넣으면 해당 값들이 하나씩 deque의 왼쪽으로 붙음

* <b>Extend the left side of the deque by appending elements from _iterable_. Note, the series of left appends results in reversing the order of elements in the iterable argument.</b>
*  <b>즉, iterable 원소의 값이 역순으로 추가된다.</b>

```python
from collections import deque

test = deque()
test.append("a") # deque(['a'])
test.extendleft("bcd") # deque(['d', 'c', 'b', 'a'])
test.appendleft("bcd") # deque(['bcd', 'd', 'c', 'b', 'a'])
```  
## insert(idx, x) => deque의 idx 위치에 x 를 삽입
```python
from collections import deque

test = deque()
test.append('a') #deque(['a'])
test.append('b') # deque(['a', 'b'])
test.insert(0, 'c') # deque(['c'.'a'.'b'])
```

## pop() => deque의 맨 오른쪽의 원소를 삭제하고 반환.  원소가 없을 경우 에러 발생
```python
from collections import deque

test = deque()
test.append('a') #deque(['a'])
test.append('b') # deque(['a', 'b'])

temp = test.pop() 
# test => deque(['a'])
# temp => 'b'
```

## popleft() => deque의 맨 왼쪽읜 원소를 삭제하고 반환. 원소가 없을 경우 에러 발생
```python
from collections import deque

test = deque()
test.append('a') #deque(['a'])
test.append('b') # deque(['a', 'b'])

temp = test.popleft()
# test => deque(['b'])
# temp => 'a'
```

## remove(x) => deque의 원소 중 처음 나오는 x 값을 삭제. x 가 없을 시 에러 발생
```python
from collections import deque

test = deque()
test.append('a') #deque(['a'])
test.append('b') # deque(['a', 'b'])
test.append('c') # deque(['a', 'b'. 'c'])

test.remove('b') # deque(['a', 'c'])
```

## reverse() => deque의 원소 순서를 반대로 뒤집는다. 반환값은 없음
```python
from collections import deque

test = deque()
test.append('a') #deque(['a'])
test.append('b') # deque(['a', 'b'])
test.append('c') # deque(['a', 'b'. 'c'])

test.reverse() # deque(['c', 'b'. 'a'])
```
## rotate(x) => x 만큼 deque의 원소를 회전시킴
* <b>x가 양수 => 우측으로 원소 회전 </b>
* <b>x가 음수 => 좌측으로 원소 회전 </b>

```python
from collections import deque

test = deque()
test.append('a') #deque(['a'])
test.append('b') # deque(['a', 'b'])
test.append('c') # deque(['a', 'b'. 'c'])

test.rotate(1) # deque(['c', 'a'. 'b'])
test.rotate(-2) # deque(['b', 'c'. 'a']) 
```
