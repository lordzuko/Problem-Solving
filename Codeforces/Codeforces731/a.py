s = raw_input().strip()



def clockwise_dist(ptr,c2):
    return abs(ord(ptr)-ord(c2))

def anticlockwise_dist(ptr,c2):
    return 26 - abs(ord(ptr)-ord(c2))

pos = 'a'
rot = 0
for i in range(0,len(s)):
    rot += min(clockwise_dist(pos,s[i]),anticlockwise_dist(pos,s[i]))
    pos = s[i]

print rot