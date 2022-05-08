package net.GLEB.Commands;

import net.GLEB.App.CollectionWorker;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.JSON.Workerable;

public class ShowCommand implements Executable {
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        StringBuilder answ = new StringBuilder();
        for (StoredType element: dispatcher.getCollectionWorker().getSet()) {
            answ.append(element.toString(dispatcher.getWorker())).append("\n");
        }
        answ.append("Это полная информация");//должно вывести элементы коллекции
        return answ.toString();
    }
}