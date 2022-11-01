package logic;

import java.util.Arrays;

public class MyArray {
    private String[] array;
    private int size;

    public MyArray() {
        this(10);
    }

    /***
     *
     * @param dimension
     */
    public MyArray(int dimension) {
        array = new String[dimension];
        size = 0;
    }

    /***
     *
     * @param element
     */
    public void add(String element) {
        ensureCapacity(size + 1);
        array[size++] = element;
    }

    private void ensureCapacity(int min) {
        if (min > array.length) {
            int newCapacity = array.length + (array.length / 2);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;

    }

    public String get(int position) throws Exception {
        if (position >= 0 && position < size) {
            return array[position];
        }
        throw new Exception("indice fuera de rango");
    }

    /**
     * destruyo el elemento en pos y y los corre para organizarlos si pos no es valido retorna null
     *
     * @param pos
     * @return
     */
    public String remove(int pos) {
        if (pos >= 0 && pos < array.length) {
            String removed = array[pos];
            array[pos] = null;
            for (int i = pos; i <= size; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return removed;
        }
        return null;
    }
    /**
     * le doy un valor y bme devuelve la posicion del primer valor coincidente si no existe -1
     *
     * @return
     */
    public int indexOf(String code) {
        for (int i = 0; i < size; i++) {
            if (code.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String code) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(code)) {
                return i;
            }
        }
        return -1;
    }

    public String[] getArray() {
        return array.clone();
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder out = new StringBuilder("array=[");
        for (int index = 0; index < size; index++) {
            out.append(array[index]);
            if (index < size - 1) {
                out.append(',');
            }
        }
        out.append(']');
        return out.toString();


    }

    /**
     * @param pos  donde coloca
     * @param code que coloca
     * @return que coloca
     */
    public String setThis(int pos, String code) {
        array[pos] = code;
        return code;
    }
}