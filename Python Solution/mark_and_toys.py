n,k = map(int,raw_input().split())
arr = map(int,raw_input().split())

arr.sort()
c=0
sum = 0
for i in range(n):
    sum+=arr[i]
    if sum <= k:
        c+=1
    else:
        break
print c