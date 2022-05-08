package net.GLEB.Commands;
import  net.GLEB.App.CollectionWorker;
import  net.GLEB.App.Dispatcher;
import  net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import  net.GLEB.JSON.Workerable;
public class InfoCommand implements Executable {

    @Override
    public String exec(String command, Dispatcher dispatcher) {

        return "Type type: " + dispatcher.getCollectionWorker().getCollectionType() + "\n Данные инициализации: " + dispatcher.getCollectionWorker().getCreationDate() + "\nКоличество элементов: " +  dispatcher.getCollectionWorker().getSize();

    }
}