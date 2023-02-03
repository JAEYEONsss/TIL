from collections import Counter
import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

times = int(sys.stdin.readline())

names = list()

for i in range(times):
    names.append(sys.stdin.readline().split()[0][0])
    
cand = Counter(names)

names = set(names)
ans = list()
wer =''

for i in names:
    if cand[i] >= 5:
        ans.append(i)
        
if len(ans) == 0:
    print("PREDAJA")
    
else:
    ans.sort()
    for i in ans:
        wer += i
    print(wer)