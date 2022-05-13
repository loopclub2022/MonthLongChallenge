# Link For Problem: https://leetcode.com/problems/flatten-nested-list-iterator/


"""
This is the interface that allows for creating nested lists.
You should not implement it, or speculate about its implementation
"""
from collections import deque


class NestedInteger:

    def isInteger(self) -> bool:
        """
        @return True if this NestedInteger holds a single integer, rather than a nested list.
        """

    def getInteger(self) -> int:
        """
        @return the single integer that this NestedInteger holds, if it holds a single integer
        Return None if this NestedInteger holds a nested list
        """

    def getList(self) -> list[NestedInteger]:
        """
        @return the nested list that this NestedInteger holds, if it holds a nested list
        Return None if this NestedInteger holds a single integer
        """


"""
      Solution is Self-Explanatory.
      
      Take a List of Integers.
      
      Just traverse through input nestedList.
      If only a single integer is found then add it
      to the List.
      
      If Nested List of Integers is found then traverse through that list
      and add all the integers one by one.
      
      Keep a pointer for the next element.
      
      TC:
            1. For Flatteing the input list : O(n)
      
            2. Next : O(1)
      
            3. hasNext: O(1)
      
      SC: O(n)
"""


class NestedIterator:

    flat: list
    pointer: int

    def __init__(self, nestedList: list[NestedInteger]):
        self.flat = []
        self._flatten(nestedList)
        self.pointer = 0

    def _flatten(self, nestedList: list[NestedInteger]) -> None:

        for item in nestedList:

            if item.isInteger():
                self.flat.append(item.getInteger())
            else:
                self._flatten(item.getList())

    def next(self) -> int:
        self.pointer += 1
        return self.flat[self.pointer-1]

    def hasNext(self) -> bool:
        return self.pointer < len(self.flat)


class Using_Deque:

    def __init__(self, nestedList):

        self.lst = deque()
        self.recurse(nestedList)

    def next(self):
        return self.lst.popleft()

    def recurse(self, lst):

        for item in lst:

            if item.isInteger():
                self.lst.append(item.getInteger())
            else:
                self.recurse(item.getList())

    def hasNext(self):
        return self.lst
