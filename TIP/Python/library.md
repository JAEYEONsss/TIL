# 코딩테스트 꼭 알아야 할 파이썬 라이브러리

## 1. 내장함수

## sum()
* 리스트와 같은 iterable 객체의 모든 원소 합 반환

```python
result = sum([1,2,3,4,5])
print(result)

# 출력: 15
```

## max(), min()
* max(): 파라미터가 2개 이상 들어왔을 때 가장 큰 값 반환
* min(): 파라미터가 2개 이상 들어왔을 때 가장 작은 값 반환

```python
a = max([1,2,3,4,5])
b = min([1,2,3,4,5])

print(a)
print(b)

# 출력 a = 5
# 출력 b = 1
```

## eval()
* 수학 수식 (문자열 형태) 계산 결과 반환

```python
result = eval("(1+2) * 3")
print(result)

# 출력 9
```

## sorted()
* iterable 객체가 들어왔을 때, 정렬된 결과 반환

```python
a = sorted([1,3,2]) #오름차순 정렬

b = sorted([1,3,2], reverse = True)# 내림차순 정렬

print(a)
print(b)

# 출력 a = [1,2,3]
# 출력 b = [3,2,1]
```

* 리스트와 같은 iterable 객체는 기본적으로 sort() 함수 내장 되어있으므로 sorted() 사용 안해도 됨

```python
result = [1,3,2]
result.sort()
print(result)

# 출력 [1,2,3]
```

## dict를 key, value 기준으로 정렬

```python
dic = {1: 10, 2: 20, 3: 30}
```

1. Key 값을 기준으로 정렬하기 => 리스트 반환

```python
# Key 값을 기준으로 오름차순 정렬
sorted_dic = sorted(dic)

# Key 값을 기준으로 내림차순 정렬
sorted_desc_dic = sorted(dic, reverse = True)
```

```python
#오름차순 정렬한 리스트
[1,2,3]

#내림차순 정렬한 리스트
[3,2,1]
```

2. Key 값을 기준으로 정렬하기 => 튜플 반환 (key, value)

```python
# Key 값을 기준으로 오름차순 정렬
sorted_dic = sorted(dic.items)

# Key 값을 기준으로 내림차순 정렬
sorted_desc_dic = sorted(dic.items, reverse = True)
```

```python
#오름차순 정렬한 튜플
[(1,10), (2,20), (3,30)]

#내림차순 정렬한 튜플
[(3,30), (2,20), (1,10)]
```

3. Value를 기준으로 정렬하기 => 튜플 반환

```python
# Value를 기준으로 오름차순 정렬
sorted_dic = sorted(dic.items, key = lambda item : item[1])

# Value를 기준으로 내림차순 정렬
sorted_desc_dic = sorted(dic.items, key = lambda item : item[1], reverse = True)
```

```python
#오름차순 정렬한 튜플
[(1,10), (2,20), (3,30)]

#내림차순 정렬한 튜플
[(3,30), (2,20), (1,10)]
```

## 2. itertools - 반복되는 데이터 처리

## permutations
* 리스트 같은 iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우(순열)제시. 클래스이므로 객체 초기화 후 리스트 자료형으로 변환 해야함.

```python
from itertools import permutations

data = ['A', 'B', 'C']

result = list(permutations(data,3))#data 중 3개를 뽑아 나열 (순열) 중복 없음

print(result)

# 출력 [('A','B','C'), ('A','C','B'), ... , ('C','B','A')]
```
## combinations
* 리스트 같은 iterable 객체에서 r개의 데이터를 뽑아 순서없이 일렬로 나열하는 모든 경우(조합)제시. 클래스이므로 객체 초기화 후 리스트 자료형으로 변환 해야함.

```python
from itertools import combinations

data = ['A','B','C']

result = list(combinations(data, 2))# data 중 2개를 뽑아 순서없이 나열(조합) 중복 없음

print(result)

# 출력 [('A','B'),('A','C'),('B','C')]
```

## product
* permutaions 에서 원소 중복 허용해서 뽑고자 하는 데이터 수를 repeat 속성 값으로 넣음

```python
from itertools import product

data = ['A','B','C']

result = list(product(data, repeat=2))#data 중 2개를 뽑아 나열

print(result)

# 출력 [('A','A'),('A','B'), ... , ('C','C')] => 9개 나옴 (순서 있음)
```

## combination_with_replacement
* combinations 에서 중복 허용

```python
from itertools import combinations_with_replacement

data = ['A','B','C']

result = list(combinations_with_replacement(data, 2))# data 중 2개를 뽑아 순서없이 나열

print(result)

# 출력 [('A','A'), ('A','B'), ... , ('C','C')] => 6개 나옴(순서 없음)
```

## 3. heapq - Heap 기능 (기본 : 최소 힙)

* PriorityQueue 보다 빠름
* 원소 삽입 = heapq.heappush()
* 원소 꺼냄 = heapq.heappop()

```python
# 최소 힙 구현
import heapq

def heapsort(param)
    
    h = list()
    result = list()

    for item in param: # 모든 원소 차례대로 힙에 삽입
        heapq.heappush(h, item) # h에 item을 push

    for i in range(len(h)):
        result.append(heapq.heappop())
    
    return result

temp = heapsort([2,1,3,0,5,4])

print(temp)

# 출력 [0,1,2,3,4,5] 최소힙 - 오름차순 정렬
```

