package net.GLEB.Commands;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;
public class RemoveFirstCommand implements Executable {
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        StoredType object = dispatcher.getReader().create(null);
        dispatcher.getCollectionWorker().RemoveFirst(object);
        return "О ДА, удалено успешно ХИХИХИ ";// удалили эл-ент
    }
}