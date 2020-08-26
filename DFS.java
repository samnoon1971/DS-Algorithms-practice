import java.util.Scanner;

public class DFS {
    private static int LIMIT = 100005;
    public static MyLinkedList[] adjList;
    public static boolean[] visited;
    private static int component;
    public static void main(String[] args) {
        adjList = new MyLinkedList[LIMIT];
        visited = new boolean[LIMIT];
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i=1; i<=n; i++)
        {
            adjList[i] = new MyLinkedList();
        }
        for(int i=0; i<m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            push(v, adjList[u]);
            push(u, adjList[v]);
        }
        for(int i=1; i<=n; i++) {
            if(visited[i])
                continue;
            component++;
            traverse(i);
        }
        System.out.println("Number of components: " + component);
    }
    public static void push(int vertex, MyLinkedList list) {
        MyLinkedList.Node new_node = new MyLinkedList.Node(vertex);
        new_node.next = list.head;
        list.head = new_node;
    }
    public static void iterate(MyLinkedList.Node head) {
        while (head != null) {
            traverse(head.data);
            head = head.next;
        }
    }
    public static void traverse(int node) {
        if(visited[node])
            return;
        visited[node] = true;
        if(adjList[node].head != null)
           iterate(adjList[node].head);
    }
}

class MyLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
    Node(int data) {this.data = data;}
    }

}
