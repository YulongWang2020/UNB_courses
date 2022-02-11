import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Creates a report on movies.
 *
 * @author Yulong Wang
 * @date 2021/10/20
 */
public class MovieReporter {
	/**
	 * @param args Terminal parameters
	 */
	public static void main(String[] args) {
		//create a set to organize Genres
		GenreSet genres = new GenreSet();
		File reader = new File("genrerating.txt");
		File writer = new File("errorLog.txt");
		try{
			Scanner sc = new Scanner(reader).useDelimiter("[~|\\n]");
			sc.nextLine();
			PrintWriter pw = new PrintWriter(writer);
//			skip the first line
			int lineNumber = 1;
//			read the file
			while(sc.hasNext()){
				lineNumber++;
				try{
					String genreName = sc.next(".+");
					double totalPoints = sc.nextDouble();
					int ratings = sc.nextInt();
					String movieName = sc.next(".+");
					Movie movie = new Movie(movieName,totalPoints,ratings);
					Genre g = new Genre(genreName);
					try{
						genres.addGenre(g);
					}catch (DuplicateGenreException e){
						g = genres.get(genres.genreIndex(g));
					}
					try{
						g.addMovie(movie);
					}catch (DuplicateMovieException e){
						pw.println(e.getMessage());
					}
				}catch(InputMismatchException e){
					pw.println("problem reading line: "+lineNumber);
//					skip this line
					sc.nextLine();
				}
			}
			pw.close();
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Not able to write or read to/from the file.");
		}
		genres.sort();
		System.out.println("TOP MOVIE GENRES");
		System.out.println("==========================================");
		for(int i=genres.length()-1;i>-1;i--){
			Genre foo = genres.get(i);
			System.out.printf("%d. %s, contains: %d movies, avg. rating: %.2f \n %8s%s; average rating: %.2f \n",
					-(i-10),foo.getName(),foo.length(),foo.calcAvgRating(),"",
					foo.getHighestRated().getName(),foo.getHighestRated().getAvgRating()
			);
		}
	}
}
