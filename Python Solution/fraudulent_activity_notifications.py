import heapq
from collections import defaultdict


class Value(object):
    def __init__(self, val):
        self.val = val
        self.deleted = False

    def __neg__(self):
        """
        negate without creating new instance
        """
        self.val = -self.val
        return self

    def __cmp__(self, other):
        assert isinstance(other, Value)
        return self.val - other.val

    def __repr__(self):
        return repr(self.val)


class Heap(object):
    def __init__(self):
        self.h = []
        self.len = 0

    def push(self, t):
        heapq.heappush(self.h, t)
        self.len += 1

    def pop(self):
        """
        :return: the top item
        """
        self._clean_top()
        self.len -= 1

        return heapq.heappop(self.h)

    def remove(self, t):
        """
        lazy remove
        :param t:
        :return:
        """
        t.deleted = True
        self.len -= 1

    def __len__(self):
        return self.len

    def _clean_top(self):
        while self.h and self.h[0].deleted:
            heapq.heappop(self.h)

    def peek(self):
        self._clean_top()
        return self.h[0]

    def __repr__(self):
        return repr(self.h)


class DualHeap(object):
    def __init__(self):
        self.min_h = Heap()  # represent right side
        self.max_h = Heap()  # represent left side

    def _rebalance(self):
        r = len(self.min_h)
        l = len(self.max_h)
        if abs(l-r) <= 1:
            return

        if r > l:
            self.max_h.push(-self.min_h.pop())
        else:
            self.min_h.push(-self.max_h.pop())

        self._rebalance()

    def add(self, t):
        if len(self.min_h) > 0 and t > self.min_h.peek():
            self.min_h.push(t)
        else:
            self.max_h.push(-t)

        self._rebalance()

    def remove(self, t):
        if len(self.min_h) > 0 and t >= self.min_h.peek():
            self.min_h.remove(t)
        else:
            self.max_h.remove(t)

        self._rebalance()

    def median(self):
        r = len(self.min_h)
        l = len(self.max_h)
        if r == l:
            return (self.min_h.peek().val + -1*self.max_h.peek().val )/2.0
        elif r > l:
            return self.min_h.peek().val
        else:
            return -self.max_h.peek().val

    def __repr__(self):
        return repr(self.max_h)+repr(self.min_h)


class Median:
    def medianSlidingWindow(self, nums, k):
        """
        Use heap
        """
        nums = map(lambda x: Value(x), nums)
        if len(nums) < 1:
            return []

        ret = []
        dh = DualHeap()
        for i in xrange(k):
            dh.add(nums[i])
        ret.append(dh.median())

        for i in xrange(k, len(nums)):
            dh.remove(nums[i - k])
            dh.add(nums[i])
            ret.append(dh.median())

        return ret

    def median(lst):
        sorted_lst = sorted(lst)
        lst_len = len(sorted_lst)
        idx = (lst_len-1) // 2
        if lst_len %2 :
            return sorted_lst[idx]
        else:
            return (sorted_lst[idx] + sorted_lst[idx+1]) / 2.0

if __name__ == "__main__":


    n,d = map(int,raw_input().strip().split())  
    a = map(int,raw_input().strip().split())

    median = Median()
    med_list = median.medianSlidingWindow(a,d)
    #print med_list
    cnt = 0
    s= [a[0]]
    for i in range(1,n):
        s.append(a[i]+s[i-1])

    for i in range(d,n):
        #print i
        if a[i] >= 2*med_list[i-d]:
            cnt+=1

    print cnt



