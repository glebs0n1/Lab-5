package net.GLEB.App.ObjectInterfaces;

import net.GLEB.JSON.Workerable;

public interface StoredType extends Comparable<StoredType> {

    int compareTo(StoredType obj);

    String toString(Workerable worker);

    Long getEngine();

    String getName();

    long getId();

    void setId(long id);
}