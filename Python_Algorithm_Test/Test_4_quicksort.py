def sub_sort(array,low,high):
    key = array[low]
    while low < high:
        while low < high and array[high] >= key:
            high -= 1
        while low < high and array[high] < key:
            array[low] = array[high]
            low += 1
            array[high] = array[low]
    array[low] = key
    return low

def quick_sort(array,low,high):
     if low < high:
        key_index = sub_sort(array,low,high)
        quick_sort(array,low,key_index)
        quick_sort(array,key_index+1,high)

# 先从数列中取出一个数作为基准数。

# 分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。

# 再对左右区间重复第二步，直到各区间只有一个数

if __name__ == '__main__':
    array1 = [8,10,9,6,11,4,14]
    print (array1)
    quick_sort(array1,0,len(array1)-1)
    print (array1)
    # print (quicksort(array1))