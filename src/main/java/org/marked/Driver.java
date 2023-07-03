package org.marked;

import org.command.executor.annotations.Command;
import org.command.executor.annotations.Param;

@Command("printInfo")
public class Driver implements Runnable {

    @Param("name")
    private String name;

    @Param("licenceId")
    private int licenceId;

    @Override
    public void run() {
        System.out.println(name + " " + licenceId);
    }
}
