package hello;
import java.util.ArrayList;

public class Game {

    public static ArrayList<Contact> masterListIN = new ArrayList<>();
    public static ArrayList<Contact> masterListOUT = new ArrayList<>();

    public void main (String [] args){

        // initial assignments
        for(int x = 0; x <masterListIN.size(); x++){
            if(x == masterListIN.size()-1){
                masterListIN.get(x).assign(masterListIN.get(0));
                break;
            }
            masterListIN.get(x).assign(masterListIN.get(x+1));
        }

        while(masterListIN.size() != 1 ){

            //checking "life status"
            for(int x = 0; x <masterListIN.size(); x++) {
                if (masterListIN.get(x).getLifeStatus() == false) {
                    masterListOUT.add(masterListIN.get(x)) //.assign(masterList.get(x+1));
                    masterListIN.remove(x);
                }
            }

            //re-assigning
            for(int x = 0; x <masterListIN.size(); x++){
                if(x == masterListIN.size()-1){
                    masterListIN.get(x).assign(masterListIN.get(0));
                    break;
                }
                masterListIN.get(x).assign(masterListIN.get(x+1));
            }

        }


   }



}
