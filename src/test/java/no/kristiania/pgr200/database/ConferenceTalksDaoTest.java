package no.kristiania.pgr200.database;

import java.sql.SQLException;

import javax.sql.DataSource;

import no.kristiania.pgr200.database.ConferenceTalkDao;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.Test;

public class ConferenceTalksDaoTest {

    @Test
    public void shouldInsertConferenceTalks() throws SQLException {
        ConferenceTalkDao dao = new ConferenceTalkDao(createDataSource());
        dao.createTableIfNotExists();
        dao.createTableIfNotExists();
        dao.insertTalk("My Talk Title", "A longer description of the talk");
    }

    private DataSource createDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        dataSource.setUser("sa");
        return dataSource;
    }


}
