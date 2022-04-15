package Dao;



import model.Section;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectionDaoImplementation implements SectionDao{
    static Connection con = DatabaseConnection.getConnection();
    @Override
    public List<Section> getSection()
            throws SQLException
    {
        String query = "select * from section";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Section> ls = new ArrayList();

        while (rs.next()) {
            Section section=new Section();
            section.setId(rs.getInt("id"));
            section.setSection_no(rs.getString("section_no"));
            section.setTiming(rs.getString("timing"));
            section.setSeat_remaining(rs.getInt("remaining_seats"));
            ls.add(section);
        }
        return ls;
    }

    @Override
    public void update(Section section)  throws SQLException
    {
        String query = "update section set remaining_seats=? where section_no = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, section.getSeat_remaining()-1);
        ps.setString(2, section.getSection_no());
        ps.executeUpdate();
    }

}
