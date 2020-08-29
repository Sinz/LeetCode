def bubble_sort_a(alist):

    n = len(alist)
    for j in range(n-1): #控制循环次数,从头开始
        for i in range(0,n-j-1): #控制循环从头到尾
            count = 0
            if alist[i] > alist[i+1]:
                alist[i],alist[i+1] = alist[i+1],alist[i]
                count += 1 
        if count is 0 : # 判断中间不需要交换时，全部退出
            return
    
def bubble_sort_b(alist):
    
    n = len(alist)
    for j in range(n-1,0,-1): #控制循环次数，从尾开始
        for i in range(j): #控制循环从头到尾
            if alist[i] > alist[i+1]:
                alist[i],alist[i+1] = alist[i+1],alist[i]

def bubble_sort_t(alist):

    n = len(alist)
    for j in range(n-1):
        count = 0
        for i in range(n-j-1):
            if alist[i+1] < alist[i]:
                alist[i+1],alist[i] = alist[i],alist[i+1]
                count += 1
        if count is 0 :
            return
    

    
if __name__ == "__main__":
    li = [54,26,97,17,77,31,44,55,28]
    print (li)
    bubble_sort_t(li)
    print (li)


    