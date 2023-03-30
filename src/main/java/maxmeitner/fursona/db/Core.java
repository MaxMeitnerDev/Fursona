package maxmeitner.fursona.db;

import maxmeitner.fursona.Fursona;
import maxmeitner.fursona.db.impl.MySQLDatabase;
import maxmeitner.fursona.db.impl.SQLiteDatabase;
import java.io.File;
import java.sql.SQLException;

public class Core {
    private final Database db;

    public Core() {
        try {
            if (Fursona.getPlugin().getConfig().getBoolean("MySQL.enabled")) {
                db = new MySQLDatabase(Fursona.getPlugin().getConfig().getString("MySQL.host"),
                        Fursona.getPlugin().getConfig().getInt("MySQL.port"),
                        Fursona.getPlugin().getConfig().getString("MySQL.database"),
                        Fursona.getPlugin().getConfig().getString("MySQL.user"),
                        Fursona.getPlugin().getConfig().getString("MySQL.password"));
            } else {db = new SQLiteDatabase(new File(Fursona.getPlugin().getDataFolder(), "fursona.db"));}
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public String getFursona(String playerName) {return db.getFursona(playerName);}

    public void setFursona(String playerName, String fursona) {db.setFursona(playerName, fursona);}

    public void close() {if(db != null) db.close();}
}

