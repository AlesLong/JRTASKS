package com.javarush.task.task26.task2613;

public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

   public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i == 1) {
            return INFO;
        }
        if (i == 2) {
            return DEPOSIT;
        }
        if (i == 3) {
            return WITHDRAW;
        }
        if (i == 4) {
            return EXIT;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
