class Node(object): #双向链表节点
    def __init__(self,item): 
        self.elem = item
        self.next = None
        self.prev = None



class DoubleLinkList():
    """双向链表的实现
    
    is_empty() 判断链表是否为空
    length() 返回链表的长度
    travel() 遍历
    add(item) 在头部添加一个节点
    append(item) 在尾部添加一个节点
    insert(pos, item) 在指定位置pos添加节点
    remove(item) 删除一个节点
    search(item) 查找节点是否存在

    """
    

    def __init__(self):
        self._head = None

    def is_empty(self): # 判断列表是否为空
        return self._head is None

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
            print (cur.elem,end='')
            cur = cur.next
        print("\n")

    def add(self,item):  # 头部添加元素
        node = Node(item) # 先创建一个保存item的节点
        node.next = self._head # 将新节点的链接域next 指向头结点，即_head 
        self._head = node # 将链表的头—_head 指向新节点
        node.next.prev = node # 新节点下一节点的prev 指向新节点

    def append(self,item): # 尾部添加元素
        node = Node(item) 
        if self.is_empty():  # 先判断链表是否为空，若是空链表，则将_head指向新节点
            self._head = node
        else: # 若不为空，则找到尾部，将尾节点的next指向新节点,新节点的prev指向cur
            cur = self._head
            while cur.next != None:
                cur = cur.next 
            cur.next = node
            node.prev = cur


    def insert(self,pos,item): # 指定位置添加元素
        if pos <= 0: # 若指定位置pos为首/尾，曾执行 头部/尾部插入
            self.add(item)
        elif pos > (self.length()-1):
            self.append(item)

        else:
            node = Node(item) 
            cur = self._head
            count = 0 
            pre = self._head # pre为指定位置前一个位置，初始为头结点开始移动到指定位置
            while count < (pos -1):
                count += 1
                cur = cur.next 
            # 将node的prev指向cur
            node.prev = cur
            # 将node的next指向cur的下一个节点
            node.next = cur.next
            # 将cur的下一个节点的prev指向node
            cur.next.prev = node
            # 将cur的next指向node
            cur.next = node

    def remove(self, item):
        """删除元素"""
        if self.is_empty():
            return
        else:
            cur = self._head
            if cur.item == item:
                # 如果首节点的元素即是要删除的元素
                if cur.next == None:
                    # 如果链表只有这一个节点
                    self._head = None
                else:
                    # 将第二个节点的prev设置为None
                    cur.next.prev = None
                    # 将_head指向第二个节点
                    self._head = cur.next
                return
            while cur != None:
                if cur.item == item:
                    # 将cur的前一个节点的next指向cur的后一个节点
                    cur.prev.next = cur.next
                    # 将cur的后一个节点的prev指向cur的前一个节点
                    cur.next.prev = cur.prev
                    break
                cur = cur.next

    def search(self,item): # 链表查找节点是否存在
        cur = self._head
        while cur != None:
            if cur.elem == item:
                return True
            cur = cur.next
        return False

if __name__ == "__main__":
    ll = DoubleLinkList()
    ll.add(1)
    ll.add(2)
    ll.append(3)
    ll.insert(2, 4)
    print ("length:",ll.length())
    ll.travel()
    print (ll.search(3))
    print (ll.search(5))
    ll.remove(1)
    print ("length:",ll.length())
    ll.travel()