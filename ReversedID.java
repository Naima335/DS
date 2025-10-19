import java.util.Arrays;
import java.util.EmptyStackException;

public class ReversedID {
    public static void main(String[] args) {

        UniStack<Character> idStack = new UniStack<>();

        String studentID = "C0122";

        // Push each character of ID into the stack
        for (int i = 0; i < studentID.length(); i++) {
            idStack.add(studentID.charAt(i));
        }

        // Pop to reverse
        StringBuilder reversed = new StringBuilder();
        while (!idStack.checkEmpty()) {
            reversed.append(idStack.remove());
        }

        System.out.println("Original ID: " + studentID);
        System.out.println("Reversed ID: " + reversed);
    }
}

class UniStack<E> {
    private static final int BASE_SIZE = 3;
    private int index;
    private E[] data;

    // default constructor
    @SuppressWarnings("unchecked")
    UniStack() {
        this.index = 0;
        this.data = (E[]) new Object[BASE_SIZE];
    }

    // constructor with initial capacity
    @SuppressWarnings("unchecked")
    UniStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be > 0");
        }
        this.index = 0;
        this.data = (E[]) new Object[initialCapacity];
    }

    // number of elements
    public int getCount() {
        return index;
    }

    // push
    public void add(E value) {
        if (getCount() == data.length) {
            expand();
        }
        data[index++] = value;
    }

    // pop
    public E remove() {
        if (checkEmpty()) {
            throw new EmptyStackException();
        }
        E item = data[--index];
        data[index] = null; // avoid loitering
        return item;
    }

    // check empty
    public boolean checkEmpty() {
        return index == 0;
    }

    // expand array capacity
    private void expand() {
        int newLen = Math.max(1, data.length * 2);
        System.out.println("Expanding array size: " + data.length + " -> " + newLen);
        data = Arrays.copyOf(data, newLen);
    }
}
