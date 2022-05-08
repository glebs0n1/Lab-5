package net.GLEB.Commands;

import net.GLEB.App.CollectionWorker;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.App.UI;
import net.GLEB.JSON.Workerable;
public class HelpCommand implements Executable {
    private final UI ui;

    public static int helpCounter = 0;

    public HelpCommand(){
        ui = new UI();
    }

    @Override
    public String  exec(String command, Dispatcher dispatcher) {
        helpCounter++;
        if(helpCounter == 5){
            helpCounter = 0;
            return "Шутки про котиков закочились и больше нету смешных мемов:(((, пора взять за голову и не умереть на ВТ ";
        }
        return "help : вывести справку по доступным командам"+
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"+
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n"+
                "add {element} : добавить новый элемент в коллекцию\n"+
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n"+
                "remove_by_id id : удалить элемент из коллекции по его id\n"+
                "clear : очистить коллекцию\n"+
                "save : сохранить коллекцию в файл\n"+
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме. \n" +
                "exit : завершить программу (без сохранения в файл) \n" +
                "remove_first : удалить первый элемент из коллекции \n" +
                "remove_head : вывести первый элемент коллекции и удалить его \n"+
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "filter_by_type type : вывести элементы, значение поля type которых равно заданному\n" +
                "print_ascending : вывести элементы коллекции в порядке возрастания\n" +
                "print_descending : вывести элементы коллекции в порядке убывания";
    }
}
