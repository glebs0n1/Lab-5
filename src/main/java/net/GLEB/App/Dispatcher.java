package net.GLEB.App;

import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.App.ObjectInterfaces.StoredTypeReader;
import net.GLEB.Commands.Executable;
import net.GLEB.FileWork.WorkFile;
import net.GLEB.JSON.Workerable;
import net.GLEB.JSON.Workerable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Dispatcher - class contains all objects and make them linked.
public class Dispatcher {
    private final Map<String, Executable> commandsMap = new HashMap<>();
    private final CollectionWorker collectionWorker;
    private final StoredTypeReader reader;
    private final Workerable worker;
    private final String filename;
    private final WorkFile fileReade;
    private boolean enabled = true;

    public Dispatcher(HashMap<String, Executable> commands, Set<StoredType> list, StoredTypeReader reader, String filename, Workerable worker, WorkFile fileRead){
        this.reader = reader;
        this.filename = filename;
        this.worker = worker;
        this.fileReade = fileRead;
        collectionWorker = new CollectionWorker(list);
        collectionWorker.init(filename,worker);
        commandsMap.putAll(commands);
    }

    public String dispatch(String line){
        if(commandsMap.get(line.split(" ")[0].toLowerCase()) != null) {
            Executable command = commandsMap.get(line.split(" ")[0]);
            return command.exec(line, this);
        }
        return "No command";
    }

    public CollectionWorker getCollectionWorker() {
        return collectionWorker;
    }

    public Workerable getWorker(){
        return worker;
    }
    public StoredTypeReader getReader(){
        return reader;
    }

    public String getFilename(){
        return filename;
    }

    boolean getEnabled(){
        return this.enabled;
    }

    public WorkFile getFileReade() {
        return fileReade;
    }

    public void stop(){
        this.enabled = false;
        collectionWorker.save(filename,worker);
    }
}