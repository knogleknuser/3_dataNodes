public class Node {
    Node next = null;
    Node previous = null;

    String data;

    public Node( String data ) {
        this.data = data;
    }

    public Node getNext() {
//        if ( this.next == null ) {
//            return null;
//        }

        return this.next;
    }

    public Node getPrevious() {
//        if ( this.previous == null ) {
//            return null;
//        }

        return this.previous;
    }

    public String getData() {
//        if ( this.data == null ) {
//            return null;
//        }

        return this.data;
    }
} //Class
