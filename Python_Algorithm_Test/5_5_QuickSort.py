def quick_sort(alist,start,end):

    """快速排序"""
    
    if start >= end:
        return # 递归循环退出条件
    low_index = start
    high_index = end
    mid_value = alist[start]

    while low_index < high_index:
        while alist[high_index] >= mid_value and low_index < high_index:
                high_index -= 1
        alist[low_index] = alist[high_index]

        while alist[low_index] < mid_value and low_index < high_index:
                low_index += 1
        alist[high_index] = alist[low_index]

    alist[low_index] = mid_value # 先从数列中取出一个数作为基准数。
                                 # 分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
    quick_sort (alist,start,low_index-1) # 再对左右区间重复第二步，直到各区间只有一个数
    quick_sort (alist,low_index+1,end)

if __name__ == "__main__":
    li = [54,26,97,17,77,31,44,55,28]
    print (li)
    quick_sort(li,0,len(li)-1)
    print (li)