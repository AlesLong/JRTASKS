public class SruCodom {


    public static void main(String[] args) {

        Node node0 = new Node(10);
        Node node1 = new Node(15);
        Node node2 = new Node(16);
        Node node3 = new Node(17);
        Node node4 = new Node(18);
        Node node5 = new Node(19);
        Node node6 = new Node(11);
        Node node7 = new Node(12);

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        node1.left = node0;

        node6.left = node5;
        node6.right = node7;

    }
}

class Node {
    Node left;
    Node right;
    int nodeValue;


    Node(int nodeValue) {
        this.nodeValue = nodeValue;
    }
}