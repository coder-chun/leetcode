/**
 * 快排
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = new int[]{2,5,6,1,6,1,21,6};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }


    /**
     * 快速排序
     * @param a
     * @param p
     * @param r
     */
    private static void quickSort(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r); // 获取分区点
        quickSort(a, p, q-1);
        quickSort(a, q+1, r);
    }

    /**
     * 排序并返回分区点
     * @param a
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i != j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
                ++i;
            }
        }

        a[r] = a[i] ;
        a[i] = pivot;
        return i;
    }
}
