import java.util.ArrayList;

public class NodeList {
    private Node tail = null;
    private Node head = null;

    public NodeList() {
    }

    public NodeList( Node someNode ) {
        this.setNodeNetwork( someNode );
    }

    //Set NodeNetwork
    public boolean setNodeNetwork_fromHead() {
        return this.setNodeNetwork( this.head );
    }

    public boolean setNodeNetwork_fromTail() {
        return this.setNodeNetwork( this.tail );
    }

    public boolean setNodeNetwork( Node someNode ) {
        if ( someNode == null ) {
            return false;
        }
        this.tail = fromNode_findTail( someNode );
        this.head = fromNode_findHead( someNode );
        return true;
    }


    //Getters
    public Node getHead() {
        if ( this.head == null ) {
            if ( this.tail != null ) {
                this.head = fromNode_findHead( this.getTail() );
                return this.head;
            }
            return null;
        }

        if ( this.head.getPrevious() != null ) {
            if ( this.tail != null ) {
                if ( this.tail.next == null ) {
                    this.head = fromNode_findHead( this.tail );
                    return this.head;
                }
            }
            this.head = fromNode_findHead( this.head );
            return this.head;
        }

        if ( this.tail == null ) {
            this.tail = fromNode_findTail( this.head );
        }

        if ( this.tail != null ) {
            if ( this.tail.next != null ) {
                this.tail = fromNode_findTail( this.head );
            }
//            else if ( !NodeList.isSameNetwork( this.tail, this.head ) ) {
//                this.setNodeNetwork_fromHead();
//            }

        }

        return this.head;
    }

    public Node getTail() {
        if ( this.tail == null ) {
            if ( this.head != null ) {
                this.tail = fromNode_findTail( this.getHead() );
                return this.tail;
            }
            return null;
        }

        if ( this.tail.getNext() != null ) {
            if ( this.head != null ) {
                if ( this.head.previous == null ) {
                    this.tail = fromNode_findTail( this.head );
                    return this.tail;
                }
            }
            this.tail = fromNode_findTail( this.tail );
            return this.tail;
        }

        if ( this.head == null ) {
            this.head = fromNode_findHead( this.tail );
        }

        if ( this.head != null ) {
            if ( this.head.previous != null ) {
                this.head = fromNode_findHead( this.tail );
            }
//            else if ( !NodeList.isSameNetwork( this.head, this.tail ) ) {
//                this.setNodeNetwork_fromTail();
//            }
        }

        return this.tail;
    }


    //Find
    public static Node fromNode_findHead( Node n ) {
        Node node = n;
        Node nodeOneBack = n;

        if ( node == null ) {
            return null;
        }

        if ( node.getPrevious() != null ) {
            node = node.previous;


            while ( node != null ) {
                node = node.previous;
                nodeOneBack = nodeOneBack.previous;
            }
        }

        return nodeOneBack;
    }

    public static Node fromNode_findTail( Node n ) {
        Node node = n;
        Node nodeOneBack = n;

        if ( node == null ) {
            return null;
        }

        if ( node.getNext() != null ) {
            node = node.next;


            while ( node != null ) {
                node = node.next;
                nodeOneBack = nodeOneBack.next;
            }
        }

        return nodeOneBack;
    }

    //Print
    public void fromHead_print() {
        fromHead_print( this.getHead() );
    }

    public void fromTail_print() {
        fromTail_print( this.getTail() );
    }

    public static void fromHead_print( Node n ) {
        Node node = fromNode_findHead( n );

        while ( node != null ) {
            System.out.println( node.data );
            node = node.next;
        }
    }

    public static void fromTail_print( Node n ) {
        Node node = fromNode_findTail( n );

        while ( node != null ) {
            System.out.println( node.data );
            node = node.previous;
        }
    }

    //Find and Remove
    public Node fromHead_findAndRemove( String data ) {
        Node nodeToRemove = this.fromHead_find( data );

        return this.removeNode( nodeToRemove );
    }

    public Node fromTail_findAndRemove( String data ) {
        Node nodeToRemove = this.fromTail_find( data );

        return this.removeNode( nodeToRemove );
    }

