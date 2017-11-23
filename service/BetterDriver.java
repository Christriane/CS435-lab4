package service;

import database.MySQLConnection;
import ui.TerminalMenu;
import java.sql.Connection;
import java.sql.SQLException;

public class BetterDriver {

    private static TerminalMenu terminalMenu;
    private static MySQLConnection mySQLConnection;
    private static Connection connection;

    public static void main(String[] args) throws SQLException {

        //start a connection to database
        MySQLConnection mySQLConnection = MySQLConnection.getInstance();
        mySQLConnection.startConnection();
        connection = mySQLConnection.getConnection();

//        //create tables - only run once
//        //add checks later
//        MySQLCreateTable mySQLCreateTable = new MySQLCreateTable(connection);
//        mySQLCreateTable.createTables();
//
//        //populate tables - only run once
//        //add checks later
//        MySQLPopulateTable mySQLPopulateTable = new MySQLPopulateTable(connection);
//        mySQLPopulateTable.populateTables();

        //initialize ui
        terminalMenu = new TerminalMenu(connection);
        terminalMenu.menu();
    }
}
