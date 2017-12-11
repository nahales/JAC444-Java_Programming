package workshop2q1;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
        boolean repeatSidesInput = true;
        
		do {
			System.out.print("Enter three sides of the triangle: ");
			double side1 = input.nextDouble();		
			double side2 = input.nextDouble();		
			double side3 = input.nextDouble();
	
			try {
				Triangle t1 = new Triangle(side1, side2, side3);
				System.out.print("Enter a triangle color: ");
		        String color = input.next();
		        System.out.print("Is the triangle filled? (true/false): ");
		        String isFilledString = input.next();
		        boolean isFilled = (isFilledString.equals("true"));	        
		        t1.setColor(color);
		        t1.setFilled(isFilled);
		        System.out.println(t1.toString());
		        System.out.println("Area = " + t1.getArea());
		        System.out.println("Perimeter = " + t1.getPerimeter());
		        System.out.println("Color = " + t1.getColor());
		        System.out.println("Is filled? " + t1.isFilled() + "\n");      		        
			}
			catch (Triangle.IllegalTriangleException ex) {
			}

		} while (repeatSidesInput);

    }

}