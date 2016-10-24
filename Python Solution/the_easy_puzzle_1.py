def gcd(a, b):
    """Return greatest common divisor using Euclid's Algorithm."""
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    """Return lowest common multiple."""
    return a * b // gcd(a, b)

def lcmm(*args):
    """Return lcm of args."""
    return reduce(lcm, args)


t = int(raw_input().strip())
while t:
    n,k = map(int,raw_input().strip().split())
    arr = map(int,raw_input().strip().split())

    l = lcmm(*arr)
    #print l
    if l%k:
        print 'NO'
    else:
        print 'YES'

    t-=1