def binary_search_r(alist,num):
    n = len(alist)
    if n > 0:
        mid = n//2
        if alist[mid] is num:
            return True,mid

        elif alist[mid] > num:
            return binary_search(alist[:mid],num)
        elif alist[mid] < num:
            return binary_search(alist[mid+1:],num)
        
    return False

def binary_search(alist,num):
    n = len(alist)
    first = 0
    last = n-1

    while first <= last:
        mid = (first + last) // 2
        if alist[mid] == num:
            return True,mid
        elif num < alist[mid]:
            last = mid - 1
        else: 
            first = mid + 1
    return False

if __name__ == "__main__":
    alist = [17, 20, 26, 31, 44, 54, 55, 77, 93]
    print(alist)
    print(binary_search_r(alist,26))
    print(binary_search(alist,44))