/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] array = new int[]{2,5,6,1,6,1,21,6};
        mergeSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }


    /**
     * 归并排序
     * @param array
     * @param begin
     * @param end
     */
    private static void mergeSort(int[] array, int begin, int end) {
        // 递归终止条件
        if (begin >= end) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int middle = begin + (end - begin)/2;
        // 分治递归
        mergeSort(array, begin, middle);
        mergeSort(array, middle+1, end);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(array, begin, middle, end);
    }

    /**
     * 排序并合并
     * @param array
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] array, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i<=q && j<=r) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = array[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = array[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            array[p+i] = tmp[i];
        }
    }
}
