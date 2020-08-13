from timeit import Timer

def binary_search (list , item):
    low = 0
    high = len(list) - 1
    while low <= high:
        mid = int((low + high) / 2)
        guess = list[mid]
        if guess == item :
            return str(item) + "找到了 "
        if guess < item :
            low = mid + 1
        if guess > item:
            high = mid -1

def test():
    matrix=list(range(1, 128))
    print(binary_search(matrix,12))

t1 = Timer("test()","from __main__ import test")
print("test",t1.timeit(number=1000),"seconds")

