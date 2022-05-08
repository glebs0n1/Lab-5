package net.GLEB.Commands;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.UI;
import java.util.Arrays;

public class ExecuteScriptCommand implements Executable{
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        UI ui = new UI();
        String[] sorted = command.split(" ");
        dispatcher.getFileReade().setUI(ui);
        try {
            String line = dispatcher.getFileReade().readFile(sorted[1]);
            if (line.equals("Неверное имя файла."))
                line = dispatcher.getFileReade().readFile(sorted[1] + ".txt");

            if (line.equals("Неверное имя файла."))
                return "Неверное имя файла.";
            else {
                sorted = line.split(";");
                for (String e : sorted) {
                    if(e.indexOf("execute_script") == 0)
                        ui.print("\n This can create recursion\n");
                    else {
                        ui.print("\n" + e + ":");
                        ui.print(dispatcher.dispatch(e));
                    }
                }
                return "\n Чтение Завершено ";
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return  " Файла Имени Нету  ";
     //считаем и исполняем скрипт из указанного файла
        }
    }
}