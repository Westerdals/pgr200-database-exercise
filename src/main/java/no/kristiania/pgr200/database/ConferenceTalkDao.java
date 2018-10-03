package no.kristiania.pgr200.database;

import java.sql.SQLException;

import javax.sql.DataSource;

public class ConferenceTalkDao {

    private DataSource dataSource;

    public ConferenceTalkDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTableIfNotExists() throws SQLException {
    }

    public void insertTalk(String title, String description) throws SQLException {
    }
}
