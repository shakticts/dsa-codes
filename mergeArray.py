class Solution(object):
    def merge(self, nums1, m, nums2, n):
       last = m+n-1
       i=m-1
       j=n-1

       while i>=0 and j>=0:
        if nums1[i]>nums2[j]:
            nums1[last]=nums1[i]
            i-=1
        else:
            nums1[last]=nums2[j]
            j-=1
        last -= 1   
       while j>=0:
        nums1[last]=nums2[j]   
        j-=1
        last-=1  
