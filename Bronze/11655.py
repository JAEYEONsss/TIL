import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

name = sys.stdin.readline()

ans = ''

for i in range(len(name)):
    if not(ord(name[i]) >= 65 and ord(name[i]) <= 90) and not(ord(name[i]) >= 97 and ord(name[i]) <= 122):
        ans += name[i]
    else:
        if ord(name[i]) >= 65 and ord(name[i]) <= 90:
            if ord(name[i]) + 13 > 90:
                ans += chr((ord(name[i]) + 13) - 90 + 64)
                continue
            ans += chr(ord(name[i]) + 13)
        
        else:
            if ord(name[i]) + 13 > 122:
                ans += chr((ord(name[i]) + 13) - 122 + 96)
                continue
            ans += chr(ord(name[i]) + 13)
        
print(ans)