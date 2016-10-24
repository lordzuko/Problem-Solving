n,m = map(int,raw_input().strip().split())
coins = map(int,raw_input().strip().split())

ways = [0]*(n+1)
ways[0] = 1
for c in coins:
    for i in range(c,n+1):
        ways[i] += ways[i-c]

print ways[n]
