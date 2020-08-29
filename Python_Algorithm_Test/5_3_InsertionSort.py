def insertion_sort_a(alist):

    n = len(alist)
    for j in range(1,n): # 从右边的无序序列中取出多少个元素执行这样的过程
        i = j # i 代表内层循环的起始值：执行从右边的无序序列中取出第一个元素，然后将其插入前面的正确位置中
        while i > 0: 
            if alist[i] < alist[i-1]:
                alist[i],alist[i-1] = alist[i-1],alist[i]
                i -= 1
            else: 
                break

def insertion_sort_b(alist):
    
    n = len(alist)
    for j in range(1,n):
        for i in range(j,0,-1):
            if alist[i] < alist[i-1]:
                alist[i],alist[i-1] = alist[i-1],alist[i]
            else:
                break


if __name__ == "__main__":
    li = [54,26,97,17,77,31,44,55,28]
    print (li)
    insertion_sort_b(li)
    print (li)