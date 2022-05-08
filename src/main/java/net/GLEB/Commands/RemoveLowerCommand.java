package net.GLEB.Commands;

import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;

public class RemoveLowerCommand implements Executable {
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        StoredType object = dispatcher.getReader().create(null);
        dispatcher.getCollectionWorker().removeLower(object);
        return "Удалено успешно";//реализуюет удаление всех элементов меньшие, чем заданный
    }
}