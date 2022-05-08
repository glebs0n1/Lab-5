package net.GLEB.Commands;

import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;

public class AddIfMaxCommand  implements Executable {
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        StoredType object = dispatcher.getReader().create("null");
        if (dispatcher.getCollectionWorker().ifMax(object)) {
            dispatcher.getCollectionWorker().insert(object);
            return "Команда Успешно Добавлена  ";
        }else{
            return "Не максимальный";
        }
    }
}