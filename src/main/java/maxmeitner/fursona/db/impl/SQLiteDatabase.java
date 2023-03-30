package maxmeitner.fursona.db.impl;

import maxmeitner.fursona.db.Database;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDatabase  implements Database {
    private final String url;

    public SQLiteDatabase(File file) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            url = "jdbc:sqlite:"+file.getAbsolutePath();
            try (Connection cn = connect(); Statement st = cn.createStatement()) {
                st.executeUpdate("CREATE TABLE IF NOT EXISTS fursonas ('id' INTEGER NOT NULL, 'player' TEXT NOT NULL, 'fursona' TEXT NOT NULL, PRIMARY KEY ('id'))");
            }
        } catch (Exception e) {throw new RuntimeException(e);}
    }

    private Connection connect() throws SQLException {return DriverManager.getConnection(url);}

    @Override
    public void setFursona(String playerName, String fursona) {
        try (Connection c = connect()) {
            c.createStatement().executeUpdate("UPDATE fursonas SET fursona = '"+fursona+"' WHERE player = '"+playerName+"'");
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    @Override
    public String getFursona(String playerName) {
        try (Connection c = connect()) {
            if (c.createStatement().executeQuery("SELECT COUNT(*) FROM 'fursonas' WHERE player = '"+playerName+"'").getInt(1) != 0) {
                return c.createStatement().executeQuery("SELECT fursona FROM 'fursonas' WHERE player = '"+playerName+"'").getString(1);
            } else {
                c.createStatement().executeUpdate("INSERT INTO 'fursonas' ('player', 'fursona') VALUES ('"+playerName+"', 'notSelected')");
                // Sets the fursona value to "notSelected" if the player is not found in the database.
                return "notSelected";
            }
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    @Override
    public void close() {}
}