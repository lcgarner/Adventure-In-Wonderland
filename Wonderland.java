//imports
import java.lang.Thread;

/**
 * Represents a Wonderland World
 * @param map 2d array representing the map of places in wonderland
 * @param fungiForest a location for fungi forest
 * @param rabbitHole a location for rabbit hole
 * @param tulgeyWoods a location for tulgey woods
 * @param cat a cheshire cat
 * @param changeLocation whether the location just changed or not
 * @param character the user's character

 */
public class Wonderland{
    String[][] map = new String[5][5];
    //private Croquet croquet;
    private FungiForest fungiForest;
    private RabbitHole rabbitHole;
    private TulgeyWoods tulgeyWoods;
    private CheshireCat cat;
    private Boolean changeLocation;

    Character character;

    /**
     * Constructs a wonderland world
     */
    public Wonderland(){
        //creates a map
        this.map = new String[][]{{"You have reached the edge of Wonderland. The sky and sea melt together into one grey plain.", "You walk along the beach to find a bottle of pills washed up on the shore.", "You have reached the light house at the endless sea... ", "After a long trek through the mountains you have reached the top of Mont Jubjub! You can see anything from here", "The far castle!"}, 
        {"You have entered the croquet grounds. An intense game is taking place between Tweedledee and Tweedledum.","You have reached the grandest Castle in all the land, the castle of the queen of hearts.", "Court House", "You have reached the royal rose gardens.", "You are at the base of the mountains of division."}, 
        {"You have reached the Mad Hatters house. It appear there is a tea party in session!", "You have reached the duchesses manner.", "You emerge from the woods into a meadow surrounding a small gabled house. You enter the house on the table is a container of pills.", "You enter a grove of massive mushrooms. Your eyes meet those of caterpillar who ignores you and takes a drag of a long hookah.", "Chilled to the bone you hurry on through the woods in the hopes of finding shelter."}, 
        {"Welcome to the dismal mire...","You found a river. Should you drink the water? It could be dangerous...Strange things happen in Wonderland...", "Giant dragonflies swarm through the sky over your head squabbling over potential perches.","The trees around you begin to morph into oversized mushrooms. You are pleased pick some fungi and arrange them into a bouquet. Your stomach growls...", "You sense someone is watching you in the darkness! Move faster"}, 
        {"You cross the water to find a small door.","You reach the edge of a calm pond. Thirsty, you cup the water to your lips only to spit out a mouthful of tears.","","The forrest thicken. A sign points east saying, 'Enter at your own peril!'", "You wander down another one of the Tulgey woods winding purple roads. Will you ever escape?"}};
        
        Character character = new Character();
        this.character = character;
        this.fungiForest = new FungiForest(this.character,this.cat);
        this.tulgeyWoods = new TulgeyWoods(this.character, this.cat);
        this.rabbitHole = new RabbitHole(this.character);

        this.changeLocation = true;

    }

    /**
     * Plays the game sequence
     */
    public void play(){
        this.character.play();
        this.rabbitHole.play();

        printSlow("The rabbit hole has dropped you in the middle of wonderland: ");

        while (this.character.health >= 0 ) {
            while (this.changeLocation){
                printSlow(this.map[this.character.locationC][this.character.locationR]);
                investigate();
                this.changeLocation = false;

            }
    
            String command = this.character.command();
            userAction(command);
    
        } 

        printSlow("Oh no, you ran out of health points..... and died....... ☠️☠️☠️");
    }

    /**
     * Prints text slowly
     * @param text string for text to print slowly
     */
    public void printSlow(String text){
        try {

            char[] textArray = text. toCharArray();

            for (int i = 0; i < textArray.length; i++) {
                //Pause for 4 seconds
                Thread.sleep(30);
                //Print a message
                if (i < textArray.length-1){
                    System.out.print(textArray[i]);

                } else {
                    System.out.println(textArray[i]);

                }
            }
        } catch (Exception e){

        }
    }


