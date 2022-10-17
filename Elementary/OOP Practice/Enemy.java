public class Enemy {

    /**
     * This 'private' word here is for safety reasons when we utilize the Enemy class and any objects created from
     * that class. We don't want anything outside the class to inadvertently change the properties of an object.
     */
    private int health;

    /**
     * Remember that 'void' here tells the program that the Talk() method doesn't return a value from the
     * contents of its body.
     */
    public void Talk() {
        System.out.println("I am an enemy.");
        System.out.println("You better run!");
    }

    /**
     * This is a 'getter' method that will output the current value of the private variable 'health' declared within the
     * Enemy.java class, a variable which the Werewolf.java and Vampire.java classes (and their objects) inherit
     * due to them 'extending' the Enemy.java class.
     */
    public void getHealth() {
        System.out.println(health);
    }

    /**
     * This is a 'setter' method that will change the value of the 'privately' accessed variable 'health' declared
     * above. You can call this method in the Main class to change the value of 'health' that an object is using.
     * @param x The new value of health that is set by this 'setter' method.
     */
    public void setHealth(int x) {
        health = x;
    }

}
