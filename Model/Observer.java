package Model;

import java.util.ArrayList;

public interface Observer {
    //should there be private variable subject here?
    
    public void update(ArrayList<Property> catalog);
}
