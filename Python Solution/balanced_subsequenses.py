n = int(raw_input())
while n:
    s = raw_input().strip()
    l = len(s)
    stack = [s[0]]
    ans = 0
    i = 1

    while i < l:
        try:
            c = stack.pop()
            if c == '(' and s[i]==')':
                ans+=1

            else:
                stack.append(c)
                stack.append(s[i])
        except IndexError:
            stack.append(s[i])
        i+=1
    print ans*2
    n-=1