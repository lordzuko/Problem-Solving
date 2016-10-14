n = int(raw_input())
a = map(int,raw_input().split())
b = [0]*100
for i in range(n):
    b[a[i]]+=1

print ' '.join([str(x) for x in b])