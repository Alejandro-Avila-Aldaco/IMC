package model;

import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private int age;
    private String sex;
    private double height;
    private List<ImcResult> imcHistory;

    public User(String username, String password, String fullname, int age, String sex, double height) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.imcHistory = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullname() { return fullname; }
    public int getAge() { return age; }
    public String getSex() { return sex; }
    public double getHeight() { return height; }
    public List<ImcResult> getImcHistory() { return imcHistory; }

    public void addImcResult(double imc) {
        Date currentDate = new Date();
        imcHistory.add(new ImcResult(imc, currentDate));
        saveImcResult(imc, currentDate);
    }

    private void saveImcResult(double imc, Date imcDate) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO imc_results (user_id, imc, imc_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, this.id);
            stmt.setDouble(2, imc);
            stmt.setTimestamp(3, new Timestamp(imcDate.getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User findUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fullname"),
                    rs.getInt("age"),
                    rs.getString("sex"),
                    rs.getDouble("height")
                );
                user.id = rs.getInt("id");
                user.loadImcHistory();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private void loadImcHistory() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM imc_results WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, this.id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                imcHistory.add(new ImcResult(rs.getDouble("imc"), rs.getTimestamp("imc_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void save(User user) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO users (username, password, fullname, age, sex, height) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFullname());
            stmt.setInt(4, user.getAge());
            stmt.setString(5, user.getSex());
            stmt.setDouble(6, user.getHeight());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                user.id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class ImcResult {
        private double imc;
        private Date imcDate;

        public ImcResult(double imc, Date imcDate) {
            this.imc = imc;
            this.imcDate = imcDate;
        }

        public double getImc() { return imc; }
        public Date getImcDate() { return imcDate; }
    }
}
