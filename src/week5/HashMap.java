package week5;

public class HashMap {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
        map.put(2, 1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }

    private final int SIZE = 1000;
    private Node[] nodes;

    public HashMap() {
        nodes = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = key % SIZE;
        Node node = nodes[index];
        if (node == null) {
            nodes[index] = new Node(key, value);
        } else {
            while (node.next != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            if (node.key == key) {
                node.value = value;
            } else {
                node.next = new Node(key, value);
            }
        }
    }

    public int get(int key) {
        int index = key % SIZE;
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;
        Node node = nodes[index];
        if (node != null) {
            if (node.key == key) {
                nodes[index] = node.next;
            } else {
                while (node.next != null) {
                    if (node.next.key == key) {
                        node.next = node.next.next;
                        return;
                    }
                    node = node.next;
                }
            }
        }
    }

    private class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