    //Find
    public Node fromHead_find( String data ) {
        Node node = this.getHead();

        while ( node != null ) {
            if ( node.data.matches( data ) ) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node fromTail_find( String data ) {
        Node node = this.getTail();

        while ( node != null ) {
            if ( node.data.matches( data ) ) {
                return node;
            }
            node = node.previous;
        }
        return null;
    }

    //ArrayList
    public ArrayList< Node > fromHead_ArrayList() {
        return fromHead_ArrayList( this.getHead() );
    }

    public ArrayList< Node > fromTail_ArrayList() {
        return fromTail_ArrayList( this.getTail() );
    }

    public static ArrayList< Node > fromHead_ArrayList( Node n ) {

        Node node = fromNode_findHead( n );

        ArrayList< Node > nodesFromHead = new ArrayList<>();

        while ( node != null ) {
            nodesFromHead.add( node );
            node = node.next;
        }

        return nodesFromHead;
    }

    public static ArrayList< Node > fromTail_ArrayList( Node n ) {
        Node node = fromNode_findTail( n );

        ArrayList< Node > nodesFromTail = new ArrayList<>();

        while ( node != null ) {
            nodesFromTail.add( node );
            node = node.previous;

        }

        return nodesFromTail;

    }

    //Remove
    public Node removeNode_head() {
        return removeNode( getHead() );
    }

    public Node removeNode_tail() {
        return removeNode( getTail() );
    }

    public Node removeNode( Node nodeToRemove ) {
        //Is Null
        if ( nodeToRemove == null ) {
            return null;
        }

        //Is only node in list
        if ( nodeToRemove.next == null ) {
            if ( nodeToRemove.previous == null ) {
                if ( this.head != null ) {
                    if ( this.head.equals( nodeToRemove ) ) {
                        if ( this.tail != null ) {
                            if ( this.tail.equals( nodeToRemove ) ) {

                                this.head.next = null;
                                this.head.previous = null;
                                this.head = null;

                                this.tail.next = null;
                                this.tail.previous = null;
                                this.tail = null;
                                return nodeToRemove;
                            }
                        }
                    }
                }


                //-----------------------------------------------------------------BUT WHAT IF IT IS THE SINGLE NODE IN A DIFFERENT LIST???
                nodeToRemove.next = null;
                nodeToRemove.previous = null;

                return nodeToRemove;
            }
        }

        //Is a head node
        if ( nodeToRemove.next != null ) {
            if ( nodeToRemove.previous == null ) {

                //This list's head node
                if ( !( this.getHead() == null ) ) {
                    if ( nodeToRemove.equals( this.head ) ) {
                        this.head = this.head.next;
                    }
                }

                nodeToRemove.next.previous = null;
                nodeToRemove.next = null;
                nodeToRemove.previous = null;

                return nodeToRemove;
            }
        }

        //Is a tail node
        if ( nodeToRemove.previous != null ) {
            if ( nodeToRemove.next == null ) {

                //This list's tail node
                if ( this.getTail() != null ) {
                    if ( nodeToRemove.equals( this.tail ) ) {
                        this.tail = this.tail.previous;
                    }
                }

                nodeToRemove.previous.next = null;
                nodeToRemove.previous = null;
                nodeToRemove.next = null;

                return nodeToRemove;
            }
        }

        //Is middle Node
        nodeToRemove.next.previous = nodeToRemove.previous;
        nodeToRemove.previous.next = nodeToRemove.next;

        nodeToRemove.next = null;
        nodeToRemove.previous = null;

        return nodeToRemove;
    }


    //Insert
    public Node insertNode_asHead( Node n ) {
        if ( n == null ) {
            return null;
        }

        if ( this.listHas_zeroNodes() ) {
            n = this.removeNode( n );
            n.next = null;
            n.previous = null;

            this.head = n;
            this.head.next = null;
            this.head.previous = null;

            this.tail = n;
            this.tail.next = null;
            this.tail.previous = null;

            return this.head;
        }

        if ( this.getHead() == null ) {
            if ( this.head == null ) {
                return null;
            }
        }

        n = this.insertNode_beforeThisNode( n, this.head );

        this.head = n;

        return n;
    }

    public Node insertNode_asTail( Node n ) {
        if ( n == null ) {
            return null;
        }

        if ( this.listHas_zeroNodes() ) {
            n = this.removeNode( n );
            n.next = null;
            n.previous = null;

            this.head = n;
            this.head.next = null;
            this.head.previous = null;

            this.tail = n;
            this.tail.next = null;
            this.tail.previous = null;


            return this.tail;
        }

        if ( this.getTail() == null ) {
            if ( this.tail == null ) {
                return null;
            }
        }

        n = this.insertNode_afterThisNode( n, this.tail );

        this.tail = n;

        return n;
    }

    public Node insertNode_beforeThisNode( Node inserted, Node beforeThis ) {
        if ( beforeThis == null || inserted == null ) {
            return null;
        }

        if ( inserted.equals( beforeThis ) ) {
            return inserted;
        }

        inserted = this.removeNode( inserted );

        if ( beforeThis.previous == null ) {
            //beforeThis.previous.next  //Is Null             = inserted;
            inserted.previous = null;

            beforeThis.previous = inserted;
            inserted.next = beforeThis;

            this.head = inserted;

            return inserted;
        }


        beforeThis.previous.next = inserted;
        inserted.previous = beforeThis.previous;

        beforeThis.previous = inserted;
        inserted.next = beforeThis;

        return inserted;
    }

    public Node insertNode_afterThisNode( Node inserted, Node afterThis ) {
        if ( afterThis == null || inserted == null ) {
            return null;
        }

        if ( inserted.equals( afterThis ) ) {
            return inserted;
        }

        inserted = this.removeNode( inserted );

        if ( afterThis.next == null ) {
            //afterThis.next.previous  //Is Null             = inserted;
            inserted.next = null;

            afterThis.next = inserted;
            inserted.previous = afterThis;

            this.tail = inserted;

            return inserted;
        }


        afterThis.next.previous = inserted;
        inserted.next = afterThis.next;

        afterThis.next = inserted;
        inserted.previous = afterThis;

        return inserted;
    }


    //Boooooooooooooooooooooooooooooooo
    public boolean listHas_oneNode() {
        if ( this.listHas_zeroNodes() ) {
            return false;
        }
        if ( this.getHead().equals( this.getTail() ) ) {
            return true;
        }
        return false;
    }

    public boolean listHas_zeroNodes() {
        if ( this.getHead() == null ) {
            if ( this.getTail() == null ) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameNetwork( Node node1, Node node2 ) {

        try {
            boolean resTemp = fromNode_findHead( node1 ).equals( fromNode_findHead( node2 ) );
            if ( !resTemp ) {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }

        try {
            boolean resTemp = fromNode_findTail( node1 ).equals( fromNode_findTail( node2 ) );
            if ( !resTemp ) {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }

        return true;
    }


    public static boolean isSameNetwork( ArrayList< Node > arrayList1, ArrayList< Node > arrayList2 ) {
        if ( !( arrayList1.size() == arrayList2.size() ) ) {
            return false;
        }

        return arrayList1.containsAll( arrayList2 );
    }


} //Class
