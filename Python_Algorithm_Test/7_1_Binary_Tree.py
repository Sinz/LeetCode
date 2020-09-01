class Node(object):
    """二叉树的节点"""
    def __init__(self, item):
        self.item = item
        self.lchild = None
        self.rchild = None

class Tree(object):
    """二叉树"""
    def __init__(self):
        self.root = None

    def add(self, item):
        """为树添加节点"""
        node = Node(item)
        #如果树是空的，则对根节点赋值
        if self.root == None:
            self.root = node
        else:
            queue = []
            queue.append(self.root)
            #对已有的节点进行层次遍历
            while queue:
                #弹出队列的第一个元素
                cur = queue.pop(0)
                if cur.lchild == None:
                    cur.lchild = node
                    return
                elif cur.rchild == None:
                    cur.rchild = node
                    return
                else:
                    #如果左右子树都不为空，加入队列继续判断
                    queue.append(cur.lchild)
                    queue.append(cur.rchild)

    def breadth_travel(self):
        """广度优先遍历"""

        queue = [self.root]
        while queue:
            cur_node = queue.pop(0)
            print (cur_node.item,end= " ")
            if cur_node.lchild is not None:
                queue.append(cur_node.lchild)
            if cur_node.rchild is not None:
                queue.append(cur_node.rchild)

    def preorder_travel(self,node): # 先序遍历
        if node is None:
            return 
        print(node.item,end=" ")
        self.preorder_travel(node.lchild)
        self.preorder_travel(node.rchild)

    def inorder_travel(self,node): # 中序遍历
        if node is None:
            return 
        self.preorder_travel(node.lchild)
        print(node.item,end=" ")
        self.preorder_travel(node.rchild)
    
    def postorder_travel(self,node): # 后续遍历
        if node is None:
            return 
        self.preorder_travel(node.lchild)
        self.preorder_travel(node.rchild)
        print(node.item,end=" ")

if __name__ == "__main__":
    tree = Tree()
    tree.add(1)
    tree.add(2)
    tree.add(3)
    tree.add(4)
    tree.add(5)
    tree.add(6)
    tree.add(7)
    tree.add(8)
    tree.add(9)
    tree.breadth_travel()
    print("")
    tree.preorder_travel(tree.root)
    print("")
    tree.inorder_travel(tree.root)
    print("")
    tree.postorder_travel(tree.root)
