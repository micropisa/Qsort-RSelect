package ru.vsu.cs.pekanov;

public class Main {

    public static void main(String[] args)
    {
        int[] arr = {5,2,9,7,7,3,8,10};
        for (int i = 0; i < arr.length; i++)
        {
            int d = RSelect(arr.clone(), 0, arr.length - 1, i);
            System.out.println(d);
        }
    }

    public static int RSelect(int[] arr, int m, int n, int i)
    {
        if (m == n)
        {
            return arr[m];
        }
        int p = (int) (Math.random() * (n - m + 1)) + m;
        p = Partition(arr, m, n, p);
        if (i == p) return arr[p];
        else if (i > p) return RSelect(arr, p + 1, n, i);
        else return RSelect(arr, m, p - 1, i);
    }



    public static int Partition(int[] arr, int m, int n, int indexCount)
    {
        int p = arr[indexCount];
        int i = m;
        int temp = arr[indexCount];
        arr[indexCount] = arr[n];
        arr[n] = temp;
        for (int j = m; j <= n; j++)
        {
            if (arr[j] < p) {
                int x = arr[i];
                arr[i] = arr[j];
                arr[j] = x;
                i++;
            }
        }
        int k = arr[n];
        arr[n] = arr[i];
        arr[i] = k;

        return i;
    }
}
