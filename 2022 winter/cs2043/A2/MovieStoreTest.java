package assn2.yw;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.api.Test;

public class MovieStoreTest {
	
	@Test
	void testAddSameMovieException() {
		Movie m1 = new Movie("movie");
		Movie m2 = new Movie("movie");
		MovieStore ms = new MovieStore();
		ms.addMovie(m1);
		Exception exception = assertThrows(
				InvalidParameterException.class,
				() -> ms.addMovie(m2)
	     );
		assertEquals("Movie already exists!",exception.getMessage());
	}
	
	@Test
	void testGetTopMoviesEmptyList() {
		MovieStore ms = new MovieStore();
		assertEquals(new ArrayList<Movie>(),ms.getTopMovies());
	}
	
	@Test
	void testGetTopMoviesMoreThanMovieSize() {
		Movie m1 = new Movie("movie1");
		Movie m2 = new Movie("movie2");
		m2.addRate(4);
		m1.addRate(1);
		MovieStore ms = new MovieStore();
		ms.addMovie(m1);
		ms.addMovie(m2);
		List<Movie> result = new ArrayList<Movie>();
		result.add(m2);
		result.add(m1);
		assertEquals(result,ms.getTopMovies(4));
	}
	
	@Test
	void testGetTopMoviesWithNullRate() {
		Movie m1 = new Movie("movie1");
		Movie m2 = new Movie("movie2");
		m2.addRate(0);
		MovieStore ms = new MovieStore();
		ms.addMovie(m1);
		ms.addMovie(m2);
		List<Movie> result = new ArrayList<Movie>();
		result.add(m2);
		result.add(m1);
		assertEquals(result,ms.getTopMovies(2));
	}
	
	@Test
	void testGetTopMoviesWithAllNullRate() {
		Movie m1 = new Movie("movie1");
		Movie m2 = new Movie("movie2");
		MovieStore ms = new MovieStore();
		ms.addMovie(m1);
		ms.addMovie(m2);
		List<Movie> result = new ArrayList<Movie>();
		result.add(m1);
		result.add(m2);
		assertEquals(result,ms.getTopMovies(2));
	}
	
	@Test
	void testGetAllMovies() {
		Movie m1 = new Movie("movie1");
		Movie m2 = new Movie("movie2");
		m2.addRate(4);
		m1.addRate(5);
		MovieStore ms = new MovieStore();
		ms.addMovie(m1);
		ms.addMovie(m2);
		List<Movie> result = new ArrayList<Movie>();
		result.add(m1);
		result.add(m2);
		assertEquals(result.size(),ms.getTopMovies().size());
	}
	
	@Test
	void testGetTopMovies() {
		Movie m1 = new Movie("movie1");
		Movie m2 = new Movie("movie2");
		Movie m3 = new Movie("movie3");
		Movie m4 = new Movie("movie4");
		m1.addRate(4);
		m2.addRate(3);
		m3.addRate(2);
		m4.addRate(1);
	
		MovieStore ms = new MovieStore();
		ms.addMovie(m1);
		ms.addMovie(m2);
		ms.addMovie(m3);
		ms.addMovie(m4);
		List<Movie> result = new ArrayList<Movie>();
		result.add(m1);
		result.add(m2);
		result.add(m3);
		assertEquals(result,ms.getTopMovies(3));
	}
	
	@Test
	void testIfReturnCopies() {
		Movie m1 = new Movie("movie1");
		m1.addRate(4);
		MovieStore ms = new MovieStore();
		ms.addMovie(m1);
		Movie mModified = ms.getTopMovies().get(0);
		mModified.clearRates();
		assertEquals(4.0, ms.getTopMovies().get(0).getAvgRate());
	}

}
