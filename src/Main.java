import java.util.ArrayList;

public class Main {
    public static void main( String[] args ) {
        //Make some nodes
        Node node0 = new Node( "0" );
        Node node1 = new Node( "1" );
        Node node2 = new Node( "2" );
        Node node3 = new Node( "3" );
        Node node4 = new Node( "4" );

        //Set up data structure
        node0.next = node1;
        node1.previous = node0;

        node1.next = node2;
        node2.previous = node1;

        node2.next = node3;
        node3.previous = node2;

        node3.next = node4;
        node4.previous = node3;



        //Print
        //Front to back
        System.out.println( "Print from Head" );
        NodeList.fromHead_print( node0 );
        //Back to Front
        System.out.println();
        System.out.println( "Print from Tail" );
        NodeList.fromTail_print( node4 );

        //Front to back
        System.out.println();
        System.out.println( "Print from Head, with a random node as input" );
        NodeList.fromHead_print( node3 );
        //Back to Front
        System.out.println();
        System.out.println( "Print from Tail, with a random node as input" );
        NodeList.fromTail_print( node2 );



        //Get Head or Tail
        //Get Head
        System.out.println();
        System.out.println( "Get Head" );
        System.out.println( NodeList.fromNode_findHead( node2 ).data );
        //Tail
        System.out.println();
        System.out.println( "Get Tail" );
        System.out.println( NodeList.fromNode_findTail( node2 ).data );



        //Get Head or Tail ArrayList
        ArrayList< Node > headArrayList;
        ArrayList< Node > tailArrayList;

        //Get Head
        System.out.println( "Get ArrayList From Head" );
        headArrayList = NodeList.fromHead_ArrayList( node2 );
        System.out.println( headArrayList );
        for ( Node node : headArrayList ) {
            System.out.println( node.data );
        }
        //Tail
        System.out.println();
        System.out.println( "Get ArrayList From Tail" );
        tailArrayList = NodeList.fromTail_ArrayList( node2 );
        System.out.println( tailArrayList );
        for ( Node node : tailArrayList ) {
            System.out.println( node.data );
        }








        //NodeList
        NodeList nodeList = new NodeList( node3 );

        System.out.println();
        System.out.println( "Print from Head NodeList" );
        nodeList.fromHead_print();


        Node nodeN1 = new Node( "-1" );
        nodeList.insertNode_asHead( nodeN1 );

        System.out.println();
        System.out.println( "Print from Head NodeList new Start Node" );
        nodeList.fromHead_print();

        Node node5 = new Node( "5" );
        nodeList.insertNode_asTail( node5 );

        System.out.println();
        System.out.println( "Print from Head NodeList new Tail Node" );
        nodeList.fromHead_print();



        //Get Head or Tail ArrayList with duplicate insertions
        nodeList.insertNode_asHead( node3 );
        nodeList.insertNode_asHead( node5 );
        nodeList.insertNode_asHead( node0 );
        nodeList.insertNode_asHead( nodeN1 );

        //Get Head
        System.out.println();
        System.out.println( "Get ArrayList From Head with duplicate node insertions" );
        headArrayList = nodeList.fromHead_ArrayList();

        System.out.println( headArrayList );
        for ( Node node : headArrayList ) {
            System.out.println( node.data );
        }
        //Tail
        System.out.println();
        System.out.println( "Get ArrayList From Tail with duplicate node insertions" );
        tailArrayList = nodeList.fromTail_ArrayList();

        System.out.println( tailArrayList );
        for ( Node node : tailArrayList ) {
            System.out.println( node.data );
        }

    } //Main


} //Class