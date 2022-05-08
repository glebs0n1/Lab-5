package commands;

import java.util.HashMap;
import java.util.LinkedHashSet;
import generatedClasses.Route;

public interface Command {

    void execute(HashMap<String, Command>  man, LinkedHashSet<Route> routes, String arg);

    String getDescription();

    String getName();
}
