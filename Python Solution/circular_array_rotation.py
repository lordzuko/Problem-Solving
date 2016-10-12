
import sys

n, k, q = raw_input().strip().split(' ')
n, k, q = [int(n), int(k), int(q)]
a = map(int, raw_input().strip().split(' '))
b = [0 for i in range(0,n)]
for i in range(n):
    b[(i+k)%n] = a[i]
for a0 in xrange(q):
    m = int(raw_input().strip())
    print b[m]


