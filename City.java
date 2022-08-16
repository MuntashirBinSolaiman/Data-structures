import java.util.*;

public class City
{
	private String name;
	private ArrayList<City> citiesWithDirectRoute;// Holds the direct flights that the city has
	
	public City( String name ){

		this.name = name;
		citiesWithDirectRoute = new ArrayList<City>();
	}

	//Adds cities with which it has a direct route to
	public void addCitiesWithDirectRoute( City formalParameter ){

		if ( formalParameter != this && formalParameter != null )
			citiesWithDirectRoute.add(formalParameter);
	}

	//Returns the list of cities with which it has direct route
	public ArrayList<City> getCitiesWithDirectRoute() {

		return citiesWithDirectRoute;
	}

	//toString which simply returns the name of the city object
	public String toString(){
		return name;
	}
}