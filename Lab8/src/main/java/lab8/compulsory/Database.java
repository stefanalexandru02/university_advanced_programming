package lab8.compulsory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Virna Stefan Alexandru
 */
public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5455/Albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    private static HikariDataSource dataSource = null;

    /**
     * @return Gets a connection to be used in the app
     */
    public static Connection getConnection() throws SQLException {
        if(connection == null) {
            if(dataSource == null) {
                initializeDataSource();
            }
            connection = dataSource.getConnection();
        }
        return connection;
    }

    /**
     * Creates a new connection
     */
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Closes connection
     */
    public static void closeConnection() {
        try {
            if(!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Creates a new database
     */
    public static void initializeDb() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute("create table if not exists \"Albums\".public.\"artists\" (id serial constraint artists_pk primary key,name varchar(500));\n" +
                    "create table if not exists \"Albums\".public.\"genres\" (id serial constraint generes_pk primary key,name varchar(500));\n" +
                    "create table if not exists \"Albums\".public.\"albums\"\n" +
                    "(\n" +
                    "    id serial\n" +
                    "        constraint albums_pk\n" +
                    "            primary key\n" +
                    "        constraint artist\n" +
                    "            references artists,\n" +
                    "    release_year int,\n" +
                    "    title varchar(500)\n" +
                    ");\n" +
                    "create table if not exists \"Albums\".public.\"albums_genre_assoc\"\n" +
                    "(\n" +
                    "    album_id integer\n" +
                    "        constraint albums_genre_assoc_albums_id_fk\n" +
                    "            references albums,\n" +
                    "    genre_id integer\n" +
                    "        constraint albums_genre_assoc_genres_id_fk\n" +
                    "            references genres\n" +
                    ");\n");
            conn.commit();
            System.out.println("Table artists created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static HikariDataSource getDataSource()
    {
        if (dataSource == null) {
            initializeDataSource();
        }
        return dataSource;
    }

    public static void initializeDataSource()
    {
        HikariConfig config = new HikariConfig();

        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.addDataSourceProperty("serverName", "localhost");
        config.addDataSourceProperty("portNumber", "5455");
        config.addDataSourceProperty("databaseName", "Albums");
        config.addDataSourceProperty("user", USER);
        config.addDataSourceProperty("password", PASSWORD);
        config.setAutoCommit(false);

        // postgress configuration for Hikari
        dataSource = new HikariDataSource(config);
    }
}
