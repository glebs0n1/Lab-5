package net.GLEB.Commands;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;

/**
 * Команда, реализующая удаление всех элементов меньших  заданный
 */
public class RemoveLoverCommand implements Executable {
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        StoredType object = dispatcher.getReader().create(null);
        dispatcher.getPriorityQueue().removeLower(object);
        return "Удалено успешно";
    }
}