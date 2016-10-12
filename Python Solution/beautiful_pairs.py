n = int(raw_input())
a = map(int,raw_input().split())
b = map(int,raw_input().split())

l = []
for i in range(n):
    for j in range(n):
        if a[i] == b[j]:
            l.append((i,j))
            break


s = set(l)
print len(s)