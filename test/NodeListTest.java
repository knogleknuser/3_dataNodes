import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class NodeListTest {

    NodeList tomNodeList = new NodeList();

    NodeList fyldtNodeList;

    NodeList fyldtNodeListBog;

    //Make some nodes
    Node node0 = new Node( "0" );
    Node node1 = new Node( "1" );
    Node node2 = new Node( "2" );
    Node node3 = new Node( "3" );
    Node node4 = new Node( "4" );

    //ArrayList
    ArrayList< Node > NodeNs = new ArrayList<>();

    //Second test list
    Node nodeA = new Node( "A" );
    Node nodeB = new Node( "B" );
    Node nodeC = new Node( "C" );
    Node nodeD = new Node( "D" );
    Node nodeE = new Node( "E" );

    //ArrayList
    ArrayList< Node > NodeLs = new ArrayList<>();

    //Array
    String[] stringsTal = {
            "0",
            "1",
            "2",
            "3",
            "4",
    };

    String[] stringsBog = {
            "A",
            "B",
            "C",
            "D",
            "E",
    };

    @BeforeEach
    void setUp() {
        //Set up data structure default
        this.node0.next = this.node1;
        this.node1.previous = this.node0;

        this.node1.next = this.node2;
        this.node2.previous = this.node1;

        this.node2.next = this.node3;
        this.node3.previous = this.node2;

        this.node3.next = this.node4;
        this.node4.previous = this.node3;

        //ArrayList
        this.NodeNs.add( this.node0 );
        this.NodeNs.add( this.node1 );
        this.NodeNs.add( this.node2 );
        this.NodeNs.add( this.node3 );
        this.NodeNs.add( this.node4 );

        //Set up data structure second
        this.nodeA.next = this.nodeB;
        this.nodeB.previous = this.nodeA;

        this.nodeB.next = this.nodeC;
        this.nodeC.previous = this.nodeB;

        this.nodeC.next = this.nodeD;
        this.nodeD.previous = this.nodeC;

        this.nodeD.next = this.nodeE;
        this.nodeE.previous = this.nodeD;

        //ArrayList
        this.NodeLs.add( this.nodeA );
        this.NodeLs.add( this.nodeB );
        this.NodeLs.add( this.nodeC );
        this.NodeLs.add( this.nodeD );
        this.NodeLs.add( this.nodeE );


        //Extra, optional, only 1
        //Loop test
//        this.node0.previous = this.node2;
//        this.node4.next = this.node2;

        //Full Loop Test
//        this.node0.previous = this.node4;
//        this.node4.next = this.node0;


        //List Specific -------------------------------

        this.fyldtNodeList = new NodeList( this.node3 );
        this.fyldtNodeListBog = new NodeList( this.nodeD );
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
            assertEquals( "2", this.fyldtNodeList.findAndReplace_fromHead( "2", String.valueOf( i ) ) );
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
            assertEquals( "2", this.fyldtNodeList.findAndReplace_fromTail( "2", String.valueOf( i ) ) );
        }
        for ( int i = 0; i < this.fyldtNodeList.strings_fromTail().length; i++ ) {
            assertEquals( "2", this.fyldtNodeList.strings_fromTail()[ i ] );
        }
        this.fyldtNodeList.print_fromHead();
    }

    @Test
    void testNetworkSize() {
        System.out.println();
        System.out.println( "-----------NETWORK SIZE-----------------" );
        this.tomNodeList.print_fromHead();
        assertEquals( 5, this.fyldtNodeList.networkSize() );
        assertEquals( 0, this.tomNodeList.networkSize() );
    }

    @Test
    void insertUnique() {
        System.out.println();
        System.out.println( "-----------INSERT UNIQUE-----------------" );

        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 0; i < this.fyldtNodeList.networkSize(); i++ ) {
                assertNull( this.fyldtNodeList.findAndInsertAfter_fromHeadUnique( String.valueOf( i ), String.valueOf( j ) ) );
            }
        }

        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 0; i < this.fyldtNodeList.networkSize(); i++ ) {
                assertNull( this.fyldtNodeList.findAndInsertBefore_fromHeadUnique( String.valueOf( i ), String.valueOf( j ) ) );
            }
        }

        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 0; i < this.fyldtNodeList.networkSize(); i++ ) {
                assertNull( this.fyldtNodeList.findAndInsertAfter_fromTailUnique( String.valueOf( i ), String.valueOf( j ) ) );
            }
        }

        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 0; i < this.fyldtNodeList.networkSize(); i++ ) {
                assertNull( this.fyldtNodeList.findAndInsertAfter_fromTailUnique( String.valueOf( i ), String.valueOf( j ) ) );
            }
        }


        for ( int i = 0; i < this.fyldtNodeList.networkSize(); i++ ) {
            assertNull( this.fyldtNodeList.insertHeadUnique( String.valueOf( i ) ) );
        }


        for ( int i = 0; i < this.fyldtNodeList.networkSize(); i++ ) {
            assertNull( this.fyldtNodeList.insertTailUnique( String.valueOf( i ) ) );
        }

        System.out.println( "Big Loop 1" );
        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 5; i < 10; i++ ) {
                if ( j == 0 ) {
                    assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndInsertAfter_fromHeadUnique( String.valueOf( i ), String.valueOf( j ) ) );
                } else {
                    assertNull( this.fyldtNodeList.findAndInsertAfter_fromHeadUnique( String.valueOf( i ), String.valueOf( j ) ) );
                }

                assertEquals( String.valueOf( i ), this.fyldtNodeList.find_fromHead( String.valueOf( i ) ) );

            }
            assertEquals( 10, this.fyldtNodeList.networkSize() );
        }
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndRemove_fromHead( String.valueOf( i ) ) );

        }


        System.out.println( "Big Loop 2" );
        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 5; i < 10; i++ ) {
                if ( j == 0 ) {
                    assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndInsertBefore_fromHeadUnique( String.valueOf( i ), String.valueOf( j ) ) );
                } else {
                    assertNull( this.fyldtNodeList.findAndInsertBefore_fromHeadUnique( String.valueOf( i ), String.valueOf( j ) ) );
                }

                assertEquals( String.valueOf( i ), this.fyldtNodeList.find_fromHead( String.valueOf( i ) ) );

            }
            assertEquals( 10, this.fyldtNodeList.networkSize() );
        }
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndRemove_fromHead( String.valueOf( i ) ) );

        }


        System.out.println( "Big Loop 3" );
        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 5; i < 10; i++ ) {
                if ( j == 0 ) {
                    assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndInsertAfter_fromTailUnique( String.valueOf( i ), String.valueOf( j ) ) );
                } else {
                    assertNull( this.fyldtNodeList.findAndInsertAfter_fromTailUnique( String.valueOf( i ), String.valueOf( j ) ) );
                }

                assertEquals( String.valueOf( i ), this.fyldtNodeList.find_fromTail( String.valueOf( i ) ) );

            }
            assertEquals( 10, this.fyldtNodeList.networkSize() );
        }
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndRemove_fromTail( String.valueOf( i ) ) );

        }


        System.out.println( "Big Loop 4" );
        for ( int j = 0; j < this.fyldtNodeList.networkSize(); j++ ) {
            for ( int i = 5; i < 10; i++ ) {
                if ( j == 0 ) {
                    assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndInsertBefore_fromTailUnique( String.valueOf( i ), String.valueOf( j ) ) );
                } else {
                    assertNull( this.fyldtNodeList.findAndInsertBefore_fromTailUnique( String.valueOf( i ), String.valueOf( j ) ) );
                }

                assertEquals( String.valueOf( i ), this.fyldtNodeList.find_fromHead( String.valueOf( i ) ) );

            }
            assertEquals( 10, this.fyldtNodeList.networkSize() );
        }
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndRemove_fromTail( String.valueOf( i ) ) );

        }


        System.out.println( "End Loop 1" );
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.insertHeadUnique( String.valueOf( i ) ) );

        }
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndRemove_fromHead( String.valueOf( i ) ) );
        }

        System.out.println( "End Loop 2" );
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.insertTailUnique( String.valueOf( i ) ) );

        }
        for ( int i = 5; i < 10; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.findAndRemove_fromTail( String.valueOf( i ) ) );

        }

    }

    @Test
    void removeDuplicates() {
        System.out.println();
        System.out.println( "-----------REMOVE ALL DUPLICATES-----------------" );

        Node node5 = new Node( ( String ) null );
        Node node6 = new Node( ( String ) null );
        Node node7 = new Node( ( String ) null );
        Node node8 = new Node( ( String ) null );

        this.node4.next = node5;
        node5.previous = this.node4;

        node5.next = node6;
        node6.previous = node5;

        node6.next = node7;
        node7.previous = node6;

        node7.next = node8;
        node8.previous = node7;

        this.fyldtNodeList = new NodeList( this.node0 );

        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( "2" );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );
        this.fyldtNodeList.insertHead( ( String ) null );

        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( "2" );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );
        this.fyldtNodeList.insertTail( ( String ) null );

        assertNotEquals( 5, this.fyldtNodeList.networkSize() );
        this.fyldtNodeList.print_fromHead();
        assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
        this.fyldtNodeList.print_fromHead();
        assertEquals( 5, this.fyldtNodeList.networkSize() );

        for ( int i = 0; i < this.fyldtNodeList.networkSize(); i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.find_fromHead( String.valueOf( i ) ) );
        }


    }

    @Test
    void multipleWordsInsertion() {
        System.out.println();
        System.out.println( "-----------MULTIPLE WORDS INSERTION-----------------" );

        String[] words = {
                "null",
                null,
                "torsdag",
                "45"
        };

        String[] wordsInvalid = null;

        //Full list
        assertFalse( this.fyldtNodeList.insertHead( wordsInvalid ) );
        assertEquals( 5, this.fyldtNodeList.networkSize() );

        assertTrue( this.fyldtNodeList.insertHead( words ) );
        assertEquals( "null", this.fyldtNodeList.strings_fromHead()[ 0 ] );
        assertEquals( "torsdag", this.fyldtNodeList.strings_fromHead()[ 1 ] );
        assertEquals( "45", this.fyldtNodeList.strings_fromHead()[ 2 ] );
        assertEquals( 8, this.fyldtNodeList.networkSize() );


        assertFalse( this.fyldtNodeList.insertTail( wordsInvalid ) );
        assertEquals( 8, this.fyldtNodeList.networkSize() );

        assertTrue( this.fyldtNodeList.insertTail( words ) );
        assertEquals( "null", this.fyldtNodeList.strings_fromHead()[ 8 ] );
        assertEquals( "torsdag", this.fyldtNodeList.strings_fromHead()[ 9 ] );
        assertEquals( "45", this.fyldtNodeList.strings_fromHead()[ 10 ] );
        assertEquals( 11, this.fyldtNodeList.networkSize() );


        //Empty list
        assertFalse( this.tomNodeList.insertHead( wordsInvalid ) );
        assertEquals( 0, this.tomNodeList.networkSize() );

        assertTrue( this.tomNodeList.insertHead( words ) );
        assertEquals( "null", this.tomNodeList.strings_fromHead()[ 0 ] );
        assertEquals( "torsdag", this.tomNodeList.strings_fromHead()[ 1 ] );
        assertEquals( "45", this.tomNodeList.strings_fromHead()[ 2 ] );
        assertEquals( 3, this.tomNodeList.networkSize() );


        //Emptying the list
        assertEquals( "null", this.tomNodeList.findAndRemove_fromHead( "null" ) );
        assertEquals( "torsdag", this.tomNodeList.findAndRemove_fromHead( "torsdag" ) );
        assertEquals( "45", this.tomNodeList.findAndRemove_fromHead( "45" ) );
        assertEquals( 0, this.tomNodeList.networkSize() );

        //Tail
        assertFalse( this.tomNodeList.insertTail( wordsInvalid ) );
        assertEquals( 0, this.tomNodeList.networkSize() );

        assertTrue( this.tomNodeList.insertTail( words ) );
        assertEquals( "null", this.tomNodeList.strings_fromHead()[ 0 ] );
        assertEquals( "torsdag", this.tomNodeList.strings_fromHead()[ 1 ] );
        assertEquals( "45", this.tomNodeList.strings_fromHead()[ 2 ] );
        assertEquals( 3, this.tomNodeList.networkSize() );


        //Emptying the list to 1 node
        assertEquals( 3, this.tomNodeList.networkSize() );
        assertEquals( "null", this.tomNodeList.findAndRemove_fromHead( "null" ) );
        assertEquals( "torsdag", this.tomNodeList.findAndRemove_fromHead( "torsdag" ) );
        assertEquals( 1, this.tomNodeList.networkSize() );


        //1 Node list
        assertFalse( this.tomNodeList.insertHead( wordsInvalid ) );
        assertEquals( 1, this.tomNodeList.networkSize() );

        assertTrue( this.tomNodeList.insertHead( words ) );
        assertEquals( "null", this.tomNodeList.strings_fromHead()[ 0 ] );
        assertEquals( "torsdag", this.tomNodeList.strings_fromHead()[ 1 ] );
        assertEquals( "45", this.tomNodeList.strings_fromHead()[ 2 ] );
        assertEquals( "45", this.tomNodeList.strings_fromHead()[ 3 ] );
        assertEquals( 4, this.tomNodeList.networkSize() );

        //Emptying the list to 1 node
        assertEquals( "null", this.tomNodeList.findAndRemove_fromHead( "null" ) );
        assertEquals( "torsdag", this.tomNodeList.findAndRemove_fromHead( "torsdag" ) );
        assertEquals( "45", this.tomNodeList.findAndRemove_fromHead( "45" ) );
        assertEquals( 1, this.tomNodeList.networkSize() );


        //Tail
        assertFalse( this.tomNodeList.insertTail( wordsInvalid ) );
        assertEquals( 1, this.tomNodeList.networkSize() );

        assertTrue( this.tomNodeList.insertTail( words ) );
        assertEquals( "45", this.tomNodeList.strings_fromHead()[ 0 ] );
        assertEquals( "null", this.tomNodeList.strings_fromHead()[ 1 ] );
        assertEquals( "torsdag", this.tomNodeList.strings_fromHead()[ 2 ] );
        assertEquals( "45", this.tomNodeList.strings_fromHead()[ 3 ] );

        assertEquals( 4, this.tomNodeList.networkSize() );

    }

    @Test
    void multipleWordsRemoval() {
        System.out.println();
        System.out.println( "-----------MULTIPLE WORDS REMOVAL-----------------" );

        String[] resStrings = this.fyldtNodeList.strings_fromHead();

        assertFalse( this.fyldtNodeList.findAndRemove_fromHead( ( String[] ) null ) );
        assertEquals( 5, this.fyldtNodeList.networkSize() );
        assertTrue( this.fyldtNodeList.findAndRemove_fromHead( resStrings ) );
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertFalse( this.fyldtNodeList.findAndRemove_fromHead( resStrings ) );
        assertFalse( this.fyldtNodeList.findAndRemove_fromHead( ( String[] ) null ) );

        this.fyldtNodeList.insertHead( resStrings );

        assertFalse( this.fyldtNodeList.findAndRemove_fromTail( ( String[] ) null ) );
        assertEquals( 5, this.fyldtNodeList.networkSize() );
        assertTrue( this.fyldtNodeList.findAndRemove_fromTail( resStrings ) );
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertFalse( this.fyldtNodeList.findAndRemove_fromTail( resStrings ) );
        assertFalse( this.fyldtNodeList.findAndRemove_fromTail( ( String[] ) null ) );
    }

    @Test
    void move_findFromHead_insertAfterFromHead() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: move_findFromHead_insertAfterFromHead-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromHead_insertAfterFromHead( String.valueOf( i ), "D", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );
        this.fyldtNodeList.print_fromHead();
        this.fyldtNodeListBog.print_fromHead();

    }

    @Test
    void move_findFromHead_insertBeforeFromHead() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: move_findFromHead_insertBeforeFromHead-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromHead_insertBeforeFromHead( String.valueOf( i ), "A", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );
        this.fyldtNodeList.print_fromHead();
        this.fyldtNodeListBog.print_fromHead();
    }

    @Test
    void move_findFromTail_insertAfterFromHead() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: move_findFromTail_insertAfterFromHead-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromTail_insertAfterFromHead( String.valueOf( i ), "E", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );
        this.fyldtNodeList.print_fromHead();
        this.fyldtNodeListBog.print_fromHead();
    }

    @Test
    void move_findFromTail_insertBeforeFromHead() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: move_findFromTail_insertBeforeFromHead-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromTail_insertBeforeFromHead( String.valueOf( i ), "D", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );
        this.fyldtNodeList.print_fromHead();
        this.fyldtNodeListBog.print_fromHead();
    }

    @Test
    void move_findFromHead_insertAfterFromTail() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: move_findFromHead_insertAfterFromTail-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromHead_insertAfterFromTail( String.valueOf( i ), "A", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );
        this.fyldtNodeList.print_fromHead();
        this.fyldtNodeListBog.print_fromHead();
    }

    @Test
    void move_findFromHead_insertBeforeFromTail() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: move_findFromHead_insertBeforeFromTail-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromHead_insertBeforeFromTail( String.valueOf( i ), "E", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );
        this.fyldtNodeList.print_fromHead();
        this.fyldtNodeListBog.print_fromHead();
    }

    @Test
    void move_findFromTail_insertAfterFromTail() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: MOVING-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromTail_insertAfterFromTail( String.valueOf( i ), "D", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );
        this.fyldtNodeList.print_fromHead();
        this.fyldtNodeListBog.print_fromHead();
    }

    @Test
    void move_findFromTail_insertBeforeFromTail() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS: MOVING-----------------" );

        for ( int i = 0; i < 5; i++ ) {
            assertEquals( String.valueOf( i ), this.fyldtNodeList.move_findFromTail_insertBeforeFromTail( String.valueOf( i ), "A", this.fyldtNodeListBog ) );
        }
        assertEquals( 0, this.fyldtNodeList.networkSize() );
        assertEquals( 10, this.fyldtNodeListBog.networkSize() );

    }

    @Test
    void testCopyListArray() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS ARRAY: COPY-----------------" );

        NodeList fyldtNodeListBackup = new NodeList( this.fyldtNodeList );
        NodeList tomNodeListBackup = new NodeList( this.tomNodeList );

        NodeList[] nodeLists = {
                new NodeList( this.fyldtNodeList ),
                new NodeList( this.fyldtNodeListBog ),
                new NodeList( this.fyldtNodeListBog ),
                new NodeList( this.fyldtNodeList ),
                new NodeList( this.fyldtNodeList ),
                new NodeList( this.fyldtNodeListBog ),
                new NodeList( this.fyldtNodeList ),
                new NodeList( this.fyldtNodeListBog ),
                new NodeList( this.fyldtNodeList )
        };

        for ( int i = 0; i < nodeLists.length; i++ ) {
            assertEquals( 5, nodeLists[ i ].networkSize() );
        }


        assertTrue( this.fyldtNodeList.copyList_headTail( nodeLists ) );

        this.fyldtNodeList.print_fromHead();
        assertEquals( 50, this.fyldtNodeList.networkSize() );
        this.fyldtNodeList.print_fromHead();
        assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
        this.fyldtNodeList.print_fromHead();
        assertEquals( 10, this.fyldtNodeList.networkSize() );

        assertTrue( this.tomNodeList.copyList_headTail( nodeLists ) );
        this.tomNodeList.print_fromHead();
        assertEquals( 45, this.tomNodeList.networkSize() );
        this.tomNodeList.print_fromHead();
        assertTrue( this.tomNodeList.findAndRemove_duplicates() );
        this.tomNodeList.print_fromHead();
        assertEquals( 10, this.tomNodeList.networkSize() );

        this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
        this.tomNodeList = new NodeList( tomNodeListBackup );


        assertTrue( this.fyldtNodeList.copyList_headTail( nodeLists ) );
        assertEquals( 50, this.fyldtNodeList.networkSize() );
        assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.fyldtNodeList.networkSize() );

        assertTrue( this.tomNodeList.copyList_headTail( nodeLists ) );
        assertEquals( 45, this.tomNodeList.networkSize() );
        assertTrue( this.tomNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.tomNodeList.networkSize() );

        this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
        this.tomNodeList = new NodeList( tomNodeListBackup );

        assertTrue( this.fyldtNodeList.copyList_headHead( nodeLists ) );
        assertEquals( 50, this.fyldtNodeList.networkSize() );
        assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.fyldtNodeList.networkSize() );

        assertTrue( this.tomNodeList.copyList_headHead( nodeLists ) );
        assertEquals( 45, this.tomNodeList.networkSize() );
        assertTrue( this.tomNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.tomNodeList.networkSize() );

        this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
        this.tomNodeList = new NodeList( tomNodeListBackup );

        assertTrue( this.fyldtNodeList.copyList_tailHead( nodeLists ) );
        assertEquals( 50, this.fyldtNodeList.networkSize() );
        assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.fyldtNodeList.networkSize() );

        assertTrue( this.tomNodeList.copyList_tailHead( nodeLists ) );
        assertEquals( 45, this.tomNodeList.networkSize() );
        assertTrue( this.tomNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.tomNodeList.networkSize() );

        this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
        this.tomNodeList = new NodeList( tomNodeListBackup );

        assertTrue( this.fyldtNodeList.copyList_tailTail( nodeLists ) );
        assertEquals( 50, this.fyldtNodeList.networkSize() );
        assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.fyldtNodeList.networkSize() );

        assertTrue( this.tomNodeList.copyList_tailTail( nodeLists ) );
        assertEquals( 45, this.tomNodeList.networkSize() );
        assertTrue( this.tomNodeList.findAndRemove_duplicates() );
        assertEquals( 10, this.tomNodeList.networkSize() );


    }

    @Test
    void testCopyAndDeleteListArray() {
        System.out.println();
        System.out.println( "-----------MULTIPLE LISTS ARRAY: COPY AND DELETE-----------------" );

        NodeList fyldtNodeListBackup = new NodeList( this.fyldtNodeList );
        NodeList fyldtNodeListBogBackup = new NodeList( this.fyldtNodeListBog );
        NodeList tomNodeListBackup = new NodeList( this.tomNodeList );
        NodeList[] nodeLists;

        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }

            assertTrue( this.fyldtNodeList.copyListAndDelete_headTail( nodeLists ) );

            this.fyldtNodeList.print_fromHead();
            assertEquals( 50, this.fyldtNodeList.networkSize() );
            this.fyldtNodeList.print_fromHead();
            assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
            this.fyldtNodeList.print_fromHead();
            assertEquals( 10, this.fyldtNodeList.networkSize() );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }

            assertTrue( this.tomNodeList.copyListAndDelete_headTail( nodeLists ) );
            this.tomNodeList.print_fromHead();
            assertEquals( 45, this.tomNodeList.networkSize() );
            this.tomNodeList.print_fromHead();
            assertTrue( this.tomNodeList.findAndRemove_duplicates() );
            this.tomNodeList.print_fromHead();
            assertEquals( 10, this.tomNodeList.networkSize() );

            this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
            this.tomNodeList = new NodeList( tomNodeListBackup );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }

            assertTrue( this.fyldtNodeList.copyListAndDelete_headTail( nodeLists ) );
            assertEquals( 50, this.fyldtNodeList.networkSize() );
            assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.fyldtNodeList.networkSize() );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }
            assertTrue( this.tomNodeList.copyListAndDelete_headTail( nodeLists ) );
            assertEquals( 45, this.tomNodeList.networkSize() );
            assertTrue( this.tomNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.tomNodeList.networkSize() );

            this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
            this.tomNodeList = new NodeList( tomNodeListBackup );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }
            assertTrue( this.fyldtNodeList.copyListAndDelete_headHead( nodeLists ) );
            assertEquals( 50, this.fyldtNodeList.networkSize() );
            assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.fyldtNodeList.networkSize() );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }
            assertTrue( this.tomNodeList.copyListAndDelete_headHead( nodeLists ) );
            assertEquals( 45, this.tomNodeList.networkSize() );
            assertTrue( this.tomNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.tomNodeList.networkSize() );

            this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
            this.tomNodeList = new NodeList( tomNodeListBackup );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }
            assertTrue( this.fyldtNodeList.copyListAndDelete_tailHead( nodeLists ) );
            assertEquals( 50, this.fyldtNodeList.networkSize() );
            assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.fyldtNodeList.networkSize() );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }
            assertTrue( this.tomNodeList.copyListAndDelete_tailHead( nodeLists ) );
            assertEquals( 45, this.tomNodeList.networkSize() );
            assertTrue( this.tomNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.tomNodeList.networkSize() );

            this.fyldtNodeList = new NodeList( fyldtNodeListBackup );
            this.tomNodeList = new NodeList( tomNodeListBackup );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }
        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };
            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }

            assertTrue( this.fyldtNodeList.copyListAndDelete_tailTail( nodeLists ) );
            assertEquals( 50, this.fyldtNodeList.networkSize() );
            assertTrue( this.fyldtNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.fyldtNodeList.networkSize() );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }
        }

        {
            nodeLists = new NodeList[]{
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup ),
                    new NodeList( fyldtNodeListBogBackup ),
                    new NodeList( fyldtNodeListBackup )
            };

            assertEquals( 9, nodeLists.length );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertEquals( 5, nodeLists[ i ].networkSize() );
            }
            assertTrue( this.tomNodeList.copyListAndDelete_tailTail( nodeLists ) );
            assertEquals( 45, this.tomNodeList.networkSize() );
            assertTrue( this.tomNodeList.findAndRemove_duplicates() );
            assertEquals( 10, this.tomNodeList.networkSize() );

            for ( int i = 0; i < nodeLists.length; i++ ) {
                assertNull( nodeLists[ i ].getHead() );
                assertNull( nodeLists[ i ].getTail() );
            }

        }
    }


    @Test
    void reverseNetwork() {
        System.out.println();
        System.out.println( "-----------REVERSE NETWORK-----------------" );

        String[] strings = this.fyldtNodeList.strings_fromHead();

        assertEquals( "0", strings[ 0 ] );
        assertEquals( "1", strings[ 1 ] );
        assertEquals( "2", strings[ 2 ] );
        assertEquals( "3", strings[ 3 ] );
        assertEquals( "4", strings[ 4 ] );

        System.out.println( "TAL: Before 1st Rotation" );
        this.fyldtNodeList.print_fromHead();
        assertTrue( this.fyldtNodeList.reverseNetwork() );
        System.out.println( "TAL: After 1st Rotation" );
        this.fyldtNodeList.print_fromHead();
        strings = this.fyldtNodeList.strings_fromHead();

        assertEquals( "4", strings[ 0 ] );
        assertEquals( "3", strings[ 1 ] );
        assertEquals( "2", strings[ 2 ] );
        assertEquals( "1", strings[ 3 ] );
        assertEquals( "0", strings[ 4 ] );

        System.out.println();

        System.out.println( "TAL: Before 2nd Rotation" );
        this.fyldtNodeList.print_fromHead();
        assertTrue( this.fyldtNodeList.reverseNetwork() );
        System.out.println( "TAL: After 2nd Rotation" );
        this.fyldtNodeList.print_fromHead();
        strings = this.fyldtNodeList.strings_fromHead();

        assertEquals( "0", strings[ 0 ] );
        assertEquals( "1", strings[ 1 ] );
        assertEquals( "2", strings[ 2 ] );
        assertEquals( "3", strings[ 3 ] );
        assertEquals( "4", strings[ 4 ] );


        //Bog bog bogb ogb ogb gobog bogb ogb gob
        System.out.println();
        System.out.println("---------");
        System.out.println();

        strings = this.fyldtNodeListBog.strings_fromHead();

        assertEquals( "A", strings[ 0 ] );
        assertEquals( "B", strings[ 1 ] );
        assertEquals( "C", strings[ 2 ] );
        assertEquals( "D", strings[ 3 ] );
        assertEquals( "E", strings[ 4 ] );

        System.out.println( "BOG: Before 1st Rotation" );
        this.fyldtNodeListBog.print_fromHead();
        assertTrue( this.fyldtNodeListBog.reverseNetwork() );
        System.out.println( "BOG: After 1st Rotation" );
        this.fyldtNodeListBog.print_fromHead();
        strings = this.fyldtNodeListBog.strings_fromHead();

        assertEquals( "E", strings[ 0 ] );
        assertEquals( "D", strings[ 1 ] );
        assertEquals( "C", strings[ 2 ] );
        assertEquals( "B", strings[ 3 ] );
        assertEquals( "A", strings[ 4 ] );

        System.out.println();

        System.out.println( "BOG: Before 2nd Rotation" );
        this.fyldtNodeListBog.print_fromHead();
        assertTrue( this.fyldtNodeListBog.reverseNetwork() );
        System.out.println( "BOG: After 2nd Rotation" );
        this.fyldtNodeListBog.print_fromHead();
        strings = this.fyldtNodeListBog.strings_fromHead();

        assertEquals( "A", strings[ 0 ] );
        assertEquals( "B", strings[ 1 ] );
        assertEquals( "C", strings[ 2 ] );
        assertEquals( "D", strings[ 3 ] );
        assertEquals( "E", strings[ 4 ] );


    }
}