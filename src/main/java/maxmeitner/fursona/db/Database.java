package maxmeitner.fursona.db;

public interface Database {

    void close();

    void setFursona(String playerName, String fursona);

    String getFursona(String playerName);

}
