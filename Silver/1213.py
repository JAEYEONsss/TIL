import sys
from collections import Counter

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

name = sys.stdin.readline()
check = len(name) % 2 # 1 = 홀수, 0 = 짝수
ans = ''
ok = True
cnt = 0

counter = Counter(name)
counter_sorted = sorted(counter)

if check == 0:
    for i in counter_sorted:
        if counter[i] % 2 == 1:
            ok = False
else:
    for i in counter_sorted:
        if counter[i] % 2 == 1:
            cnt += 1
    
    if cnt != 1:
        ok = False
        
if ok:
    if check == 0:
        for i in counter_sorted:
            counter[i] /= 2
            while counter[i] != 0:
                ans += i
                counter[i] -= 1
        ans += ans[::-1]
        
    else:
        for i in counter_sorted:
            if counter[i] % 2 == 1:
                mid = i
                counter[i] -= 1
            counter[i] /= 2
            while counter[i] != 0:
                ans += i
                counter[i] -= 1
        ans = ans + mid + ans[::-1]
    print(ans)
        
else:
    print("I'm Sorry Hansoo")