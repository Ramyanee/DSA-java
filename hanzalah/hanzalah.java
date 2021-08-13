package hanzalah;

import java.util.Scanner;

public class hanzalah {

    // Merge function to merge sort the modified input array which is the help array
    // Help array contains start index and end index of the input array
    public static void merge(int help[][], int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int L[][] = new int[n1][2];
        int R[][] = new int[n2][2];
        for (int i = 0; i < n1; i++) {
            L[i] = help[p + i];

        }
        for (int i = 0; i < n2; i++) {
            R[i] = help[q + i + 1];
        }

        int i = 0, j = 0;
        int k = p;

        while (i < n1 && j < n2) {

            if (L[i][0] < R[j][0]) {
                help[k] = L[i];
                i++;
            }
            // if the start index (column 0) of help array is equal then we will sort it on
            // the basis of end index (column 1) of help array in descending order
            else if (L[i][0] == R[j][0]) {
                if (L[i][1] >= R[j][1]) {
                    help[k] = L[i];
                    i++;
                } else {
                    help[k] = R[j];
                    j++;
                }
            } else {
                help[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any to stu[k] */
        while (i < n1) {
            help[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any to stu[k] */
        while (j < n2) {
            help[k] = R[j];
            j++;
            k++;
        }
    }

    // Merge Sort
    public static void merge_sort(int help[][], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(help, p, q);
            merge_sort(help, q + 1, r);
            merge(help, p, q, r);
        }

    }

    public static void main(String[] args) {

        // Taking Input
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // Help array contains start index and end index of the input array
        int help[][] = new int[n][2];
        int r = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                int start = (i - arr[i] <= 0) ? 0 : i - arr[i];
                int end = (i + arr[i] > n - 1) ? n - 1 : i + arr[i];
                help[r][0] = start;
                help[r][1] = end;

                r++;
            }

        }

        // Sorting the help array
        // if the start index (column 0) of help array is equal then we will sort it on
        // the basis of end index (column 1) of help array in descending order
        merge_sort(help, 0, r - 1);

        if (help[0][0] != 0) {
            System.out.println("-1");
            System.exit(0);
        }

        boolean cover = false;
        for (int i = 0; i < r; i++) {
            if (help[i][1] == n - 1)
                cover = true;
        }
        if (cover == false) {
            System.out.println("-1");
            System.exit(0);
        }
        if (help[0][0] == 0 && help[0][1] == n - 1) {
            System.out.println(1);
            System.exit(0);
        }

        // The main logic is that we will skip the rows in help array while
        // trying to get the maximum end value from a row in the help array
        // count contains the minimum helper needed
        int end = help[0][1];
        int count = 1;
        int currentmax;
        currentmax = end;
        int i = 0;
        while (i < r) {
            int j = i + 1;
            int inner_loop = 0;

            currentmax=end;
            //System.out.printf("%n%d %d %d %n",currentmax,end,i);

            while (j < r && help[j][0] <= end + 1) {
                inner_loop = 1;


                    currentmax = currentmax > help[j][1] ? currentmax : help[j][1];

                j++;
            }
            if (inner_loop == 0)
                i++;
            else {
                i = j-1;
                end = currentmax;
            }
            count++;

            if (end >= n - 1) {
                System.out.println(count);
                System.exit(0);
            }

        }

        // if end is not equal to the number of people to be helped
        // then we will print -1 else we will print count
        if (end != n - 1) {
            System.out.println("-1");
            System.exit(0);
        }
        System.out.println(count);
        sc.close();
    }
}