num = int(input())
ans = list()
ans.append(num)
now = 0
cnt = 0
size = 0
fin = 0

while True:
    if ans[now] == 1:
        break
    if ans[now] % 2 == 0:
        ans.append(int(ans[now]/2))
        size += 1
    if ans[now] % 3 == 0:
        ans.append(int(ans[now]/3))
        size += 1
        
    temp = ans[now] - 1
    ans.append(temp)
    size += 1
        
    if now == fin:
        fin = size
        cnt += 1
        if 1 in ans:
            break
    
    now += 1
    
print(cnt)