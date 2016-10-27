n = int(raw_input().strip())
a = map(int,raw_input().strip().split())

odd_cnt = 0
flag = False
for i in range(0,n):
    #if two consecutive are odd -> they can be converted to even by using 2nd coupon and then unlimited 1st coupon
    #if both are even -> then unlimited 1st coupon can be applied
    #if one is odd and next is 0 -> not possible
    #if all are odd -> not possible
    if (a[i]&1) and (not odd_cnt):
        odd_cnt = 1
    elif (a[i]&1) and odd_cnt:
        odd_cnt = 0

    if (not a[i] and odd_cnt==1):
        flag = True
        break

if (flag or odd_cnt):
    print "NO"
else :
    print "YES"