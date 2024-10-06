package ru.innopolis.java.homework019.tvapp.repository;

import ru.innopolis.java.homework019.tvapp.model.TV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TVDaoImpl implements TVDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TVDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TV createTV(TV tv) {
        String sql = "INSERT INTO tv (brand, model, screen_size, resolution, price, warranty_years) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tv.getBrand(), tv.getModel(), tv.getScreenSize(), tv.getResolution(), tv.getPrice(), tv.getWarrantyYears());
        return tv;
    }

    @Override
    public TV updateTV(TV tv) {
        String sql = "UPDATE tv SET brand = ?, model = ?, screen_size = ?, resolution = ?, price = ?, warranty_years = ?, updated_at = CURRENT_TIMESTAMP WHERE id = ?";
        jdbcTemplate.update(sql, tv.getBrand(), tv.getModel(), tv.getScreenSize(), tv.getResolution(), tv.getPrice(), tv.getWarrantyYears(), tv.getId());
        return tv;
    }

    @Override
    public void deleteTV(Long id) {
        String sql = "DELETE FROM tv WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public TV getTVById(Long id) {
        String sql = "SELECT * FROM tv WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new TVRowMapper(), id);
    }

    @Override
    public List<TV> getAllTVs() {
        String sql = "SELECT * FROM tv";
        return jdbcTemplate.query(sql, new TVRowMapper());
    }

    private static class TVRowMapper implements RowMapper<TV> {
        @Override
        public TV mapRow(ResultSet rs, int rowNum) throws SQLException {
            TV tv = new TV();
            tv.setId(rs.getLong("id"));
            tv.setBrand(rs.getString("brand"));
            tv.setModel(rs.getString("model"));
            tv.setScreenSize(rs.getBigDecimal("screen_size"));
            tv.setResolution(rs.getString("resolution"));
            tv.setPrice(rs.getBigDecimal("price"));
            tv.setWarrantyYears(rs.getShort("warranty_years"));
            tv.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            tv.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            return tv;
        }
    }
}
