# 单链表的实现
class SingleLinkList(object):
    def __init__(self):
        self._head = None
        # self.item = item

    def is_empty(self): # 判断列表是否为空
        return self._head == None

    def length(self): # 链表长度 : 初始时指向头结点，尾节点指向None；
        cur = self._head
        count = 0
        while cur != None:
            count += 1
            cur = cur._next
        return count
    
    def travel(self): # 遍历链表
        cur = self._head
        while cur != None:
            print (cur.elem,end='')
            cur = cur._next
        print("\n")

    def add(self,item): # 头部添加元素
        node = SingleNode(item)
        node.next = self._head
        self._head = node


