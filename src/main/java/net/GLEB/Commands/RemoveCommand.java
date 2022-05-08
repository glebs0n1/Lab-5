package net.GLEB.Commands;

import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.UI;

public class RemoveCommand implements Executable{
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        dispatcher.getReader().setUI(new UI());
        try {
            String[] splitted = command.split(" ");

            for (StoredType element : dispatcher.getCollectionWorker().getSet()) {
                if (element.getId() == Long.parseLong(splitted[1])) {
                    dispatcher.getCollectionWorker().remove(element);
                    return "Delete accepted ";
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return "Id Идентификатор не ищет";
        }
        return "Id Идентификатор не действителен ";
    }
}