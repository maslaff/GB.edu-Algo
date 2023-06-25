class LinList:
    def __init__(self) -> None:
        self.head = self.Node(None, None, None)

    class Node:
        def __init__(self, value, nextNode, prevNode) -> None:
            self.value = value
            self.nextNode = nextNode
            self.prevNode = prevNode

    def add(self, value, prevNode: Node = None):
        node = self.Node(value, None, None)
        if prevNode:
            node.prevNode = prevNode
            node.nextNode = prevNode.nextNode
            node.prevNode.nextNode = node
            if node.nextNode:
                node.nextNode.prevNode = node
        else:
            if self.head.value:
                node.nextNode = self.head
                self.head.prevNode = node
            self.head = node

    def printList(self):
        node = self.head
        while (node):
            print(node.value)
            node = node.nextNode

    def revert(self):
        node = self.Node
        nx_node = self.head
        while nx_node:
            node = nx_node
            nx_node = node.nextNode
            node.nextNode, node.prevNode = node.prevNode, node.nextNode
        self.head = node


lst = LinList()
lst.printList()
lst.add(30)
lst.add(50)
lst.add(12)
lst.add(84)
lst.add(4353)
lst.printList()
print("-------")
lst.revert()
lst.printList()
