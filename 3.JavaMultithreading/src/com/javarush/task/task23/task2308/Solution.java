package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/

public class Solution {

    public static final class Constants {
       public static final Constants SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = new Constants("The server is currently not accessible.");
       public static final Constants USER_IS_NOT_AUTHORIZED = new Constants("The user is not authorized.");
       public static final Constants USER_IS_BANNED = new Constants("The user is banned.");
       public static final Constants ACCESS_IS_DENIED = new Constants("Access is denied.");

        public Constants(String s) {
        }
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("The server is currently not accessible.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("The server is currently not accessible.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("The user is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("The user is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("The user is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("The user is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }

    public static void main(String[] args) {

    }
}
