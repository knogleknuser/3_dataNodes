public class NodeList {
    private Node tail = null;
    private Node head = null;

    public NodeList() {
    }

    public NodeList( Node someNode ) {
        this.setNodeNetwork_fromNode( someNode );
    }

    //Set NodeNetwork
    public boolean setNodeNetwork_fromHead() {
        return this.setNodeNetwork_fromNode( this.head );
    }

    public boolean setNodeNetwork_fromTail() {
        return this.setNodeNetwork_fromNode( this.tail );
    }

    public boolean setNodeNetwork_fromNode( Node someNode ) {
        if ( someNode == null ) {
            return false;
        }
        this.tail = Node.findTail( someNode );
        this.head = Node.findHead( someNode );
        return true;
    }


    //Getters
    public Node getAndCalcHead() {
        if ( this.head == null ) {
            if ( this.tail != null ) {
                this.head = Node.findHead( this.getAndCalcTail() );
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
            this.tail = Node.findTail( this.head ); //This part only runs if the tail isn't actually a tail, so we need to fix the tail too
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

    public Node getAndCalcTail() {
        if ( this.tail == null ) {
            if ( this.head != null ) {
                this.tail = Node.findTail( this.getAndCalcHead() );
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
            this.head = Node.findHead( this.tail );  //This part only runs if the head isn't actually a head, so we need to fix the head too
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
        Node.print_toFromHead( this.getAndCalcHead() );
    }

    public void print_fromTail() {
        Node.print_toFromTail( this.getAndCalcTail() );
    }

    //Strings - Simple Standalone
    public String[] strings_fromHead() {
        return Node.strings_toFromHead( this.getAndCalcHead(), new StringBuilder() );
    }

    public String[] strings_fromTail() {
        return Node.strings_toFromTail( this.getAndCalcTail(), new StringBuilder() );
    }

    //Strings
    public String[] strings_fromHead( StringBuilder stringBuilder ) {
        return Node.strings_toFromHead( this.getAndCalcHead(), stringBuilder );
    }

    public String[] strings_fromTail( StringBuilder stringBuilder ) {
        return Node.strings_toFromTail( this.getAndCalcTail(), stringBuilder );
    }

    //Stringbuilder - Simple Standalone
    public StringBuilder sb_fromHead() {
        return Node.sb_toFromHead( this.getAndCalcHead(), new StringBuilder() );
    }

    public StringBuilder sb_fromTail() {
        return Node.sb_toFromTail( this.getAndCalcTail(), new StringBuilder() );
    }

    //Stringbuilder
    public StringBuilder sb_fromHead( StringBuilder stringBuilder ) {
        return Node.sb_toFromHead( this.getAndCalcHead(), stringBuilder );
    }

    public StringBuilder sb_fromTail( StringBuilder stringBuilder ) {
        return Node.sb_toFromTail( this.getAndCalcTail(), stringBuilder );
    }


    //Find and Remove
    public Node findAndRemove_fromHead( String data ) {
        Node nodeToRemove = this.find_fromHead( data );
        return this.remove( nodeToRemove );
    }

    public Node findAndRemove_fromTail( String data ) {
        Node nodeToRemove = this.find_fromTail( data );
        return this.remove( nodeToRemove );
    }

    //Find
    public Node find_fromHead( String data ) {
        if ( this.getAndCalcHead() == null || data == null ) {
            return null;
        }
        return Node.find_toTail( this.head, data );
    }

    public Node find_fromTail( String data ) {
        if ( this.getAndCalcTail() == null || data == null ) {
            return null;
        }
        return Node.find_toHead( this.tail, data );
    }

    //Remove
    public Node removeHead() {
        return this.remove( this.getAndCalcHead() );
    }

    public Node removeTail() {
        return this.remove( this.getAndCalcTail() );
    }

    public Node remove( Node nodeToRemove ) {
        //Is Null
        if ( nodeToRemove == null ) {
            return null;
        }

        //Update Head and Tails
        this.getAndCalcHead();
        this.getAndCalcTail();

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
                    return Node.helper_remove_head( nodeToRemove );
                }
            }
        }

        //This list's tail node
        if ( this.tail != null ) {
            if ( this.tail.previous != null ) {
                if ( nodeToRemove.equals( this.tail ) ) {
                    this.tail = this.tail.previous;
                    return Node.helper_remove_tail( nodeToRemove );
                }
            }
        }

        //General Removal, middle, head or tail on a different list, ect.
        return nodeToRemove.remove();


    }


    //Insert
    public Node insertHead( Node n ) {
        if ( n == null ) {
            return null;
        }

        if ( this.hasZeroNodes() ) {
            this.helper_emptyList_make_headAndTail_outOfThisNode( n );

            return this.head;
        }

        n = this.insertBefore( n, this.head );

        this.head = n;

        return n;
    }

    public Node insertTail( Node n ) {
        if ( n == null ) {
            return null;
        }

        if ( this.hasZeroNodes() ) {
            this.helper_emptyList_make_headAndTail_outOfThisNode( n );

            return this.tail;
        }

        n = this.insertAfter( n, this.tail );

        this.tail = n;

        return n;
    }

    private void helper_emptyList_make_headAndTail_outOfThisNode( Node n ) {
        //BEFORE USING THIS;
        //-Must have checked the list is empty

        n = this.remove( n );
        n.next = null;
        n.previous = null;

        this.head = n;
        this.head.next = null;
        this.head.previous = null;

        this.tail = n;
        this.tail.next = null;
        this.tail.previous = null;
    }

    public Node insertBefore( Node inserted, Node beforeThis ) {
        try {
            if ( beforeThis.equals( this.getAndCalcHead() ) ) {
                this.head = inserted;
            }
        } catch ( Exception ignored ) {
        }

        return Node.insertBefore( inserted, beforeThis );

    }

    public Node insertAfter( Node inserted, Node afterThis ) {
        try {
            if ( afterThis.equals( this.getAndCalcTail() ) ) {
                this.tail = inserted;
            }
        } catch ( Exception ignored ) {
        }

        return Node.insertAfter( inserted, afterThis );

    }


    //Boooooooooooooooooooooooooooooooo
    public boolean hasOneNode() { //List Has
        if ( this.hasZeroNodes() ) {
            return false;
        }
        if ( this.head.equals( this.tail ) ) {
            return true;
        }
        return false;
    }

    public boolean hasZeroNodes() { //List Has
        //Update heads and Tails
        this.getAndCalcHead();
        this.getAndCalcTail();

        if ( this.head == null && this.tail == null ) {
            return true;
        }
        return false;
    }


} //Class
