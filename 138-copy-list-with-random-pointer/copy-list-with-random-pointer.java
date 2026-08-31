/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Map old nodes → new nodes
        Map<Node, Node> map = new HashMap<>();

        // Step 1: Copy all nodes (just values, no pointers yet)
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // Step 2: Assign next and random pointers
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);     // copy next
            map.get(cur).random = map.get(cur.random); // copy random
            cur = cur.next;
        }

        // Return head of copied list
        return map.get(head);
    }
}