import java.util.Scanner;

public class ArrayRotation {

    /*
    Function to left rotate arr[] of size n by d
     */
    void leftRotate(int arr[], int d, int n) {
        for(int i=0; i<d; i++) {
            leftRotatebyOne(arr, n);
        }
    }
    void leftRotatebyOne(int arr[], int n) {
        int temp = arr[0];
        for(int i=0; i<n-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[n-1] = temp;
    }
    void printArray(int arr[], int n) {
        for(int i=0; i<n; i++) {
            System.out.println(arr[i] + ' ');
        }
    }
    public static void main(String[] args) {
        ArrayRotation rotate = new ArrayRotation();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scan.nextInt();
        System.out.println("Enter " + n + " elements: ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter d: ");
        int d = scan.nextInt();
        rotate.leftRotate(arr, d, n);
        rotate.printArray(arr, n);
    }
}
