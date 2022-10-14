package io.github.magicpluginteam.dbapi;

import java.sql.*;

public class SQLite {

    public String uri;

    public SQLite(String uri) {
        this.uri = uri;
    }

    public Connection connect(String url) {
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    public void execute(String sql) {
        try {
            var conn = connect(uri);
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        ResultSet rs = null;
        try {
            var conn = connect(uri);
             Statement stmt  = conn.createStatement();
             rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //empty
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;

    }



}
