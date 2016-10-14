from collections import Counter
def isValid(s):
    d = Counter(s)
    val_map = Counter(d.values())

    if len(val_map) == 1:
        return True

    if len(val_map) == 2:
        for v in val_map.values():
            if v == 1:
                return True

    return False

s = raw_input()
if isValid(s):
    print "YES"
else:
    print "NO"