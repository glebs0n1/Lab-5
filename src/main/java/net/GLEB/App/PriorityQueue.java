package net.GLEB.App;

import net.GLEB.App.ObjectInterfaces.Storable;
import net.GLEB.App.ObjectInterfaces.StoredType;
import net.GLEB.JSON.Workerable;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class PriorityQueue  implements Storable {

    private Set<StoredType> collection;
    private Date creationDate;

    public PriorityQueue (Set<StoredType> list){
        collection = list;
        creationDate = new Date();
    }

    @Override
    public Set<StoredType> getSet() {
        return collection;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean remove(StoredType key) {
        return collection.remove(key);
    }

    @Override
    public void removeGreater(StoredType object) {
        collection = collection.stream().filter(x -> x.compareTo(object)<=0).collect(Collectors.toSet());
    }

    @Override
    public int getSize() {
        return collection.size();
    }

    @Override
    public String getCollectionType() {
        return collection.getClass().getSimpleName();
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
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
            PriorityQueue  data = (PriorityQueue ) worker.load(fileName, this.getClass());
            if (data == null) {
                data = new PriorityQueue (collection);
            }
            collection = data.getSet();
            creationDate = data.getCreationDate();
        }catch (ClassCastException e){
            System.out.println("Файл битый");
        }
    }

    @Override
    public void removeLower(StoredType object) {
        collection = collection.stream().filter(x -> x.compareTo(object)>=0).collect(Collectors.toSet());
    }

    @Override
    public boolean insert(StoredType object) {
        boolean flag = false;
        for (StoredType obj: collection){
            if(object.equals(obj)){
                flag = true;
                break;
            }
        }
        if(!flag)
            collection.add(object);

        return !flag;
    }

    public int coutAge(int number){
        int cnt = 0;

        for (StoredType obj : collection)
            if(obj.getAge()<number)
                cnt++;
        return cnt;
    }

}