import java.util.Scanner;

public class SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner input = new Scanner(System.in);
        int n, m;
        do {

            System.out.println("1 = Insert at front");
            System.out.println("2 = Insert at end");
            System.out.println("3 = Insert after");
            System.out.println("4 = Print current list");
            System.out.println("0 = Exit");
            m = input.nextInt();
            if(m == 0)
                break;
            if(m == 1) {
                System.out.println("Enter data : ");
                n = input.nextInt();
                list.insertAtFront(n);
            }
            else if(m == 2) {
                System.out.println("Enter data : ");
                n = input.nextInt();
                list.insertAtEnd(n);
            }
            else if(m == 3) {
                System.out.println("Enter data : ");
                n = input.nextInt();
                System.out.println("Enter prev node element: ");
                int prev = input.nextInt();
                Node prev_node = list.findNode(prev);
                list.insertAfter(prev_node, n);
            }
            else if(m == 4) {
                list.printList();
            }
            else {
                System.out.println("Invalid input");
            }
        }while(m != 0);
    }

    Node findNode(int data) {
        Node cur = head;
        while(cur != null) {
            if(cur.data == data)
                return cur;
            cur = cur.next;
        }
        return cur;
    }

    Node head;

    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insertAtFront(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAfter(Node prev_node, int new_data) {
        if(prev_node == null) {
            System.out.println("Given previous node can not be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void insertAtEnd(int new_data) {
        Node new_node = new Node(new_data);
        if(head == null) {
            head = new_node;
            return;
        }
        new_node.next = null;
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
