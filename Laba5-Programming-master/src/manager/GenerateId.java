package  manager;

import commands.*;
import generatedClasses.*;

public class GenerateId {
    private static Long id;
    private static Long i = new Long(1);

    public static Long giveMeId(){
        id = i;
        i++;
        return id;
    }

}
