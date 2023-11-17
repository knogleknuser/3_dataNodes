import java.util.Arrays;

public class Node {
    //Code
    public static final String stringBuilderDivider = "\ngq37489Q02hfFwkUethg\n";
    Node next = null;
    Node previous = null;

    String data;

    public Node( String data ) {
        this.data = data;
    }

    //Getters
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

    //Print towardsFromComplete
    public void print_towardsFromHead() {
        System.out.println( Arrays.toString( this.strings_towardsFromHead() ) );
    }

    public void print_towardsFromTail() {
        System.out.println( Arrays.toString( this.strings_towardsFromTail() ) );
    }

    //Print towardsFromComplete - Static
    public static void print_towardsFromHead( Node n ) {
        System.out.println( Arrays.toString( strings_towardsFromHead( n ) ) );
    }

    public static void print_towardsFromTail( Node n ) {
        System.out.println( Arrays.toString( strings_towardsFromTail( n ) ) );
    }

    //String[] - towardsFromComplete - Simple Standalone
    public String[] strings_towardsFromHead() {
        return stringBuilderToStrings( this.stringbuilder_fromHead() );
    }

    public String[] strings_towardsFromTail() {
        return stringBuilderToStrings( this.stringbuilder_fromTail() );

    }


    //String[] - towardsFromComplete
    public String[] strings_towardsFromHead( StringBuilder stringBuilder ) {
        return stringBuilderToStrings( this.stringbuilder_fromHead( stringBuilder ) );
    }

    public String[] strings_towardsFromTail( StringBuilder stringBuilder ) {
        return stringBuilderToStrings( this.stringbuilder_fromTail( stringBuilder ) );

    }

    //String[] - towardsFromComplete - Static - Simple Standalone
    public static String[] strings_towardsFromHead( Node n ) {
        return stringBuilderToStrings( stringbuilder_fromHead( n ) );
    }

    public static String[] strings_towardsFromTail( Node n ) {
        return stringBuilderToStrings( stringbuilder_fromTail( n ) );
    }

    //String[] - towardsFromComplete - Static

    public static String[] strings_towardsFromHead( Node n, StringBuilder stringBuilder ) {
        return stringBuilderToStrings( stringbuilder_fromHead( n, stringBuilder ) );
    }

    public static String[] strings_towardsFromTail( Node n, StringBuilder stringBuilder ) {
        return stringBuilderToStrings( stringbuilder_fromTail( n, stringBuilder ) );
    }

    //Helper-------------------------------------------------------------------------------------------------------
    public static String[] stringBuilderToStrings( StringBuilder stringBuilder ) {
        return stringBuilder.toString().split( stringBuilderDivider );
    }

    public static StringBuilder stringsToStringBuilder( String[] strings ) {
        return new StringBuilder( String.join( stringBuilderDivider, strings ) );
    }

    //Stringbuilder  - towardsFromComplete - Simple Standalone
    public StringBuilder stringbuilder_fromHead() {
        return stringbuilder_fromHead( this );
    }

    public StringBuilder stringbuilder_fromTail() {
        return stringbuilder_fromTail( this );
    }

    //Stringbuilder  - towardsFromComplete
    public StringBuilder stringbuilder_fromHead( StringBuilder stringBuilder ) {
        return stringbuilder_fromHead( this, stringBuilder );
    }

    public StringBuilder stringbuilder_fromTail( StringBuilder stringBuilder ) {
        return stringbuilder_fromTail( this, stringBuilder );
    }

    //Stringbuilder  - towardsFromComplete - Static - Simple Standalone
    public static StringBuilder stringbuilder_fromHead( Node n ) {
        return stringbuilder_fromHead( n, new StringBuilder() );
    }

    public static StringBuilder stringbuilder_fromTail( Node n ) {
        return stringbuilder_fromTail( n, new StringBuilder() );
    }

    //Stringbuilder - towardsFromComplete - Static
    public static StringBuilder stringbuilder_fromHead( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        stringbuilder_towardsReverseHead( n, stringBuilder );

        //We need to remove node n, since it will be added again
        //We know node n is the last "something" + divider password
//            stringBuilder.delete( stringBuilder.length() - stringBuilderDivider.length() - 1, stringBuilder.length() );
//            int lastIndex = stringBuilder.lastIndexOf( stringBuilderDivider );
//            stringBuilder.delete( lastIndex + 1, stringBuilder.length() );

        if ( n.next != null ) {
            if ( n.next.previous != n  ) {
                n.next = null;
            } else {
                stringbuilder_towardsTail( n.getNext(), stringBuilder );
            }
        }
        return stringBuilder;
    }

