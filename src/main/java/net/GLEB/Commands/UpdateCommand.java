package net.GLEB.Commands;

import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.UI;

public class UpdateCommand implements Executable {

    @Override
    public String exec(String command, Dispatcher dispatcher) {
        UI ui = new UI();
        dispatcher.getReader().setUI(new UI());
        try {
            String[] splitted = command.split(" ");
            for (StoredType element : dispatcher.getCollectionWorker().getSet()) {
                if (element.getId() == Long.parseLong(splitted[1])) {
                    dispatcher.getCollectionWorker().remove(element);
                    dispatcher.getCollectionWorker().insert(dispatcher.getReader().create(splitted[1]));
                    return "Обновить данные";
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            return "Id Идентификатор не ищет";//задаем ищет ли ID
        }
        return "Id Идентификатор недействителен";//проверяем действителен ли ID
        //обновить значение элемента коллекции
    }
}