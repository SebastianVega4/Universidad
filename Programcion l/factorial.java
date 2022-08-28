package clase5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.BigInteger;
/*
public class factorial {
	static public int factorial(int n) {
		return n==0 || n==1 ? 1 : n* factorial(n-1);
		
	}

	public static void main(String[] args) throws FileNotFoundException {

		File doc = new File("F:\\clase5\\src\\clase5\\in_1.in");
		int fact = 0;
		int num = 0;
		Scanner sc = new Scanner(doc);

		while (sc.hasNextLine()) {
			num = Integer.parseInt(sc.nextLine());
			System.out.println(num);
				System.out.println("     "+factorial(num));
			}

		}
	}
*/
public class factorial {
	static public BigInteger factorial(BigInteger n) {
		return (n.equals(BigInteger.ZERO)) || n==BigInteger.ONE ? BigInteger.ONE : n.multiply(factorial(n.subtract(BigInteger.ONE)));
	
	}

	public static void main(String[] args) throws FileNotFoundException {

		File doc = new File("F:\\clase5\\src\\clase5\\in_2.in");
		int fact = 0;
		String num ;
		Scanner sc = new Scanner(doc);

		while (sc.hasNextLine()) {
			num = sc.nextLine();
			System.out.println("     "+num);

			System.out.println("     "+factorial(new BigInteger(num)));
			}

		}
	}