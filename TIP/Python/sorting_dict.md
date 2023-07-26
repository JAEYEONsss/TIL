# python dictionary ket/value 정렬
* dictionary를 사용했을 때,  key 혹은 value를 기준으로 dictionary를 정렬할 필요가 있는 경우가 있다.

## key 기준 정렬
```python
test_dict = {'e': 5, 'c': 3, 'a':1, 'd': 4, 'b': 2}

up_test = sorted[test_dict.items()] # Key 기준 오름차순 정렬 => list 반환
print(up_test)

down_test = sorted(test_dict.items(), reverse = True) # Key 기준 내림차순 정렬 => list 반환
print(down_test)

# [('a', 5), ('b', 4), ('c', 3), ('d', 2), ('e', 1)]
# [('e', 1), ('d', 2), ('c', 3), ('b', 4), ('a', 5)]
```
* list  형태로 반환된다.

## value  기준 정렬
```python
test_dict = {'e': 5, 'c': 3, 'a':1, 'd': 4, 'b': 2}

up_test = sorted[test_dict.items(), key = lambda item : item[1]] # value 기준 오름차순 정렬 => list 반환
print(up_test)

down_test = sorted(test_dict.items(), key = lambda item : item[1], reverse = True) # value 기준 내림차순 정렬 => list 반환
print(down_test)

# [('e', 1), ('d', 2), ('c', 3), ('b', 4), ('a', 5)]
# [('a', 5), ('b', 4), ('c', 3), ('d', 2), ('e', 1)]
```
* list 형태로 반환된다.
