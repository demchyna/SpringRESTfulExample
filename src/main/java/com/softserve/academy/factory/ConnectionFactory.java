package com.softserve.academy.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getDBConnection(ConnectionType connectionType) {
        Connection connection = null;

        switch (connectionType) {
            case SIMPLE_CONNECTION : {
                DBSimpleConnection dbSimpleConnection = new DBSimpleConnection();
                try {
                    connection = dbSimpleConnection.getConnection();
                } catch (Exception e) {
                    throw new RuntimeException("The connection wasn't created: " + e.getMessage());
                }
                break;
            }
            case  CONNECTION_POOL : {
                DBConnectionPool dbConnectionPool = new DBConnectionPool();
                try {
                    connection = dbConnectionPool.getConnection();
                } catch (Exception e) {
                    throw new RuntimeException("The connection wasn't created: " + e.getMessage());
                }
                break;
            }
        }
        return connection;
    }
}
