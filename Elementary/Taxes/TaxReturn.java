/**
 * This will calculate the tax return of a single or married person based on 2022-2023 tax brackets.
 *
 * Below is a class that stores constant variables that cannot be accessed outside of the TaxReturn class.
 */

public class TaxReturn {
    public static final int SINGLE = 1;
    public static final int MARRIED = 2;

    private static final double RATE1 = 0.10;
    private static final double RATE2 = 0.12;
    private static final double RATE3 = 0.22;
    private static final double RATE4 = 0.24;
    private static final double RATE5 = 0.32;
    private static final double RATE6 = 0.35;
    private static final double RATE7 = 0.37;
    private static final double RATE1_SINGLE_LIMIT = 10275;
    private static final double RATE2_SINGLE_LIMIT = 41775;
    private static final double RATE3_SINGLE_LIMIT = 89075;
    private static final double RATE4_SINGLE_LIMIT = 170050;
    private static final double RATE5_SINGLE_LIMIT = 215950;
    private static final double RATE6_SINGLE_LIMIT = 539900;
    private static final double RATE1_MARRIED_LIMIT = 20550;
    private static final double RATE2_MARRIED_LIMIT = 83550;
    private static final double RATE3_MARRIED_LIMIT = 178150;
    private static final double RATE4_MARRIED_LIMIT = 340100;
    private static final double RATE5_MARRIED_LIMIT = 431900;
    private static final double RATE6_MARRIED_LIMIT = 647850;

    private double income;
    private int status;

    /**
     * Constructs a TaxReturn object for a given income and marital status.
     * @param anIncome = the taxpayer income
     * @param aStatus = either SINGLE or MARRIED
     */

    public TaxReturn(double anIncome, int aStatus) {
        income = anIncome;
        status = aStatus;
    }

