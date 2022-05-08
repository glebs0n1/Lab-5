package net.GLEB.Commands;

import net.GLEB.App.CollectionWorker;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.JSON.Workerable;

public class ExitCommand implements Executable {
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        dispatcher.stop();
        return "Finally Work in the console is finished \n";//завершаем программу
        //без сохранения в файл
    }
}