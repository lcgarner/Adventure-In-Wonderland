//imports
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;

/**
* Represents Tulgey Woods.
* @param character the users character.
* @param cat the Cheshire Cat
*/
public class TulgeyWoods{
    //ArrayList<String> areas;
    //int index;
    Character character;
    CheshireCat cat;
    //Boolean hasLantern;
    //Boolean inForest;
    //Boolean newArea;
    //String hasStick;

    /**
     * Constructs Tulgey Woods.
     * @param character the users character.
     * @param cat the Cheshire Cat
     */
    public TulgeyWoods(Character character, CheshireCat cat){
        //this.index = 0;
        this.character = character;
        this.cat = cat;
        //this.hasLantern = false;
        //this.hasStick = false;
        //ArrayList<String> floors = new ArrayList<String>();
        //floors.add("You strip over a large stick.");
    }

    /*Prints the conversation between Cheshire Cat and player*/
    public void play(){

        System.out.println();
        this.character.printSlow("After hours of wandering, you wind up at a crossroads.");
        this.character.printSlow("Suddenly, you hear laughter coming from above.");
        this.character.printSlow(cat.hint("Tulgey"));
        //this.character.printSlow("A striped cat appears in front of you, seemingly out of thin air.");
        this.character.printSlow("This is the Cheshire Cat. He grins from ear to ear, and he speaks in a sing-song voice.");
        this.character.printSlow("Maybe the Cheshire Cat knows the way out of here!");
        this.character.printSlow("    \"What have I found here?\", asks the Cheshire Cat.");
        this.character.printSlow("    \"Nobody. Do you know which way I should go?\", you respond.");
        this.character.printSlow("    \"That depends on where you want to get to.\", he says.");
        this.character.printSlow("    \"It really doesn't matter.\"");
        this.character.printSlow("    \"Then I guess it doesn't matter which way you go!\", exclaims the Cheshire Cat.");

        this.character.printSlow("You realize that the Cheshire Cat is right: It doesn't matter. You wander whichever way you please until you find the end of the woods.");
    }

        //System.out.println("Type \"green\" if you want to take the green path; type \"pink\" if you want to take the pink path.");

        // String start = this.character.command();
        // userAction(start);

        // String command;

        // if (start.contains("enter")){

        //     while (this.inForest){

        //         if (this.newArea == true){
        //             this.newArea = false;

        //             System.out.println(this.areas.get(this.index));
        //         }
        //         command = this.character.command();
        //         userAction(command);
        //     }
        //     System.out.println("Where did the Cheshire Cat come from? And why is his smile so wide?");
        // }

    // }

    // public void userAction(String command){

    // }

    // public boolean hasLantern(){
    //     return this.hasLantern;
    // }

    // public void userAction(String command){
    //     if (command.contains("investigate") || command.contains("check out") || command.contains("go to")){
    //         actionInvestigate(command);

    //     } else if (command.contains("take") || command.contains("grab")){
    //         actionTake(command);

    //     } else if (command.contains("sleep")){
    //         this.character.actionSleep();

    //     } else if (command.contains("drop")){
    //         this.character.drop(command);
            
    //     } else if (command.contains("clue")){
    //         printCommand();
    //     }else {
    //         this.character.printSlow("I don't know that command yet.");
    //     }
    // }

    // public void actionInvestigate(String command){
    //     if (this.area.contains("stick" & this.command.contains("stick")){

    //     }
    // }

    public static void main(String[] args){
        Character a = new Character();
        CheshireCat c = new CheshireCat();
        TulgeyWoods t = new TulgeyWoods(a, c);
        t.play();
    }
}

