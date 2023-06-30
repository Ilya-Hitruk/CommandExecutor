package org.command.executor.executors;

import org.junit.jupiter.api.Test;

public class TestExecutor {

        @Test
        public void executeCommand() {
            CommandExecutor.execute("org.command.executor.test.classes", new String[] {"print", "--name", "ilya"});

            // имея путь пакета найти все классы анотированные анотацией Command. Реализующие Runnable
            // распарсить аргументы командной строки (1 - получить имя команды(1 аргумент)   2 - распарсить все параметры(имя значение))
            // по имени команды найти класс который отвечает за эту команду
            // найти все филды анотированныые как Param и сопоставить с переданными аргументы
            // создать экземпляр класса
            // засетить все параметры
            // выполнить метод этого класса (классы команд должны реализовывать Runnable)

        }
}
