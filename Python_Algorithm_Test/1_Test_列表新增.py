from timeit import Timer
  
def test1(): 
    l = []
    for i in range(1000):
        l += [i]
        # l = l + [i] 处理效率很低，需要生成一个新的列表
def test2():
    l = []
    for i in range(1000):
        l.append(i)
def test3():
    l = [i for i in range(1000)]
def test4():
    l = list(range(1000))

t1 = Timer("test1()","from __main__ import test1")
t2 = Timer("test2()","from __main__ import test2")
t3 = Timer("test3()","from __main__ import test3")
t4 = Timer("test4()","from __main__ import test4")

print("concat",t1.timeit(number=1000),"seconds")
print("append ",t2.timeit(number=1000),"seconds")

print("comprehension ",t3.timeit(number=1000),"seconds")
print("list range",t4.timeit(number=1000),"seconds")

