def selection_sort(alist):
    
    n = len(alist)
    
    for j in range(0,n-1):
        min_index = j
        for i in range(j+1,n):
            if alist[min_index] > alist[i] :
                min_index = i
        alist[j],alist[min_index] = alist[min_index],alist[j]

def selection_sort_t(alist):
    
    n = len(alist)
    
    for j in range(0,n-1):
        min_index = j
        for i in range(j+1,n):
            if alist[min_index] > alist[i] :
                min_index = i
        alist[j],alist[min_index] = alist[min_index],alist[j]



if __name__ == "__main__":
    li = [54,26,97,17,77,31,44,55,28]
    print (li)
    selection_sort_t(li)
    print (li)