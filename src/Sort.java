public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{2,5,6,1,6,1,21,6};
        array = selectionSort(array);
        printArray(array);
    }

    private static void  printArray(int[] array) {
        for (int value : array) {
            System.out.println(value);
        }
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    private static  int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean falg = false;
            for (int j = 0; j < array.length -1-i; j++) {

                //asc
                // if (array[j] > array[j + 1]) {
                //desc
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    falg = true;
                }
            }
            if (!falg) {
                return array;
            }
        }
        return array;
    }

    /**
     * 插入排序
     * @param array
     * @return
     */
    private static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j;
            for (j = i; j > 0; j--) {
                //asc
                //if (value < array[j - 1]) {
                //desc
                if (value > array[j - 1]) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = value;

        }
        return array;
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    private static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length ; j++) {
                //asc
                // if (array[j] < array[index]) {
                //desc
                 if (array[j] > array[index]) {
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
}
