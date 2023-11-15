import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        //Set up getData() structure
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
        assertTrue( this.tomNodeList.listHas_zeroNodes() );

        assertNull( this.tomNodeList.getHead() );

        assertNull( this.tomNodeList.getTail() );

    }

    @Test
    void insertFromHeadEmpty() {
        this.tomNodeList.insertNode_asHead( this.node0 );

        assertFalse( this.tomNodeList.listHas_zeroNodes() );

        assertEquals( this.node0.getData(), this.tomNodeList.getHead().getData() );

        assertEquals( this.node0.getData(), this.tomNodeList.getTail().getData() );
    }

    @Test
    void insertFromTailEmpty() {
        this.tomNodeList.insertNode_asTail( this.node0 );

        assertFalse( this.tomNodeList.listHas_zeroNodes() );

        assertEquals( this.node0.getData(), this.tomNodeList.getHead().getData() );

        assertEquals( this.node0.getData(), this.tomNodeList.getTail().getData() );
    }

    @Test
    void testFyldtListe() {
        //Get Head or Tail
        //Get Head
        assertEquals( this.node0.getData(), this.fyldtNodeList.getHead().getData() );

        //Tail
        assertEquals( this.node4.getData(), this.fyldtNodeList.getTail().getData() );


    }

    @Test
    void testGetHeadArrayList() {
        //Get Head or Tail ArrayList
        //Get Head
        ArrayList< Node > arrayListFromHead = new ArrayList<>();
        arrayListFromHead.add( this.node0 );
        arrayListFromHead.add( this.node1 );
        arrayListFromHead.add( this.node2 );
        arrayListFromHead.add( this.node3 );
        arrayListFromHead.add( this.node4 );

        //ListeArray
        ArrayList< Node > ListeHeadArrayList = this.fyldtNodeList.fromHead_ArrayList();

        //Test
        for ( int i = 0; i < ListeHeadArrayList.size(); i++ ) {
            assertEquals( arrayListFromHead.get( i ).getData(), ListeHeadArrayList.get( i ).getData() );
        }

        assertTrue( NodeList.isSameNetwork( arrayListFromHead, ListeHeadArrayList ) );
    }


    @Test
    void testGetTailArrayList() {
        //Tail
        ArrayList< Node > arrayListFromTail = new ArrayList<>();
        arrayListFromTail.add( this.node4 );
        arrayListFromTail.add( this.node3 );
        arrayListFromTail.add( this.node2 );
        arrayListFromTail.add( this.node1 );
        arrayListFromTail.add( this.node0 );

        //ListeArray
        ArrayList< Node > ListeTailArrayList = this.fyldtNodeList.fromTail_ArrayList();

        //Test
        for ( int i = 0; i < ListeTailArrayList.size(); i++ ) {
            assertEquals( arrayListFromTail.get( i ).getData(), ListeTailArrayList.get( i ).getData() );
        }

        assertTrue( NodeList.isSameNetwork( arrayListFromTail, ListeTailArrayList ) );

    }

    @Test
    void insertFromHead() {
        this.fyldtNodeList.insertNode_asHead( this.node2 );

        assertEquals( this.node2.getData(), this.fyldtNodeList.getHead().getData() );

        //Head
        ArrayList< Node > arrayListFromHead = new ArrayList<>();
        arrayListFromHead.add( this.node2 );
        arrayListFromHead.add( this.node0 );
        arrayListFromHead.add( this.node1 );
        arrayListFromHead.add( this.node3 );
        arrayListFromHead.add( this.node4 );

        //ListeArray
        ArrayList< Node > ListeHeadArrayList = this.fyldtNodeList.fromHead_ArrayList();

        //Test
        for ( int i = 0; i < ListeHeadArrayList.size(); i++ ) {
            assertEquals( arrayListFromHead.get( i ).getData(), ListeHeadArrayList.get( i ).getData() );
        }

        assertTrue( NodeList.isSameNetwork( arrayListFromHead, ListeHeadArrayList ) );

        assertEquals( this.node3.getData(), this.fyldtNodeList.insertNode_asHead( this.node3 ).getData() );
        assertEquals( this.fyldtNodeList.getHead().getData(), this.fyldtNodeList.insertNode_asHead( this.node3 ).getData() );
        assertEquals( this.node3.getData(), this.fyldtNodeList.getHead().getData() );

        //Is Tail unchanged?
        assertEquals( this.node4.getData(), this.fyldtNodeList.getTail().getData() );


    }

    @Test
    void testInsertFromTail() {
        this.fyldtNodeList.insertNode_asTail( this.node2 );

        assertEquals( this.node2.getData(), this.fyldtNodeList.getTail().getData() );

        //Tail
        ArrayList< Node > arrayListFromTail = new ArrayList<>();
        arrayListFromTail.add( this.node2 );
        arrayListFromTail.add( this.node4 );
        arrayListFromTail.add( this.node3 );
        arrayListFromTail.add( this.node1 );
        arrayListFromTail.add( this.node0 );

        //ListeArray
        ArrayList< Node > ListeTailArrayList = this.fyldtNodeList.fromTail_ArrayList();

        //Test
        for ( int i = 0; i < ListeTailArrayList.size(); i++ ) {
            assertEquals( arrayListFromTail.get( i ).getData(), ListeTailArrayList.get( i ).getData() );
        }

        assertTrue( NodeList.isSameNetwork( arrayListFromTail, ListeTailArrayList ) );

        assertEquals( this.node3.getData(), this.fyldtNodeList.insertNode_asTail( this.node3 ).getData() );
        assertEquals( this.fyldtNodeList.getTail().getData(), this.fyldtNodeList.insertNode_asTail( this.node3 ).getData() );
        assertEquals( this.node3.getData(), this.fyldtNodeList.getTail().getData() );

        //Is head unchanged?
        assertEquals( this.node0.getData(), this.fyldtNodeList.getHead().getData() );

    }

    @Test
    void testIsOnlyOne() {
        assertFalse( this.tomNodeList.listHas_oneNode() );

        NodeList oneNodeList = new NodeList( new Node( "111111" ) );
        assertTrue( oneNodeList.listHas_oneNode() );

        NodeList twoNodeList = new NodeList( new Node( "111111" ) );
        twoNodeList.insertNode_asHead( new Node( "222222" ) );
        assertFalse( twoNodeList.listHas_oneNode() );
    }

    @Test
    void testRemoveFromHead() {
        System.out.println( "-----------REMOVED FROM HEAD-----------------" );
        System.out.println();
        System.out.println( "Before 2 removals from head" );
        this.fyldtNodeList.fromHead_print();

        assertNotEquals( null, this.fyldtNodeList.removeNode_head() );
        assertNotEquals( null, this.fyldtNodeList.removeNode_head() );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed from head" );
        this.fyldtNodeList.fromHead_print();

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed from head" );
        this.fyldtNodeList.fromHead_print();

        assertNotEquals( null, this.fyldtNodeList.removeNode_head() );
        assertNotEquals( null, this.fyldtNodeList.removeNode_head() );
        assertNotEquals( null, this.fyldtNodeList.removeNode_head() );
        assertNull( this.fyldtNodeList.removeNode_head() );
        assertNull( this.fyldtNodeList.removeNode_head() );

        assertNull( this.tomNodeList.removeNode_head() );

        this.tomNodeList.insertNode_asHead( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeNode_head() );
        assertNull( this.tomNodeList.removeNode_head() );

        this.tomNodeList.insertNode_asHead( this.node2 );
        this.tomNodeList.insertNode_asHead( this.node2 );
        this.tomNodeList.insertNode_asHead( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeNode_head() );
        assertNull( this.tomNodeList.removeNode_head() );

        this.tomNodeList.insertNode_asHead( this.node2 );
        this.tomNodeList.insertNode_asHead( this.node4 );
        assertNotEquals( null, this.tomNodeList.removeNode_head() );
        assertNotEquals( null, this.tomNodeList.removeNode_head() );
        assertNull( this.tomNodeList.removeNode_head() );
    }

    @Test
    void removeFromTail() {
        System.out.println( "-----------REMOVED FROM TAIL-----------------" );
        System.out.println();
        System.out.println( "Before 2 removals from tail" );
        this.fyldtNodeList.fromHead_print();

        assertNotEquals( null, this.fyldtNodeList.removeNode_tail() );
        assertNotEquals( null, this.fyldtNodeList.removeNode_tail() );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed from tail" );
        this.fyldtNodeList.fromHead_print();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed from tail" );
        this.fyldtNodeList.fromTail_print();

        assertNotEquals( null, this.fyldtNodeList.removeNode_tail() );
        assertNotEquals( null, this.fyldtNodeList.removeNode_tail() );
        assertNotEquals( null, this.fyldtNodeList.removeNode_tail() );
        assertNull( this.fyldtNodeList.removeNode_tail() );
        assertNull( this.fyldtNodeList.removeNode_tail() );

        assertNull( this.tomNodeList.removeNode_tail() );

        this.tomNodeList.insertNode_asTail( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeNode_tail() );
        assertNull( this.tomNodeList.removeNode_tail() );

        this.tomNodeList.insertNode_asHead( this.node2 );
        this.tomNodeList.insertNode_asTail( this.node2 );
        this.tomNodeList.insertNode_asHead( this.node2 );
        assertNotEquals( null, this.tomNodeList.removeNode_tail() );
        assertNull( this.tomNodeList.removeNode_tail() );

        this.tomNodeList.insertNode_asTail( this.node2 );
        this.tomNodeList.insertNode_asHead( this.node4 );
        assertNotEquals( null, this.tomNodeList.removeNode_tail() );
        assertNotEquals( null, this.tomNodeList.removeNode_tail() );
        assertNull( this.tomNodeList.removeNode_tail() );
    }

    @Test
    void testGetHeadAndRemoveIt() {
        Node headRes = this.fyldtNodeList.getHead();
        assertEquals( "0", this.fyldtNodeList.getHead().getData() );

        Node newHeadRes = this.fyldtNodeList.getHead().next;
        assertEquals( headRes.getData(), this.fyldtNodeList.removeNode_head().getData() );
        assertEquals( newHeadRes.getData(), this.fyldtNodeList.getHead().getData() );

        assertNotEquals( headRes.getData(), this.fyldtNodeList.removeNode_head().getData() );
        assertNotEquals( newHeadRes.getData(), this.fyldtNodeList.getHead().getData() );

        assertNull( this.tomNodeList.removeNode_head() );
    }

    @Test
    void testGetTailAndRemoveIt() {
        Node tailRes = this.fyldtNodeList.getTail();
        assertEquals( "4", this.fyldtNodeList.getTail().getData() );

        Node newTailRes = this.fyldtNodeList.getTail().previous;
        assertEquals( tailRes.getData(), this.fyldtNodeList.removeNode_tail().getData() );
        assertEquals( newTailRes.getData(), this.fyldtNodeList.getTail().getData() );

        assertNotEquals( tailRes.getData(), this.fyldtNodeList.removeNode_tail().getData() );
        assertNotEquals( newTailRes.getData(), this.fyldtNodeList.getTail().getData() );

        assertNull( this.tomNodeList.removeNode_tail() );
    }

    @Test
    void testGetNodeWithDataFromHead() {
        assertNull( this.fyldtNodeList.fromHead_find( "-1" ) );
        assertEquals( this.node0, this.fyldtNodeList.fromHead_find( "0" ) );
        assertEquals( this.node1, this.fyldtNodeList.fromHead_find( "1" ) );
        assertEquals( this.node2, this.fyldtNodeList.fromHead_find( "2" ) );
        assertEquals( this.node3, this.fyldtNodeList.fromHead_find( "3" ) );
        assertEquals( this.node4, this.fyldtNodeList.fromHead_find( "4" ) );
        assertNull( this.fyldtNodeList.fromHead_find( "5" ) );
    }

    @Test
    void testGetNodeWithDataFromTail() {
        assertNull( this.fyldtNodeList.fromTail_find( "-1" ) );
        assertEquals( this.node0, this.fyldtNodeList.fromTail_find( "0" ) );
        assertEquals( this.node1, this.fyldtNodeList.fromTail_find( "1" ) );
        assertEquals( this.node2, this.fyldtNodeList.fromTail_find( "2" ) );
        assertEquals( this.node3, this.fyldtNodeList.fromTail_find( "3" ) );
        assertEquals( this.node4, this.fyldtNodeList.fromTail_find( "4" ) );
        assertNull( this.fyldtNodeList.fromTail_find( "5" ) );
    }

    @Test
    void testGetNodeWithDataFromHeadAndRemoveIt() {
        System.out.println( "-----------REMOVE SPECIFIC NODES FROM HEAD-----------------" );
        System.out.println();
        System.out.println( "Before node 2 removed" );
        this.fyldtNodeList.fromHead_print();

        assertEquals( this.node2, this.fyldtNodeList.fromHead_findAndRemove( "2" ) );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed" );
        this.fyldtNodeList.fromHead_print();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed" );
        this.fyldtNodeList.fromTail_print();

        assertEquals( this.node0.getData(), this.fyldtNodeList.fromHead_findAndRemove( "0" ).getData() );
        assertEquals( this.node1.getData(), this.fyldtNodeList.getHead().getData() );

        assertEquals( this.node4.getData(), this.fyldtNodeList.fromHead_findAndRemove( "4" ).getData() );
        assertEquals( this.node3.getData(), this.fyldtNodeList.getTail().getData() );

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.fromHead_print();

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.fromTail_print();

        assertNull( this.fyldtNodeList.fromHead_findAndRemove( "-1" ) );
        assertNull( this.fyldtNodeList.fromHead_findAndRemove( "0" ) );
        assertEquals( this.node1.getData(), this.fyldtNodeList.fromHead_findAndRemove( "1" ).getData() );
        assertNull( this.fyldtNodeList.fromHead_findAndRemove( "2" ) );
        assertEquals( this.node3.getData(), this.fyldtNodeList.fromHead_findAndRemove( "3" ).getData() );
        assertNull( this.fyldtNodeList.fromHead_findAndRemove( "4" ) );
        assertNull( this.fyldtNodeList.fromHead_findAndRemove( "5" ) );

        assertTrue( this.fyldtNodeList.listHas_zeroNodes() );

        this.fyldtNodeList.insertNode_asHead( this.node2 );
        assertEquals( this.fyldtNodeList.getHead().getData(), this.node2.getData() );
        assertEquals( this.fyldtNodeList.getTail().getData(), this.node2.getData() );

        System.out.println();
        System.out.println( "Reduced List reinserted node 2, from head" );
        this.fyldtNodeList.fromHead_print();
    }

    @Test
    void testGetNodeWithDataFromTailAndRemoveIt() {
        System.out.println( "-----------REMOVE SPECIFIC NODES FROM TAIL-----------------" );
        System.out.println();
        System.out.println( "Before node 2 removed" );
        this.fyldtNodeList.fromHead_print();

        assertEquals( this.node2, this.fyldtNodeList.fromTail_findAndRemove( "2" ) );

        System.out.println();
        System.out.println( "Reduced List printed from head, 2 removed" );
        this.fyldtNodeList.fromHead_print();

        System.out.println();
        System.out.println( "Reduced List printed from tail, 2 removed" );
        this.fyldtNodeList.fromTail_print();

        assertEquals( this.node0.getData(), this.fyldtNodeList.fromTail_findAndRemove( "0" ).getData() );
        assertEquals( this.node1.getData(), this.fyldtNodeList.getHead().getData() );

        assertEquals( this.node4.getData(), this.fyldtNodeList.fromTail_findAndRemove( "4" ).getData() );
        assertEquals( this.node3.getData(), this.fyldtNodeList.getTail().getData() );

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.fromHead_print();

        System.out.println();
        System.out.println( "Reduced List printed from head, only 1 and 3 left" );
        this.fyldtNodeList.fromTail_print();


        assertNull( this.fyldtNodeList.fromTail_findAndRemove( "-1" ) );
        assertNull( this.fyldtNodeList.fromTail_findAndRemove( "0" ) );
        assertEquals( this.node1, this.fyldtNodeList.fromTail_findAndRemove( "1" ) );
        assertNull( this.fyldtNodeList.fromTail_findAndRemove( "2" ) );
        assertEquals( this.node3, this.fyldtNodeList.fromTail_findAndRemove( "3" ) );
        assertNull( this.fyldtNodeList.fromTail_findAndRemove( "4" ) );
        assertNull( this.fyldtNodeList.fromTail_findAndRemove( "5" ) );

        assertTrue( this.fyldtNodeList.listHas_zeroNodes() );

        this.fyldtNodeList.insertNode_asTail( this.node2 );
        assertEquals( this.fyldtNodeList.getHead().getData(), this.node2.getData() );
        assertEquals( this.fyldtNodeList.getTail().getData(), this.node2.getData() );

        System.out.println();
        System.out.println( "Reduced List reinserted node 2, from head" );
        this.fyldtNodeList.fromHead_print();
    }

    @Test
    void testCanMoveBetweenLists() {
        System.out.println();
        System.out.println( "-----------REMOVE NODES BETWEEN LISTS-----------------" );
        assertEquals( this.node2.getData(), this.tomNodeList.insertNode_asHead( this.node2 ).getData() );
        assertEquals( this.node3.getData(), this.tomNodeList.insertNode_asTail( this.node3 ).getData() );

        System.out.println();
        System.out.println( "Added node 2 and 3 to empty List" );
        System.out.println( "ArrayList of empty nodelist" );
        assertEquals( 2, this.tomNodeList.fromTail_ArrayList().size() );
        ArrayList< Node > nodes = this.tomNodeList.fromTail_ArrayList();
        for ( Node node : nodes ) {
            System.out.println( node.data );
        }

        System.out.println();
        System.out.println( "empty node list, 2,3" );
        this.tomNodeList.fromHead_print();
        System.out.println("Now in reverse order");
        this.tomNodeList.fromTail_print();

        System.out.println();
        System.out.println( "filled node list, 4,1,0" );
        this.fyldtNodeList.fromTail_print();
        System.out.println("Now in reverse order");
        this.fyldtNodeList.fromHead_print();

        this.tomNodeList.insertNode_afterThisNode( this.node4, this.node2 );

        System.out.println();
        System.out.println( "empty node list, 2, 4, 3" );
        this.tomNodeList.fromHead_print();
        System.out.println("Now in reverse order");
        this.tomNodeList.fromTail_print();

        System.out.println();
        System.out.println( "filled node list, 1,0" );
        this.fyldtNodeList.fromTail_print();
        System.out.println("Now in reverse order");
        this.fyldtNodeList.fromHead_print();

        this.fyldtNodeList.insertNode_beforeThisNode( this.node4, this.node1 );

        System.out.println();
        System.out.println( "empty node list, 2, 3" );
        this.tomNodeList.fromHead_print();
        System.out.println("Now in reverse order");
        this.tomNodeList.fromTail_print();

        System.out.println();
        System.out.println( "filled node list, 1,4,0" );
        this.fyldtNodeList.fromTail_print();
        System.out.println("Now in reverse order");
        this.fyldtNodeList.fromHead_print();

        this.tomNodeList.insertNode_afterThisNode( this.node0, this.node3 );

        System.out.println();
        System.out.println( "empty node list, 2, 3, 0" );
        this.tomNodeList.fromHead_print();
        System.out.println("Now in reverse order");
        this.tomNodeList.fromTail_print();

        System.out.println();
        System.out.println( "filled node list, 1, 4" );
        this.fyldtNodeList.fromTail_print();
        System.out.println("Now in reverse order");
        this.fyldtNodeList.fromHead_print();


        this.fyldtNodeList.insertNode_beforeThisNode( this.node0, this.node1 );

        System.out.println();
        System.out.println( "empty node list, 2, 3" );
        this.tomNodeList.fromHead_print();
        System.out.println("Now in reverse order");
        this.tomNodeList.fromTail_print();

        System.out.println();
        System.out.println( "filled node list, 1, 0, 4" );
        this.fyldtNodeList.fromTail_print();
        System.out.println("Now in reverse order");
        this.fyldtNodeList.fromHead_print();

        assertEquals( this.node0, this.fyldtNodeList.insertNode_beforeThisNode( this.node0, this.node0 ) );
        assertEquals( this.node0, this.fyldtNodeList.insertNode_afterThisNode( this.node0, this.node0 ) );
        assertEquals( this.node0, this.tomNodeList.insertNode_beforeThisNode( this.node0, this.node0 ) );
        assertEquals( this.node0, this.tomNodeList.insertNode_afterThisNode( this.node0, this.node0 ) );

        this.tomNodeList.insertNode_afterThisNode( this.node1, this.node3 );

        System.out.println();
        System.out.println( "empty node list, 2, 3, 1" );
        this.tomNodeList.fromHead_print();
        System.out.println("Now in reverse order");
        this.tomNodeList.fromTail_print();

        System.out.println();
        System.out.println( "filled node list, 0,4" );
        this.fyldtNodeList.fromTail_print();
        System.out.println("Now in reverse order");
        this.fyldtNodeList.fromHead_print();


        this.fyldtNodeList.insertNode_beforeThisNode( this.node1, this.node0 );

        System.out.println();
        System.out.println( "empty node list, 2, 3" );
        this.tomNodeList.fromHead_print();
        System.out.println("Now in reverse order");
        this.tomNodeList.fromTail_print();

        System.out.println();
        System.out.println( "filled node list, 0, 1, 4" );
        this.fyldtNodeList.fromTail_print();
        System.out.println("Now in reverse order");
        this.fyldtNodeList.fromHead_print();

        this.fyldtNodeList.insertNode_beforeThisNode( this.node3, this.node0 );
        this.fyldtNodeList.insertNode_afterThisNode( this.node2, this.node4 );
        assertEquals( this.fyldtNodeList.getHead(),this.tomNodeList.getHead() );
        assertEquals( this.fyldtNodeList.getTail(),this.tomNodeList.getTail() );
        assertEquals( 5, this.fyldtNodeList.fromTail_ArrayList().size() );

        this.tomNodeList.insertNode_asHead( this.node3 );
        this.tomNodeList.insertNode_asTail( this.node2 );
        assertEquals( this.fyldtNodeList.getHead(),this.tomNodeList.getHead() );
        assertEquals( this.fyldtNodeList.getTail(),this.tomNodeList.getTail() );
        assertEquals( 5, this.fyldtNodeList.fromHead_ArrayList().size() );
    }
}