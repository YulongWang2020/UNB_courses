/**
TestSeq.java
A simple driver that uses the Seq class to compute the
nth element of the sequence.
*/

import java.util.Scanner;

public class TestSeq{

	public static void main(String[] args){
		int n, seqRec;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		n = scan.nextInt();
		
		seqRec = Seq.seqR(n);
		System.out.println("seqR(" + n + ") is: " + seqRec);
	}
} 