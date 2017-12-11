public class RevLabQ1 {

	public static void main(String[] args) {
		// Sum the series
		double sum = 0.0;
		for (double n = 1; n <= 97; n+=2) {
			sum += n / (n+2);
		}
		
		System.out.println ("Series: 1/3 + 3/5 + 5/7 + 7/9 + ... + 95/97 + 97/99");
		System.out.format("Sum of the series: %.2f" , sum);
	}

}
