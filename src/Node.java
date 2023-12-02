import java.util.Arrays;
import java.util.Objects;

public class Node {
    //Code
    public static final String stringBuilderDivider = "\ngq37489Q02hfFwkUethg\n"; //Our code, hopefully, no data strings contain it, otherwise we need to improve it.
    protected Node next = null;
    protected Node previous = null;

    protected String data = null;

    public Node( String data ) {
        this.data = data;
    }

    public Node( Node node ) {
        if ( node != null ) {
            this.data = node.getData();
        }
    }

    //Getters
    public Node getNext() {
        return this.next;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public String getData() {
        return this.data;
    }

    //Extra getters
    public Node getTowardsHead() { //The same as get previous, but the name makes it obvious what it also is, (The pseudo-head)
        return this.previous;
    }

    public Node getTowardsTail() { //The same as get next, but the name makes it obvious what it also is, (The pseudo-tail)
        return this.next;
    }

    //Network Size
    public int networkSize(){
        return Node.networkSize(this);
    }

    public static int networkSize(Node n){
        String[] strings = strings_toFromHead( n );
        if ( strings == null ) {
            return -1;
        }
        return strings.length;
    }


    //Print towardsFromComplete
    public String print_toFromHead() {
        String res = Arrays.toString( strings_toFromHead( this, new StringBuilder() ) );
        System.out.println( res );
        return res;
    }

    public String print_toFromTail() {
        String res = Arrays.toString( strings_toFromTail( this, new StringBuilder() ) );
        System.out.println( res );
        return res;
    }

    //Print towardsFromComplete - Static
    public static String print_toFromHead( Node n ) {
        if ( n == null ) {
            return null;
        }
        String res = Arrays.toString( strings_toFromHead( n, new StringBuilder() ) );
        System.out.println( res );
        return res;
    }

    public static String print_toFromTail( Node n ) {
        if ( n == null ) {
            return null;
        }
        String res = Arrays.toString( strings_toFromTail( n, new StringBuilder() ) );
        System.out.println( res );
        return res;
    }


    //String[] - toFromComplete - Simple Standalone
    public String[] strings_toFromHead() {
        return sbToStrings( sb_toFromHead( this, new StringBuilder() ) );
    }

    public String[] strings_toFromTail() {
        return sbToStrings( sb_toFromTail( this, new StringBuilder() ) );

    }


    //String[] - toFromComplete
    public String[] strings_toFromHead( StringBuilder stringBuilder ) {
        return sbToStrings( sb_toFromHead( this, stringBuilder ) );
    }

    public String[] strings_toFromTail( StringBuilder stringBuilder ) {
        return sbToStrings( sb_toFromTail( this, stringBuilder ) );

    }

    //String[] - toFromComplete - Static - Simple Standalone
    public static String[] strings_toFromHead( Node n ) {
        return sbToStrings( sb_toFromHead( n, new StringBuilder() ) );
    }

    public static String[] strings_toFromTail( Node n ) {
        return sbToStrings( sb_toFromTail( n, new StringBuilder() ) );
    }

    //String[] - toFromComplete - Static

    public static String[] strings_toFromHead( Node n, StringBuilder stringBuilder ) {
        return sbToStrings( sb_toFromHead( n, stringBuilder ) );
    }

    public static String[] strings_toFromTail( Node n, StringBuilder stringBuilder ) {
        return sbToStrings( sb_toFromTail( n, stringBuilder ) );
    }

    //Helper-------------------------------------------------------------------------------------------------------
    public static String[] sbToStrings( StringBuilder stringBuilder ) {
        if ( stringBuilder == null ) {
            return null;
        }
        if ( stringBuilder.isEmpty() ) {
            return new String[0];
        }
        return stringBuilder.toString().split( stringBuilderDivider );
    }

    public static StringBuilder stringsToSb( String[] strings ) {
        if ( strings == null ) {
            return null;
        }
        return new StringBuilder( String.join( stringBuilderDivider, strings ) );
    }


    //Stringbuilder  - toFromComplete - Simple Standalone
    public StringBuilder sb_toFromHead() {
        return sb_toFromHead( this, new StringBuilder() );
    }

    public StringBuilder sb_toFromTail() {
        return sb_toFromTail( this, new StringBuilder() );
    }

    //Stringbuilder  - toFromComplete
    public StringBuilder sb_toFromHead( StringBuilder stringBuilder ) {
        return sb_toFromHead( this, stringBuilder );
    }

    public StringBuilder sb_toFromTail( StringBuilder stringBuilder ) {
        return sb_toFromTail( this, stringBuilder );
    }

    //Stringbuilder  - toFromComplete - Static - Simple Standalone
    public static StringBuilder sb_toFromHead( Node n ) {
        return sb_toFromHead( n, new StringBuilder() );
    }

    public static StringBuilder sb_toFromTail( Node n ) {
        return sb_toFromTail( n, new StringBuilder() );
    }


    //Stringbuilder - from - Simple Standalone
    public StringBuilder sb_toHead_reverse() {
        return sb_toHead_reverse( this, new StringBuilder() );
    }

    public StringBuilder sb_toTail_reverse() {
        return sb_toTail_reverse( this, new StringBuilder() );
    }

    //towards
    public StringBuilder sb_toHead() {
        return sb_toHead_reverse( this, new StringBuilder() );
    }

    public StringBuilder sb_toTail() {
        return sb_toTail_reverse( this, new StringBuilder() );
    }

    //Stringbuilder - from
    public StringBuilder sb_toHead_reverse( StringBuilder stringBuilder ) {
        return sb_toHead_reverse( this, stringBuilder );
    }

    public StringBuilder sb_toTail_reverse( StringBuilder stringBuilder ) {
        return sb_toTail_reverse( this, stringBuilder );
    }

    //towards
    public StringBuilder sb_toHead( StringBuilder stringBuilder ) {
        return sb_toHead_reverse( this, stringBuilder );
    }

    public StringBuilder sb_toTail( StringBuilder stringBuilder ) {
        return sb_toTail_reverse( this, stringBuilder );
    }


    //Stringbuilder - from - Static - Simple Standalone
    public static StringBuilder sb_toHead_reverse( Node n ) {
        return sb_toHead_reverse( n, new StringBuilder() );
    }

    public static StringBuilder sb_toTail_reverse( Node n ) {
        return sb_toTail_reverse( n, new StringBuilder() );
    }

    //towards
    public static StringBuilder sb_toHead( Node n ) {
        return sb_toHead( n, new StringBuilder() );
    }

    public static StringBuilder sb_toTail( Node n ) {
        return sb_toTail( n, new StringBuilder() );
    }


    //Stringbuilder - toFromComplete - Static
    public static StringBuilder sb_toFromHead( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        sb_toHead_reverse( n, stringBuilder );

        //We need to remove node n, since it will be added again
        //We know node n is the last "something" + divider password
//            stringBuilder.delete( stringBuilder.length() - stringBuilderDivider.length() - 1, stringBuilder.length() );
//            int lastIndex = stringBuilder.lastIndexOf( stringBuilderDivider );
//            stringBuilder.delete( lastIndex + 1, stringBuilder.length() );

        if ( n.next != null ) {
            if ( n.next.previous != n ) {
                n.next = null;
            } else {
                sb_toTail( n.getNext(), stringBuilder );
            }
        }
        return stringBuilder;
    }

    public static StringBuilder sb_toFromTail( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }


        sb_toTail_reverse( n, stringBuilder );

        //We need to remove node n, since it will be added again
        //We know node n is the last "something" + divider password
//            stringBuilder.delete( stringBuilder.length() - stringBuilderDivider.length() - 1, stringBuilder.length() );
//            int lastIndex = stringBuilder.lastIndexOf( stringBuilderDivider );
//            stringBuilder.delete( lastIndex + 1, stringBuilder.length() );


        if ( n.previous != null ) {
            if ( n.previous.next != n ) {
                n.previous = null;
            } else {
                sb_toHead( n.getPrevious(), stringBuilder );
            }
        }

        return stringBuilder;

    }


