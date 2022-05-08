package net.GLEB.FileWork;

import net.GLEB.App.UI;

import java.io.BufferedReader;
import java.io.File;

public class FileReader implements WorkFile {

    private UI ui;

    public FileReader(){}

    @Override
    public String readFile(String filename) {
        StringBuilder answ = new StringBuilder();
        try {
            File file = new File("resources/" + filename);
            java.io.FileReader fileReader = new java.io.FileReader(file);
            // поток,подключается к нашему текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); //мы сейчас стараеимся соединить BufferedReader вместе с  FileReader

            String line;
            while((line = bufferedReader.readLine()) != null) {
                answ.append(line).append(";");
            }

            bufferedReader.close();
            // сейчас мы закрываем поток
        } catch (Exception e) {
            return "Извините,неверное имя файла";
        }
        return answ.toString();
    }

    @Override
    public void setUI(UI ui) {
        this.ui = ui;
    }

    public UI getUi() {
        return ui;
    }
}