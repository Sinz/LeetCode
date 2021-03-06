class Node(object):
    def __init__(self, item):
        self.item = item
        self.next = None


class SinCycLinkedlist(object):
    """单向循环链表
    
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
    
    def is_empty(self): # 判断链表是否为空
        return self._head == None

    def length(self): # 返回链表的长度
        if self.is_empty():
            return 0
        count = 0 
        cur = self._head
        while cur.next != self._head:
            count += 1
            cur = cur.next
        return count
    
    def travel(self): # 遍历链表
        if self.is_empty():
            return
        cur = self._head
        print (cur.item)
        while cur.next != self._head:
            cur = cur.next
            print (cur.item ,)
        print (" ")

    def add(self,item): # 头部添加节点
        node = Node(item)
        if self.is_empty():
            self._head = node
            node.next = self._head # 添加的节点指向_head
        else:
            node.next = self._head
            cur = self._head # 移到链表尾部，将尾部节点的next 指向node
            while cur.next != self._head:
                cur = cur.next
            cur.next = node
            self._head = node # head 指向添加的node

    def append(self,item): # 尾部添加节点
        node = Node(item)
        if self.is_empty():
            self._head = node
            node.next = self._head # 添加的节点指向_head
        else:
            node.next = self._head
            cur = self._head # 移到链表尾部，将尾部节点的next 指向node
            while cur.next != self._head:
                cur = cur.next
            cur.next = node # 将尾节点指向node
            node.next = self._head # 将node指向头节点_head
        
    def insert(self,pos,item): 
        if pos <= 0:
            self.add(item)
        elif pos >= (self.length):
            self.append(item)
        else:
            node = Node(item)
            cur = self._head
            count = 0 
            while count < (pos-1): # 移动到指定位置的前一个位置
                count += 1
                cur = cur.next
            node.next = cur.next
            cur.next = node
          
    def remove(self,item): #删除节点
        if self.is_empty():
                return
        cur = self._head
        pre = None
         # 若头节点的元素就是要查找的元素item
        if cur.item == item:
            # 如果链表不止一个节点
            if cur.next != self._head:
                # 先找到尾节点，将尾节点的next指向第二个节点
                while cur.next != self._head:
                    cur = cur.next
                # cur指向了尾节点
                cur.next = self._head.next
                self._head = self._head.next
            else:
                # 链表只有一个节点
                self._head = None
        else:
            pre = self._head
            # 第一个节点不是要删除的
            while cur.next != self._head:
                # 找到了要删除的元素
                if cur.item == item:
                    # 删除
                    pre.next = cur.next
                    return
                else:
                    pre = cur
                    cur = cur.next
            # cur 指向尾节点
            if cur.item == item:
                # 尾部删除
                pre.next = cur.next
            
    def search(self,item): # 链表查找节点是否存在 
        cur = self._head
        if self.is_empty():
            return False
        while cur.next != self._head:
            if cur.elem == item:
                return True
            cur = cur.next
        if cur.elem == item:
            return True
        return False


