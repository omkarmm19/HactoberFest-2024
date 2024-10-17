// Doubly Linked List Implementation in Java
class DoublyLinkedList {
    // Node class for doubly linked list
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail of the list
    private Node head;
    private Node tail;

    // Constructor for empty list
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add a node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // List is empty
            head = newNode;
            tail = newNode;
        } else {
            // List is not empty
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            // List is empty
            head = newNode;
            tail = newNode;
        } else {
            // List is not empty
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Delete a node from the list
    public void delete(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                // If it's the only node in the list
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                }
                // If it's the head node
                else if (current == head) {
                    head = head.next;
                    head.prev = null;
                }
                // If it's the tail node
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // If it's a middle node
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Node with data " + data + " deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Node with data " + data + " not found.");
    }

    // Display the list from head to tail
    public void displayForward() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List (head to tail): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Display the list from tail to head
    public void displayBackward() {
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List (tail to head): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Main method to test the doubly linked list
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        list.displayForward();  // Output: List (head to tail): 5 10 20 30
        list.displayBackward(); // Output: List (tail to head): 30 20 10 5

        list.delete(20);
        list.displayForward();  // Output: List (head to tail): 5 10 30

        list.delete(5);
        list.displayForward();  // Output: List (head to tail): 10 30

        list.delete(30);
        list.displayForward();  // Output: List (head to tail): 10

        list.delete(10);
        list.displayForward();  // Output: List is empty.
    }
}
