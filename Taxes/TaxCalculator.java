 import java.util.Scanner;

/**
 * This calculates an income tax return using 2022-2023 rates.
 */

public class TaxCalculator {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Are you married? (Y/N): ");
        String answer = input.next();

        System.out.print("Please enter your income: ");
        double income = input.nextDouble();

        int status;
        if (answer.equals("Y")){
            status = TaxReturn.MARRIED;
        } else {
            status = TaxReturn.SINGLE;
        }
        TaxReturn aTaxReturn = new TaxReturn(income, status);
        System.out.println("Tax: " + aTaxReturn.getTax());
    }
}
