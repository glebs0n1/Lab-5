package net.GLEB.Commands;

import net.GLEB.App.CollectionWorker;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.JSON.Workerable;

public class ClearCommand implements Executable{
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        dispatcher.getCollectionWorker().clear();
        return " Коллекция очищена ";//мы очистили коллекцию
    }
}