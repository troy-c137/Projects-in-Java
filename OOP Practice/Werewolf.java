public class Werewolf extends Enemy{

    /**
     * By making this 'health' value 'public', we allow the other classes to access it while running code outside of
     * this specific class.
     */
    //public int health;
    public void Talk() {
        System.out.println("I am a werewolf, I will bite you!");
    }

}
