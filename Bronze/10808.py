from collections import Counter
import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

string = Counter(list(sys.stdin.readline()))

cand = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']

for i in cand:
    print(string[i])
    
# Counter를 이용해서 풀이