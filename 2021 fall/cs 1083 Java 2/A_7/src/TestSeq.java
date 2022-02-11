/**
TestSeq.java
A simple driver that uses the Seq class to compute the
nth element of the sequence.
*/

import java.text.NumberFormat;
import java.util.Scanner;

public class TestSeq{

	public static void main(String[] args) {
		int n, seqRec;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		n = scan.nextInt();

		seqRec = Seq.seqR(n);
		System.out.println("seqR(" + n + ") is: " + seqRec);
		seqRec = Seq.seqM(n);
		System.out.println("seqM(" + n + ") is: " + seqRec);
		seqRec = Seq.seqI(n);
		System.out.println("seqI(" + n + ") is: " + seqRec);


		NumberFormat form = NumberFormat.getInstance();
		form.setMaximumFractionDigits(7);
		form.setMinimumFractionDigits(7);

		System.out.println("Execution Times in Milliseconds (ms)");
		System.out.println("n\tRecursive\tSeq(n)\tMemoization" +
				"\tSeq(n)\tItertive\tSeq(n)");
		for (int i = 15; i <= 35; i += 10) {
			long start = System.nanoTime();
			int seqA = Seq.seqR(i);
			long end = System.nanoTime();
			double time = (double) (end - start) / 1000000;
			System.out.print(i + "\t" + form.format(time) + "\t" + String.format("%-5s",seqA));

			start = System.nanoTime();
			int seqB = Seq.seqM(i);
			end = System.nanoTime();
			time = (double) (end - start) / 1000000;
			System.out.print("\t" + form.format(time) + "\t" + String.format("%-5s",seqB));

			start = System.nanoTime();
			int seqC = Seq.seqI(i);
			end = System.nanoTime();
			time = (double) (end - start) / 1000000;
			System.out.print("\t" + form.format(time) + "\t" + String.format("%-5s",seqC) + "\n");
		}
	}
} 