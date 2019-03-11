package hashcode;

import java.util.*;

public class Photo {
    public ArrayList<String> tags = new ArrayList<String>();
    public static int autoIncrement = 0;
    public int id;
    boolean orientation = true; // Horizontal
    
    public Photo()
    {
        this.id=autoIncrement;
        autoIncrement++;
    }
}
