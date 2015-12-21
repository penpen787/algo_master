package acmicpc.solved;

import java.util.Scanner;

/*
 * Author : Kyunghun Jeon
 * Little Price Question : https://www.acmicpc.net/problem/1094
 * 
 */

public class Q1004 {
	public static void main(String... args) {

		int stick = 64;
		Scanner scanner = new Scanner(System.in);
		int cp;
		cp = scanner.nextInt();
		int[] a = new int[10];
		int c = 0; // Pointer
		a[c] = stick;
		while (true) {
			int div2 = 0;
			int sum = sum(a, c);
			if (sum == cp) {
				System.out.println(c + 1);
				break;
			}
			if (sum > cp) {
				div2 = a[c] / 2;
				if (div2 == 0) {
					System.out.println(-1);
					break;
				}
				a[c] = div2;
				a[c + 1] = div2;
				sum = sum(a, c);
				if (sum < cp) {
					++c;
				}
			}
		}

	}

	public static int sum(int[] a, int c) {
		int sum = 0;
		for (int i = 0; i <= c; i++) {
			sum += a[i];
		}
		return sum;
	}
}