public class fourPillars {

    /**
     * This Main.java class and its main method show and explain the 4 pillars of Object-Oriented Programming (OOP):
     * 1) Abstraction
     * 2) Inheritance
     * 3) Polymorphism
     * 4) Encapsulation
     */

    public static void main(String[] args) {

        /**
         * This creates a new Enemy object, named 'enemy' that calls methods from the class we created called
         * Enemy.java
         *
         * This object and any other object created uses the concept of 'Abstraction' which decouples what the user
         * experiences and what is actually going on behind the scenes. For example, when a user presses the power
         * button on their computer and the screen turns on.
         */
        //Enemy enemy = new Enemy();

        /**
         * This creates a Werewolf object named 'werewolf'. This can inherit the methods within the Enemy class.
         */
        Werewolf werewolf = new Werewolf();

        /**
         * Like Werewolf, this Vampire object can inherit methods within the Enemy class, even if the Vampire class
         * was empty without its own Talk() method. However, since it has its own Talk() method, when the object here
         * calls 'vampire.Talk();', the Talk() method within the Vampire class overwrites the inherited Talk()
         * method from the Enemy class and will output the contents/values of the Talk() method within Vampire.java
         */
        Vampire vampire = new Vampire();

        /**
         * Since both Werewolf.java and Vampire.java 'extend' Enemy.java, this makes Enemy.java the parent class; thus
         * making Werewolf.java and Vampire.java sibling classes
         */

        //enemy.Talk();
        //vampire.Talk();
        //werewolf.Talk();

        /**
         * This creates an Enemy pointer that is set equal to our Vampire.java object named 'vampire'. By calling:
         * 'enemy.Talk();', it will call the Talk() method from the Vampire.java class since the object we have created
         * 'points' to the vampire class containing its own Talk() method which then overwrites the Talk() method
         * inside the Enemy.java class. This concept is called polymorphism.
         */
        //Enemy enemy = vampire;
        //enemy.Talk();

        /**
         * This contains an array of the Enemy.java class, named 'enemies', that contains the vampire and werewolf
         * objects that were created from the Werewolf.java and Vampire.java classes.
         *
         * Calling the Talk() methods using the indexing of the array 'enemies' uses the power of polymorphism. The
         * computer figures out which Talk() method to use during run time.
         */
        Enemy [] enemies = {vampire, werewolf};

        enemies[0].Talk(); //Calls the Talk() method for the object at index [0] which is the vampire object
        enemies[1].Talk(); //Calls the Talk() method for the object at index [1] which is the werewolf object

        /**
         * This sets the public integer value of 'health' that was initialized in the Vampire class, from which the
         * 'vampire' object was created from, to 25. This usually isn't the best practice--to allow something outside
         * class from which it originates to change its value.
         */
        //vampire.health = 25;

        /**
         * This series of code uses the idea of encapsulation. Basically, by using the setHealth() and getHealth()
         * methods defined in the Enemy class, we are encapsulating the processes going on within each line of code to
         * clean up and improve the readability of the code and what the program is doing overall. We are
         * 'encapsulating' our properties within the object, which in this case is any object deriving from the
         * Enemy.java class. We do this by setting our properties like 'health' to 'private'. Instead of giving everyone
         * access to the properties of our object, we set those properties as private values, and then create 'setter'
         * 'getter' methods to give the user control over what we the user to be able to set and get.
         */
        vampire.setHealth(25);
        vampire.getHealth();
        System.out.println("You throw a stake at the vampire's heart!");
        vampire.setHealth(0);
        vampire.getHealth();
        System.out.println("You killed the vampire!");

    }
}
