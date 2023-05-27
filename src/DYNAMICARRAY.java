import java.util.Arrays;
import java.util.Iterator;

public class DYNAMICARRAY implements Iterable<Integer> {
    private int[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;


    public DYNAMICARRAY() {
        data = new int[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(int value) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size] = value;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int value = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        if (size <= data.length / 4 && data.length > INITIAL_CAPACITY) {
            resize(data.length / 2);
        }
        return value;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    public int getMax() {
        if (size == 0){
            throw new IllegalStateException("DynamicArray is empty.");
        }
        int max = data[0];
        for (int i = 1; i < size; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public int getSecondMax() {
        if (size < 2) {
            throw new IllegalStateException("DynamicArray has less than 2 elements.");
        }
        int max = Math.max(data[0], data[1]);
        int secondMax = Math.min(data[0], data[1]);
        for (int i = 2; i < size; i++) {
            if (data[i] > max) {
                secondMax = max;
                max = data[i];
            } else if (data[i] > secondMax) {
                secondMax = data[i];
            }
        }
        return secondMax;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int getSize() {
        return size;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                return data[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }
}

