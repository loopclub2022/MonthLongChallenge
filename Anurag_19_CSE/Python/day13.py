# Link For Problem: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

from collections import deque
from platform import node


class Node:

    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:

    """
        TC : O(n)

        SC : O(n)
    """

    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None

        q: deque = deque()
        q.append(root)

        while(q):
            size: int = len(q)
            dummy: Node = Node(0)

            while(size > 0):
                size -= 1
                current: Node = q.popleft()
                dummy.next = current
                dummy = dummy.next

                if current.left:
                    q.append(current.left)

                if current.right:
                    q.append(current.right)

        return root

    """
        TC : O(n)

        SC : O(1)
    """

    def space_optimized(self, root: 'Node') -> 'Node':
        if not root:
            return None

        head: Node = root

        while(head):
            dummy: Node = Node(0)
            temp: Node = dummy

            while(head):

                if head.left:
                    temp.next = head.left
                    temp = temp.next

                if head.right:
                    temp.next = head.right
                    temp = temp.next

                head = head.next

            head = dummy.next

        return root

    """
        TC : O(n)

        SC : O(1)
    """

    def another_solution(self, root: 'Node') -> 'Node':
        if not root:
            return None

        dummyHead: Node = Node(0)
        pre: Node = dummyHead
        real_root: Node = root

        while(root):

            if root.left:
                pre.next = root.left
                pre = pre.next

            if root.right:
                pre.next = root.right
                pre = pre.next

            root = root.next

            if not root:
                pre = dummyHead
                root = dummyHead.next
                dummyHead.next = None

        return real_root
