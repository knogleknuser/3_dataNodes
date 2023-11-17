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
        node0.print_towardsFromHead();
        //Back to Front
        System.out.println();
        System.out.println( "Print from Tail" );
        node4.print_towardsFromTail();

        //Front to back
        System.out.println();
        System.out.println( "Print from Head, with a random node as input" );
        node3.print_towardsFromHead();
        //Back to Front
        System.out.println();
        System.out.println( "Print from Tail, with a random node as input" );
        node2.print_towardsFromTail();



        //Get Head or Tail
        //Get Head
        System.out.println();
        System.out.println( "Get Head" );
        System.out.println( Node.findHead( node2 ).data );
        //Tail
        System.out.println();
        System.out.println( "Get Tail" );
        System.out.println( Node.findTail( node2 ).data );







        //NodeList
        NodeList nodeList = new NodeList( node3 );

        System.out.println();
        System.out.println( "Print from Head NodeList" );
        nodeList.print_fromHead();


        Node nodeN1 = new Node( "-1" );
        nodeList.insertNode_asHead( nodeN1 );

        System.out.println();
        System.out.println( "Print from Head NodeList new Start Node" );
        nodeList.print_fromHead();

        Node node5 = new Node( "5" );
        nodeList.insertNode_asTail( node5 );

        System.out.println();
        System.out.println( "Print from Head NodeList new Tail Node" );
        nodeList.print_fromHead();





    } //Main


} //Class