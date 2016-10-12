"""
Sample Test:
INPUT:

3
3
3 1 2
4
1 3 4 2
5
1 2 3 5 4

OUTPUT:

YES
YES
NO

"""



t = int(raw_input())
while t:
    a = []
    c = 0
    n = int(raw_input())
    a = [int(x) for x in raw_input().split()]
    for i in xrange(0,n):
        for j in xrange(i+1,n):
            c+=  a[i] > a[j]

    if(c%2 == 0):
        print "YES"
    else:
        print "NO"

    t-=0