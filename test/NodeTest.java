import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node node0 = new Node( "0" );
    Node node1 = new Node( "1" );
    Node node2 = new Node( "2" );
    Node node3 = new Node( "3" );
    Node node4 = new Node( "4" );

    @BeforeEach
    void setUp() {
        //Set up data structure
        this.node0.next = this.node1;
        this.node1.previous = this.node0;

        this.node1.next = this.node2;
        this.node2.previous = this.node1;

        this.node2.next = this.node3;
        this.node3.previous = this.node2;

        this.node3.next = this.node4;
        this.node4.previous = this.node3;


        //Extra, optional, only 1
        //Loop test
//        this.node0.previous = this.node2;
//        this.node4.next = this.node2;

        //Full Loop Test
//        this.node0.previous = this.node4;
//        this.node4.next = this.node0;
    }

    @Test
    void print_towardsFromHead() {
        this.node0.print_towardsFromHead();
        this.node1.print_towardsFromHead();
        this.node2.print_towardsFromHead();
        this.node3.print_towardsFromHead();
        this.node4.print_towardsFromHead();

        this.node0.print_towardsFromHead();
        this.node1.print_towardsFromHead();
        this.node2.print_towardsFromHead();
        this.node3.print_towardsFromHead();
        this.node4.print_towardsFromHead();
    }

    @Test
    void print_towardsFromTail() {
        this.node0.print_towardsFromTail();
        this.node1.print_towardsFromTail();
        this.node2.print_towardsFromTail();
        this.node3.print_towardsFromTail();
        this.node4.print_towardsFromTail();

        this.node0.print_towardsFromTail();
        this.node1.print_towardsFromTail();
        this.node2.print_towardsFromTail();
        this.node3.print_towardsFromTail();
        this.node4.print_towardsFromTail();
    }

    @Test
    void testPrint_towardsFromHead() {
        Node.print_towardsFromHead( this.node0 );
        Node.print_towardsFromHead( this.node1 );
        Node.print_towardsFromHead( this.node2 );
        Node.print_towardsFromHead( this.node3 );
        Node.print_towardsFromHead( this.node4 );

        Node.print_towardsFromHead( this.node0 );
        Node.print_towardsFromHead( this.node1 );
        Node.print_towardsFromHead( this.node2 );
        Node.print_towardsFromHead( this.node3 );
        Node.print_towardsFromHead( this.node4 );
    }

    @Test
    void testPrint_towardsFromTail() {
        Node.print_towardsFromTail( this.node0 );
        Node.print_towardsFromTail( this.node1 );
        Node.print_towardsFromTail( this.node2 );
        Node.print_towardsFromTail( this.node3 );
        Node.print_towardsFromTail( this.node4 );

        Node.print_towardsFromTail( this.node0 );
        Node.print_towardsFromTail( this.node1 );
        Node.print_towardsFromTail( this.node2 );
        Node.print_towardsFromTail( this.node3 );
        Node.print_towardsFromTail( this.node4 );
    }

    @Test
    void strings_towardsFromHead() {
        //Make the strings
        String[] node0s = this.node0.strings_toFromHead();
        String[] node1s = this.node1.strings_toFromHead();
        String[] node2s = this.node2.strings_toFromHead();
        String[] node3s = this.node3.strings_toFromHead();
        String[] node4s = this.node4.strings_toFromHead();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromHead( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = this.node0.strings_toFromHead();
        node1s = this.node1.strings_toFromHead();
        node2s = this.node2.strings_toFromHead();
        node3s = this.node3.strings_toFromHead();
        node4s = this.node4.strings_toFromHead();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromHead( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    @Test
    void strings_towardsFromTail() {
        //Make the strings
        String[] node0s = this.node0.strings_toFromTail();
        String[] node1s = this.node1.strings_toFromTail();
        String[] node2s = this.node2.strings_toFromTail();
        String[] node3s = this.node3.strings_toFromTail();
        String[] node4s = this.node4.strings_toFromTail();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromTail( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = this.node0.strings_toFromTail();
        node1s = this.node1.strings_toFromTail();
        node2s = this.node2.strings_toFromTail();
        node3s = this.node3.strings_toFromTail();
        node4s = this.node4.strings_toFromTail();

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], Node.strings_toFromTail( this.node2 )[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    @Test
    void testStrings_towardsFromHead() {
        //Make the strings
        String[] node0s = Node.strings_toFromHead( this.node0 );
        String[] node1s = Node.strings_toFromHead( this.node1 );
        String[] node2s = Node.strings_toFromHead( this.node2 );
        String[] node3s = Node.strings_toFromHead( this.node3 );
        String[] node4s = Node.strings_toFromHead( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromHead()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = Node.strings_toFromHead( this.node0 );
        node1s = Node.strings_toFromHead( this.node1 );
        node2s = Node.strings_toFromHead( this.node2 );
        node3s = Node.strings_toFromHead( this.node3 );
        node4s = Node.strings_toFromHead( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromHead()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    @Test
    void testStrings_towardsFromTail() {
        //Make the strings
        String[] node0s = Node.strings_toFromTail( this.node0 );
        String[] node1s = Node.strings_toFromTail( this.node1 );
        String[] node2s = Node.strings_toFromTail( this.node2 );
        String[] node3s = Node.strings_toFromTail( this.node3 );
        String[] node4s = Node.strings_toFromTail( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromTail()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }

        //Repeat
        //Make the strings
        node0s = Node.strings_toFromTail( this.node0 );
        node1s = Node.strings_toFromTail( this.node1 );
        node2s = Node.strings_toFromTail( this.node2 );
        node3s = Node.strings_toFromTail( this.node3 );
        node4s = Node.strings_toFromTail( this.node4 );

        //Same Size
        assertEquals( node0s.length, node1s.length );
        assertEquals( node1s.length, node2s.length );
        assertEquals( node2s.length, node3s.length );
        assertEquals( node3s.length, node4s.length );


        for ( int i = 0; i < node0s.length; i++ ) {
            assertEquals( node0s[ i ], node4s[ i ] );
        }

        for ( int i = 0; i < node1s.length; i++ ) {
            assertEquals( node1s[ i ], node3s[ i ] );
        }

        for ( int i = 0; i < node2s.length; i++ ) {
            assertEquals( node2s[ i ], this.node2.strings_toFromTail()[ i ] );
        }

        for ( int i = 0; i < node3s.length; i++ ) {
            assertEquals( node3s[ i ], node1s[ i ] );
        }

        for ( int i = 0; i < node4s.length; i++ ) {
            assertEquals( node4s[ i ], node0s[ i ] );
        }
    }

    //Fuck the stringbuilder test
    @Test
    void testStrings_towardsFromHead1() {
    }

    @Test
    void testStrings_towardsFromTail1() {
    }

    @Test
    void testStrings_towardsFromHead2() {
    }

    @Test
    void testStrings_towardsFromTail2() {
    }

    @Test
    void stringBuilderToStrings() {
    }

    @Test
    void stringsToStringBuilder() {
    }

    @Test
    void stringbuilder_towardsFromHead() {
    }

    @Test
    void stringbuilder_towardsFromTail() {
    }

    @Test
    void testStringbuilder_towardsFromHead() {
    }

    @Test
    void testStringbuilder_towardsFromTail() {
    }

    @Test
    void testStringbuilder_towardsFromHead1() {
    }

    @Test
    void testStringbuilder_towardsFromTail1() {
    }

    @Test
    void testStringbuilder_towardsFromHead2() {
    }

    @Test
    void testStringbuilder_towardsFromTail2() {
    }

    @Test
    void stringbuilder_towardsFromHeadToNode() {
    }

    @Test
    void stringbuilder_towardsFromTailToNode() {
    }

    @Test
    void stringbuilder_towardsHead() {
    }

    @Test
    void stringbuilder_towardsTail() {
    }

    @Test
    void testStringbuilder_towardsFromHeadToNode() {
    }

    @Test
    void testStringbuilder_towardsFromTailToNode() {
    }

    @Test
    void testStringbuilder_towardsHead() {
    }

    @Test
    void testStringbuilder_towardsTail() {
    }

    @Test
    void testStringbuilder_towardsFromHeadToNode1() {
    }

    @Test
    void testStringbuilder_towardsFromTailToNode1() {
    }

    @Test
    void testStringbuilder_towardsHead1() {
    }

    @Test
    void testStringbuilder_towardsTail1() {
    }

    @Test
    void testStringbuilder_towardsFromHeadToNode2() {
    }

    @Test
    void testStringbuilder_towardsFromTailToNode2() {
    }

    @Test
    void testStringbuilder_towardsHead2() {
    }

    @Test
    void testStringbuilder_towardsTail2() {
    }


    @Test
    void findHead() {
        assertEquals( this.node0, this.node0.findHead() );
        assertEquals( this.node0, this.node1.findHead() );
        assertEquals( this.node0, this.node2.findHead() );
        assertEquals( this.node0, this.node3.findHead() );
        assertEquals( this.node0, this.node4.findHead() );

        //Repeat
        assertEquals( this.node0, this.node0.findHead() );
        assertEquals( this.node0, this.node1.findHead() );
        assertEquals( this.node0, this.node2.findHead() );
        assertEquals( this.node0, this.node3.findHead() );
        assertEquals( this.node0, this.node4.findHead() );
    }

    @Test
    void findTail() {
        assertEquals( this.node4, this.node0.findTail() );
        assertEquals( this.node4, this.node1.findTail() );
        assertEquals( this.node4, this.node2.findTail() );
        assertEquals( this.node4, this.node3.findTail() );
        assertEquals( this.node4, this.node4.findTail() );

        //Repeat
        assertEquals( this.node4, this.node0.findTail() );
        assertEquals( this.node4, this.node1.findTail() );
        assertEquals( this.node4, this.node2.findTail() );
        assertEquals( this.node4, this.node3.findTail() );
        assertEquals( this.node4, this.node4.findTail() );
    }

    @Test
    void testFindHead() {
        assertEquals( this.node0, Node.findHead( this.node0 ) );
        assertEquals( this.node0, Node.findHead( this.node1 ) );
        assertEquals( this.node0, Node.findHead( this.node2 ) );
        assertEquals( this.node0, Node.findHead( this.node3 ) );
        assertEquals( this.node0, Node.findHead( this.node4 ) );

        //Repeat
        assertEquals( this.node0, Node.findHead( this.node0 ) );
        assertEquals( this.node0, Node.findHead( this.node1 ) );
        assertEquals( this.node0, Node.findHead( this.node2 ) );
        assertEquals( this.node0, Node.findHead( this.node3 ) );
        assertEquals( this.node0, Node.findHead( this.node4 ) );
    }

    @Test
    void testFindTail() {
        assertEquals( this.node4, Node.findTail( this.node0 ) );
        assertEquals( this.node4, Node.findTail( this.node1 ) );
        assertEquals( this.node4, Node.findTail( this.node2 ) );
        assertEquals( this.node4, Node.findTail( this.node3 ) );
        assertEquals( this.node4, Node.findTail( this.node4 ) );

        //Repeat
        assertEquals( this.node4, Node.findTail( this.node0 ) );
        assertEquals( this.node4, Node.findTail( this.node1 ) );
        assertEquals( this.node4, Node.findTail( this.node2 ) );
        assertEquals( this.node4, Node.findTail( this.node3 ) );
        assertEquals( this.node4, Node.findTail( this.node4 ) );
    }

    @Test
    void find_fromTowards_head() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromHead( String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromHead( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromHead( String.valueOf( i ) ).data );
        }
    }

    @Test
    void find_fromTowards_tail() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromTail( String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node0.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node1.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node2.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node3.find_toFromTail( String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.node4.find_toFromTail( String.valueOf( i ) ).data );
        }
    }

    @Test
    void testFind_fromTowards_head() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node4, String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromHead( this.node4, String.valueOf( i ) ).data );
        }
    }

    @Test
    void testFind_fromTowards_tail() {
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node4, String.valueOf( i ) ).data );
        }

        //Repeat
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node0, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node1, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node2, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node3, String.valueOf( i ) ).data );
        }
        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), Node.find_toFromTail( this.node4, String.valueOf( i ) ).data );
        }
    }

    @Test
    void findAndRemove_fromTowards_head() {
        assertNull( this.node0.findAndRemove_toFromHead( null ) );

        assertEquals( this.node1, this.node0.next );
        assertNull( this.node0.previous );

        assertNotNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertEquals( "0", this.node2.findAndRemove_toFromHead( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromHead( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromHead( "0" ).data );

        assertNull( this.node0.previous );
        assertNull( this.node0.next );

        assertNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertNull( this.node1.find_toFromHead( "0" ) );
        assertNull( this.node2.find_toFromHead( "0" ) );
        assertNull( this.node3.find_toFromHead( "0" ) );
        assertNull( this.node4.find_toFromHead( "0" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node0.find_toFromHead( String.valueOf( i + 1 ) ) );
        }

        //Repeat with Tail
        assertEquals( this.node3, this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNotNull( this.node3.next );

        assertEquals( "4", this.node1.findAndRemove_toFromHead( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromHead( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromHead( "4" ).data );

        assertNull( this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.find_toFromHead( "4" ) );
        assertNull( this.node1.find_toFromHead( "4" ) );
        assertNull( this.node2.find_toFromHead( "4" ) );
        assertNull( this.node3.find_toFromHead( "4" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node4.find_toFromHead( String.valueOf( i - 1 ) ) );
        }

        //Repeat with Middle
        assertEquals( this.node1, this.node2.previous );
        assertEquals( this.node3, this.node2.next );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertEquals( this.node2, this.node1.next );
        assertEquals( this.node2, this.node3.previous );

        assertEquals( "2", this.node3.findAndRemove_toFromHead( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromHead( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromHead( "2" ).data );

        assertNull( this.node2.previous );
        assertNull( this.node2.next );

        assertEquals( this.node3, this.node1.next );
        assertEquals( this.node1, this.node3.previous );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.find_toFromHead( "2" ) );
        assertNull( this.node1.find_toFromHead( "2" ) );

        assertNull( this.node3.find_toFromHead( "2" ) );
        assertNull( this.node4.find_toFromHead( "2" ) );

        assertNull( this.node2.find_toFromHead( String.valueOf( 0 ) ) );
        assertNull( this.node2.find_toFromHead( String.valueOf( 1 ) ) );
        assertNull( this.node2.find_toFromHead( String.valueOf( 3 ) ) );
        assertNull( this.node2.find_toFromHead( String.valueOf( 4 ) ) );
    }

    @Test
    void findAndRemove_fromTowards_tail() {
        assertNull( this.node0.findAndRemove_toFromTail( null ) );

        assertEquals( this.node1, this.node0.next );
        assertNull( this.node0.previous );

        assertNotNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertEquals( "0", this.node2.findAndRemove_toFromTail( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromTail( "0" ).data );
        assertEquals( "0", this.node0.findAndRemove_toFromTail( "0" ).data );

        assertNull( this.node0.previous );
        assertNull( this.node0.next );

        assertNull( this.node1.previous );
        assertNotNull( this.node1.next );

        assertNull( this.node1.findAndRemove_toFromTail( "0" ) );
        assertNull( this.node2.findAndRemove_toFromTail( "0" ) );
        assertNull( this.node3.findAndRemove_toFromTail( "0" ) );
        assertNull( this.node4.findAndRemove_toFromTail( "0" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node0.findAndRemove_toFromTail( String.valueOf( i + 1 ) ) );
        }

        //Repeat with Tail
        assertEquals( this.node3, this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNotNull( this.node3.next );

        assertEquals( "4", this.node1.findAndRemove_toFromTail( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromTail( "4" ).data );
        assertEquals( "4", this.node4.findAndRemove_toFromTail( "4" ).data );

        assertNull( this.node4.previous );
        assertNull( this.node4.next );

        assertNotNull( this.node3.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.findAndRemove_toFromTail( "4" ) );
        assertNull( this.node1.findAndRemove_toFromTail( "4" ) );
        assertNull( this.node2.findAndRemove_toFromTail( "4" ) );
        assertNull( this.node3.findAndRemove_toFromTail( "4" ) );

        for ( int i = 0; i < 5; i++ ) {
            assertNull( this.node4.findAndRemove_toFromTail( String.valueOf( i - 1 ) ) );
        }

        //Repeat with Middle
        assertEquals( this.node1, this.node2.previous );
        assertEquals( this.node3, this.node2.next );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertEquals( this.node2, this.node1.next );
        assertEquals( this.node2, this.node3.previous );

        assertEquals( "2", this.node3.findAndRemove_toFromTail( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromTail( "2" ).data );
        assertEquals( "2", this.node2.findAndRemove_toFromTail( "2" ).data );

        assertNull( this.node2.previous );
        assertNull( this.node2.next );

        assertEquals( this.node3, this.node1.next );
        assertEquals( this.node1, this.node3.previous );

        assertNull( this.node1.previous );
        assertNull( this.node3.next );

        assertNull( this.node0.findAndRemove_toFromTail( "2" ) );
        assertNull( this.node1.findAndRemove_toFromTail( "2" ) );

        assertNull( this.node3.findAndRemove_toFromTail( "2" ) );
        assertNull( this.node4.findAndRemove_toFromTail( "2" ) );

        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 0 ) ) );
        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 1 ) ) );
        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 3 ) ) );
        assertNull( this.node2.findAndRemove_toFromTail( String.valueOf( 4 ) ) );
    }

    @Test
    void testFindAndRemove_fromTowards_head() {
    }

    @Test
    void testFindAndRemove_fromTowards_tail() {
    }

    @Test
    void removeNode_fromHead() {
    }

    @Test
    void removeNode_fromTail() {
    }

    @Test
    void testRemoveNode_fromHead() {
    }

    @Test
    void testRemoveNode_fromTail() {
    }

    @Test
    void removeNode_towardsHead() {
    }

    @Test
    void removeNode_towardsTail() {
    }

    @Test
    void testRemoveNode_towardsHead() {
    }

    @Test
    void testRemoveNode_towardsTail() {
    }

    @Test
    void removeNode() {
    }

    @Test
    void testRemoveNode() {
    }

    @Test
    void helper_removeNode_head() {
    }

    @Test
    void helper_removeNode_tail() {
    }

    @Test
    void insertNode_towardsHead() {
        Node node5 = new Node( "5" );
        Node node6 = new Node( "6" );

        System.out.println( "insert towards head" );
        node2.print_towardsFromHead();
        this.node2.insert_towardsHead( node5 );
        node2.print_towardsFromHead();
        this.node2.insert_towardsHead( node6 );
        node2.print_towardsFromHead();

        assertEquals( node6.data, this.node2.previous.data );
        assertEquals( node5.data, this.node2.previous.previous.data );

        assertEquals( this.node2.data, node6.next.data );
        assertEquals( this.node2.data, node5.next.next.data );

        node5.insert_towardsHead( this.node2 );
        node6.print_towardsFromHead();
        node5.insert_towardsHead( this.node2 );
        node6.print_towardsFromHead();
        node5.insert_towardsHead( this.node2 );
        node6.print_towardsFromHead();

        assertEquals( this.node2.data, node5.previous.data );
        assertEquals( node5.data, this.node2.next.data );


        String[] node2s = this.node2.strings_toFromHead();
        String[] node6s = node6.strings_toFromHead();

        for ( int i = 0; i < node6s.length; i++ ) {
            assertEquals( node2s[ i ], node6s[ i ] );
        }

        node6.print_towardsFromHead();
        assertEquals( 7, node5.strings_toFromHead().length );
        node6.remove();
        node5.print_towardsFromHead();
        assertEquals( 6, node5.strings_toFromHead().length );
        assertEquals( 1, node6.strings_toFromHead().length );
        node6.print_towardsFromHead();
        System.out.println();
    }

    @Test
    void insertNode_towardsTail() {
        Node node5 = new Node( "5" );
        Node node6 = new Node( "6" );

        System.out.println( "insert towards tail" );
        this.node2.print_towardsFromHead();

        this.node2.insert_towardsTail( node5 );
        this.node2.print_towardsFromHead();
        this.node2.insert_towardsTail( node6 );
        this.node2.print_towardsFromHead();

        assertEquals( node6.data, this.node2.next.data );
        assertEquals( node5.data, this.node2.next.next.data );

        node5.insert_towardsTail( this.node2 );
        this.node2.print_towardsFromHead();
        node5.insert_towardsTail( this.node2 );
        this.node2.print_towardsFromHead();

        assertEquals( this.node2.data, node5.next.data );
        assertEquals( this.node2.data, node6.next.next.data );

        String[] node2s = this.node2.strings_toFromTail();
        String[] node6s = node6.strings_toFromTail();

        for ( int i = 0; i < node6s.length; i++ ) {
            assertEquals( node2s[ i ], node6s[ i ] );
        }

        node6.print_towardsFromHead();
        assertEquals( 7, node5.strings_toFromHead().length );
        node6.remove();
        node5.print_towardsFromHead();
        assertEquals( 6, node5.strings_toFromHead().length );
        assertEquals( 1, node6.strings_toFromHead().length );
        node6.print_towardsFromHead();
        System.out.println();
    }

    @Test
    void insertNode_beforeThisNode() {
    }

    @Test
    void insertNode_afterThisNode() {
    }
}