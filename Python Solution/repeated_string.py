s = raw_input().strip()
n = long(raw_input().strip())
cnt = s.count('a')
ans = n/len(s) * cnt
for x in range(n%len(s)):
    if s[x] == 'a':
        ans+=1
print ans
