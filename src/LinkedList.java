public class LinkedList {


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        Node node= conversionArrayToLinkedList(array);
        System.out.println("打印初始链表:");
        printLinkedList(node);
        node = reversLinkedList(node);
        System.out.println("打印反转后的链表:");
        printLinkedList(node);
    }

    /**
     * 打印链表
     * @param headNode
     */
    public static void printLinkedList(Node headNode) {
        while (headNode != null) {
            System.out.println(headNode.getValue());
            headNode = headNode.next;
        }
    }

    public static Node reversLinkedList(Node headNode) {
        Node preNode = null;
        Node currentNode = headNode;
        Node nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode = nextNode;
        }
        return headNode;
    }

    /**
     * 将数组转换为链表
     * @param array
     * @return
     */
    public static  Node conversionArrayToLinkedList(int[] array) {
        Node headNode = null;
        Node preNode = null;
        if (array.length < 1) {
            return headNode;
        }
        for (int i=0;i<array.length;i++) {
            Node node = new Node(array[i]);
            if (headNode == null) {
                headNode = node;
            } else {
                preNode.setNext(node);
            }
            preNode = node;
        }
        return headNode;
    }


    /**
     * 链表的节点
     */
    static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
