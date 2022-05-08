package net.GLEB.Commands;
import net.GLEB.App.Dispatcher;
import net.GLEB.App.ObjectInterfaces.StoredType;

public class SumOfEnginestCommand implements Executable {
    @Override
    public String exec(String command, Dispatcher dispatcher) {
        long summ = 0;
        for (StoredType element: dispatcher.getCollectionWorker().getSet()) {
            summ = summ + element.getEngine();
        }
        return String.valueOf(summ);
    }
}