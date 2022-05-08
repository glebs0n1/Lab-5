package net.GLEB.App;

import  net.GLEB.App.ObjectInterfaces.StoredType;
import  net.GLEB.JSON.Workerable;
import net.GLEB.App.ObjectInterfaces.*;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;


//CollectionWorker -  класс реализует Storable.

 //содержит коллекцию и методы для работы с ней
public class CollectionWorker implements Storable {

    private Set<StoredType> collection;
    private Date creationDate;

    CollectionWorker(Set<StoredType> list){
        collection = list;
        creationDate = new Date();
    }
    public Set<StoredType> getSet() {
        return collection;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void remove(StoredType key) {
        collection.remove(key);
    }
    public void removeGreater(StoredType object) {
        collection = collection.stream().filter(x -> x.compareTo(object)<=0).collect(Collectors.toSet());
    }

    public int getSize() {
        return collection.size();
    }

    public String getCollectionType() {
        return collection.getClass().getSimpleName();
    }

    public void clear() {
        collection.clear();
    }

    public boolean ifMax(StoredType object) {
        for (StoredType obj : collection){
            if(obj.compareTo(object)>=0)
                return false;
        }
        return true;
    }

    public void save(String fileName, Workerable worker){
        worker.save(this, fileName);
    }

    public void init(String fileName, Workerable worker) {
        try {
            CollectionWorker data = (CollectionWorker) worker.load(fileName, this.getClass());
            if (data == null) {
                data = new CollectionWorker(collection);
            }
            collection = data.getSet();
            creationDate = data.getCreationDate();
        }catch (ClassCastException e){
            System.out.println("Файл битый");
        }
    }

    public void removeLower(StoredType object) {
        collection = collection.stream().filter(x -> x.compareTo(object)>=0).collect(Collectors.toSet());
    }
    public void insert(StoredType object) {
        collection.add(object);
    }

    public int coutEngine(int parseInt) {
        return parseInt;
    }
    public void RemoveFirst(StoredType object) {
    }
}