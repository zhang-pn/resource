    public static void quick(int[] array, int before, int after) {
        if (before >= after || before < 0 || after > array.length - 1) return;
        int low = before;
        int high = after;
        boolean direction = true;
        int index = low;
        int pivot = array[index];
        while (low < high) {
            if (direction) {
                while (true) {
                    if (array[high] <= pivot) {
                        array[index] = array[high];
                        index = high;
                        low++;
                        direction = !direction;
                        break;
                    }
                    if (--high == low) break;
                }
            } else {
                while (true) {
                    if (array[low] >= pivot) {
                        array[index] = array[low];
                        index = low;
                        high--;
                        direction = !direction;
                        break;
                    }
                    if (high == ++low) break;
                }
            }
        }
        array[low] = pivot;
        quick(array, before, low - 1);
        quick(array, low + 1, after);
    }