def bubble_sort_a(alist):

    n = len(alist)
    for j in range(0,n-1): #控制循环次数
        for i in range(0,n-j-1): #控制循环从头到尾
            count = 0
            if alist[i] > alist[i+1]:
                alist[i],alist[i+1] = alist[i+1],alist[i]
                count += 1 
        if count is 0 : # 判断中间不需要交换时，全部退出
            return
    
def bubble_sort_b(alist):
    
    n = len(alist)
    for j in range(n-1,0,-1): #控制循环次数
        for i in range(j): #控制循环从头到尾
            if alist[i] > alist[i+1]:
                alist[i],alist[i+1] = alist[i+1],alist[i]
    

    
if __name__ == "__main__":
    li = [54,26,97,17,77,31,44,55,28]
    print (li)
    bubble_sort_a(li)
    print (li)
    bubble_sort_b(li)
    print (li)

    