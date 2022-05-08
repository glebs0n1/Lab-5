package net.GLEB;

import com.google.gson.JsonDeserializer;
import net.GLEB.App.App;
import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.Commands.*;
import net.GLEB.Fuel.FuelReader;
import net.GLEB.FileWork.FileReader;
import net.GLEB.FileWork.WorkFile;
import net.GLEB.JSON.JSONWorker;
import net.GLEB.JSON.Workerable;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main
{
    public static void main( String[] args )
    {
        //Json поиск имени/названия файла
        String filename;
        if(args.length!=0){
            filename = "resources/" + args[0];
        }else {
            filename = "resources/data.json";
        }
        // Инициализация конкретного десериализатора

        JsonDeserializer<StoredType> deserializer = null;

        // Init JSONWorker

        Workerable worker;
        worker = new JSONWorker(deserializer);

        //Инициализация конкретного десериализатора

        HashMap<String, Executable> commands = new HashMap<>();

        commands.put("help", new HelpCommand());
        commands.put("info",new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("update", new UpdateCommand());
        commands.put("remove_by_id", new RemoveCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save",new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("exit", new ExitCommand());
        commands.put("remove_first", new RemoveFirstCommand());
        commands.put("remove_head", new RemoveHeadCommand());
        commands.put("remove_lower", new RemoveLowerCommand());
        commands.put("filter_by_type", new FilterByTypeCommand());
        //commands.put("print_ascending", new PrintAscending());
        //commands.put("print_descending", new PrintDescending());
        // Начально заданный считыватель
        StoredTypeReader reader = (StoredTypeReader) new FuelReader();

        // Уточняет тип наборов

        Set<StoredType> set = new LinkedHashSet<>();

        WorkFile fileRead = new FileReader();

        App app = new App(commands, set, reader ,filename, worker, fileRead);

        app.start();
    }
}