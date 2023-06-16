# 소수 찾기

* 에라토스테네스의 체 알고리즘을 이용해서 소수를 찾는 방법이다.

```python
def solution(n):
    check = [True] * (n+1)
    check[0] = check[1] = False

    for num in range(2, int(n**(1/2))+1): #...1
        if check[num]:
            for ber in range(num*2, n+1, num): #...2
                check[ber] = False

    prime_count = sum(check)
    return prime_count

```

## 1의 이유
* n은 자연수 a,b에 대해 n = a * b 라고 표현할 수 있다.    
m = sqrt(n)일 때, n = m * m 라고 표현할 수 있다.    
따라서, a * b = n = m * m 이고, a * b = m * m 이다.   
이 때, a와 b는 세 가지 조건 내에서 성립된다.   
```
1. a = m && b = m
2. a < m && b > m
3. a > m && b < m
```

따라서, min(a,b) <= m 이다. 즉, n의 모든 약수 에 해당하는 a와 b가 어느 수이더라도 둘 중 하나는 sqrt(n) 이하이므로, sqrt(n) = m 까지만 조사하면 되는 것이다.   
[출처](https://nahwasa.com/entry/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98-%EC%B2%B4-%ED%98%B9%EC%9D%80-%EC%86%8C%EC%88%98%ED%8C%90%EC%A0%95-%EC%8B%9C-%EC%A0%9C%EA%B3%B1%EA%B7%BC-%EA%B9%8C%EC%A7%80%EB%A7%8C-%ED%99%95%EC%9D%B8%ED%95%98%EB%A9%B4-%EB%90%98%EB%8A%94-%EC%9D%B4%EC%9C%A0)

## 2의 이유
* 현재 소수인 num의 배수를 모두 제거하기 위한 반복문으로 생각하면 된다.   
에라토스테네스의 체 알고리즘에서는 각 소수의 배수는 모두 소수가 아닌 수라는 특성을 이용함.  
num * 2는 num의 배수 중 가장 작은 수를 의미함.   
또한, num 씩 숫자를 증가시키며 num의 배수를 차례대로 제거함.