n = int(raw_input().strip())
watcher = 5
sharer = 0
ans = 0
for i in range(n):
    sharer = int(watcher/2)
    watcher = sharer*3
    ans += sharer
print ans