```python
# 최대 힙 구현 => 값에 -를 붙여서 넣는다
import heapq

def heapsort(param)
    
    h = list()
    result = list()

    for item in param: # 모든 원소 차례대로 힙에 삽입
        heapq.heappush(h, -item) # 원소에 - 를 붙여 넣으면 최소 힙과 반대로 된다

    for i in range(len(h)):
        result.append(-heapq.heappop())
    
    return result

temp = heapsort([2,1,3,0,5,4])

print(temp)

# 출력 [5,4,3,2,1,0] 최대 힙 - 내림차순 정렬
```

## 4. bisect - 이진 탐색 쉽개 구현

* 정렬된 배열에서 특정 원소 찾을 때 효과적
* bisect_left(x,y), bisect_right(x,y) 함수가 가장 중요 => 시간복잡도 O(logN)
* bisect_left(x,y): 정렬 순서 유지, 리스트 x에 데이터 y를 삽입 할 가장 왼쪽 인덱스 찾음
* bisect_right(x,y): 정렬 순서 유지, 리스트 x에 데이터 y를 삽입 할 가장 오른쪽 인덱스 찾음

```python
from bisect import bisect_left, bisect_right

x = [1,2,4,4,8]
y = 4
print(bisect_left(x,y)) #출력 2
print(bisect_right(x,y))# 출력 4
```
* bisect_left(), bisect_right() : 정렬된 리스트에서 값이 특정 범위에 속하는 원소의 개수 구할 때 효과적임

```python
from bisect import bisect_left, bisect_right

def count(a, left_value, right_value):
    left_idx = bisect_left(a, left_value)
    right_idx = bisect_right(a, right_value)

    return right_idx - left_idx

a = [1,2,3,3,3,3,4,5]

# 리스트 a에서 값이 3인 데이터의 갯수
print(count(a,3,3)) #출력 4

# 리스트 a에서 [-1,3] 범위에 있는 데이터 갯수
print(count(a,-1,3)) #출력 6
```

## 5. collections - 유용한 자료구조 (ex. deque, Counter)

## deque
* 보통 queue 구현할 때 사용(stack도 가능, queue 라이브러리보다 빠름)

    - list는 삭제, 삽입이 모두 가장 뒤쪽 원소 기준임
    - 하지만, deque 이용 시, popleft()로 첫 번째(가장 앞) 원소 삭제, append(x)로 마지막 인덱스에 삽입   
    (pop()으로 마지막 원소 삭제, appendleft(x)로 첫 번째 인덱스에 삽입 가능)

```python
from collections import deque

data = deque([2,3,4])
data.appendleft(1)
data.append(5)

print(data) #출력 deque([1,2,3,4,5])

print(list(data))# 출력 [1,2,3,4,5] => 리스트 자료형으로 변환
```
## Counter => 등장 횟수 셈
* 리스트 같은 iterable 객체에서 내부 원소가 몇 번씩 등장했는지 알려준다
```python
from collections import Counter

counter = Counter(['a','a','a','b','b','c','d','e'])

print(counter['a']) # 'a' 등장횟수, 출력 3

print(counter['c']) # 'c' 등장횟수, 출력 1
```

## 6. math
## factorial(x) => x의 팩토리얼 값 출력
## sqrt(x) => x의 제곱근 출력
## gcd(a,b) => a와 b의 최대공약수 출력
## 상수 pi, e => 파이(3,14....)와 자연상수 출력

```python
import math

print(math.factorial(5))# 출력 120

print(math.sqrt(9)) # 출력 3

print(math.gcd(21,14)) # 출력 7

print(math.pi) #출력 3.141592...

print(math.e)# 출력 2.71828...
```

## 7. 기타

## ord()
* 아스키코드로 변환

``` python
print(ord('a'))

# 출력 97
```

## chr()
* 정수를 인자로 받아서 문자로 변환

``` python
print(chr(97))

# 출력 a
```
## replace
* old 문자를 new 문자로 치환

```python
name = "Hello world!"

name.replace("!", "?")
print(name)

# 출력 Hello world?
```

## isdigit()
* 문자열이 숫자인지 확인
* 숫자만 포함되었을 때 True를 반환한다.

```python
ex1 = "123"
ex2 = "123AS"

print(ex1.isdigit())
# 출력 True

print(ex2.isdigit())
#출력 False
```
## isalpha()
* 문자열이 알파벳인지 확인
* 알파벳만 포함되었을 때 True를 반환한다.

```python
ex1 = "ABC"
ex2 = "abc asd" # 공백은 False
ex3 = "asd-asd"

print(ex1.isalpha())
# 출력 True

print(ex2.isalpha())
#출력 False

print(ex3.isalpha())
#출력 False
```

## dict => value 값을 통해 key 값 찾기
* 기존 dict를 뒤집어서 새로운 dict를 만든다

```python
book = {}
book["대한민국"] = '+82"
book["미국"] = '+1'
book["영국"] = '+44'
print(book)

# 출력 {'대한민국':'+82', '미국':'+1', '영국':'+44'}

reverse_book = dict(map(reversed, book.items()))
print(reverse_book)

#출력 {'+82': '대한민국', '+1':'미국', '+44':'영국'}
```

## 파이썬의 삼항 연산자

```python
[true_value] if [condition] else [false_value]
```

* 예시

```python
a = 1 if alpha > beta else 2
```