package  manager;

import commands.*;
import generatedClasses.*;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


//Invoker
public class Driver {
    private HashMap<String, Command> man = new HashMap();

    public Driver (Command ... com) {
        for (Command comm : com) {
            register(comm.getName(), comm);
        }

    }


    public void register(String commandName, Command command) {
        man.put(commandName, command);
    }

    public void execute(String commandName, LinkedHashSet<Route> routes, String arg)  {

        //Scanner sc = new Scanner(System.in);
        commandName = commandName.trim();

        if (commandName.indexOf(" ")!=-1) {
            String s = commandName.substring(0, commandName.indexOf(" "));
            arg = commandName.substring(commandName.indexOf(" "), commandName.length());
            arg = arg.trim();

            commandName = s;

        }

        Command command = man.get(commandName);
            if (command == null) {
                throw new IllegalStateException("no command registered for " + commandName);
            } else {
                command.execute(man, routes, arg);
            }

    }






}
