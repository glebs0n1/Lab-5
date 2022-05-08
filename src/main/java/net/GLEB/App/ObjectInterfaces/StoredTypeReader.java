package net.GLEB.App.ObjectInterfaces;

import net.GLEB.App.UI;

public interface StoredTypeReader {
    StoredType create(String id);
    void setUI(UI ui);
}