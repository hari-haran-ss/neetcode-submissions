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
       Map<Node, Node> nodeMap = new HashMap<>();
       nodeMap.put(null, null);
       Node result = null, copy = null, temp = head;
       while(temp != null){
            if(result == null){
                result = new Node(temp.val);
                copy = result;
            }
            else{
                copy.next = new Node(temp.val);
                copy = copy.next;
            }
            nodeMap.put(temp, copy);
            temp = temp.next;
       }
       temp = head;
       while(temp != null){
            Node node = nodeMap.get(temp);
            node.random = nodeMap.get(temp.random);
            temp = temp.next;
       }
       return result;
    }
}
