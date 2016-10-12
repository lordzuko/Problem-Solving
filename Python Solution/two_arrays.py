t = int(raw_input())

while t:
    n,k = map(int,raw_input().split())
    a = map(int,raw_input().split())
    b = map(int,raw_input().split())

    a.sort()
    b.sort(reverse=True)

    for i in range(n):
        if a[i]+b[i] < k:
            print "NO"
            break
    else:
        print "YES"
    t -= 1