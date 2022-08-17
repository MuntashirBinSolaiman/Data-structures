package Problem4;

import java.util.Scanner;

public class ApplicationDriver{

    private static String from;
    private static String to;

    public static void main( String[] args ){

        Graph instance = new Graph();

        instance.createGraph();

        getInputFromUser();

        System.out.println( "\n" + instance.printDistance( from, to ) );
    }

    private static void getInputFromUser( ){

        Scanner input = new Scanner(System.in);

        System.out.println( "Choose departure" );
        for (int index = 0; index < Graph.cityInRouteFile.size(); index++){

            System.out.println(index + ". " + Graph.cityInRouteFile.get(index) );
        }
        int fromChosen = input.nextInt();
        from = Graph.cityInRouteFile.get( fromChosen );
        System.out.println( "\nYou have chosen " + from + " as departure");


        System.out.println( "\nChoose destination" );
        for (int index = 0; index < Graph.cityInRouteFile.size(); index++){

            System.out.println(index + ". " + Graph.cityInRouteFile.get(index) );
        }
        int toChosen = input.nextInt();
        to = Graph.cityInRouteFile.get( toChosen );
        System.out.println( "\nYou have chosen " + to + " as destination" );
    }
}
