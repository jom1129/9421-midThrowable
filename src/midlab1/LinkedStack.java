package midlab1;

public class LinkedStack <T> implements Stack<T> {
    private Node<T> top;
    private int numElements = 0;

    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T top() throws StackException {
        if (isEmpty()) throw new StackException("Stack is empty.");
        return top.getInfo();
    }

    public T pop() throws StackException {
        Node<T> temp;
        if (isEmpty()) throw new StackException("Stack underflow.");
        temp = top;
        top = top.getLink();
        return temp.getInfo();
    }

    @Override
    public void push(T item) throws StackException {
        Node<T> newNode = new Node<>();
        newNode.setInfo(item);
        newNode.setLink(top);
        top = newNode;
    }

    @Override
    public T peek() throws StackException {
        return top();
    }

    @Override
    public void clear() {
        for (var top = this.top; !isEmpty(); top = top.getLink(), --numElements)
            top.setLink(null);
    }

    @Override
    public int search(T item) {
        int index;
        Node<T> current = top;
        for (index = numElements; current.getLink() != null;
             current = current.getLink(), --index)
            if (current.getInfo().equals(item)) return index;
        return -1;
    }

    public Node<T> getTop() {
        return top;
    }
}
