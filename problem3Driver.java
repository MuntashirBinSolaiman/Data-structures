import java.util.ArrayList;
import java.util.Scanner;

public class problem3Driver {

    private static City[] citiesInRouteFile; // Cities held as per question
    private static ArrayList<City> flightRoute;// will hold the answer/route
    private static City from, to; // departure and destination

    public static void main( String[] args ){

        initialSetUp();
        getInputFromUser();
        flightRoute.add(from);
        bondingFunction(from, to, flightRoute);
        outputAnswer();
    }

    //Initialises variables and adds direct flights to the cities
    private static void initialSetUp(){

        citiesInRouteFile = new City[14];
        addCitiesWithDirectRouteToCities();
        flightRoute = new ArrayList<City>();
    }

    //Adds the direct flights for the given city
    private static void addCitiesWithDirectRouteToCities(){

        City paris = new City("Paris");
        citiesInRouteFile[0] = paris;
        City london = new City("London");
        citiesInRouteFile[1] = london;
        City amsterdam = new City("Amsterdam");
        citiesInRouteFile[2] = amsterdam;
        City newYork = new City("New York");
        citiesInRouteFile[3] = newYork;
        City sydney = new City("Sydney");
        citiesInRouteFile[4] = sydney;
        City bristol = new City("Bristol");
        citiesInRouteFile[5] = bristol;
        City johannesburg = new City("Johannesburg");
        citiesInRouteFile[6] = johannesburg;
        City melbourne = new City("Melbourne");
        citiesInRouteFile[7] = melbourne;
        City kuala = new City("Kuala Lumpur");
        citiesInRouteFile[8] = kuala;
        City brisbane = new City("Brisbane");
        citiesInRouteFile[9] = brisbane;
        City perth = new City("Perth");
        citiesInRouteFile[10] = perth;
        City delhi = new City("Delhi");
        citiesInRouteFile[11] = delhi;
        City beijing = new City("Beijing");
        citiesInRouteFile[12] = beijing;
        City california = new City("California");
        citiesInRouteFile[13] = california;


        london.addCitiesWithDirectRoute(paris);
        paris.addCitiesWithDirectRoute(london);
        amsterdam.addCitiesWithDirectRoute(bristol);
        bristol.addCitiesWithDirectRoute(london);
        london.addCitiesWithDirectRoute(amsterdam);
        amsterdam.addCitiesWithDirectRoute(london);
        london.addCitiesWithDirectRoute(johannesburg);
        johannesburg.addCitiesWithDirectRoute(london);
        johannesburg.addCitiesWithDirectRoute(perth);
        perth.addCitiesWithDirectRoute(johannesburg);
        sydney.addCitiesWithDirectRoute(brisbane);
        brisbane.addCitiesWithDirectRoute(sydney);
        brisbane.addCitiesWithDirectRoute(kuala);
        kuala.addCitiesWithDirectRoute(brisbane);
        sydney.addCitiesWithDirectRoute(newYork);
        newYork.addCitiesWithDirectRoute(sydney);
        newYork.addCitiesWithDirectRoute(california);
        california.addCitiesWithDirectRoute(newYork);
        brisbane.addCitiesWithDirectRoute(delhi);
        delhi.addCitiesWithDirectRoute(beijing);
        beijing.addCitiesWithDirectRoute(brisbane);
        perth.addCitiesWithDirectRoute(sydney);
        sydney.addCitiesWithDirectRoute(melbourne);
        melbourne.addCitiesWithDirectRoute(perth);
        beijing.addCitiesWithDirectRoute(sydney);
    }

    /* Gets departure and destination from the user.
       Responsible for assignment of from and to instance variables */
    private static void getInputFromUser( ){

        Scanner input = new Scanner(System.in);

        System.out.println( "Choose departure" );
        for (int index = 0; index < citiesInRouteFile.length; index++){

            System.out.println(index + ". " + citiesInRouteFile[index]);
        }
        int fromChosen = input.nextInt();
        from = citiesInRouteFile[fromChosen];
        System.out.println( "\nYou have chosen " + from + " as departure");


        System.out.println( "\nChoose destination" );
        for (int index = 0; index < citiesInRouteFile.length; index++){

            System.out.println(index + ". " + citiesInRouteFile[index]);
        }
        int toChosen = input.nextInt();
        to = citiesInRouteFile[toChosen];
        System.out.println( "\nYou have chosen " + to + " as destination" );

    }

    /* The recursive method.
        Checks if the destination is present in the citiesWithDirectRoute
        If not, it backtracks and the method is invoked recursively */
    public static boolean bondingFunction( City from, City to, ArrayList<City> flightRoute ) {

        if ( from.getCitiesWithDirectRoute( ).contains( to ) ) {
            flightRoute.add( to );
            return true;
        }
        else{

            for ( int index = 0; index < from.getCitiesWithDirectRoute( ).size( ); index++) {

                City checkCity = from.getCitiesWithDirectRoute( ).get( index );

                if (!flightRoute.contains(checkCity)) {

                    flightRoute.add(checkCity);
                    if (bondingFunction(checkCity, to, flightRoute))
                        return true;

                    flightRoute.remove(checkCity);
                }
            }
        }
        return false;

    }

    //Prints the flightRoute as the answer
    private static void outputAnswer( ) {

        System.out.println( "\nYour route is \n\n" + flightRoute );
    }
}
