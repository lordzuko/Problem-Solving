n = int(raw_input().strip())
c = map(int,raw_input().strip().split(' '))
i=0
cnt = 0
while i!=n-1:
    if i >= n-1:
        break
    if i+2 <= n-1 and c[i+2] != 1:
        i+=2
    else:
        i+=1
    cnt+=1

print cnt
