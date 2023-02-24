import sys

sys.stdin = open("/Users/yang/Desktop/공부기록/TIL/input.txt", "r")

times = int(sys.stdin.readline())

for i in range(times):
    cloth_num = int(sys.stdin.readline())
    fin_num = 1
    book = dict()
    
    for j in range(cloth_num):
        wear, kind = sys.stdin.readline().split()
    
        if kind in book:
            book[kind] += 1
        
        if not kind in book:
            book[kind] = 1
            
    for k in book:
            fin_num *= (book[k] + 1)
            
    print(fin_num-1)
    
# len() 사용보다는 dict에 해당 카테고리 추가하고 몇 개 있는지 숫자를 세는게 더 낫다