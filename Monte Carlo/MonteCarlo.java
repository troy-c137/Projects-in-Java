import java.util.Random;

/**
 * This program uses the Monte Carlo method to approximate the value of pi, using simple arithmetic. The concept used
 * here to simulate pi is tracking the number of dart throw attempts onto a dart board and then multiplying that by 4.
 * This is because the (x^2 + y^2 = 1) area of a circle on top of the area of a (x * y) square creates the
 * (hits / tries) ratio which is equal to (pi / 4), the number representing the curve of a circle and the number of
 * sides that a square has.
 *
 * This program will output a different number each time it is run, ranging from 3.13... to 3.15...
 */

public class MonteCarlo {

    public static void main(String[] args) {
        final int TRIES = 100000;
        Random generator = new Random();

        //int hits = 0; //Putting this variable here causes the first for loop below to add the output value of
                        //piEstimate due to hits being declared outside the loop. Once it is put inside the first
                        //for loop, it's value is reset to zero, thus resetting the calculated value of piEstimate
                        //that comes from the second for loop.
        
        double piEstimate;

        //This first for loop determines how many times the approximation of pi is calculated through the 2nd for loop.
        //The middle parameter of the for loop, 'i <= ___', determines this.
        for (int i = 1; i <= 5; i++) {
            int hits = 0;
            //This for loop create the number approximate to pi (~3.14)
            for (int j = 1; j <= TRIES; j++) {
                // generates two random numbers between -1 and 1
                double r = generator.nextDouble(); // Between -1 and 1
                double x = -1 + 2 * r;
                r = generator.nextDouble(); // re-initializing the value of r to create a second number between -1 and 1
                double y = -1 + 2 * r;

                //Check whether the point lies in the unit circle (x^2 + y^2 = 1)
                if (x * x + y * y <= 1) {hits++;}

            }
            piEstimate = 4.0 * hits / TRIES;
            System.out.println("Estimate for pi: " + piEstimate);

        }

    }
}