    //Stringbuilder - from  - Static
    public static StringBuilder sb_toHead_reverse( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder( stringBuilder );

        Node node = n;

        while ( node != null ) {
            if ( node.getData() != null ) {
                stringBuilder.insert( 0, stringBuilderDivider );
                stringBuilder.insert( 0, node.getData() ); //Code to divide by
            }

            Node lastNode = node;
            node = node.previous;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.next != lastNode ) {
                    lastNode.previous = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toHead_reverse( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.previous.next = null;
                    n.previous = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toHead_reverse( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }
        return stringBuilder;
    }

    public static StringBuilder sb_toTail_reverse( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder( stringBuilder );

        Node node = n;

        while ( node != null ) {
            if ( node.getData() != null ) {
                stringBuilder.insert( 0, stringBuilderDivider );
                stringBuilder.insert( 0, node.getData() ); //Code to divide by
            }

            Node lastNode = node;
            node = node.next;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.previous != lastNode ) {
                    lastNode.next = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toTail_reverse( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    lastNode.next.previous = null;
                    lastNode.next = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toTail_reverse( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }

        return stringBuilder;
    }

    //towards
    public static StringBuilder sb_toHead( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder( stringBuilder );

        Node node = n;

        while ( node != null ) {
            if ( node.getData() != null ) {
                stringBuilder.append( node.getData() ).append( stringBuilderDivider ); //Code to divide by
            }
            Node lastNode = node;
            node = node.previous;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.next != lastNode ) {
                    lastNode.previous = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toHead( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.previous.next = null;
                    n.previous = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toHead( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }
        return stringBuilder;
    }

    public static StringBuilder sb_toTail( Node n, StringBuilder stringBuilder ) {
        if ( n == null || stringBuilder == null ) {
            return stringBuilder;
        }

        StringBuilder stringBuilder1 = new StringBuilder( stringBuilder );

        Node node = n;

        while ( node != null ) {
            if ( node.getData() != null ) {
                stringBuilder.append( node.getData() ).append( stringBuilderDivider ); //Code to divide by
            }

            Node lastNode = node;
            node = node.next;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.previous != lastNode ) {
                    lastNode.next = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toTail( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    lastNode.next.previous = null;
                    lastNode.next = null;
                    stringBuilder.replace( 0, stringBuilder.length(), String.valueOf( sb_toTail( n, stringBuilder1 ) ) );
                    return stringBuilder;
                }
            }
        }

        return stringBuilder;
    }


    //Hybrids!-------------------------------------------------------------

    //FindAndReplace - This Node - Same Network - toFrom - String
    public Node findAndReplace_toFromHead_newNode( String dataReplaceWith ) {
        return findAndReplace_toFromHead_newNode( this, dataReplaceWith, this.getData() );
    }

    public Node findAndReplace_toFromTail_newNode( String dataReplaceWith ) {
        return findAndReplace_toFromTail_newNode( this, dataReplaceWith, this.getData() );
    }


    //FindAndReplace - Same Network - toFrom - String
    public Node findAndReplace_toFromHead_newNode( String dataReplaceWith, String dataReplaced ) {
        return findAndReplace_toFromHead_newNode( this, dataReplaceWith, dataReplaced );
    }

    public Node findAndReplace_toFromTail_newNode( String dataReplaceWith, String dataReplaced ) {
        return findAndReplace_toFromTail_newNode( this, dataReplaceWith, dataReplaced );
    }


    //FindAndReplace - Static - toFrom - String
    public static Node findAndReplace_toFromHead_newNode( Node nReplacedNetwork, String dataReplaceWith, String dataReplaced ) {

        Node nReplaced = find_toFromHead( nReplacedNetwork, dataReplaced );
        if ( nReplaced == null ) {
            return null;
        }

        return replace( nReplaced, new Node( dataReplaceWith ) );
    }

    public static Node findAndReplace_toFromTail_newNode( Node nReplacedNetwork, String dataReplaceWith, String dataReplaced ) {

        Node nReplaced = find_toFromTail( nReplacedNetwork, dataReplaced );
        if ( nReplaced == null ) {
            return null;
        }

        return replace( nReplaced, new Node( dataReplaceWith ) );
    }

    //FindAndReplace - This Node - Same Network - toFrom
    public Node findAndReplace_toFromHead( String dataReplaceWith ) {
        return findAndReplace_toFromHead( this, this, dataReplaceWith, this.getData() );
    }

    public Node findAndReplace_toFromTail( String dataReplaceWith ) {
        return findAndReplace_toFromTail( this, this, dataReplaceWith, this.getData() );
    }

    //FindAndReplace - This Node - Other Network - toFrom
    public Node findAndReplace_toFromHead( Node nReplaceWithNetwork, String dataReplaceWith ) {
        return findAndReplace_toFromHead( nReplaceWithNetwork, this, dataReplaceWith, this.getData() );
    }

    public Node findAndReplace_toFromTail( Node nReplaceWithNetwork, String dataReplaceWith ) {
        return findAndReplace_toFromTail( nReplaceWithNetwork, this, dataReplaceWith, this.getData() );
    }

    //FindAndReplace - Same Network - toFrom
    public Node findAndReplace_toFromHead( String dataReplaceWith, String dataReplaced ) {
        return findAndReplace_toFromHead( this, this, dataReplaceWith, dataReplaced );
    }

    public Node findAndReplace_toFromTail( String dataReplaceWith, String dataReplaced ) {
        return findAndReplace_toFromTail( this, this, dataReplaceWith, dataReplaced );
    }

    //FindAndReplace - Different Network - toFrom
    public Node findAndReplace_toFromHead( Node nReplaceWithNetwork, String dataReplaceWith, String dataReplaced ) {
        return findAndReplace_toFromHead( nReplaceWithNetwork, this, dataReplaceWith, dataReplaced );
    }

    public Node findAndReplace_toFromTail( Node nReplaceWithNetwork, String dataReplaceWith, String dataReplaced ) {
        return findAndReplace_toFromTail( nReplaceWithNetwork, this, dataReplaceWith, dataReplaced );
    }


    //FindAndReplace - Static - toFrom
    public static Node findAndReplace_toFromHead( Node nReplaceWithNetwork, Node nReplacedNetwork, String dataReplaceWith, String dataReplaced ) {

        Node nReplaced = find_toFromHead( nReplacedNetwork, dataReplaced );
        if ( nReplaced == null ) {
            return null;
        }

        Node nReplaceWith = find_toFromHead( nReplaceWithNetwork, dataReplaceWith );
        if ( nReplaceWith == null ) {
            return null;
        }

        return replace( nReplaced, nReplaceWith );
    }

    public static Node findAndReplace_toFromTail( Node nReplaceWithNetwork, Node nReplacedNetwork, String dataReplaceWith, String dataReplaced ) {

        Node nReplaced = find_toFromTail( nReplacedNetwork, dataReplaced );
        if ( nReplaced == null ) {
            return null;
        }

        Node nReplaceWith = find_toFromTail( nReplaceWithNetwork, dataReplaceWith );
        if ( nReplaceWith == null ) {
            return null;
        }

        return replace( nReplaced, nReplaceWith );
    }

    //Replace - toFrom
    public Node replace( String sReplaceWith ) {
        return replace( this, sReplaceWith );
    }

    //Replace - Static - toFrom

    public static Node replace( Node nReplaced, String sReplaceWith ) {
        return replace( nReplaced, new Node( sReplaceWith ) );
    }

    //Replace - toFrom
    public Node replace( Node nReplaceWith ) {
        return replace( this, nReplaceWith );
    }

    //Replace - Static - toFrom
    public static Node replace( Node nReplaced, Node nReplaceWith ) {
        if ( nReplaced.equals( nReplaceWith ) ) {
            return null;
        }

        if ( insertBefore( nReplaceWith, nReplaced ) == null ) {
            return null;
        }

        if ( remove( nReplaced ) == null ) {
            return null;
        }

        return nReplaceWith;
    }


    //findAndInsert - New Node - Same Network - toFrom - String
    public Node findAndInsertAfter_toFromHead_newNode( String dataInserted ) {
        return findAndInsertAfter_toFromHead_newNode( this, dataInserted, this.getData() );
    }

    public Node findAndInsertAfter_toFromTail_newNode( String dataInserted ) {
        return findAndInsertAfter_toFromTail_newNode( this, dataInserted, this.getData() );
    }

    public Node findAndInsertBefore_toFromHead_newNode( String dataInserted ) {
        return findAndInsertBefore_toFromHead_newNode( this, dataInserted, this.getData() );
    }

    public Node findAndInsertBefore_toFromTail_newNode( String dataInserted ) {
        return findAndInsertBefore_toFromTail_newNode( this, dataInserted, this.getData() );
    }

    //FindAndInsert  - New Node - Same Network - toFrom - String
    public Node findAndInsertAfter_toFromHead_newNode( String dataInserted, String dataAfterThis ) {
        return findAndInsertAfter_toFromHead_newNode( this, dataInserted, dataAfterThis );
    }

    public Node findAndInsertAfter_toFromTail_newNode( String dataInserted, String dataAfterThis ) {
        return findAndInsertAfter_toFromTail_newNode( this, dataInserted, dataAfterThis );
    }

    public Node findAndInsertBefore_toFromHead_newNode( String dataInserted, String dataBeforeThis ) {
        return findAndInsertBefore_toFromHead_newNode( this, dataInserted, dataBeforeThis );
    }

    public Node findAndInsertBefore_toFromTail_newNode( String dataInserted, String dataBeforeThis ) {
        return findAndInsertBefore_toFromTail_newNode( this, dataInserted, dataBeforeThis );
    }

    //FindAndInsert  - New Node - Right Here - toFrom - String
    public Node findAndInsertAfter_toFromHead_newNode( Node nAfterThisNetwork, String dataInserted ) {
        if ( nAfterThisNetwork == null ) {
            return null;
        }
        return findAndInsertAfter_toFromHead_newNode( nAfterThisNetwork, dataInserted, nAfterThisNetwork.getData() );
    }

    public Node findAndInsertAfter_toFromTail_newNode( Node nAfterThisNetwork, String dataInserted ) {
        if ( nAfterThisNetwork == null ) {
            return null;
        }
        return findAndInsertAfter_toFromTail_newNode( nAfterThisNetwork, dataInserted, nAfterThisNetwork.getData() );
    }

    public Node findAndInsertBefore_toFromHead_newNode( Node nAfterThisNetwork, String dataInserted ) {
        if ( nAfterThisNetwork == null ) {
            return null;
        }
        return findAndInsertBefore_toFromHead_newNode( nAfterThisNetwork, dataInserted, nAfterThisNetwork.getData() );
    }

    public Node findAndInsertBefore_toFromTail_newNode( Node nAfterThisNetwork, String dataInserted ) {
        if ( nAfterThisNetwork == null ) {
            return null;
        }
        return findAndInsertBefore_toFromTail_newNode( nAfterThisNetwork, dataInserted, nAfterThisNetwork.getData() );
    }


    //FindAndInsert  - New Node - static - toFrom - String
    public static Node findAndInsertAfter_toFromHead_newNode( Node nAfterThisNetwork, String dataInserted, String dataAfterThis ) {
        if ( dataInserted.equals( dataAfterThis ) ) {
            return null;
        }

        Node nAfterThis = find_toFromHead( nAfterThisNetwork, dataAfterThis );
        if ( nAfterThis == null ) {
            return null;
        }

        return insertAfter( new Node( dataInserted ), nAfterThis );
    }

    public static Node findAndInsertBefore_toFromHead_newNode( Node nBeforeThisNetwork, String dataInserted, String dataBeforeThis ) {
        if ( dataInserted.equals( dataBeforeThis ) ) {
            return null;
        }

        Node nBeforeThis = find_toFromHead( nBeforeThisNetwork, dataBeforeThis );
        if ( nBeforeThis == null ) {
            return null;
        }

        return insertBefore( new Node( dataInserted ), nBeforeThis );
    }

    public static Node findAndInsertAfter_toFromTail_newNode( Node nAfterThisNetwork, String dataInserted, String dataAfterThis ) {
        if ( dataInserted.equals( dataAfterThis ) ) {
            return null;
        }

        Node nAfterThis = find_toFromTail( nAfterThisNetwork, dataAfterThis );
        if ( nAfterThis == null ) {
            return null;
        }

        return insertAfter( new Node( dataInserted ), nAfterThis );
    }

    public static Node findAndInsertBefore_toFromTail_newNode( Node nBeforeThisNetwork, String dataInserted, String dataBeforeThis ) {
        if ( dataInserted.equals( dataBeforeThis ) ) {
            return null;
        }

        Node nBeforeThis = find_toFromTail( nBeforeThisNetwork, dataBeforeThis );
        if ( nBeforeThis == null ) {
            return null;
        }

        return insertBefore( new Node( dataInserted ), nBeforeThis );
    }


    //findAndInsert - This Node - Same Network - toFrom
    public Node findAndInsertAfter_toFromHead( String dataInserted ) {
        return findAndInsertAfter_toFromHead( this, this, dataInserted, this.getData() );
    }

    public Node findAndInsertAfter_toFromTail( String dataInserted ) {
        return findAndInsertAfter_toFromTail( this, this, dataInserted, this.getData() );
    }

    public Node findAndInsertBefore_toFromHead( String dataInserted ) {
        return findAndInsertBefore_toFromHead( this, this, dataInserted, this.getData() );
    }

    public Node findAndInsertBefore_toFromTail( String dataInserted ) {
        return findAndInsertBefore_toFromTail( this, this, dataInserted, this.getData() );
    }

    //FindAndInsert - This Node - Other Network - toFrom
    public Node findAndInsertAfter_toFromHead( Node nInsertedOriginNetwork, String dataInserted ) {
        return findAndInsertAfter_toFromHead( nInsertedOriginNetwork, this, dataInserted, this.getData() );
    }

    public Node findAndInsertAfter_toFromTail( Node nInsertedOriginNetwork, String dataInserted ) {
        return findAndInsertAfter_toFromTail( nInsertedOriginNetwork, this, dataInserted, this.getData() );
    }

    public Node findAndInsertBefore_toFromHead( Node nInsertedOriginNetwork, String dataInserted ) {
        return findAndInsertBefore_toFromHead( nInsertedOriginNetwork, this, dataInserted, this.getData() );
    }

    public Node findAndInsertBefore_toFromTail( Node nInsertedOriginNetwork, String dataInserted ) {
        return findAndInsertBefore_toFromTail( nInsertedOriginNetwork, this, dataInserted, this.getData() );
    }

    //FindAndInsert - Same Network - toFrom
    public Node findAndInsertAfter_toFromHead( String dataInserted, String dataAfterThis ) {
        return findAndInsertAfter_toFromHead( this, this, dataInserted, dataAfterThis );
    }

    public Node findAndInsertAfter_toFromTail( String dataInserted, String dataAfterThis ) {
        return findAndInsertAfter_toFromTail( this, this, dataInserted, dataAfterThis );
    }

    public Node findAndInsertBefore_toFromHead( String dataInserted, String dataBeforeThis ) {
        return findAndInsertBefore_toFromHead( this, this, dataInserted, dataBeforeThis );
    }

    public Node findAndInsertBefore_toFromTail( String dataInserted, String dataBeforeThis ) {
        return findAndInsertBefore_toFromTail( this, this, dataInserted, dataBeforeThis );
    }

    //FindAndInsert - Different Network - toFrom
    public Node findAndInsertAfter_toFromHead( Node nInsertedOriginNetwork, String dataInserted, String dataAfterThis ) {
        return findAndInsertAfter_toFromHead( nInsertedOriginNetwork, this, dataInserted, dataAfterThis );
    }

    public Node findAndInsertAfter_toFromTail( Node nInsertedOriginNetwork, String dataInserted, String dataAfterThis ) {
        return findAndInsertAfter_toFromTail( nInsertedOriginNetwork, this, dataInserted, dataAfterThis );
    }

    public Node findAndInsertBefore_toFromHead( Node nInsertedOriginNetwork, String dataInserted, String dataBeforeThis ) {
        return findAndInsertBefore_toFromHead( nInsertedOriginNetwork, this, dataInserted, dataBeforeThis );
    }

    public Node findAndInsertBefore_toFromTail( Node nInsertedOriginNetwork, String dataInserted, String dataBeforeThis ) {
        return findAndInsertBefore_toFromTail( nInsertedOriginNetwork, this, dataInserted, dataBeforeThis );
    }


    //FindAndInsert - static - toFrom
    public static Node findAndInsertAfter_toFromHead( Node nInsertedOriginNetwork, Node nAfterThisNetwork, String dataInserted, String dataAfterThis ) {
        if ( dataInserted.equals( dataAfterThis ) ) {
            return null;
        }

        Node nInserted = find_toFromHead( nInsertedOriginNetwork, dataInserted );
        if ( nInserted == null ) {
            return null;
        }

        Node nAfterThis = find_toFromHead( nAfterThisNetwork, dataAfterThis );
        if ( nAfterThis == null ) {
            return null;
        }

        return insertAfter( nInserted, nAfterThis );
    }

    public static Node findAndInsertBefore_toFromHead( Node nInsertedOriginNetwork, Node nBeforeThisNetwork, String dataInserted, String dataBeforeThis ) {
        if ( dataInserted.equals( dataBeforeThis ) ) {
            return null;
        }

        Node nInserted = find_toFromHead( nInsertedOriginNetwork, dataInserted );
        if ( nInserted == null ) {
            return null;
        }

        Node nBeforeThis = find_toFromHead( nBeforeThisNetwork, dataBeforeThis );
        if ( nBeforeThis == null ) {
            return null;
        }

        return insertBefore( nInserted, nBeforeThis );
    }

    public static Node findAndInsertAfter_toFromTail( Node nInsertedOriginNetwork, Node nAfterThisNetwork, String dataInserted, String dataAfterThis ) {
        if ( dataInserted.equals( dataAfterThis ) ) {
            return null;
        }

        Node nInserted = find_toFromTail( nInsertedOriginNetwork, dataInserted );
        if ( nInserted == null ) {
            return null;
        }

        Node nAfterThis = find_toFromTail( nAfterThisNetwork, dataAfterThis );
        if ( nAfterThis == null ) {
            return null;
        }

        return insertAfter( nInserted, nAfterThis );
    }

    public static Node findAndInsertBefore_toFromTail( Node nInsertedOriginNetwork, Node nBeforeThisNetwork, String dataInserted, String dataBeforeThis ) {
        if ( dataInserted.equals( dataBeforeThis ) ) {
            return null;
        }

        Node nInserted = find_toFromTail( nInsertedOriginNetwork, dataInserted );
        if ( nInserted == null ) {
            return null;
        }

        Node nBeforeThis = find_toFromTail( nBeforeThisNetwork, dataBeforeThis );
        if ( nBeforeThis == null ) {
            return null;
        }

        return insertBefore( nInserted, nBeforeThis );
    }

    //FindAndRemove - toFrom
    public Node findAndRemove_toFromHead( String data ) {
        return findAndRemove_toFromHead( this, data );
    }

    public Node findAndRemove_toFromTail( String data ) {
        return findAndRemove_toFromTail( this, data );
    }

    //FindAndRemove - static - toFrom
    public static Node findAndRemove_toFromHead( Node n, String data ) {
        Node nodeToRemove = find_toFromHead( n, data );

        return remove( nodeToRemove );
    }

    public static Node findAndRemove_toFromTail( Node n, String data ) {
        Node nodeToRemove = find_toFromTail( n, data );

        return remove( nodeToRemove );
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
                    return findHead( n );
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
                    return findTail( lastNode );
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

    //Find - toFrom
    public Node find_toFromHead( String data ) {
        return find_toFromHead( this, data );
    }

    public Node find_toFromTail( String data ) {
        return find_toFromTail( this, data );
    }

    //Find - toFrom - Static
    public static Node find_toFromHead( Node n, String data ) {
        if ( n == null || data == null ) {
            return null;
        }

        Node node = n;

        Node res = find_toHead( node, data );
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
        return find_toTail( node, data );
    }

    public static Node find_toFromTail( Node n, String data ) {
        if ( n == null || data == null ) {
            return null;
        }

        Node node = n;

        Node res = find_toTail( node, data );
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
        return find_toHead( node, data );
    }

    //Helper - find - towards - Static
    protected static Node find_toHead( Node n, String data ) {
        //Check if data or node is null before using

        Node node = n;

        while ( node != null ) {
            if ( data == null && node.data == null ) {
                return node;
            }
            if ( node.data != null && node.data.equals( data ) ) {
                return node;
            }
            Node lastNode = node;
            node = node.previous;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.next != lastNode ) {
                    lastNode.previous = null;
                    return find_toHead( n, data );
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.previous.next = null;
                    n.previous = null;
                    return find_toHead( n, data );
                }
            }
        }
        return null;
    }

    protected static Node find_toTail( Node n, String data ) {
        //Check if data or node is null before using

        Node node = n;

        while ( node != null ) {
            if ( data == null && node.data == null ) {
                return node;
            }
            if ( node.data != null && node.data.equals( data ) ) {
                return node;
            }
            Node lastNode = node;
            node = node.next;

            if ( node != null ) {
                //If the last node isn't actually the last node, then we might have started a loop, fix it!
                if ( node.previous != lastNode ) {
                    lastNode.next = null;
                    return find_toTail( n, data );
                }

                //If we get the starter node again we have a closed loop
                if ( node == n ) {
                    n.next.previous = null;
                    n.next = null;
                    return find_toTail( n, data );
                }
            }
        }
        return null;
    }


    //Remove head/tail
    public Node removeHead() {
        return removeHead( this );
    }

    public Node removeTail() {
        return removeTail( this );
    }

    //Remove head/tail - Static
    public static Node removeHead( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        Node head = findHead( masterNode );

        return remove( head );
    }

    public static Node removeTail( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        Node tail = findTail( masterNode );

        return remove( tail );
    }


    //RemoveTowards
    public Node remove_towardsHead() {
        return remove_towardsHead( this );
    }

    public Node remove_towardsTail() {
        return remove_towardsTail( this );
    }

    //RemoveTowards - Static
    public static Node remove_towardsHead( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        if ( masterNode.previous == null ) {
            return null;
        }
        return remove( masterNode.previous );
    }

    public static Node remove_towardsTail( Node masterNode ) {
        if ( masterNode == null ) {
            return null;
        }

        if ( masterNode.next == null ) {
            return null;
        }
        return remove( masterNode.next );
    }


    //Remove
    public Node remove() {
        return remove( this );
    }

    //Remove - Static
    public static Node remove( Node nodeToRemove ) {
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

                return helper_remove_head( nodeToRemove );
            }
        }

        //Is a tail node
        //if ( nodeToRemove.previous != null ) { //Always true
        if ( nodeToRemove.next == null ) {

//                nodeToRemove.next = null;    //Already the case
            return helper_remove_tail( nodeToRemove );
        }
        //}

        //Is middle Node
        nodeToRemove.next.previous = nodeToRemove.previous;
        nodeToRemove.previous.next = nodeToRemove.next;

        nodeToRemove.next = null;
        nodeToRemove.previous = null;

        return nodeToRemove;
    }

    //Helpers
    protected static Node helper_remove_head( Node headToRemove ) {

        //Check if node is null before using this method.
        //Also check if it is actually a head/tail node with a next/previous
        headToRemove.next.previous = null;
        headToRemove.next = null;

//      nodeToRemove.previous = null;     //Already the case

        return headToRemove;
    }

    protected static Node helper_remove_tail( Node tailToRemove ) {

        //Check if node is null before using this method.
        //Also check if it is actually a head/tail node with a next/previous
        tailToRemove.previous.next = null;
        tailToRemove.previous = null;

//      tailToRemove.next = null;    //Already the case

        return tailToRemove;
    }

    public Node insert_towardsHead( String insertedString ) {
        return insertBefore( new Node( insertedString ), this );
    }

    public Node insert_towardsTail( String insertedString ) {
        return insertAfter( new Node( insertedString ), this );
    }

    //Insert
    public Node insert_towardsHead( Node inserted ) {
        return insertBefore( inserted, this );
    }

    public Node insert_towardsTail( Node inserted ) {
        return insertAfter( inserted, this );
    }

    //Insert beforeAfter - Static - String
    public static Node insertBefore( String insertedString, Node beforeThis ) {
        return insertBefore( new Node( insertedString ), beforeThis );
    }

    public static Node insertAfter( String insertedString, Node afterThis ) {
        return insertAfter( new Node( insertedString ), afterThis );
    }

    //Insert beforeAfter - Static
    public static Node insertBefore( Node inserted, Node beforeThis ) {
        if ( beforeThis == null || inserted == null ) {
            return null;
        }

        if ( inserted.equals( beforeThis ) ) {
            return inserted;
        }

        inserted = remove( inserted );

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

    public static Node insertAfter( Node inserted, Node afterThis ) {
        if ( afterThis == null || inserted == null ) {
            return null;
        }

        if ( inserted.equals( afterThis ) ) {
            return inserted;
        }

        inserted = remove( inserted );

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

    //Network from Strings Array----------------------------------------------------------------------------
    public static Node stringsToNetwork( String[] strings ) {
        if ( strings == null ) {
            return null;
        }

        if ( strings[ 0 ] != null && strings.length == 1 ) {
            return new Node( strings[ 0 ] );
        }

        if ( strings.length == 1 ) {
            return null;
        }

        Node newNetworkHead = null;
        int afterNewHeadIndex = 0;

        for ( int i = 0; i < strings.length; i++ ) {
            if ( strings[ i ] != null ) {
                newNetworkHead = new Node( strings[ i ] );
                afterNewHeadIndex = i + 1;
                if ( afterNewHeadIndex == strings.length ) {
                    return newNetworkHead;
                }
                break;
            }
        }
        if ( newNetworkHead == null ) {
            return null;
        }

        Node temp = newNetworkHead;

        for ( int i = afterNewHeadIndex; i < strings.length; i++ ) {
            if ( strings[ i ] != null ) {
                temp = Node.insertAfter( strings[ i ], temp );
            }
        }

        return newNetworkHead;
    }

    //Boolean Checks----------------------------------------------------------------------------
    public static boolean haveSameNetwork( Node node1, Node node2 ) { //Nodes Have

        try {
            boolean resTemp = findHead( node1 ).equals( findHead( node2 ) );
            if ( resTemp == false ) {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }

        try {
            boolean resTemp = findTail( node1 ).equals( findTail( node2 ) );
            if ( resTemp == false ) {
                return false;
            }
        } catch ( Exception e ) {
            return false;
        }

        return true;
    }

} //Class
