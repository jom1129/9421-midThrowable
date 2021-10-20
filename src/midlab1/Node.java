package midlab1;

/**
 * Provided Node Reference class by
 * the problem specification
 * @param <T> Node content
 */
public class Node <T> {
    private T info; // Node content
    private Node<T> link;   // links to the next node

    /**
     * The default constructor does nothing
     */
    public Node() { }

    /**
     * A constructor that receives a parameter
     * to be stored and a reference to the next node
     * @param info data to be stored inside the node
     * @param link contains a reference to the next node
     */
    public Node(T info, Node<T> link) {
        this.info = info;
        this.link = link;
    }

    /**
     * Holds the element to be stored
     * @param info element to be stored within the node
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Contains a memory reference (pointer) to the
     * next node
     * @param link
     */
    public void setLink(Node<T> link) {
        this.link = link;
    }

    /**
     * Returns the contents of the node
     * @return element stored within the node
     */
    public T getInfo() {
        return info;
    }

    /**
     * Returns the next node
     * @return reference to the next node
     */
    public Node<T> getLink() {
        return link;
    }
}
