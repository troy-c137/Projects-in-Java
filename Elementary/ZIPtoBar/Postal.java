/**
 * This absolute god amongst men (Jimmy Kurian) generously donated this perfect solution to this coding problem. However, it is
 * so fucking cool to see that nearly anything can be computed on a computer!!
 * 
 * I am including this program in here just to show a comparison of how the same problem can be solved in many different ways. All the commments are mine as it 
 * is essentially my way of learning from the source code and explaining what's going on, so I can then apply these same strategies and concepts later on. 
 */

import java.util.Scanner;

public class Postal
{
    public int num2;     // 10000 digit
    public int num3;     // 1000 digit
    public int num4;     // 100 digit
    public int num5;     // 10 digit
    public int num6;     // 1 digit
    public int checkDig; // check digit
    public static int num;
    public static String temp;
    public static int menu;
    public static int zip;
    public static String bar0;
    public static String bar1;
    public static String bar2;
    public static String bar3;
    public static String bar4;
    public static String bar5;
    public static String bar6;
    public static String bar7;
    public static String bar8;
    public static String bar9;
    public static String str;
    public static int numb;

    /**
     * This is a constructor that creates a Postal object that is either a ZIP code in integer format or a
     * bar code using the '|' and ':' characters as a 'full bar' and 'half bar' respectively.
     */
    public Postal()
    {
        zip = 0;

        bar0 = "||:::"; bar1 = ":::||"; bar2 = "::|:|";
        bar3 = "::||:"; bar4 = ":|::|"; bar5 = ":|:|:";
        bar6 = ":||::"; bar7 = "|:::|"; bar8 = "|::|:";
        bar9 = "|:|::";

    }

    /**
     * This getter method simply asks the user for an input and checks to see if that input is within legal
     * limits of what can constitute a ZIP code.
     * @return zip; The integer entered by the user that represents a ZIP code that has been cleared by the
     *         loop that checks for a valid input.
     */
    public static int getZIP() {

        System.out.println("Enter a ZIP code : ");
        Scanner sc = new Scanner(System.in);
        zip = sc.nextInt();
        while((zip < 513)||(zip > 99950)) {

            System.out.println("**** ERROR ****");
            System.out.println("The ZIP code must be between 01001 and 99950");
            System.out.println("Please,enter the correct zip : ");
            zip = sc.nextInt();

        }
        return zip;
    }

