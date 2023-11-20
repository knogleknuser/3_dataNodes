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

        assertNull( this.tomNodeList.calcHead() );

        assertNull( this.tomNodeList.calcTail() );

    }

    @Test
    void insertFromHeadEmpty() {
        this.tomNodeList.insertHead( this.node0 );

        assertFalse( this.tomNodeList.hasZeroNodes() );

        assertEquals( this.node0.data, this.tomNodeList.calcHead().data );

        assertEquals( this.node0.data, this.tomNodeList.calcTail().data );
    }

    @Test
    void insertFromTailEmpty() {
        this.tomNodeList.insertTail( this.node0 );

        assertFalse( this.tomNodeList.hasZeroNodes() );

        assertEquals( this.node0.data, this.tomNodeList.calcHead().data );

        assertEquals( this.node0.data, this.tomNodeList.calcTail().data );
    }

    @Test
    void testFyldtListe() {
        //Get Head or Tail
        //Get Head
        assertEquals( this.node0.data, this.fyldtNodeList.calcHead().data );

        //Tail
        assertEquals( this.node4.data, this.fyldtNodeList.calcTail().data );


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

        assertTrue( Node.haveSameNetwork( this.fyldtNodeList.calcHead(), this.node4 ) );
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

        assertTrue( Node.haveSameNetwork( this.fyldtNodeList.calcHead(), this.node4 ) );

    }

    @Test
    void insertFromHead() {
        this.fyldtNodeList.insertHead( this.node2 );

        assertEquals( this.node2.data, this.fyldtNodeList.calcHead().data );

        //Get Head or Tail Array
        //Get Head
        //Tail
        String[] stringsFromHead = new String[ 5 ];
        stringsFromHead[ 0 ] = this.node2.data;
        stringsFromHead[ 1 ] = this.node0.data;
        stringsFromHead[ 2 ] = this.node1.data;
        stringsFromHead[ 3 ] = this.node3.data;
        stringsFromHead[ 4 ] = this.node4.data;




        //Liste Array
        String[] listsStringsFromHead = this.fyldtNodeList.strings_fromHead();

        //Test
        for ( int i = 0; i < listsStringsFromHead.length; i++ ) {
            assertEquals( stringsFromHead[ i ], listsStringsFromHead[ i ] );
        }

        assertTrue( Node.haveSameNetwork( this.fyldtNodeList.calcHead(), this.node4 ) );

        assertEquals( this.node3.data, this.fyldtNodeList.insertHead( this.node3 ).data );
        assertEquals( this.fyldtNodeList.calcHead().data, this.fyldtNodeList.insertHead( this.node3 ).data );
        assertEquals( this.node3.data, this.fyldtNodeList.calcHead().data );

        //Is Tail unchanged?
        assertEquals( this.node4.data, this.fyldtNodeList.calcTail().data );


    }

    @Test
    void testInsertFromTail() {
        this.fyldtNodeList.insertTail( this.node2 );

        assertEquals( this.node2.data, this.fyldtNodeList.calcTail().data );

        //Tail
        String[] stringsFromTail = new String[ 5 ];
        stringsFromTail[ 0 ] = this.node2.data;
        stringsFromTail[ 1 ] = this.node4.data;
        stringsFromTail[ 2 ] = this.node3.data;
        stringsFromTail[ 3 ] = this.node1.data;
        stringsFromTail[ 4 ] = this.node0.data;

        //Liste Array
        String[] listsStringsFromTail = this.fyldtNodeList.strings_fromTail();

        //Test
        for ( int i = 0; i < listsStringsFromTail.length; i++ ) {
            assertEquals( stringsFromTail[ i ], listsStringsFromTail[ i ] );
        }

        assertTrue( Node.haveSameNetwork( this.fyldtNodeList.calcHead(), this.node4 ) );


        assertEquals( this.node3.data, this.fyldtNodeList.insertTail( this.node3 ).data );
        assertEquals( this.fyldtNodeList.calcTail().data, this.fyldtNodeList.insertTail( this.node3 ).data );
        assertEquals( this.node3.data, this.fyldtNodeList.calcTail().data );

        //Is head unchanged?
        assertEquals( this.node0.data, this.fyldtNodeList.calcHead().data );

    }

    @Test
    void testIsOnlyOne() {
        assertFalse( this.tomNodeList.hasOneNode() );

        NodeList oneNodeList = new NodeList( new Node( "111111" ) );
        assertTrue( oneNodeList.hasOneNode() );

        NodeList twoNodeList = new NodeList( new Node( "111111" ) );
        twoNodeList.insertHead( new Node( "222222" ) );
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

        this.tomNodeList.insertHead( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNull( this.tomNodeList.removeHead() );

        this.tomNodeList.insertHead( this.node2 );
        this.tomNodeList.insertHead( this.node2 );
        this.tomNodeList.insertHead( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeHead() );
        assertNull( this.tomNodeList.removeHead() );

        this.tomNodeList.insertHead( this.node2 );
        this.tomNodeList.insertHead( this.node4 );
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

        this.tomNodeList.insertTail( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNull( this.tomNodeList.removeTail() );

        this.tomNodeList.insertHead( this.node2 );
        this.tomNodeList.insertTail( this.node2 );
        this.tomNodeList.insertHead( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNull( this.tomNodeList.removeTail() );

        this.tomNodeList.insertTail( this.node2 );
        this.tomNodeList.insertHead( this.node4 );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNotEquals( null, this.tomNodeList.removeTail() );
        assertNull( this.tomNodeList.removeTail() );
    }

    @Test
    void testGetHeadAndRemoveIt() {
        Node headRes = this.fyldtNodeList.calcHead();
        assertEquals( "0", this.fyldtNodeList.calcHead().data );

        Node newHeadRes = this.fyldtNodeList.calcHead().next;
        assertEquals( headRes.data, this.fyldtNodeList.removeHead().data );
        assertEquals( newHeadRes.data, this.fyldtNodeList.calcHead().data );

        assertNotEquals( headRes.data, this.fyldtNodeList.removeHead().data );
        assertNotEquals( newHeadRes.data, this.fyldtNodeList.calcHead().data );

        assertNull( this.tomNodeList.removeHead() );
    }

    @Test
    void testGetTailAndRemoveIt() {
        Node tailRes = this.fyldtNodeList.calcTail();
        assertEquals( "4", this.fyldtNodeList.calcTail().data );

        Node newTailRes = this.fyldtNodeList.calcTail().previous;
        assertEquals( tailRes.data, this.fyldtNodeList.removeTail().data );
        assertEquals( newTailRes.data, this.fyldtNodeList.calcTail().data );

        assertNotEquals( tailRes.data, this.fyldtNodeList.removeTail().data );
        assertNotEquals( newTailRes.data, this.fyldtNodeList.calcTail().data );

        assertNull( this.tomNodeList.removeTail() );
    }

    @Test
    void testGetNodeWithDataFromHead() {
        assertNull( this.fyldtNodeList.find_fromHead( "-1" ) );
        assertEquals( this.node0.data, this.fyldtNodeList.find_fromHead( "0" ).data );
        assertEquals( this.node1.data, this.fyldtNodeList.find_fromHead( "1" ).data );
        assertEquals( this.node2.data, this.fyldtNodeList.find_fromHead( "2" ).data );
        assertEquals( this.node3.data, this.fyldtNodeList.find_fromHead( "3" ).data );
        assertEquals( this.node4.data, this.fyldtNodeList.find_fromHead( "4" ).data );
        assertNull( this.fyldtNodeList.find_fromHead( "5" ) );
    }

    @Test
    void testGetNodeWithDataFromTail() {
        assertNull( this.fyldtNodeList.find_fromTail( "-1" ) );
        assertEquals( this.node0.data, this.fyldtNodeList.find_fromTail( "0" ).data );
        assertEquals( this.node1.data, this.fyldtNodeList.find_fromTail( "1" ).data );
        assertEquals( this.node2.data, this.fyldtNodeList.find_fromTail( "2" ).data );
        assertEquals( this.node3.data, this.fyldtNodeList.find_fromTail( "3" ).data );
        assertEquals( this.node4.data, this.fyldtNodeList.find_fromTail( "4" ).data );
        assertNull( this.fyldtNodeList.find_fromTail( "5" ) );
    }

    @Test
    void testGetNodeWithDataFromHeadAndRemoveIt() {
        System.out.println( "-----------REMOVE SPECIFIC NODES FROM HEAD-----------------" );
        System.out.println();
        System.out.println( "Before node 2 removed" );
        this.fyldtNodeList.print_fromHead();

        assertEquals( this.node2, this.fyldtNodeList.findAndRemove_fromHead( "2" ) );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed" );
        this.fyldtNodeList.print_fromTail();

        assertEquals( this.node0.data, this.fyldtNodeList.findAndRemove_fromHead( "0" ).data );
        assertEquals( this.node1.data, this.fyldtNodeList.calcHead().data );

        assertEquals( this.node4.data, this.fyldtNodeList.findAndRemove_fromHead( "4" ).data );
        assertEquals( this.node3.data, this.fyldtNodeList.calcTail().data );

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromTail();

        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "-1" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "0" ) );
        assertEquals( this.node1.data, this.fyldtNodeList.findAndRemove_fromHead( "1" ).data );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "2" ) );
        assertEquals( this.node3.data, this.fyldtNodeList.findAndRemove_fromHead( "3" ).data );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "4" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromHead( "5" ) );

        assertTrue( this.fyldtNodeList.hasZeroNodes() );

        this.fyldtNodeList.insertHead( this.node2 );
        assertEquals( this.fyldtNodeList.calcHead().data, this.node2.data );
        assertEquals( this.fyldtNodeList.calcTail().data, this.node2.data );

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

        assertEquals( this.node2, this.fyldtNodeList.findAndRemove_fromTail( "2" ) );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed" );
        this.fyldtNodeList.print_fromTail();

        assertEquals( this.node0.data, this.fyldtNodeList.findAndRemove_fromTail( "0" ).data );
        assertEquals( this.node1.data, this.fyldtNodeList.calcHead().data );

        assertEquals( this.node4.data, this.fyldtNodeList.findAndRemove_fromTail( "4" ).data );
        assertEquals( this.node3.data, this.fyldtNodeList.calcTail().data );

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromHead();

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.print_fromTail();


        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "-1" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "0" ) );
        assertEquals( this.node1, this.fyldtNodeList.findAndRemove_fromTail( "1" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "2" ) );
        assertEquals( this.node3, this.fyldtNodeList.findAndRemove_fromTail( "3" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "4" ) );
        assertNull( this.fyldtNodeList.findAndRemove_fromTail( "5" ) );

        assertTrue( this.fyldtNodeList.hasZeroNodes() );

        this.fyldtNodeList.insertTail( this.node2 );
        assertEquals( this.fyldtNodeList.calcHead().data, this.node2.data );
        assertEquals( this.fyldtNodeList.calcTail().data, this.node2.data );

        System.out.println();
        System.out.println( "Reduced List reinserted node 2, from head" );
        this.fyldtNodeList.print_fromHead();
    }

    @Test
    void testCanMoveBetweenLists() {
        System.out.println();
        System.out.println( "-----------REMOVE NODES BETWEEN LISTS-----------------" );
        assertEquals( this.node2.data, this.tomNodeList.insertHead( this.node2 ).data );
        assertEquals( this.node3.data, this.tomNodeList.insertTail( this.node3 ).data );

        System.out.println();
        System.out.println( "Added node 2 and 3 to empty List" );
        System.out.println( "ArrayList of empty nodelist" );
        assertEquals( 2, this.tomNodeList.strings_fromTail().length );
        tomNodeList.print_fromHead();

        System.out.println();
        System.out.println( "empty node list, 2,3" );
        this.tomNodeList.print_fromHead();
        System.out.println( "Now in reverse order" );
        this.tomNodeList.print_fromTail();

        System.out.println();
        System.out.println( "filled node list, 4,1,0" );
        this.fyldtNodeList.print_fromTail();
        System.out.println( "Now in reverse order" );
        this.fyldtNodeList.print_fromHead();

        this.tomNodeList.insertAfter( this.node4, this.node2 );

        System.out.println();
        System.out.println( "empty node list, 2, 4, 3" );
        this.tomNodeList.print_fromHead();
        System.out.println( "Now in reverse order" );
        this.tomNodeList.print_fromTail();

        System.out.println();
        System.out.println( "filled node list, 1,0" );
        this.fyldtNodeList.print_fromTail();
        System.out.println( "Now in reverse order" );
        this.fyldtNodeList.print_fromHead();

        this.fyldtNodeList.insertBefore( this.node4, this.node1 );

        System.out.println();
        System.out.println( "empty node list, 2, 3" );
        this.tomNodeList.print_fromHead();
        System.out.println( "Now in reverse order" );
        this.tomNodeList.print_fromTail();

        System.out.println();
        System.out.println( "filled node list, 1,4,0" );
        this.fyldtNodeList.print_fromTail();
        System.out.println( "Now in reverse order" );
        this.fyldtNodeList.print_fromHead();

        this.tomNodeList.insertAfter( this.node0, this.node3 );

        System.out.println();
        System.out.println( "empty node list, 2, 3, 0" );
        this.tomNodeList.print_fromHead();
        System.out.println( "Now in reverse order" );
        this.tomNodeList.print_fromTail();

        System.out.println();
        System.out.println( "filled node list, 1, 4" );
        this.fyldtNodeList.print_fromTail();
        System.out.println( "Now in reverse order" );
        this.fyldtNodeList.print_fromHead();


        this.fyldtNodeList.insertBefore( this.node0, this.node1 );

        System.out.println();
        System.out.println( "empty node list, 2, 3" );
        this.tomNodeList.print_fromHead();
        System.out.println( "Now in reverse order" );
        this.tomNodeList.print_fromTail();

        System.out.println();
        System.out.println( "filled node list, 1, 0, 4" );
        this.fyldtNodeList.print_fromTail();
        System.out.println( "Now in reverse order" );
        this.fyldtNodeList.print_fromHead();

        assertEquals( this.node0, this.fyldtNodeList.insertBefore( this.node0, this.node0 ) );
        assertEquals( this.node0, this.fyldtNodeList.insertAfter( this.node0, this.node0 ) );
        assertEquals( this.node0, this.tomNodeList.insertBefore( this.node0, this.node0 ) );
        assertEquals( this.node0, this.tomNodeList.insertAfter( this.node0, this.node0 ) );

        this.tomNodeList.insertAfter( this.node1, this.node3 );

        System.out.println();
        System.out.println( "empty node list, 2, 3, 1" );
        this.tomNodeList.print_fromHead();
        System.out.println( "Now in reverse order" );
        this.tomNodeList.print_fromTail();

        System.out.println();
        System.out.println( "filled node list, 0,4" );
        this.fyldtNodeList.print_fromTail();
        System.out.println( "Now in reverse order" );
        this.fyldtNodeList.print_fromHead();


        this.fyldtNodeList.insertBefore( this.node1, this.node0 );

        System.out.println();
        System.out.println( "empty node list, 2, 3" );
        this.tomNodeList.print_fromHead();
        System.out.println( "Now in reverse order" );
        this.tomNodeList.print_fromTail();

        System.out.println();
        System.out.println( "filled node list, 0, 1, 4" );
        this.fyldtNodeList.print_fromTail();
        System.out.println( "Now in reverse order" );
        this.fyldtNodeList.print_fromHead();

        this.fyldtNodeList.insertBefore( this.node3, this.node0 );
        this.fyldtNodeList.insertAfter( this.node2, this.node4 );
        assertEquals( this.fyldtNodeList.calcHead(), this.tomNodeList.calcHead() );
        assertEquals( this.fyldtNodeList.calcTail(), this.tomNodeList.calcTail() );
        assertEquals( 5, this.fyldtNodeList.strings_fromTail().length );

        this.tomNodeList.insertHead( this.node3 );
        this.tomNodeList.insertTail( this.node2 );
        assertEquals( this.fyldtNodeList.calcHead(), this.tomNodeList.calcHead() );
        assertEquals( this.fyldtNodeList.calcTail(), this.tomNodeList.calcTail() );
        assertEquals( 5, this.fyldtNodeList.strings_fromHead().length );
    }
}