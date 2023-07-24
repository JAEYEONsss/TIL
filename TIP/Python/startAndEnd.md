# python startswith(), endswith()
* 어떤 문자열이 있을 때, 특정 문자(열)로 시작하는지 알고 싶을 때는  startswith()  
   특정 문자(열)로 끝나는지 알고 싶을 때는 endswith()를 사용하면 된다.

## startswith(문자(열), 시작 지점)
```python
test = "aaa bbb ccc"

print(test.startswith("a"))#시작 지점을 지정안할시 0번 인덱스에서부터 시작한다
print(test.startswith("aa"))
print(test.startswith("a",4))#4번 인덱스가 a로 시작하는지 확인한다
print(test.startswith("b",4))

#True
#True
#False 
#True
```
* 반환값은  True/False 형식이다.

## endwith(문자(열), 문자열 시작 지점, 끝 지점)

```python
test = "aaa bbb ccc"

print(test.endwith('c'))#시작/끝 지점 지정 안할시 문자열 전체가 탐색 대상이다
print(test.endwith('b'))
print(test.endwith('b', 0, 2))#문자열 0번 인덱스부터 2번 인덱스까지가 탐색 대상이다
print(test.endwith('a', 0, 2))

# True
# False
# False
# True
```
