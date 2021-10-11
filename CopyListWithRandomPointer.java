/*
138. Copy List with Random Pointer
Medium

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

 

Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

 

Note:

    You must return the copy of the given head as a reference to the cloned list.


*/
class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(oldNode, newNode);
        while(oldNode != null) {
            newNode.next = clone(oldNode.next, map);
            newNode.random = clone(oldNode.random, map);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
    }
    
    private Node clone(Node oldNode, Map<Node, Node> map) {
        if (oldNode == null) {
            return null;            
        }
        if (!map.containsKey(oldNode)) {
            map.put(oldNode, new Node(oldNode.val));
        }
        return map.get(oldNode);
    }
}