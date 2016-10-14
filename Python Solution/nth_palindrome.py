#!/usr/bin/env python

''' Binary palindromes

    Find (non-negative) integers which are palindromes when written in binary

    See http://stackoverflow.com/q/39675412/4014959
    and https://oeis.org/A006995

    Written by PM 2Ring 2016.09.24

    Recursion for n>2: a(n)=2^(2k-q)+1+2^p*a(m), where k:=floor(log_2(n-1)), and p, q and m are determined as follows:

    Case 1: If n=2^(k+1), then p=0, q=0, m=1;

    Case 2: If 2^k<n<2^k+2^(k-1), then set i:=n-2^k, p=k-floor(log_2(i))-1, q=2, m=2^floor(log_2(i))+i;

    Case 3: If n=2^k+2^(k-1), then p=0, q=1, m=1;

    Case 4: If 2^k+2^(k-1)<n<2^(k+1), then set j:=n-2^k-2^(k-1), p=k-floor(log_2(j))-1, q=1, m=2*2^floor(log_2(j))+j;
'''

#Fast Python 3 version of floor(log2(n))
def flog2(n):
    return n.bit_length() - 1

def binpal(n, cache={1:0, 2:1, 3:3}):
    if n in cache:
        return cache[n]

    k = flog2(n - 1)
    b = 1 << k
    a, c = b >> 1, b << 1

    if n == c:
        p, q, m = 0, 0, 1
    elif b < n < a + b:
        i = n - b
        logi = flog2(i)
        p, q, m = k - logi - 1, 2, (1 << logi) + i
    elif n == a + b:
        p, q, m = 0, 1, 1
    else:
        #a + b < n < c
        i = n - a - b
        logi = flog2(i)
        p, q, m = k - logi - 1, 1, (2 << logi) + i

    result = (1 << (2*k - q)) + 1 + (1 << p) * binpal(m)
    cache[n] = result
    return result

def palgenbase2():
    ''' generator of binary palindromes '''
    #yield 0
    x, n, n2 = 1, 1, 2
    while True:
        for y in range(n, n2):
            s = format(y, 'b')
            yield int(s+s[-2::-1], 2)
        for y in range(n, n2):
            s = format(y, 'b')
            yield int(s+s[::-1], 2)
        x += 1
        n *= 2
        n2 *= 2

gen = palgenbase2()


n = int(raw_input())
for i in range(0, n):
    x = int(raw_input())
    #b = next(gen)
    c = binpal(x+1)
    #print('{0:>2}: {1} {1:b} {2}'.format(i, b, c))
    print c