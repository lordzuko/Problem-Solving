import re
_pattern = "abba" #raw_input().strip()
_string = "catdogdogcat" #raw_input().strip()
hm = {}
rxp = ""
c = 1
for x in _pattern:
    if x in hm:
        rxp += hm[x]
        continue
    else:
        rxp += "(.+)"
        hm[x]="\\" + str(c)
        c+=1
{}.ha
print rxp
print re.match(rxp,_string)