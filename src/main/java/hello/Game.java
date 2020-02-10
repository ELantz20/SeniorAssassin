package hello;
import java.util.ArrayList;

public class Game {

    public static ArrayList<Contact> masterList = new ArrayList<>();

    public void main (String [] args){

        // initial assignments
        for(int x = 0; x <masterList.size(); x++){
            masterList.get(x).assign(masterList.get(x+1));
            if(x == masterList.size()-1){
                masterList.get(x).assign(masterList.get(0));
            }
        }

        while(masterList.size() != 1 ){

            //checking "life status"
            for(int x = 0; x <masterList.size(); x++){
                if(masterList.get(x).getLifeStatus() == false){
                    masterList.get(x).assign(masterList.get(x+1));
                }

                if(x == masterList.size()-1){
                    masterList.get(x).assign(masterList.get(0));
                }
            }

            // "assigning"
            for(int x = 0; x <masterList.size(); x++){
                masterList.get(x).assign(masterList.get(x+1));
                if(x == masterList.size()-1){
                    masterList.get(x).assign(masterList.get(0));
                }
            }

            // playing the game



        }


   }



}
