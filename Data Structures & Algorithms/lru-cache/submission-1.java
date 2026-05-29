class LRUCache {

    Node head;
    Node tail;
    Map<Integer, Node> keyMap;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.keyMap = new HashMap<>();
    }
    
    public int get(int key) {
        // System.out.println("Before get key "+key+" - "+keyMap);
        // display();
        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            updateLatest(node);
            // System.out.println("After get ");
            // display();
            return node.value;
        }
        // System.out.println("After get ");
        // display();
        return -1;
    }
    
    public void put(int key, int value) {
        // System.out.println("Before put ");
        // display();
        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.value = value;
            updateLatest(node);
            keyMap.put(key, node);
        }
        else{
            Node newNode = new Node(key, value);
            Node headNext = head.next;
            head.next = newNode;
            newNode.prev = head;
            headNext.prev = newNode;
            newNode.next = headNext;
            keyMap.put(key, newNode);
            if(keyMap.size() > capacity){
                Node tailPrev = tail.prev;
                tailPrev.prev.next = tail;
                tail.prev = tailPrev.prev;
                // System.out.println("Removing key for capacity "+tailPrev.key);
                keyMap.remove(tailPrev.key);
            }
        }
        // System.out.println("After put ");
        // display();
    }

    public void updateLatest(Node node){
        if(node != null && node.prev != head){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            headNext.prev = node;
            node.next = headNext;
        }
    }

    public void display(){
        Node temp = head.next;
        while(temp != null && temp != tail){
            System.out.println("Key "+temp.key+" value "+temp.value);
            temp = temp.next;
        }
    }

}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