    /**
     * Finds key action words
     * @param command
     */
    public void userAction(String command){
        if (command.contains("walk")){
            walkDirection(command);
    
        } else if(command.contains("fly")){
            //Fly();
            printSlow("this ability is not available yet");

        } else if (command.contains("drop")){
            this.character.drop(command);

        } else if (command.contains("take")||command.contains("grab")){
            this.character.drop(command);

        } else if (command.contains("sleep")){
            this.character.actionSleep();

        }  else if (command.contains("drink")){
            this.character.actionDrink(command);

        } else if (command.contains("check")){
            this.character.actionCheck(command);

        }
    }
    
    /**
     * Finds the direction the user wants to go.
     * @param command
     */
    public void walkDirection(String command){
        if (command.contains("north")){
            walkNorth(command);

        } else if (command.contains("south")){
            walkSouth(command);

        } else if(command.contains("west")){
            walkWest(command);

        } else if (command.contains("east")){
            walkEast(command);

        } else{
            printSlow("Please enter a valid direction: north, south, east or west.");

        }
    }

    /**
     * Moves up one column in the map. 
     * @param command user command.
     */
    public void walkNorth(String command){
        if (this.character.locationC == 0){
            throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

        } else {
            this.character.locationC-=1;
            this.character.health -= 1;
        }
        
    }

    /**
     * Moves down one one column in the map.
     * @param command user command.
     */
    public void walkSouth(String command){
        if (this.character.locationC == 5){
            throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

        } else {
            this.character.locationC+=1;
            this.character.health -= 1;
        }
    }

    /**
     * Moves user one row to the left in the map.
     * @param command user command.
     */
    public void walkWest(String command){
        if (command.contains("west") || command.contains("West")){
            if (this.character.locationR == 0){
                throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

            } else {
                this.character.locationR -= 1;
                this.character.health -= 1;

            }
        }
    }

    /**
     * Moves user one row to the right in the map.
     * @param command user command.
     */
    public void walkEast(String command){
        if (command.contains("east") || command.contains("East")){
            if (this.character.locationR == 5){
                throw new RuntimeException("You have reached the North most edge of Wonderland. Please try a different direction.");

            } else {
                this.character.locationR += 1;
                this.character.health -= 1;

            }
        }
    }

    /**
     * Investigates place on the map and sends character to that place
     */
    public void investigate(){
        if (this.map[this.character.locationC][this.character.locationR].contains("pill")){
            printSlow("You can use grab(\"pill\") to learn more.");

        } if (this.map[this.character.locationC][this.character.locationR].contains("fungi")){
            printSlow("You can use grab(\"fungi\") to learn more.");

        } if (this.map[this.character.locationC][this.character.locationR].contains("water")){
            printSlow("You can drink (\"water\") to learn more.");

        } if (this.map[this.character.locationC][this.character.locationR].contains("door")){
            //printSlow("You can use use(\"door\") to learn more.");    
            printSlow("This function is coming soon.");    


        } if (this.map[this.character.locationC][this.character.locationR].contains("croquet")){
            Croquet croquet = new Croquet(this.character);
            croquet.play();

        } if (this.map[this.character.locationC][this.character.locationR].contains("caterpillar")){
            this.fungiForest.conversation();

        } if (this.map[this.character.locationC][this.character.locationR].contains("Tulgeywoods")){
            this.tulgeyWoods.play();

        } if (this.map[this.character.locationC][this.character.locationR].contains("gabled")){
            MarchManor marchManor = new MarchManor(this.character);
            marchManor.play();

        }if (this.character.canFly && (this.map[this.character.locationC][this.character.locationR].contains("pill") || this.map[this.character.locationC][this.character.locationR].contains("fungi") 
        || this.map[this.character.locationC][this.character.locationR].contains("water") || this.map[this.character.locationC][this.character.locationR].contains("door") 
        || this.map[this.character.locationC][this.character.locationR].contains("croquet") || this.map[this.character.locationC][this.character.locationR].contains("caterpillar"))){
          
            printSlow("Note: If you grab an item you will lose the ability to fly.");
    
        }
    }

    public static void main(String[] args){
        Wonderland wonderland = new Wonderland();

        wonderland.printSlow("Welcome to your adventure in wonderland!");

        //game loop
        boolean runGame = true;

        while (runGame == true){
        
            wonderland.printSlow("***********************");
            //wonderland.promptEnterKey();

            wonderland.play();

            while (wonderland.character.health >= 0){
                wonderland.printSlow("What direction do you want to go?");
            }

        }


    }
}