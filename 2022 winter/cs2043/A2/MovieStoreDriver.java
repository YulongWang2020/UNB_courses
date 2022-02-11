package assn2.yw;

import java.security.InvalidParameterException;
import java.util.List;

public class MovieStoreDriver {
    public static void main(String[] args) {
        Movie m1 = new Movie("Star Wars");
        MovieStore list = new MovieStore();
        list.addMovie(m1);
        try{
        	m1.addRate(4);
        	m1.addRate(4);
        	m1.addRate(5);
        }catch(InvalidParameterException e){
        	System.out.println(e.getMessage());
        }
        
        Movie m2 = new Movie("Star Trek");
        list.addMovie(m2);
        m2.addRate(2);
        
        Movie m3 = new Movie("A Few Good Men");
        list.addMovie(m3);
        
        Movie m4 = new Movie("Enders Game");
        m4.addRate(5);
        list.addMovie(m4);
        
        try{
        	Movie m5 = new Movie("Star Trek");
            list.addMovie(m5);
        }catch(InvalidParameterException e){
            System.out.println(e.getMessage());
        }

        List<Movie> tempList1 = list.getTopMovies();
        System.out.printf("All Movies -  %d in total: \n",tempList1.size());
        for(Movie m : tempList1){
            System.out.println(m.toString());
        }

        System.out.println();

        List<Movie> tempList2 = list.getTopMovies(2);
        System.out.println("Top 2 Rated Movies: ");
        for(Movie m : tempList2){
            System.out.println(m.toString());
        }
    }
    
    
}
