package net.GLEB.Commands;

import net.GLEB.App.CollectionWorker;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.JSON.Workerable;
public class SaveCommand implements Executable{

    @Override
    public String exec(String command, Dispatcher dispatcher) {
        dispatcher.getCollectionWorker().save(dispatcher.getFilename(),dispatcher.getWorker());
        return "Saved";//успешно сохранили  коллекцию
    }
}