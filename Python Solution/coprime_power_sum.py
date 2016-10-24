bcof = [[1 for i in xrange(n + 1)] for n in xrange(102)]
mod = 10**9 + 7
for i in xrange(1, 11):
    for j in xrange(1, i + 1):
        bcof[i + 1][j] = (bcof[i][j - 1] + bcof[i][j])

def pow_sum(n,k,p):
    s = 0
    ans = [n for _ in xrange(k + 1)]
    for i in xrange(1, k + 1):
        ans[i] = ((pow(n + 1, i + 1,p)) - 1)
        for j in range(2, i + 2):
            ans[i] -= ((bcof[i + 1][j] * ans[i + 1 - j]))
        ans[i] = (ans[i] / (i + 1))
        #print ans[i]
    return (ans[k] % p)

for _ in  range(int(raw_input().strip())):

    n,k,m = map(int,raw_input().strip().split())
    a = map(long,raw_input().strip().split())

    summation = pow_sum(m,k,mod)
    l = set()
    for x in a:
        for z in range(x, m + 1, x):
            l.add(z)
    #print l
    for z in l:
        summation = summation - pow(z,k,mod)

    print summation % mod
