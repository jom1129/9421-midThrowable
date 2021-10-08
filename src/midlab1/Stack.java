package midlab1;

/**
 * A collection of objects that are inserted and removed according
 * to the last-in first-out principle. Although similar in purpose,
 * this interface differs from java.util.Stack
 */
public interface Stack<T>{
    public int size(); // returns the size of the Stack
    public boolean isEmpty();   // checks if stack is empty
    public T top() throws StackException;
    public T pop() throws StackException;
    public void push(T item) throws StackException;
    public T peek() throws StackException;
    public void clear();
    public int search(T item);  // return the location of T
}
