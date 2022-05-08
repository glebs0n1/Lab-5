package net.GLEB;

import net.GLEB.JSON.Workerable;

public interface StoredType extends Comparable<StoredType> {

    int compareTo(StoredType obj);

    String toString(Workerable worker);

    int getEngine();

    String getName();

    long getId();

    void setId(long id);
}