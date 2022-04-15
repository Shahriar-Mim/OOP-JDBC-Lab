package Dao;

import model.Section;

import java.sql.SQLException;
import java.util.List;

public interface SectionDao {
    public List<Section> getSection()
            throws SQLException;
    public void update(Section section)
            throws SQLException;
}