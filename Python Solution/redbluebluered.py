def _word_pattern(pattern, pattern_index, input, input_index, hashmap):
    if pattern_index == len(pattern) and input_index == len(input):
        return True;

    if pattern_index == len(pattern) or input_index == len(input):
        return False

    char = pattern[pattern_index]

    if char in hashmap:
        to_match = hashmap[char]

        for i in range(len(to_match)):
            if input_index >= len(input) or input[input_index] != to_match[i]:
                return False
            input_index += 1

        print  "from if   "+ str(hashmap)
        return _word_pattern(pattern, pattern_index + 1, input, input_index, hashmap)
    else:
        flag = False

        for i in range(input_index, len(input)):
            # get substring to match
            to_match = input[input_index:i + 1]

            # update hashmap
            if to_match in hashmap.values():
                return False

            hashmap[char] = to_match
            print  "from else "+ str(hashmap)
            flag = flag or _word_pattern(pattern, pattern_index + 1, input, i + 1, hashmap)

            del hashmap[char]

            if flag:
                return True

        return False


def wordpattern(pattern, input):
    if len(input) < len(pattern):
        return False
    hashmap = {}
    ans = _word_pattern(pattern, 0, input, 0, hashmap)

    if ans:
        return 1
    else:
        return 0


p = raw_input().strip()
s = raw_input().strip()
if wordpattern(p, s):
    print 1
else:
    print 0

