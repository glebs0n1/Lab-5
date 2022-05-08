package net.GLEB.Commands;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;
import java.util.stream.Collectors;

public class FilterByTypeCommand implements Executable{
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        StringBuilder answ = new StringBuilder();
        for (StoredType element: dispatcher.getCollectionWorker().getSet().stream().filter(
                x->x.getName().contains(command.split(" ")[1])).collect(Collectors.toSet())) {
            answ.append(element.toString(dispatcher.getWorker())).append("\n");
        }
        answ.append("Выведена Полная информация");//выводим элементы значение type
        return answ.toString();
    }
}