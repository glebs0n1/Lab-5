package net.GLEB.Commands;
import net.GLEB.App.Dispatcher;

public interface Executable{
    String syntax = "";
    String exec(String command, Dispatcher dispatcher);
}