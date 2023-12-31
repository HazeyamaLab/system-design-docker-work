package control;

import dao.SampleDao;
import model.Sample;

import java.sql.Connection;
import java.util.List;

public class SampleManager {

    private Connection connection = null;

    private void createConnection(SampleDao dao) {
        this.connection = dao.createConnection();
    }

    private void closeConnection(SampleDao dao) {
        dao.closeConnection(this.connection);
        this.connection = null;
    }

    public List<Sample> getSample() {
        SampleDao dao = new SampleDao();
        createConnection(dao);
        List<Sample> sample = dao.findAll(connection);
        closeConnection(dao);
        return sample;
    }

}