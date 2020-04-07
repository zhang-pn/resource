    public static void select(int[] array) {
        for (int round = 0; round < array.length - 1; round++) {
            int minIndex = round;
            for (int item = round + 1; item < array.length; item++) {
                if (array[item] < array[minIndex]) minIndex = item;
            }
            if (minIndex != round) {
                array[round] = array[round] + array[minIndex];
                array[minIndex] = array[round] - array[minIndex];
                array[round] = array[round] - array[minIndex];
            }
        }
    }