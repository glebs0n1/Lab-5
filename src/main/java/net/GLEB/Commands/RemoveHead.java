package net.GLEB.Commands;

import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.UI;

/**
 * Команда, реализующая удаление элемента из коллекции
 */
public class RemoveHead implements Executable{
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        dispatcher.getReader().setUI(new UI());
        try {
            String[] splitted = command.split(" ");

            for (StoredType element : dispatcher.getPriorityQueue().getSet()) {
                if (element.getId() == Long.parseLong(splitted[1])) {
                    dispatcher.getPriorityQueue().remove(element);
                    return "Delete accept";
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return "do not search!!!";
        }
        return "is not valid";
    }
}