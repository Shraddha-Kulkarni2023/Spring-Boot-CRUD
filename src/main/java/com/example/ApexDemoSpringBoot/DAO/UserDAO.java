package com.example.ApexDemoSpringBoot.DAO;

import com.example.ApexDemoSpringBoot.Beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addData(String name, String age, String address) {
        int ans;
        String sql1 = "insert into User1(Name, Age, Address) values (?, ?, ?)";
        ans = jdbcTemplate.update(sql1, name, age, address);
        return ans;
    }

    public int deleteUser(int id) {
        int ans;
        String sql2 = "delete from User1 where id = ?";
        return jdbcTemplate.update(sql2, id);
    }

    public List<User> getUsers() {

        String sql3 = "select * from User1";
        return jdbcTemplate.query(sql3, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        });
    }

    public int updatebyname(int id,String name, String nameval) {
        String sql4 = "update User1 set Name = ? where id = ? and Name = ?";
        return jdbcTemplate.update(sql4,nameval,id,name);

    }

    public int updatebyage(int id, int newage) {
        String sql5 = "update User1 set Age = ? where id = ?";
        return jdbcTemplate.update(sql5, newage,id);
    }

    public int updatebyaddress(int id, String newaddress) {
        String sql6 = "update User1 set Address = ? where id = ?";
        return jdbcTemplate.update(sql6,newaddress,id);
    }

}
