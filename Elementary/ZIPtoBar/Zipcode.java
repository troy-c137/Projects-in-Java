/**
 * @author Troy Warshaw
 * @date 11/11/2022
 * This class takes in a ZIP code and converts it into a bar code or vice versa.
 */

public class Zipcode {

    public int firstDigit; //1st digit in input ZIP code
    public int secondDigit; //2nd digit in input ZIP code
    public int thirdDigit; //3rd digit in input ZIP code
    public int fourthDigit; //4th digit in input ZIP code
    public int fifthDigit; //5th digit in input ZIP code
    public int checkDigit1; //Reference check digit
    public int checkDigit2; //Counter check digit
    public int checkDigit3; //Actual check digit
    public static int num; //variable used in helper method call
    public static int num1; //used in another helper method call
    public static String str; //string used in helper method call
    public static String str1; //string used in helper method call
    public static String str2; //string used in helper method call
    public static String str3; //string used in helper method call
    public static String str4; //string used in helper method call
    public static String str5; //string used in helper method call
    public static String str6; //string used in helper method call
    public static String zeroBar; //bar code string representing 0
    public static String oneBar; //bar code string representing 1
    public static String twoBar; //bar code string representing 2
    public static String threeBar; //bar code string representing 3
    public static String fourBar; //bar code string representing 4
    public static String fiveBar; //bar code string representing 5
    public static String sixBar; //bar code string representing 6
    public static String sevenBar; //bar code string representing 7
    public static String eightBar; //bar code string representing 8
    public static String nineBar; //bar code string representing 9

    /**
     * This constructor creates a Zipcode() object that takes an (int) argument and initializes bar code values.
     * @param zip This integer is used to convert a ZIP code into a bar code via the getBarcode() method.
     */
    public Zipcode(int zip) {

        num = zip;

        //Initializing bar code values for use later in methods
        zeroBar = "||:::";
        oneBar = ":::||";
        twoBar = "::|:|";
        threeBar = "::||:";
        fourBar = ":|::|";
        fiveBar = ":|:|:";
        sixBar = ":||::";
        sevenBar = "|:::|";
        eightBar = "|::|:";
        nineBar = "|:|::";

    }

    /**
     * This constructor creates a Zipcode() object that takes a (String) argument and initializes bar code values.
     * @param bar This String is used to convert a bar code into a ZIP code via the getZIPcode() method.
     */
    public Zipcode(String bar) {

        str = bar;

        //Initializing bar code values for use later in methods
        zeroBar = "||:::";
        oneBar = ":::||";
        twoBar = "::|:|";
        threeBar = "::||:";
        fourBar = ":|::|";
        fiveBar = ":|:|:";
        sixBar = ":||::";
        sevenBar = "|:::|";
        eightBar = "|::|:";
        nineBar = "|:|::";

    }

    /**
     * This method sets 'num' equal to 'zip' argument taken from the main() method's input request that initializes
     * the Zipcode() object 'code1'. Then, it isolates each digit in the input integer and converts it from an integer
     * to a bar code representation of that integer defined in the initialization of the Zipcode object called with
     * the (int) argument 'zip'.
     * @return the string that is then output by the println() call in ZipTest
     */
    public String getBarcode(){

        //Formula that isolates each digit from the input integer
        firstDigit = num / 10000;
        secondDigit = ((num / 1000) - firstDigit * 10);
        thirdDigit = (num / 100 - (firstDigit * 100 + secondDigit * 10));
        fourthDigit = (num / 10 - (firstDigit * 1000 + secondDigit * 100 + thirdDigit * 10));
        fifthDigit = (num - (firstDigit * 10000 + secondDigit * 1000 + thirdDigit * 100 + fourthDigit * 10));

        //Adds initial value of the check digit
        checkDigit1 = (firstDigit + secondDigit + thirdDigit + fourthDigit + fifthDigit);
        checkDigit2 = checkDigit1; //helper variable for math purposes

        //Increments the check digit according to the rules of ZIP coding
        while(checkDigit2 % 10 != 0) {
            checkDigit2++;
        }
        checkDigit3 = checkDigit2 - checkDigit1; //The # of times incremented gives the value represented by the
                                                 //final frame of the bar code.

        //Calls the helper method convertToBar() to convert each digit to a bar code
        String bar1 = convertToBar(firstDigit);
        String bar2 = convertToBar(secondDigit);
        String bar3 = convertToBar(thirdDigit);
        String bar4 = convertToBar(fourthDigit);
        String bar5 = convertToBar(fifthDigit);
        String checkBar = convertToBar(checkDigit3);

        return "|" + bar1 + bar2 + bar3 + bar4 + bar5 + checkBar + "|"; //Builds the bar code
    }

