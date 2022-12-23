/**
* Represents Cheshire Cat
* @param String hint The cat's hint
*/
public class CheshireCat{

    String hint;

    /*Constructs Cheshire Cat.*/
    public CheshireCat(){
        hint = "The CHESHIRE CAT appears to give you a HINT: ";
    }

    /**
    * Finds correct hint given keyword and adds it to hint
    * @param String hint the cat's hint
    * @return hint the appropriate hint given keyword
    */
    public String hint(String key){
        //figures out specific hint for current location
        if(key == "caterpillar"){
            hint+="The CATERPILLAR is indeed very knowledgeable, but the longer you stay here, the blacker your lungs will get. Try not to talk about yourself too much; it really gets him going. And don't forget--you can't leave without a proper \"goodbye\"! For some reason, the CATERPILLAR is very particular about this sort of thing.";
        }

        if(key == "Tulgey"){
            hint+="Fun fact, I am pretty is well-known around here. Even the Queen is scared of me!";
        }

        //It is possible to add whatever hint you want: just call System.out.println(cat.hint(key_word)) in the appropriate place in your code and add a corresponding if-statement here
        //FOR EXAMPLE:
            // if(key == "gabeled"){
            //     hint+="This is MARCH MANOR., etc.";
            // }

        //returns appropriate hint given key
        return hint;
    }
}
