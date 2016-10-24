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

n = int(raw_input())
for i in range(0, n):
    x = int(raw_input())
    c = binpal(x+1)
    print c