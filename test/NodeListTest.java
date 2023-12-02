import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class NodeListTest {

    NodeList tomNodeList = new NodeList();

    NodeList fyldtNodeList;

    //Make some nodes
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

        this.fyldtNodeList = new NodeList( this.node3 );
    }

    @Test
    void isEmpty() {
        assertTrue( this.tomNodeList.hasZeroNodes() );

        assertNull( this.tomNodeList.getHead() );

        assertNull( this.tomNodeList.getTail() );

    }

    @Test
    void insertFromHeadEmpty() {
        this.tomNodeList.insertHead( this.node0.data );

        assertFalse( this.tomNodeList.hasZeroNodes() );

        assertEquals( this.node0.data, this.tomNodeList.getHead() );

        assertEquals( this.node0.data, this.tomNodeList.getTail() );
    }

    @Test
    void insertFromTailEmpty() {
        this.tomNodeList.insertTail( this.node0.data );

        assertFalse( this.tomNodeList.hasZeroNodes() );

        assertEquals( this.node0.data, this.tomNodeList.getHead() );

        assertEquals( this.node0.data, this.tomNodeList.getTail() );
    }

    @Test
    void testFyldtListe() {
        //Get Head or Tail
        //Get Head
        assertEquals( this.node0.data, this.fyldtNodeList.getHead() );

        //Tail
        assertEquals( this.node4.data, this.fyldtNodeList.getTail() );


    }

    @Test
    void testGetHeadArrayList() {
        //Get Head or Tail Array
        //Get Head
        //Tail
        String[] stringsFromHead = new String[ 5 ];
        stringsFromHead[ 0 ] = this.node0.data;
        stringsFromHead[ 1 ] = this.node1.data;
        stringsFromHead[ 2 ] = this.node2.data;
        stringsFromHead[ 3 ] = this.node3.data;
        stringsFromHead[ 4 ] = this.node4.data;

        //Liste Array
        String[] listsStringsFromHead = this.fyldtNodeList.strings_fromHead();

        //Test
        for ( int i = 0; i < listsStringsFromHead.length; i++ ) {
            assertEquals( stringsFromHead[ i ], listsStringsFromHead[ i ] );
        }


    }


    @Test
    void testGetTailArrayList() {
        //Tail
        String[] stringsFromTail = new String[ 5 ];
        stringsFromTail[ 0 ] = this.node4.data;
        stringsFromTail[ 1 ] = this.node3.data;
        stringsFromTail[ 2 ] = this.node2.data;
        stringsFromTail[ 3 ] = this.node1.data;
        stringsFromTail[ 4 ] = this.node0.data;

        //Liste Array
        String[] listsStringsFromTail = this.fyldtNodeList.strings_fromTail();

        //Test
        for ( int i = 0; i < listsStringsFromTail.length; i++ ) {
            assertEquals( stringsFromTail[ i ], listsStringsFromTail[ i ] );
        }


    }

    @Test
    void insertFromHead() {
        this.fyldtNodeList.insertHead( this.node2.data );

        assertEquals( this.node2.data, this.fyldtNodeList.getHead() );

        //Get Head or Tail Array
        //Get Head
        //Tail
        String[] stringsFromHead = new String[ 6 ];
        stringsFromHead[ 0 ] = this.node2.data;
        stringsFromHead[ 1 ] = this.node0.data;
        stringsFromHead[ 2 ] = this.node1.data;
        stringsFromHead[ 3 ] = this.node2.data;
        stringsFromHead[ 4 ] = this.node3.data;
        stringsFromHead[ 5 ] = this.node4.data;


        //Liste Array
        String[] listsStringsFromHead = this.fyldtNodeList.strings_fromHead();

        //Test
        for ( int i = 0; i < listsStringsFromHead.length; i++ ) {
            assertEquals( stringsFromHead[ i ], listsStringsFromHead[ i ] );
        }


        assertEquals( this.node3.data, this.fyldtNodeList.insertHead( this.node3.data ) );
        assertEquals( this.fyldtNodeList.getHead(), this.fyldtNodeList.insertHead( this.node3.data ) );
        assertEquals( this.node3.data, this.fyldtNodeList.getHead() );

        //Is Tail unchanged?
        assertEquals( this.node4.data, this.fyldtNodeList.getTail() );


    }

    @Test
    void testInsertFromTail() {
        this.fyldtNodeList.insertTail( this.node2.data );

        assertEquals( this.node2.data, this.fyldtNodeList.getTail() );

        //Tail
        String[] stringsFromTail = new String[ 6 ];
        stringsFromTail[ 0 ] = this.node2.data;
        stringsFromTail[ 1 ] = this.node4.data;
        stringsFromTail[ 2 ] = this.node3.data;
        stringsFromTail[ 3 ] = this.node2.data;
        stringsFromTail[ 4 ] = this.node1.data;
        stringsFromTail[ 5 ] = this.node0.data;

        //Liste Array
        String[] listsStringsFromTail = this.fyldtNodeList.strings_fromTail();

        //Test
        for ( int i = 0; i < listsStringsFromTail.length; i++ ) {
            assertEquals( stringsFromTail[ i ], listsStringsFromTail[ i ] );
        }


        assertEquals( this.node3.data, this.fyldtNodeList.insertTail( this.node3.data ) );
        assertEquals( this.fyldtNodeList.getTail(), this.fyldtNodeList.insertTail( this.node3.data ) );
        assertEquals( this.node3.data, this.fyldtNodeList.getTail() );

        //Is head unchanged?
        assertEquals( this.node0.data, this.fyldtNodeList.getHead() );

    }

    @Test
    void testIsOnlyOne() {
        assertFalse( this.tomNodeList.hasOneNode() );

        NodeList oneNodeList = new NodeList( new Node( "111111" ) );
        assertTrue( oneNodeList.hasOneNode() );

        NodeList twoNodeList = new NodeList( new Node( "111111" ) );
        twoNodeList.insertHead( "222222" );
        assertFalse( twoNodeList.hasOneNode() );
    }

    @Test
    void testRemoveFromHead() {
        System.out.println( "-----------REMOVED FROM HEAD-----------------" );
        System.out.println();
        System.out.println( "Before 2 removals from head" );
        this.fyldtNodeList.print_fromHead();

        assertNotEquals( null, this.fyldtNodeList.removeHead() );
        assertNotEquals( null, this.fyldtNodeList.removeHead() );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed from head" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed from head" );
        this.fyldtNodeList.print_fromHead();

        assertNotEquals( null, this.fyldtNodeList.removeHead() );
        assertNotEquals( null, this.fyldtNodeList.removeHead() );
        assertNotEquals( null, this.fyldtNodeList.removeHead() );
        assertNull( this.fyldtNodeList.removeHead() );
        assertNull( this.fyldtNodeList.removeHead() );

        assertNull( this.tomNodeList.removeHead() );

        this.tomNodeList.insertHead( this.node2.data );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNull( this.tomNodeList.removeHead() );

        this.tomNodeList.insertHead( this.node2.data );
        this.tomNodeList.insertHead( this.node2.data );
        this.tomNodeList.insertHead( this.node2.data );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNull( this.tomNodeList.removeHead() );

        this.tomNodeList.insertHead( this.node2.data );
        this.tomNodeList.insertHead( this.node4.data );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNull( this.tomNodeList.removeHead() );
    }

    @Test
    void removeFromTail() {
        System.out.println( "-----------REMOVED FROM TAIL-----------------" );
        System.out.println();
        System.out.println( "Before 2 removals from tail" );
        this.fyldtNodeList.print_fromHead();

        assertNotEquals( null, this.fyldtNodeList.removeTail() );
        assertNotEquals( null, this.fyldtNodeList.removeTail() );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed from tail" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed from tail" );
        this.fyldtNodeList.print_fromTail();

        assertNotEquals( null, this.fyldtNodeList.removeTail() );
        assertNotEquals( null, this.fyldtNodeList.removeTail() );
        assertNotEquals( null, this.fyldtNodeList.removeTail() );
        assertNull( this.fyldtNodeList.removeTail() );
        assertNull( this.fyldtNodeList.removeTail() );

        assertNull( this.tomNodeList.removeTail() );

        this.tomNodeList.insertTail( this.node2.data );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNull( this.tomNodeList.removeTail() );

        this.tomNodeList.insertHead( this.node2.data );
        this.tomNodeList.insertTail( this.node2.data );
        this.tomNodeList.insertHead( this.node2.data );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNull( this.tomNodeList.removeTail() );

        this.tomNodeList.insertTail( this.node2.data );
        this.tomNodeList.insertHead( this.node4.data );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNull( this.tomNodeList.removeTail() );
    }

    @Test
    void testGetHeadAndRemoveIt() {
        String headRes = this.fyldtNodeList.getHead();
        assertEquals( "0", this.fyldtNodeList.getHead() );

        assertEquals( headRes, this.fyldtNodeList.removeHead() );
        assertEquals( "1", this.fyldtNodeList.getHead() );

        assertNotEquals( headRes, this.fyldtNodeList.removeHead() );
        assertNotEquals( "1", this.fyldtNodeList.getHead() );

        assertNull( this.tomNodeList.removeHead() );
    }

    @Test
    void testGetTailAndRemoveIt() {
        String tailRes = this.fyldtNodeList.getTail();
        assertEquals( "4", this.fyldtNodeList.getTail() );

        assertEquals( tailRes, this.fyldtNodeList.removeTail() );
        assertEquals( "3", this.fyldtNodeList.getTail() );

        assertNotEquals( tailRes, this.fyldtNodeList.removeTail() );
        assertNotEquals( "3", this.fyldtNodeList.getTail() );

        assertNull( this.tomNodeList.removeTail() );
    }

    @Test
    void testGetNodeWithDataFromHead() {
        assertNull( this.fyldtNodeList.find_fromHead( "-1" ) );
        assertEquals( this.node0.data, this.fyldtNodeList.find_fromHead( "0" ) );
        assertEquals( this.node1.data, this.fyldtNodeList.find_fromHead( "1" ) );
        assertEquals( this.node2.data, this.fyldtNodeList.find_fromHead( "2" ) );
        assertEquals( this.node3.data, this.fyldtNodeList.find_fromHead( "3" ) );
        assertEquals( this.node4.data, this.fyldtNodeList.find_fromHead( "4" ) );
        assertNull( this.fyldtNodeList.find_fromHead( "5" ) );
    }

    @Test
    void testGetNodeWithDataFromTail() {
        assertNull( this.fyldtNodeList.find_fromTail( "-1" ) );
        assertEquals( this.node0.data, this.fyldtNodeList.find_fromTail( "0" ) );
        assertEquals( this.node1.data, this.fyldtNodeList.find_fromTail( "1" ) );
        assertEquals( this.node2.data, this.fyldtNodeList.find_fromTail( "2" ) );
        assertEquals( this.node3.data, this.fyldtNodeList.find_fromTail( "3" ) );
        assertEquals( this.node4.data, this.fyldtNodeList.find_fromTail( "4" ) );
        assertNull( this.fyldtNodeList.find_fromTail( "5" ) );
    }

    @Test
    void testGetNodeWithDataFromHeadAndRemoveIt() {
        System.out.println( "-----------REMOVE SPECIFIC NODES FROM HEAD-----------------" );
        System.out.println();
        System.out.println( "Before node 2 removed" );
        this.fyldtNodeList.print_fromHead();

        assertEquals( this.node2.data, this.fyldtNodeList.findAndRemove_fromHead( "2" ) );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed" );
        this.fyldtNodeList.print_fromTail();

        assertEquals( this.node0.data, this.fyldtNodeList.findAndRemove_fromHead( "0" ) );
        assertEquals( this.node1.data, this.fyldtNodeList.getHead() );

        assertEquals( this.node4.data, this.fyldtNodeList.findAndRemove_fromHead( "4" ) );
        assertEquals( this.node3.data, this.fyldtNodeList.getTail() );

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromTail();

        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "-1" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "0" ) );
        assertEquals( this.node1.data, this.fyldtNodeList.findAndRemove_fromHead( "1" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "2" ) );
        assertEquals( this.node3.data, this.fyldtNodeList.findAndRemove_fromHead( "3" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "4" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "5" ) );

        assertTrue( this.fyldtNodeList.hasZeroNodes() );

        this.fyldtNodeList.insertHead( this.node2.data );
        assertEquals( this.fyldtNodeList.getHead(), this.node2.data );
        assertEquals( this.fyldtNodeList.getTail(), this.node2.data );

        System.out.println();
        System.out.println( "Reduced List reinserted node 2, from head" );
        this.fyldtNodeList.print_fromHead();
    }

    @Test
    void testGetNodeWithDataFromTailAndRemoveIt() {
        System.out.println( "-----------REMOVE SPECIFIC NODES FROM TAIL-----------------" );
        System.out.println();
        System.out.println( "Before node 2 removed" );
        this.fyldtNodeList.print_fromHead();

        assertEquals( this.node2.data, this.fyldtNodeList.findAndRemove_fromTail( "2" ) );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed" );
        this.fyldtNodeList.print_fromTail();

        assertEquals( this.node0.data, this.fyldtNodeList.findAndRemove_fromTail( "0" ) );
        assertEquals( this.node1.data, this.fyldtNodeList.getHead() );

        assertEquals( this.node4.data, this.fyldtNodeList.findAndRemove_fromTail( "4" ) );
        assertEquals( this.node3.data, this.fyldtNodeList.getTail() );

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromTail();


        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "-1" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "0" ) );
        assertEquals( this.node1.data, this.fyldtNodeList.findAndRemove_fromTail( "1" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "2" ) );
        assertEquals( this.node3.data, this.fyldtNodeList.findAndRemove_fromTail( "3" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "4" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "5" ) );

        assertTrue( this.fyldtNodeList.hasZeroNodes() );

        this.fyldtNodeList.insertTail( this.node2.data );
        assertEquals( this.fyldtNodeList.getHead(), this.node2.data );
        assertEquals( this.fyldtNodeList.getTail(), this.node2.data );

        System.out.println();
        System.out.println( "Reduced List reinserted node 2, from head" );
        this.fyldtNodeList.print_fromHead();
    }

    @Test
    void testFindFromHead() {
        System.out.println();
        System.out.println( "-----------FIND DATA FROM HEAD-----------------" );

        for ( int i = 0; i < this.fyldtNodeList.strings_fromHead().length; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.find_fromHead( String.valueOf( i ) ) );
        }

    }

    @Test
    void testFindFromTail() {
        System.out.println();
        System.out.println( "-----------FIND DATA FROM HEAD-----------------" );

        for ( int i = 0; i < this.fyldtNodeList.strings_fromTail().length; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.find_fromTail( String.valueOf( i ) ) );
        }
    }

    @Test
    void testReplaceFromHead() {
        System.out.println();
        System.out.println( "-----------REPLACE DATA FROM HEAD-----------------" );
        this.fyldtNodeList.print_fromHead();
        for ( int i = 0; i < this.fyldtNodeList.strings_fromHead().length; i++ ) {
            assertEquals( "2", this.fyldtNodeList.findAndReplace_fromHead(  "2",String.valueOf( i ) ) );
        }
        for ( int i = 0; i < this.fyldtNodeList.strings_fromHead().length; i++ ) {
            assertEquals( "2", this.fyldtNodeList.strings_fromHead()[ i ] );
        }
        this.fyldtNodeList.print_fromHead();
    }

    @Test
    void testReplaceFromTail() {
        System.out.println();
        System.out.println( "-----------REPLACE DATA FROM TAIL-----------------" );
        this.fyldtNodeList.print_fromHead();
        for ( int i = 0; i < this.fyldtNodeList.strings_fromTail().length; i++ ) {
            assertEquals( "2", this.fyldtNodeList.findAndReplace_fromTail( "2",String.valueOf( i )  ) );
        }
        for ( int i = 0; i < this.fyldtNodeList.strings_fromTail().length; i++ ) {
            assertEquals( "2", this.fyldtNodeList.strings_fromTail()[ i ] );
        }
        this.fyldtNodeList.print_fromHead();
    }
}