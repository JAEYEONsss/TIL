num = int(input())

dp = [3, 7, 1]

cnt = 2

if num >= 3:
    while cnt != num:
        dp[2] = dp[1]*2 + dp[0]
        dp[0] = dp[1]
        dp[1] = dp[2]
        cnt += 1
    
elif num == 1:
    dp[2] = dp[0]

elif num == 2:
    dp[2] = dp[1]
    
print(dp[2]%9901)
