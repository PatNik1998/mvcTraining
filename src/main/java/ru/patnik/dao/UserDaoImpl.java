package ru.patnik.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.patnik.entity.User;
@Repository
public class UserDaoImpl implements UserDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addUser(User user) {
       String sql = "INSERT INTO users (first_name, last_name, age, phone) VALUES (?,?,?,?)";
       jdbcTemplate.update(sql,user.getFirstName(), user.getLastName(), user.getAge(),user.getPhone());
    }
}
