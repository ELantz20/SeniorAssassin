package hello;
import java.util.ArrayList;

public class Game {

    public static ArrayList<Contact> masterList = new ArrayList<>();

    public void main (String [] args){

        while(masterList.size() != 1 ){

            // "assigning"
            for(int x = 0; x <masterList.size(); x++){
                masterList.get(x).assign(masterList.get(x+1));
                if(x == masterList.size()-1){
                    masterList.get(x).assign(masterList.get(0));
                }
            }

            // eliminating

            

        }


   }



}
