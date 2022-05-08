package net.GLEB.App;

import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.Commands.Executable;
import net.GLEB.FileWork.WorkFile;
import net.GLEB.JSON.Workerable;

import java.util.HashMap;
import java.util.Set;

//App class- это интерфейс всего приложения.Пользователь будет использовать этот класс в качестве основного.
public class App {

    private final UI ui;
    private final Dispatcher dispatcher;

    public App(HashMap<String, Executable> commandsMap, Set<StoredType> set, StoredTypeReader reader, String filename, Workerable worker, WorkFile fileRead){
        ui = new UI();
        reader.setUI(ui);
        dispatcher = new Dispatcher(commandsMap, set, reader, filename, worker, fileRead);
    }
    public void start(){
        while (dispatcher.getEnabled()){
            String line = ui.getNextCommand();
            ui.print(dispatcher.dispatch(line.trim()));
        }
    }

}