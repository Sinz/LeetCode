def shell_sort(alist):

    """希尔排序"""
    n = len(alist)
    gap = n//2

    while gap > 0:    
        # 与普通的插入算法的区别就是步长
        for j in range(gap,n):
            i = j
            while i > 0:
                if alist[i]<alist[i-gap]:
                    alist[i],alist[i-gap] = alist[i-gap],alist[i] 
                    i -= gap       
                else:
                    break
        gap //= 2            
if __name__ == "__main__":
    li = [54,26,97,17,77,31,44,55,28]
    print (li)
    shell_sort(li)
    print (li)