package shiro.demo.dao;

import shiro.demo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hunter on 2017/5/19.
 */
public class UserDao {
    public User getByUsername(Connection connection,String name) throws SQLException {
        User user = null;
        String sql = "select * from t_user where username=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
        }
        return user;
    }
    //根据用户名查找改用户所拥有的角色
    public Set<String> getRoles(Connection conn, String username) throws Exception {
        Set<String> roles = new HashSet<String>();
        String sql = "select * from t_user u, t_role r where u.role_id=r.id and u.username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            roles.add(rs.getString("rolename"));
        }
        return roles;
    }

    //根据用户名查找该用户角色所拥有的权限
    public Set<String> getPerms(Connection conn, String username) throws Exception {
        Set<String> perms = new HashSet<String>();
        String sql = "select * from t_user u, t_role r, t_permission p where u.role_id=r.id and p.role_id=r.id and u.username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            perms.add(rs.getString("permissionname"));
        }
        return perms;
    }
}
