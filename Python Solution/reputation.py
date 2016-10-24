from operator import itemgetter

n = int(raw_input().strip())
s_boys = []
c_boys = 0
c_girls = 0
s_girls = []
for i in range(n):
    x = int(raw_input().strip())
    if x<0:
        c_boys+=1
    s_boys.append(x)

n = int(raw_input())
for i in range(n):
    x = int(raw_input().strip())
    if x < 0:
        c_girls += 1
    s_girls.append(x)

m = int(raw_input())

a1 = sum(x*y for x,y in zip(s_boys,s_girls)) + m*max(map(abs, s_girls))
a2 = sum(x*y for x,y in zip(s_boys,s_girls)) + m*max(map(abs,s_boys))

print max(a1,a2)