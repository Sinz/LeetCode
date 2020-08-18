
class SingleNode(object):
    """单链表的结点"""
    def __init__(self,item):
        # _item存放数据元素
        self.item = item
        # _next是下一个节点的标识
        self.next = None

class SingleLinkList(object):
    """单链表的实现"""
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
            cur = cur.next
        return count
    
    def travel(self): # 遍历链表
        cur = self._head
        while cur != None:
            print (cur.item,end='')
            cur = cur.next
        print("\n")

    def add(self,item): # 头部添加元素
        node = SingleNode(item)
        node.next = self._head
        self._head = node


