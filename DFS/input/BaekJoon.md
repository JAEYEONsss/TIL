# 백준 입력 정리
## sys 모듈 사용
* 백준 문제의 첫 줄에는 입력 조건이 나온다.
1. 입력값을 작성한 파일을 만든다.
2. import sys module
3. 첫 줄에 있는 값을 저장할 변수를 만들고 값을 읽는다.
4. 문제에 사용될 값을 (여러 줄) 읽는다.

### 파일 예시 (input.txt)
```
1 2 3
10 20 
40 50 
70 80 
```
```python
import sys
sys.stdin = open("input.txt", "r")# 이 때, 경로르 정확하게 입력해야한다.
                                  # 절대 경로로 작성하는 것을 추천(오류 발생x)

a,b,c = map(int, sys.stdin.readline().split())# 첫 줄의 1, 2, 3 입력 받기

arr = [list(map(int, sys.stdin.readline().split())) for _ in range(b)]

for x, y in arr:
    print(x, y)

```
* input() 사용도 가능하지만, sys.stdin.readline()을 사용하는 것이 입력 속도가 빠르다.