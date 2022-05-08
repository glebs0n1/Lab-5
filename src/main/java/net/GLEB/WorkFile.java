package net.GLEB;

import net.GLEB.App.UI;

public interface WorkFile {
    String readFile(String filename);
    void setUI(UI ui);
}