# python enumerate
* 파이썬을 이용해서 코테 문제를 풀 때, for문을 사용하는 경우가 허다하다. 
```python
test = ['a','b','c']

for word in test:
	print(word) # 인덱스 없이 원소를 출력하고 싶은 경우

for num in range(len(test)):
	print(test[num]) # 인덱스를 통해서 원소를 출력하고 싶은 경우
```
* 위의 서로 다른 두 가지의 예시를 통해서 원소 출력하는 경우를 확인했다.    
   하지만, 원소와 인덱스 두 개가 동시에 필요한 경우는 어떻게 해야 하는지 고민해봐야 한다.

```python
 test = ['a', 'b', 'c']
 cnt = 0

 for word in test:
	 print(cnt, word)
	 cnt += 1 #인덱스를 위해서 추가적인 계산을 하는 경우
``` 

* 물론, 이 경우에도 원하는 출력 결과를 얻을 수 있다.  하지만, 파이썬에는 enumerate  라는 편리한 기능이 있다.

## enumerate
* 인덱스와 원소를 동시에 접근하는 방식을 사용할 수 있다.

``` python
test = ['a', 'b', 'c']

for idx, word in enumerate(test):
	print(idx, word)

# (0, 'a')
# (1, 'b')
# (2, 'c')	
```
### 시작 인덱스 변경
* 위에서 살펴본 경우는 인덱스가 0 부터 출력되는 것을 확인할 수 있다.       
   하지만, 인덱스를 임의로 설정해서 사용하고 싶은 경우도 있을 것이다.

```python
test = ['a', 'b', 'c']

for idx, word in enumerate(test, start = 1):
	print(idx, word)

# (1, 'a')
# (2, 'b')
# (3, 'c')
```  
### 2차원 리스트
* 위에서 살펴본 1차원 리스트를 통해서 2차원 리스트에 적용해서 enumerate를 사용할 수 있다.

```python
matrix = [['a', 'b', 'c'], ['d', 'e', 'f'], ['g', 'h', 'i']]

for row_idx, row in enumerate(matrix):
	for col_idx, col in enumerate(row):
		print(row_idx, col_idx, col)

# 0 0 a
# 0 1 b
# 0 2 c
# 1 0 d
# 1 1 e
# 1 2 f
# 2 0 g
# 2 1 h
# 2 2 i
```
