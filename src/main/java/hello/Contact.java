package hello;

import java.util.ArrayList;

public class Contact{

    private String name;
    private int ID;
    private boolean lifeStatus;
    private String assignment;

    public Contact(String n, int i) {

        name = n;
        ID = i;
        lifeStatus = true;
        Game.masterListIN.add(this);
    }

    public String getName() {

        return name;
    }

    public int getID() {

        return ID;
    }

    public boolean getLifeStatus() {
        return lifeStatus;
    }

    public void setName(String n) {

        name = n;
    }

    public void setID(int i) {

        ID = i;
    }

    public void setLifeStatus(boolean t) {

        lifeStatus = t;
    }

    public void assign(String c) {

        assignment = c;

    }


}
