package midlab1;

/**
 * Required LinkedStack implementation
 * @param <T>
 */
public class LinkedStack <T> implements Stack<T> {
    private Node<T> top;    // a reference to the node at the
                            // top of the stack
    private int numElements = 0;    // holds the number of elements

    /**
     * Returns the number of elements
     * @return number of elements
     */
    public int size() {
        return numElements;
    }

    /**
     * Tests if the stack is empty
     * @return is the stack empty?
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the contents of the top node
     * without removing the node
     * @return contents of the top node
     * @throws StackException if the stack is empty (stack underflow)
     */
    @Override
    public T top() throws StackException {
        if (isEmpty()) throw new StackException("Stack is empty.");
        return top.getInfo();
    }

    /**
     * Pops the stack, returns the contents of the top node,
     * removes that node, and sets the bottom node as the new head (top node)
     * @return contents of the top node
     * @throws StackException if the stack is empty (stack underflow)
     */
    public T pop() throws StackException {
        Node<T> temp;
        if (isEmpty()) throw new StackException("Stack underflow.");
        temp = top;
        top = top.getLink();
        --numElements;
        return temp.getInfo();
    }

    /**
     * Push an element into the stack
     * This creates a new node, sets the
     * new node as the top node,
     * and links to the previous top node
     * @param item element to be stored inside the new node
     * @throws StackException is the stack is full (StackOverFlow)
     */
    @Override
    public void push(T item) throws StackException {
        Node<T> newNode = new Node<>();
        newNode.setInfo(item);
        newNode.setLink(top);
        top = newNode;
        ++numElements;
    }

    /**
     * Invokes top()
     * Returns the content of the top node, without
     * removing that node
     * @return contents of the top node
     * @throws StackException if the stack is empty
     */
    @Override
    public T peek() throws StackException {
        return top();
    }

    /**
     * Empties the stack without
     * deleting the stack instance
     */
    @Override
    public void clear() {
        for (var top = this.top; !isEmpty(); top = top.getLink(), --numElements)
            top.setLink(null);
    }

    /**
     * Searches for the passed argument if
     * it is in the stack
     * @param item item to lookup
     * @return index of the item (if it exists), else return -1
     */
    @Override
    public int search(T item) {
        int index;
        Node<T> current = top;
        for (index = numElements; current.getLink() != null;
             current = current.getLink(), --index)
            if (current.getInfo().equals(item)) return index;
        return -1;
    }

    /**
     * Return the top node (head node)
     * @return head node
     */
    public Node<T> getTop() {
        return top;
    }
}
