public class Vampire extends Enemy{

    /**
     * By making this 'health' value 'public', we allow the other classes to access it while running code outside of
     * this specific class.
     */
    //public int health;

    /**
     * Looking above, the word 'extends' could allow a Vampire called from this class to use the Talk() method
     * from the Enemy class without having its own Talk() method seen here below.
     */
    public void Talk() {
        System.out.println("I am a vampire, I will suck your blood!");
    }

}
