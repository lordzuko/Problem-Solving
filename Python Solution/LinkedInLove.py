s = bytearray(raw_input().rstrip())
length = len(s)
initialCount = 0
lucky = bytearray("linkedin")
palindrome = bytearray(length)
j=0
k=length-1
while j<=k:
    if s[j]!=s[k]:
        initialCount+=1
    palindrome[j] = min(s[j], s[k])
    j+=1
    k-=1
palindrome[j:]=palindrome[length/2-1::-1]
minimum = 1001
answer = bytearray(length)
for i in range(length-7):
    if i<((length+1)/2-4) or i>=length/2:
        count = initialCount
        for j in range(i, i+8):
            count+=(1+(1 if (s[j]==s[length-1-j] and j != (length-1-j)) else 0)) if lucky[j-i]!=s[j] and lucky[j-i]!=s[length-1-j] else 0
        if minimum >= count:
            save1 = palindrome[i:i+8]
            save2 = palindrome[length-i-8:length-i]
            palindrome[i:i+8]=lucky
            palindrome[length-8-i:length-i]=lucky[::-1]
            if minimum == count:
                answer[:] = min(answer, palindrome)
            else:
                minimum = count
                answer[:] = palindrome
            palindrome[i:i+8]=save1
            palindrome[length-i-8:length-i]=save2
print  minimum