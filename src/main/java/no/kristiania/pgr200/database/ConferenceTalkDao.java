package no.kristiania.pgr200.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConferenceTalkDao {

    private DataSource dataSource;

    public ConferenceTalkDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createTableIfNotExists() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            conn.createStatement().executeUpdate("create table if not exists CONFERENCE_TALK (TITLE varchar primary key, DESCRIPTION text)");
        }
    }

    public void insertTalk(String title, String description) throws SQLException {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "insert into CONFERENCE_TALK (TITLE, DESCRIPTION) values (?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.setString(2, description);

                statement.executeUpdate();
            }
        }
    }
}