    public static StringBuilder stringbuilder_fromTail( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }




        stringbuilder_towardsReverseTail( n, stringBuilder );

        //We need to remove node n, since it will be added again
        //We know node n is the last "something" + divider password
//            stringBuilder.delete( stringBuilder.length() - stringBuilderDivider.length() - 1, stringBuilder.length() );
//            int lastIndex = stringBuilder.lastIndexOf( stringBuilderDivider );
//            stringBuilder.delete( lastIndex + 1, stringBuilder.length() );


        if ( n.previous != null ) {
            if ( n.previous.next != n  ) {
                n.previous = null;
            } else {
                stringbuilder_towardsHead( n.getPrevious(), stringBuilder );
            }
        }

        return stringBuilder;

    }


    //Stringbuilder - from - Simple Standalone
    public StringBuilder stringbuilder_towardsReverseHead() {
        return stringbuilder_towardsReverseHead( this );
    }

    public StringBuilder stringbuilder_towardsReverseTail() {
        return stringbuilder_towardsReverseTail( this );
    }

    //towards
    public StringBuilder stringbuilder_towardsHead() {
        return stringbuilder_towardsReverseHead( this );
    }

    public StringBuilder stringbuilder_towardsTail() {
        return stringbuilder_towardsReverseTail( this );
    }

    //Stringbuilder - from
    public StringBuilder stringbuilder_towardsReverseHead( StringBuilder stringBuilder ) {
        return stringbuilder_towardsReverseHead( this, stringBuilder );
    }

    public StringBuilder stringbuilder_towardsReverseTail( StringBuilder stringBuilder ) {
        return stringbuilder_towardsReverseTail( this, stringBuilder );
    }

    //towards
    public StringBuilder stringbuilder_towardsHead( StringBuilder stringBuilder ) {
        return stringbuilder_towardsReverseHead( this, stringBuilder );
    }

    public StringBuilder stringbuilder_towardsTail( StringBuilder stringBuilder ) {
        return stringbuilder_towardsReverseTail( this, stringBuilder );
    }


    //Stringbuilder - from - Static - Simple Standalone
    public static StringBuilder stringbuilder_towardsReverseHead( Node n ) {
        return stringbuilder_towardsReverseHead( n, new StringBuilder() );
    }

    public static StringBuilder stringbuilder_towardsReverseTail( Node n ) {
        return stringbuilder_towardsReverseTail( n, new StringBuilder() );
    }

    //towards
    public static StringBuilder stringbuilder_towardsHead( Node n ) {
        return stringbuilder_towardsHead( n, new StringBuilder() );
    }

    public static StringBuilder stringbuilder_towardsTail( Node n ) {
        return stringbuilder_towardsTail( n, new StringBuilder() );
    }

    //Stringbuilder - from  - Static
    public static StringBuilder stringbuilder_towardsReverseHead( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);

        Node node = n;

        while ( node != null ) {
            stringBuilder.insert( 0, stringBuilderDivider );
            stringBuilder.insert( 0, node.getData() ); //Code to divide by

            Node lastNode = node;
            node = node.previous;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.next != lastNode ) {
                    lastNode.previous = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsReverseHead( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.previous.next = null;
                    n.previous = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsReverseHead( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }
        return stringBuilder;
    }

    public static StringBuilder stringbuilder_towardsReverseTail( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);

        Node node = n;

        while ( node != null ) {
            stringBuilder.insert( 0, stringBuilderDivider );
            stringBuilder.insert( 0, node.getData() ); //Code to divide by

            Node lastNode = node;
            node = node.next;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.previous != lastNode ) {
                    lastNode.next = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsReverseTail( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    lastNode.next.previous = null;
                    lastNode.next = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsReverseTail( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }

        return stringBuilder;
    }

    //towards
    public static StringBuilder stringbuilder_towardsHead( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);

        Node node = n;

        while ( node != null ) {
            stringBuilder.append( node.getData() ).append( stringBuilderDivider ); //Code to divide by

            Node lastNode = node;
            node = node.previous;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.next != lastNode ) {
                    lastNode.previous = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsHead( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.previous.next = null;
                    n.previous = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsHead( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }
        return stringBuilder;
    }

    public static StringBuilder stringbuilder_towardsTail( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);

        Node node = n;

        while ( node != null ) {
            stringBuilder.append( node.getData() ).append( stringBuilderDivider ); //Code to divide by

            Node lastNode = node;
            node = node.next;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.previous != lastNode ) {
                    lastNode.next = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsTail( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    lastNode.next.previous = null;
                    lastNode.next = null;
                    stringBuilder.replace(0, stringBuilder.length(), String.valueOf( stringbuilder_towardsTail( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }

        return stringBuilder;
    }

    //Find
    public Node findHead() {
        return findHead( this );
    }

    public Node findTail() {
        return findTail( this );
    }

    //Find - Static
    public static Node findHead( Node n ) {
        if ( n == null ) {
            return null;
        }

        Node node = n;
        Node lastNode = n;


        while ( node != null ) {

            lastNode = node;
            node = node.previous;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.next != lastNode ) {
                    lastNode.previous = null;
                    return lastNode;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.previous.next = null;
                    n.previous = null;
                    return findHead( n );
                }
            }
        }


        return lastNode;
    }

    public static Node findTail( Node n ) {
        if ( n == null ) {
            return null;
        }

        Node node = n;
        Node lastNode = n;

        while ( node != null ) {

            lastNode = node;
            node = node.next;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.previous != lastNode ) {
                    lastNode.next = null;
                    return lastNode;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    lastNode.next.previous = null;
                    lastNode.next = null;
                    return findTail( lastNode );
                }
            }
        }


        return lastNode;
    }

    //Find - fromTowards
    public Node find_fromTowards_head( String data ) {
        return find_fromTowards_head( this, data );
    }

    public Node find_fromTowards_tail( String data ) {
        return find_fromTowards_tail( this, data );
    }

    //Find - fromTowards - Static
    public static Node find_fromTowards_head( Node n, String data ) {
        if ( n == null || data == null ) {
            return null;
        }

        Node node = n;

        Node res = find_towards_head( node, data );
        if ( res != null ) {
            return res;
        }

        //We don't wanna check n again
        node = node.next;

        //We don't wanna run a null
        if ( node == null ) {
            return null;
        }

        //If we don't find it here, it doesn't exist
        return find_towards_tail( node, data );
    }

    public static Node find_fromTowards_tail( Node n, String data ) {
        if ( n == null || data == null ) {
            return null;
        }

        Node node = n;

        Node res = find_towards_tail( node, data );
        if ( res != null ) {
            return res;
        }


        //We don't wanna check n again
        node = node.previous;

        //We don't wanna run a null
        if ( node == null ) {
            return null;
        }

        //If we don't find it here, it doesn't exist
        return find_towards_head( node, data );
    }

    //Helper - find - towards - Static
    private static Node find_towards_head( Node n, String data ) {
        //Check if data or node is null before using

        Node node = n;

        while ( node != null ) {
            if ( node.data.matches( data ) ) {
                return node;
            }
            Node lastNode = node;
            node = node.previous;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.next != lastNode ) {
                    lastNode.previous = null;
                    return find_fromTowards_head( n, data );
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.previous.next = null;
                    n.previous = null;
                    return find_towards_head( n, data );
                }
            }
        }
        return null;
    }

    //FindAndRemove - fromTowards
    public Node findAndRemove_fromTowards_head( String data ) {
        Node nodeToRemove = this.find_fromTowards_head( data );

        return removeNode( nodeToRemove );
    }

    public Node findAndRemove_fromTowards_tail( String data ) {
        Node nodeToRemove = this.find_fromTowards_tail( data );

        return removeNode( nodeToRemove );
    }

    //FindAndRemove - static - fromTowards
    public static Node findAndRemove_fromTowards_head( Node n, String data ) {
        Node nodeToRemove = find_fromTowards_head( n, data );

        return removeNode( nodeToRemove );
    }

    public static Node findAndRemove_fromTowards_tail( Node n, String data ) {
        Node nodeToRemove = find_fromTowards_tail( n, data );

        return removeNode( nodeToRemove );
    }

    private static Node find_towards_tail( Node n, String data ) {
        //Check if data or node is null before using

        Node node = n;

        while ( node != null ) {
            if ( node.data.matches( data ) ) {
                return node;
            }
            Node lastNode = node;
            node = node.next;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.previous != lastNode ) {
                    lastNode.next = null;
                    return find_towards_tail( n, data );
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.next.previous = null;
                    n.next = null;
                    return find_towards_tail( n, data );
                }
            }
        }
        return null;
    }

    //RemoveFrom
    public Node removeNode_fromHead() {
        return removeNode_towardsHead( this );
    }

    public Node removeNode_fromTail() {
        return removeNode_towardsTail( this );
    }

    //RemoveFrom - Static
    public static Node removeNode_fromHead( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        Node head = findHead( masterNode );

        return removeNode( head );
    }

    public static Node removeNode_fromTail( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        Node tail = findTail( masterNode );

        return removeNode( tail );
    }

    //RemoveTowards
    public Node removeNode_towardsHead() {
        return removeNode_towardsHead( this );
    }

    public Node removeNode_towardsTail() {
        return removeNode_towardsTail( this );
    }

    //RemoveTowards - Static
    public static Node removeNode_towardsHead( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        if ( masterNode.previous == null ) {
            return null;
        }
        return removeNode( masterNode.previous );
    }

    public static Node removeNode_towardsTail( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        if ( masterNode.next == null ) {
            return null;
        }
        return removeNode( masterNode.next );
    }

    //Remove
    public Node removeNode() {
        return removeNode( this );
    }

    //Remove - Static
    public static Node removeNode( Node nodeToRemove ) {
        //Is Null
        if ( nodeToRemove == null ) {
            return null;
        }

        //Is only node in list
        if ( nodeToRemove.next == null && nodeToRemove.previous == null ) {


            //-----------------------------------------------------------------BUT WHAT IF IT IS THE SINGLE NODE IN A DIFFERENT LIST???
//            nodeToRemove.next = null;
//            nodeToRemove.previous = null;

            return nodeToRemove;

        }

        //Is a head node
        if ( nodeToRemove.next != null ) {
            if ( nodeToRemove.previous == null ) {

//              nodeToRemove.previous = null;     //Already the case

                return helper_removeNode_head( nodeToRemove );
            }
        }

        //Is a tail node
        //if ( nodeToRemove.previous != null ) { //Always true
        if ( nodeToRemove.next == null ) {

//                nodeToRemove.next = null;    //Already the case
            return helper_removeNode_tail( nodeToRemove );
        }
        //}

        //Is middle Node
        nodeToRemove.next.previous = nodeToRemove.previous;
        nodeToRemove.previous.next = nodeToRemove.next;

        nodeToRemove.next = null;
        nodeToRemove.previous = null;

        return nodeToRemove;
    }

    protected static Node helper_removeNode_head( Node headToRemove ) {

        //Check if node is null before using this method.
        //Also check if it is actually a head/tail node with a next/previous
        headToRemove.next.previous = null;
        headToRemove.next = null;

//      nodeToRemove.previous = null;     //Already the case

        return headToRemove;
    }

    protected static Node helper_removeNode_tail( Node tailToRemove ) {

        //Check if node is null before using this method.
        //Also check if it is actually a head/tail node with a next/previous
        tailToRemove.previous.next = null;
        tailToRemove.previous = null;

//      tailToRemove.next = null;    //Already the case

        return tailToRemove;
    }

    //Insert
    public Node insertNode_towardsHead( Node inserted ) {
        return insertNode_beforeThisNode( inserted, this );
    }

    public Node insertNode_towardsTail( Node inserted ) {
        return insertNode_afterThisNode( inserted, this );
    }

    //Insert - Static
    public static Node insertNode_beforeThisNode( Node inserted, Node beforeThis ) {
        if ( beforeThis == null || inserted == null ) {
            return null;
        }

        if ( inserted.equals( beforeThis ) ) {
            return inserted;
        }

        inserted = removeNode( inserted );

        //Is inserted before the head node
        if ( beforeThis.previous == null ) {
            //beforeThis.previous.next  //Is Null             = inserted;
            inserted.previous = null;

            beforeThis.previous = inserted;
            inserted.next = beforeThis;

            return inserted;
        }

        //Normal Middle Insertion
        beforeThis.previous.next = inserted;
        inserted.previous = beforeThis.previous;

        beforeThis.previous = inserted;
        inserted.next = beforeThis;

        return inserted;
    }

    public static Node insertNode_afterThisNode( Node inserted, Node afterThis ) {
        if ( afterThis == null || inserted == null ) {
            return null;
        }

        if ( inserted.equals( afterThis ) ) {
            return inserted;
        }

        inserted = removeNode( inserted );

        //Is inserted after the tail node
        if ( afterThis.next == null ) {
            //afterThis.next.previous  //Is Null             = inserted;
            inserted.next = null;

            afterThis.next = inserted;
            inserted.previous = afterThis;

            return inserted;
        }

        //Normal Middle Insertion
        afterThis.next.previous = inserted;
        inserted.next = afterThis.next;

        afterThis.next = inserted;
        inserted.previous = afterThis;

        return inserted;
    }

} //Class
