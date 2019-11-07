package pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Sw_Nov {
	static int N, K, M;
	static int layer[];
	static long f[];
	static long comb[][];

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		f = new long[100];
		comb = new long[100][100];
		int limit = 14;
		layer = new int[limit];
		for (int i = 0; i < limit; i++) {
			layer[i] = fun(i);
//			System.out.println("Layer " + i + " : " + layer[i]);
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

//			N = 8;
//			K = 6;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;

			for (int i = 0; i < limit; i++) {
				if (N < layer[i]) {
					a = i - 1;
					b = i;
					break;
				}
			}
//			System.out.println("a : " + a + "  b : " + b);
			for (int i = 0; i < limit; i++) {
				if (K < layer[i]) {
					c = i - 1;
					d = i;
					break;
				}
			}
//			System.out.println("c : " + c + "  d :" + d);
			M = layer[a] + ((layer[b] - layer[a]) / 2);
//			System.out.println("N : " + N);
//			System.out.println("K : " + K);
			long par = 0;
			long child = 0;
			long x = 0;
			long y = 0;
			long ans = 1;
			if (a > c||N==layer[b]-1 ) {
//			확률 1/1
//				System.out.println("1 / 1");
				par = 1;
				child = 1;

			} else if (a < c) {
//			확률 0
//				System.out.println("0 / 1");
				par = 1;
				child = 0;

			} else {
				int n = N - layer[a];
				int r = K - layer[a];
				par = (long) (Math.pow(2, n));
				child = 0;
//				System.out.println("n : " + n);
//				System.out.println("r : " + r);
//				System.out.println("분모 : " + par);
				if (N < M) { // 한번만 계산해도됨
					if (M < K)
						r = M - (K - M) - layer[a];
					if (n < r) {
						child = 0;
					} else {

						for (int i = r; i <= n; i++) {
							child += combination(n, i);
						}
					}
//					System.out.println("분자 : " + child);
				} else if (N == M) {
					if(K==M) {
						child = 2;
						
					}else if(K<N) {
						for (int i = r; i <= n; i++) {
							child += combination(n, i);
						}
					}else {
						r = (M-K)+M-layer[c];
						for (int i = r; i <= n; i++) {
							child += combination(n, i);
						}
					}

				} else {// N이 M보다 클 때
					for (int i = r; i <= n; i++) {
						child += (combination(n, i));
					}
					if (M < K) {
						r = (M-K)+M-layer[c];
					}else if(K==M) {
					
					}else {
						r= (M-K)+M-layer[c];
					}
					for (int i = r; i <= n; i++) {
						child += (combination(n, i));
					}
//					System.out.println("분자 : " + child);

				}
				if(layer[c]==K) {
					child =1;
					par = 1;
				}
				// 최대공약수
				ans = gcd(par, child);


			}

			y = par / ans;
			x = child / ans;
			System.out.println("#" + test_case +" " + x + " / " + y);

		}
	}

	static long gcd(long x, long y) {
		while (y > 0) {
			long temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}

	static long combination(int n, int r) {
//		if (comb[n][r] == 0) {
//			comb[n][r] = fac(n) / fac(r) / fac(n - r);
//		}
//		return comb[n][r];

		if (r == 0 || n == r) {
			return 1;
		} else {
			if (comb[n][r] == 0) {
				comb[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
			}
			return comb[n][r];
		}

	}

	static long fac(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			if (f[n] == 0) {
				f[n] = n * fac(n - 1);
			}
			return f[n];
		}

	}

	static int fun(int n) {
		if (n == 0) {
			return 1;

		} else if (n == 1) {
			return 2;

		} else {
			if (layer[n] != 0) {
				return layer[n];
			} else {
				return fun(n - 1) + (n - 1) * 8;
			}

		}

	}

}
