package maxmeitner.fursona.db.impl;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import maxmeitner.fursona.db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDatabase implements Database {
    private static HikariDataSource src;

    public MySQLDatabase(String host, int port, String database, String user, String password) throws SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://"+host+":"+port+"/"+database);
        config.setUsername(user);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        src = new HikariDataSource(config);
        try (Connection cn = connect(); Statement st = cn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS fursonas (id INTEGER AUTO_INCREMENT PRIMARY KEY, player TEXT NOT NULL, fursona TEXT NOT NULL)");
        }
    }

    private Connection connect() throws SQLException {return src.getConnection();}

    @Override
    public void setFursona(String playerName, String fursona) {
        try (Connection c = connect()) {
            c.createStatement().executeUpdate("UPDATE fursonas SET fursona = '"+fursona+"' WHERE player = '"+playerName+"'");
        } catch (SQLException e) {throw new RuntimeException(e);}
    }


    @Override
    public String getFursona(String playerName) {
        try (Connection c = connect()) {
            ResultSet result = c.createStatement().executeQuery("SELECT COUNT(*) FROM fursonas WHERE player = '"+playerName+"'");
            result.next();
            if (result.getInt(1) != 0) {
                ResultSet result2 = c.createStatement().executeQuery("SELECT fursona FROM fursonas WHERE player = '"+playerName+"'");
                result2.next();
                return result2.getString(1);
            } else {
                c.createStatement().executeUpdate("INSERT INTO fursonas (player, fursona) VALUES ('"+playerName+"', 'notSelected')");
                // Sets the fursona value to "notSelected" if the player is not found in the database.
                return "notSelected";
            }
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    @Override
    public void close() {src.close();}
}
