package assn2.yw;

import java.security.InvalidParameterException;
import java.util.*;

public class MovieStore {
    private PriorityQueue<Movie> maxMovieHeap = new PriorityQueue<Movie>(new MovieComparator());
    private HashMap<String,Integer> movieTitles= new HashMap<String, Integer>();

    class MovieComparator implements Comparator<Movie> {
        @Override
        public int compare(Movie movie1, Movie movie2) {
            Double m1 = movie1.getAvgRate()==null ? -1 : movie1.getAvgRate();
            Double m2 = movie2.getAvgRate()==null ? -1 : movie2.getAvgRate();
            return m2.compareTo(m1);
        }
    }
    
    public void addMovie(Movie movie) throws InvalidParameterException {
        if(!movieTitles.containsKey(movie.getTitle())){
            maxMovieHeap.add(movie);
            movieTitles.put(movie.getTitle(), 1);
        }else{
            throw new InvalidParameterException("Movie already exists!");
        }
    }

    public List<Movie> getTopMovies(){
        Iterator<Movie> iterator = maxMovieHeap.iterator();
        List<Movie> copy = new ArrayList<Movie>();
        while(iterator.hasNext()){
            copy.add(iterator.next().clone());
        }
        return copy;
    }

    public List<Movie> getTopMovies(int top){
        Iterator<Movie> iterator = maxMovieHeap.iterator();
        List<Movie> copy = new ArrayList<Movie>();
        while(iterator.hasNext() && top > 0){
            copy.add(iterator.next().clone());
            top -= 1;
        }
        return copy;
    }
    

}