    /**
     * This helper method takes the integer provided from the getDigit() method and uses 'firstDigit' through 'fifthDigit' as the
     * argument 'digit' and then that integer value is run as an argument in the switch() statement which then checks
     * every case ONCE and then outputs the corresponding bar that's defined in the Zipcode() constructor.
     * @param digit int value derived from various int variables defined in the getZIP() method that is then translated
     *          into a bar code representation that is defined in the class's constructor.
     */
    public String convertToBar(int digit){

        String barChunk = "";
        //Much more efficient to use a switch() as only 1 value is being checked in each condition.
        //Also, this uses an enhanced switch() statement format.
        switch (digit) {

            case 0 -> barChunk = zeroBar;   //"if digit == 0, then set local 'barChunk' to 'zeroBar'
            case 1 -> barChunk = oneBar;
            case 2 -> barChunk = twoBar;
            case 3 -> barChunk = threeBar;
            case 4 -> barChunk = fourBar;
            case 5 -> barChunk = fiveBar;
            case 6 -> barChunk = sixBar;
            case 7 -> barChunk = sevenBar;
            case 8 -> barChunk = eightBar;
            case 9 -> barChunk = nineBar;

        }
        return barChunk;
    }

    /**
     * This method uses the 'str' variable initialized from the Zipcode(bar) constructor. The convertToInt()
     * helper method reads the substring of 'str' and sees which bar code chunk it equates to. Once found, the
     * integer value is set to a helper variable local to the function and then all helpers are cast to Strings so
     * that constructing the final String output is easier to do.
     * @return the ZIP code that has been converted from the input bar code.
     */
    public String getZIPcode(){

        String output;

        str1 = str.substring(1,6);
        int one = convertToInt(str1);
        String oneStr = Integer.toString(one);
        str2 = str.substring(6,11);
        int two = convertToInt(str2);
        String twoStr = Integer.toString(two);
        str3 = str.substring(11,16);
        int three = convertToInt(str3);
        String threeStr = Integer.toString(three);
        str4 = str.substring(16,21);
        int four = convertToInt(str4);
        String fourStr = Integer.toString(four);
        str5 = str.substring(21,26);
        int five = convertToInt(str5);
        String fiveStr = Integer.toString(five);

        output = oneStr + twoStr + threeStr + fourStr + fiveStr;

        str6 = str.substring(26,31);

        //This checks if the check digit bar code matches the one previously output by getBarcode()
        if (!getBarcode().substring(26,31).equals(str6)){
            return "The check digit for the bar code you entered did not match the correct output for the previously entered ZIP.";
        } else {
            return output;
        }

        //int outputX = Integer.parseInt(output);


    }

    /**
     * This method takes the initialized variable 'str' from the Zipcode(bar) constructor and evaluates the bar code
     * chunk that the getZIPcode() method separates from the original input String called in ZipTest.java main().
     * @param str Actually the substring created within the getZIPcode() method.
     * @return the integer value equal to the bar code chunk that was evaluated by this method.
     */
    public int convertToInt(String str){

        if(str.equals(zeroBar)) {
            num1 = 0;
        }
        if(str.equals(oneBar)) {
            num1 = 1;
        }
        if(str.equals(twoBar)) {
            num1 = 2;
        }
        if(str.equals(threeBar)) {
            num1 = 3;
        }
        if(str.equals(fourBar)) {
            num1 = 4;
        }
        if(str.equals(fiveBar)) {
            num1 = 5;
        }
        if(str.equals(sixBar)) {
            num1 = 6;
        }
        if(str.equals(sevenBar)) {
            num1 = 7;
        }
        if(str.equals(eightBar)) {
            num1 = 8;
        }
        if(str.equals(nineBar)) {
            num1 = 9;
        }
        return num1;
    }

}
