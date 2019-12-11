package sample.data.setup;

import java.sql.*;

public class H2Init {
    public static void initialize() {
        H2DataBase sql = new H2DataBase("jdbc:h2:mem");

        sql.executeUpdate("DROP TABLE IF EXISTS users;");
        sql.executeUpdate("DROP TABLE IF EXISTS movies;");
        sql.executeUpdate("DROP TABLE IF EXISTS series;");
        sql.executeUpdate("DROP TABLE IF EXISTS myMovieList");
        sql.executeUpdate("DROP TABLE IF EXISTS mySeriesList");

        String tableInitQuery = SQLDataScript.buildTables();
        String movieInitQuery = SQLDataScript.buildMovies();
        String seriesInitQuery = SQLDataScript.buildSeries();
        String usersInitQuery = SQLDataScript.buildUsers();
        sql.executeUpdate(tableInitQuery);
        sql.executeUpdate(movieInitQuery);
        sql.executeUpdate(seriesInitQuery);
        sql.executeUpdate(usersInitQuery);
    }
}