    public double getTax(){

        double taxOwed = 0;

        if (status == SINGLE){
            if (income <= RATE1_SINGLE_LIMIT){
                taxOwed = RATE1 * income;
            } else if (income <= RATE2_SINGLE_LIMIT) {
                taxOwed = (RATE1 * RATE1_SINGLE_LIMIT) + (RATE2 * (income - RATE1_SINGLE_LIMIT));
            } else if (income <= RATE3_SINGLE_LIMIT) {
                taxOwed = (RATE1 * RATE1_SINGLE_LIMIT) + (RATE2 * (RATE2_SINGLE_LIMIT - RATE1_SINGLE_LIMIT)
                        + (RATE3 * (income - RATE2_SINGLE_LIMIT)));
            } else if (income <= RATE4_SINGLE_LIMIT) {
                taxOwed = (RATE1 * RATE1_SINGLE_LIMIT) + (RATE2 * (RATE2_SINGLE_LIMIT - RATE1_SINGLE_LIMIT))
                        + (RATE3 * (RATE3_SINGLE_LIMIT - RATE2_SINGLE_LIMIT)) + (RATE4 * (income - RATE3_SINGLE_LIMIT));
            } else if (income <= RATE5_SINGLE_LIMIT) {
                taxOwed = (RATE1 * RATE1_SINGLE_LIMIT) + (RATE2 * (RATE2_SINGLE_LIMIT - RATE1_SINGLE_LIMIT))
                        + (RATE3 * (RATE3_SINGLE_LIMIT - RATE2_SINGLE_LIMIT)) + (RATE4 * (RATE4_SINGLE_LIMIT - RATE3_SINGLE_LIMIT))
                        + (RATE5 * (income - RATE4_SINGLE_LIMIT));
            } else if (income <= RATE6_SINGLE_LIMIT) {
                taxOwed = (RATE1 * RATE1_SINGLE_LIMIT) + (RATE2 * (RATE2_SINGLE_LIMIT - RATE1_SINGLE_LIMIT))
                        + (RATE3 * (RATE3_SINGLE_LIMIT - RATE2_SINGLE_LIMIT)) + (RATE4 * (RATE4_SINGLE_LIMIT - RATE3_SINGLE_LIMIT))
                        + (RATE5 * (RATE5_SINGLE_LIMIT - RATE4_SINGLE_LIMIT)) + (RATE6 * (income - RATE5_SINGLE_LIMIT));
            } else {
                taxOwed = (RATE1 * RATE1_SINGLE_LIMIT) + (RATE2 * (RATE2_SINGLE_LIMIT - RATE1_SINGLE_LIMIT))
                        + (RATE3 * (RATE3_SINGLE_LIMIT - RATE2_SINGLE_LIMIT)) + (RATE4 * (RATE4_SINGLE_LIMIT - RATE3_SINGLE_LIMIT))
                        + (RATE5 * (RATE5_SINGLE_LIMIT - RATE4_SINGLE_LIMIT)) + (RATE6 * (RATE6_SINGLE_LIMIT - RATE5_SINGLE_LIMIT))
                        + (RATE7 * (income - RATE6_SINGLE_LIMIT));
            }
        } else {
            if (income <= RATE1_MARRIED_LIMIT){
                taxOwed = RATE1 * income;
            } else if (income <= RATE2_MARRIED_LIMIT) {
                taxOwed = (RATE1 * RATE1_MARRIED_LIMIT) + (RATE2 * (income - RATE1_MARRIED_LIMIT));
            } else if (income <= RATE3_MARRIED_LIMIT) {
                taxOwed = (RATE1 * RATE1_MARRIED_LIMIT) + (RATE2 * (RATE2_MARRIED_LIMIT - RATE1_MARRIED_LIMIT)
                        + (RATE3 * (income - RATE2_MARRIED_LIMIT)));
            } else if (income <= RATE4_MARRIED_LIMIT) {
                taxOwed = (RATE1 * RATE1_MARRIED_LIMIT) + (RATE2 * (RATE2_MARRIED_LIMIT - RATE1_MARRIED_LIMIT))
                        + (RATE3 * (RATE3_MARRIED_LIMIT - RATE2_MARRIED_LIMIT)) + (RATE4 * (income - RATE3_MARRIED_LIMIT));
            } else if (income <= RATE5_MARRIED_LIMIT) {
                taxOwed = (RATE1 * RATE1_MARRIED_LIMIT) + (RATE2 * (RATE2_MARRIED_LIMIT - RATE1_MARRIED_LIMIT))
                        + (RATE3 * (RATE3_MARRIED_LIMIT - RATE2_MARRIED_LIMIT)) + (RATE4 * (RATE4_MARRIED_LIMIT - RATE3_MARRIED_LIMIT))
                        + (RATE5 * (income - RATE4_MARRIED_LIMIT));
            } else if (income <= RATE6_MARRIED_LIMIT) {
                taxOwed = (RATE1 * RATE1_MARRIED_LIMIT) + (RATE2 * (RATE2_MARRIED_LIMIT - RATE1_MARRIED_LIMIT))
                        + (RATE3 * (RATE3_MARRIED_LIMIT - RATE2_MARRIED_LIMIT)) + (RATE4 * (RATE4_MARRIED_LIMIT - RATE3_MARRIED_LIMIT))
                        + (RATE5 * (RATE5_MARRIED_LIMIT - RATE4_MARRIED_LIMIT)) + (RATE6 * (income - RATE5_MARRIED_LIMIT));
            } else {
                taxOwed = (RATE1 * RATE1_MARRIED_LIMIT) + (RATE2 * (RATE2_MARRIED_LIMIT - RATE1_MARRIED_LIMIT))
                        + (RATE3 * (RATE3_MARRIED_LIMIT - RATE2_MARRIED_LIMIT)) + (RATE4 * (RATE4_MARRIED_LIMIT - RATE3_MARRIED_LIMIT))
                        + (RATE5 * (RATE5_MARRIED_LIMIT - RATE4_MARRIED_LIMIT)) + (RATE6 * (RATE6_MARRIED_LIMIT - RATE5_MARRIED_LIMIT))
                        + (RATE7 * (income - RATE6_MARRIED_LIMIT));
            }


        }
    return taxOwed;
    }
}
