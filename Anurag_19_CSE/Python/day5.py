# Link For Problem: https://leetcode.com/problems/implement-stack-using-queues/

from collections import deque

"""
    Use Default list.
    Push towards the end.
    Pop last element.

    TC:
    1. Push : O(1)
    2. Pop : O(1)
    3. Top : O(1)
    4. Empty : O(1)

    SC: O(n)  

"""


class MyStack:
    stack: list

    def __init__(self):
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        return self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def empty(self) -> bool:
        return len(self.stack) == 0


"""
    Use Deque.
    Push towards the Front.
    Pop First Element.

    TC:
    1. Push : O(1)
    2. Pop : O(1)
    3. Top : O(1)
    4. Empty : O(1)

    SC: O(n)  

"""


class UsingDeque:
    dq: deque

    def __init__(self):
        self.dq = deque()

    def push(self, x: int) -> None:
        self.dq.appendleft(x)

    def pop(self) -> int:
        return self.dq.popleft()

    def top(self) -> int:
        return self.dq[0]

    def empty(self) -> bool:
        return not self.dq
