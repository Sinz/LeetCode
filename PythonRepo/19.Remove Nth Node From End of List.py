# 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
#
#  进阶：你能尝试使用一趟扫描实现吗？
#
#
#
#  示例 1：
#
#
# 输入：head = [1,2,3,4,5], n = 2
# 输出：[1,2,3,5]
#
#
#  示例 2：
#
#
# 输入：head = [1], n = 1
# 输出：[]
#
#
#  示例 3：
#
#
# 输入：head = [1,2], n = 1
# 输出：[1]
#
#
#
#
#  提示：
#
#
#  链表中结点的数目为 sz
#  1 <= sz <= 30
#  0 <= Node.val <= 100
#  1 <= n <= sz
#
#  Related Topics 链表 双指针
#  👍 1201 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
 def __init__(self, val=0, next=None):
     self.val = val
     self.next = next

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        if not head or n <= 0: return head
        slow, fast = head, head
        while fast:
            if n:
                fast = fast.next  # 快递指针先走N步
                n -= 1
                continue
            slow = slow.next
            fast = fast.next

        # 三种情况，1.删除节点在头 2.删除节点在尾 3.删除节点在中间
        if slow.next:  # 1.删除节点在头 3.删除节点在中间
            slow.val = slow.next.val
            slow.next = slow.next.next
        elif slow == head:  # 要删除的k节点与头节点相同，那表示链表中只有一个节点
            head = None
        else:  # 2.删除节点在尾
            curNode = head
            while curNode:
                if curNode.next == slow:  # 找到尾巴
                    curNode.next = None
                curNode = curNode.next

        return head


# leetcode submit region end(Prohibit modification and deletion)