    /**
     * This method creates a menu from which the user can select whether they want to create a bar code from a
     * ZIP or vice versa. This is so fucking cool to see!!
     * @return an integer input from the user representing the selection they made from the options provided.
     */
    public static int menu() {

        System.out.println("**** Zip & Bar Code Convertor ****");
        System.out.println("Choose one option from following : ");
        System.out.println("1) Create ZIP barcode ");
        System.out.println("2) Find ZIP code from barcode ");
        System.out.println("3) Exit ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    /**
     * This method takes the integer that is returned from the getZIP() method as an argument and creates the
     * bar code by doing some integer math since the value input by the user in the getZIP() method is an int.
     * @param num an int derived from the getZIP() method that gives the function the value that it needs to
     *            create a bar code.
     */
    public void getDigit(int num) {

        num2 = num / 10000;
        num3 = ((num / 1000) - num2 * 10);
        num4 = (num / 100 - (num2 * 100 + num3 * 10));
        num5 = (num / 10 - (num2 * 1000 + num3 * 100 + num4 * 10));
        num6 = (num - (num2 * 10000 + num3 * 1000 + num4 * 100 + num5 * 10));

        checkDig = 100 - (num2 + num3 + num4 + num5 + num6);
        System.out.println(checkDig);

        while(checkDig > 10) {
            checkDig -= 10;
        }
        System.out.println("**** BARCODE ****");
        System.out.print("|");
        getBar(num2);
        getBar(num3);
        getBar(num4);
        getBar(num5);
        getBar(num6);
        getBar(checkDig);
        System.out.print("|");

    }

    /**
     * This method takes the integer provided from the getDigit() method and uses 'num2' through 'num6' as the
     * argument 'x' and then that integer value is run as an argument in the switch() statement which then checks
     * every case ONCE and then outputs the corresponding bar that's defined in the Postal() constructor.
     * @param x int value derived from various int variables defined in the getZIP() method that is then translated
     *          into a bar code representation that is defined in the class's constructor.
     */
    public void getBar(int x) {

        switch (x) {

            case 0 -> System.out.print(bar0);
            case 1 -> System.out.print(bar1);
            case 2 -> System.out.print(bar2);
            case 3 -> System.out.print(bar3);
            case 4 -> System.out.print(bar4);
            case 5 -> System.out.print(bar5);
            case 6 -> System.out.print(bar6);
            case 7 -> System.out.print(bar7);
            case 8 -> System.out.print(bar8);
            case 9 -> System.out.print(bar9);

        }
    }

    /**
     * This method takes in the user's input when they want to convert a bar code into a ZIP code. This method
     * call creates the string that is the bar code which will then be broken down to be converted into an integer
     * representation of a ZIP code.
     * @return the string that representing the bar code that will be converted into a ZIP code. ALSO, the string
     *         that this method returns is assigned to the variable 'temp' in the main() method which sets the
     *         value of 'temp' as the returned value of a number() object!!
     */
    public static String number() {

        System.out.println("Enter a barcode with using : or | ");
        Scanner scn = new Scanner(System.in); //locally defined Scanner object, so it can update every method call
        return scn.nextLine();
    }

    /**
     * This helper method takes the string output from the number() method call and does the actual conversions of the
     * string containing '|' and ':' into a specific integer value that corresponds with the definitions laid out
     * in the class's constructor.
     * @param temp the output of the number() method call that then converts to a bar code and serves as the argument
     *             for the divide() method.
     */
    public static void getNumber(String temp) {

        System.out.println();
        System.out.println(temp);
        if(temp.equals(bar0)) {
            numb = 0;
        }
        if(temp.equals(bar1)) {
            numb = 1;
        }
        if(temp.equals(bar2)) {
            numb = 2;
        }
        if(temp.equals(bar3)) {
            numb = 3;
        }
        if(temp.equals(bar4)) {
            numb = 4;
        }
        if(temp.equals(bar5)) {
            numb = 5;
        }
        if(temp.equals(bar6)) {
            numb = 6;
        }
        if(temp.equals(bar7)) {
            numb = 7;
        }
        if(temp.equals(bar8)) {
            numb = 8;
        }
        if(temp.equals(bar9)) {
            numb = 9;
        }
        System.out.print(numb);

    }

    /**
     * This method separates the complete string that is the bar code into 5 separate parts which the getNumber()
     * method can use to convert each section into an integer which equates to one of the 5 separate parts of the
     * ZIP code that will be output from this conversion.
     * @param temp a string set as the output of the number() method call which is then broken up and converted
     *             by the function of this method.
     */
    public static void divide(String temp) {

        new Postal();
        str = temp.substring(1,6);
        getNumber(str);
        str = temp.substring(6,11);
        getNumber(str);
        str = temp.substring(11,16);
        getNumber(str);
        str = temp.substring(16,21);
        getNumber(str);
        str = temp.substring(21,26);
        getNumber(str);

    }

    /**
     * The main() method of the class. This is where the magic happens.
     * 1) It first creates a Postal object, 'pos', from the constructor that initializes all the important variables, such as
     *    what each potential number 0-9 is represented as in bar code format and the ZIP code to 0.
     * 2) While the output value from the input taken in the menu() method is not 3, then it creates a new menu()
     *    object every loop that can then take in a new input from the subsequent menu() method call that determines
     *    which case the switch() statement executes.
     * 3) In case 1, the variable 'num' is set as the output value from the getZIP() method which is a ZIP code integer
     *    taken as user input. Then, 'pos.getDigit(num)' uses the values initialized in the Postal() constructor
     *    object 'pos' as a reference while calling the getDigit() method that takes the output of getZIP() assigned to
     *    the local variable 'num' as an argument. The getDigit() method then converts each digit in the integer
     *    entered as 'num' into a bar code and prints out the completed bar code. It then breaks out of the switch()
     *    statement and loops through the 'while(menu != 3)' loop.
     * 4) In case 2, the variable 'temp' is set the output of the number() method call which asks the user to input
     *    a string representing a bar code. The bar code entered by the user is then printed. After, the divide()
     *    takes that input string 'temp' as an argument and converts each 5-character chunk into an integer that
     *    equates to the subsequent 5-integer integer that represents the ZIP code. It then breaks out of the switch()
     *    statement and cycles back through the while loop.
     * 5) In case 3, if the user enters a '3' while in menu() method call, the code will break out of the switch()
     *    statement and since the value of menu() is '3', the while loop will also break thus causing the JVM to exit
     *    the program successfully with exit code 0.
     * @param args No actual 'args'
     */
    public static void main(String[] args) {

        Postal pos = new Postal();
        while(menu != 3) {

            System.out.println();
            menu = menu();
            switch (menu) {

                case 1:
                    num = getZIP();
                    pos.getDigit(num);
                    System.out.println();
                    break;
                case 2:
                    temp = number();
                    System.out.println(temp);
                    divide(temp);
                    break;
                case 3:
                    break;
            }
        }
    }
}
