# 문제설명
<img width="1230" alt="스크린샷 2023-01-02 오후 3 18 59" src="https://user-images.githubusercontent.com/87291052/210200161-a53bec20-1357-45ef-81b7-48954c95cf8b.png">

* 점화식을 이용해서 규칙성을 발견한다.   
1마리 = 3   
2마리 = 7   
3마리 = 17   
4마리 = 41 ...   
즉, dp[n] = dp[n-1]*2 + dp[n-2]

### 어려웠던 점
* 문제 접근 시에 초기 모델을 설정하는게 어려웠다. 동물이 들어갈 위치만 구하면 되는데 서로 다른 동물의 위치까지 변경되는 경우도 생각해서 초기 모델 설정이 안되었다.