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
        this.tail = Node.findTail( someNode );
        this.head = Node.findHead( someNode );
        return true;
    }


    //Getters
    public Node getHead() {
        if ( this.head == null ) {
            if ( this.tail != null ) {
                this.head = Node.findHead( this.getTail() );
                return this.head;
            }
            return null;
        }

        if ( this.head.getPrevious() != null ) {
            if ( this.tail != null ) {
                if ( this.tail.next == null ) {
                    this.head = Node.findHead( this.tail );
                    return this.head;
                }
            }
            this.head = Node.findHead( this.head );
            return this.head;
        }

        if ( this.tail == null ) {
            this.tail = Node.findTail( this.head );
        }

        if ( this.tail != null ) {
            if ( this.tail.next != null ) {
                this.tail = Node.findTail( this.head );
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
                this.tail = Node.findTail( this.getHead() );
                return this.tail;
            }
            return null;
        }

        if ( this.tail.getNext() != null ) {
            if ( this.head != null ) {
                if ( this.head.previous == null ) {
                    this.tail = Node.findTail( this.head );
                    return this.tail;
                }
            }
            this.tail = Node.findTail( this.tail );
            return this.tail;
        }

        if ( this.head == null ) {
            this.head = Node.findHead( this.tail );
        }

        if ( this.head != null ) {
            if ( this.head.previous != null ) {
                this.head = Node.findHead( this.tail );
            }
//            else if ( !NodeList.isSameNetwork( this.head, this.tail ) ) {
//                this.setNodeNetwork_fromTail();
//            }
        }

        return this.tail;
    }
    //Print
    public void print_fromHead() {
        Node.print_towardsFromHead( this.getHead() );
    }

    public void print_fromTail() {
        Node.print_towardsFromTail( this.getTail() );
    }

    //Strings - Simple Standalone
    public String[] strings_fromHead() {
        return Node.strings_towardsFromHead( this.getHead() );
    }

    public String[] strings_fromTail() {
        return Node.strings_towardsFromTail( this.getTail() );
    }

    //Strings
    public String[] strings_fromHead( StringBuilder stringBuilder ) {
        return Node.strings_towardsFromHead( this.getHead(), stringBuilder );
    }

    public String[] strings_fromTail( StringBuilder stringBuilder ) {
        return Node.strings_towardsFromTail( this.getTail(), stringBuilder );
    }

    //Stringbuilder - Simple Standalone
    public StringBuilder stringbuilder_fromHead() {
        return Node.stringbuilder_fromHead( this.getHead() );
    }

    public StringBuilder stringbuilder_fromTail() {
        return Node.stringbuilder_fromTail( this.getTail() );
    }

    //Stringbuilder
    public StringBuilder stringbuilder_fromHead( StringBuilder stringBuilder ) {
        return Node.stringbuilder_fromHead( this.getHead(), stringBuilder );
    }

    public StringBuilder stringbuilder_fromTail( StringBuilder stringBuilder ) {
        return Node.stringbuilder_fromTail( this.getTail(), stringBuilder );
    }


    //Find and Remove
    public Node findAndRemove_fromHead( String data ) {
        Node nodeToRemove = this.find_fromHead( data );
        return this.removeNode(nodeToRemove);
    }

    public Node findAndRemove_fromTail( String data ) {
        Node nodeToRemove = this.find_fromTail( data );
        return this.removeNode(nodeToRemove);
    }

    //Find
    public Node find_fromHead( String data ) {
        return Node.find_fromTowards_head( this.getHead(), data );
    }

    public Node find_fromTail( String data ) {
        return Node.find_fromTowards_tail( this.getTail(), data );
    }

    //Remove
    public Node removeNode_head() {
        return this.removeNode( this.getHead() );
    }

    public Node removeNode_tail() {
        return this.removeNode( this.getTail() );
    }

    public Node removeNode( Node nodeToRemove ) {
        //Is Null
        if ( nodeToRemove == null ) {
            return null;
        }

        //Update Head and Tails
        this.getHead();
        this.getTail();

        //List Specific
        //Is only node in list
        if ( this.head != null && this.tail != null && this.head.equals( nodeToRemove ) && this.tail.equals( nodeToRemove ) ) {

            this.head.next = null;
            this.head.previous = null;
            this.head = null;

            this.tail.next = null;
            this.tail.previous = null;
            this.tail = null;

            return nodeToRemove;
        }

        //This list's head node
        if ( this.head != null ) {
            if ( this.head.next != null ) {
                if ( nodeToRemove.equals( this.head ) ) {
                    this.head = this.head.next;
                    return Node.helper_removeNode_head( nodeToRemove );
                }
            }
        }

        //This list's tail node
        if ( this.tail != null ) {
            if ( this.tail.previous != null ) {
                if ( nodeToRemove.equals( this.tail ) ) {
                    this.tail = this.tail.previous;
                    return Node.helper_removeNode_tail( nodeToRemove );
                }
            }
        }

        //General Removal, middle, head or tail on a different list, ect.
        return Node.removeNode( nodeToRemove );


    }


    //Insert
    public Node insertNode_asHead( Node n ) {
        if ( n == null ) {
            return null;
        }

        if ( this.listHas_zeroNodes() ) {
            this.helper_emptyList_make_headAndTail_outOfThisNode( n );

            return this.head;
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
            this.helper_emptyList_make_headAndTail_outOfThisNode( n );

            return this.tail;
        }

        n = this.insertNode_afterThisNode( n, this.tail );

        this.tail = n;

        return n;
    }

    private void helper_emptyList_make_headAndTail_outOfThisNode( Node n ) {
        //BEFORE USING THIS;
        //-Must have checked the list is empty

        n = this.removeNode( n );
        n.next = null;
        n.previous = null;

        this.head = n;
        this.head.next = null;
        this.head.previous = null;

        this.tail = n;
        this.tail.next = null;
        this.tail.previous = null;
    }

    public Node insertNode_beforeThisNode( Node inserted, Node beforeThis ) {
        try {
            if ( beforeThis.equals( this.getHead() ) ) {
                this.head = inserted;
            }
        } catch ( Exception ignored ) {
        }

        return Node.insertNode_beforeThisNode( inserted, beforeThis );

    }

    public Node insertNode_afterThisNode( Node inserted, Node afterThis ) {
        try {
            if ( afterThis.equals( this.getTail() ) ) {
                this.tail = inserted;
            }
        } catch ( Exception ignored ) {
        }

        return Node.insertNode_afterThisNode( inserted, afterThis );

    }


    //Boooooooooooooooooooooooooooooooo
    public boolean listHas_oneNode() {
        if ( this.listHas_zeroNodes() ) {
            return false;
        }
        if ( this.head.equals( this.tail ) ) {
            return true;
        }
        return false;
    }

    public boolean listHas_zeroNodes() {
        //Update heads and Tails
        this.getHead();
        this.getTail();

        if ( this.head == null && this.tail == null ) {
            return true;
        }
        return false;
    }

    public static boolean nodesHave_sameNetwork( Node node1, Node node2 ) {

        try {
            boolean resTemp = Node.findHead( node1 ).equals( Node.findHead( node2 ) );
            if ( !resTemp ) {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }

        try {
            boolean resTemp = Node.findTail( node1 ).equals( Node.findTail( node2 ) );
            if ( !resTemp ) {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }

        return true;
    }


} //Class
