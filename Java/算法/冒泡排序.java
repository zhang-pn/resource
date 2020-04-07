    public static void bubble(int[] array) {
        for (int round = 0; round < array.length - 1; round++) {
            for (int headNo = 0; headNo < array.length - 1 - round; headNo++) {
                if (array[headNo] > array[headNo + 1]) {
                    array[headNo] = array[headNo] + array[headNo + 1];
                    array[headNo + 1] = array[headNo] - array[headNo + 1];
                    array[headNo] = array[headNo] - array[headNo + 1];
                }
            }
        }
    }