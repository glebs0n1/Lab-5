package net.GLEB.App.ObjectInterfaces;
import  net.GLEB.JSON.Workerable;

import java.util.Date;
import java.util.Set;

public interface Storable {
    Set getSet();
    Date getCreationDate();
    void remove(StoredType key);
    void removeGreater(StoredType object);
    int getSize();
    String getCollectionType();
    void clear();
    void save(String fileName, Workerable worker);
    boolean ifMax(StoredType object);
    void init(String fileName, Workerable worker);
    void removeLower(StoredType object);
    void insert(StoredType hum);
    int coutEngine(int number);
}