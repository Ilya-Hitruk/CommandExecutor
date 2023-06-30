package org.command.executor;

import org.command.executor.executors.CommandExecutor;

public class Main {

    public static void main(String[] args) {
        CommandExecutor.execute("org.marked", args);
    }
}


//showInfo --name ilya --age 23  --avgGrade 9.5
//printInfo --name oleg --licenceId 123