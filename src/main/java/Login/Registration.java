package Login;

import Login.Password;
import com.example.projektjavafinal.DatabaseConnection;
import entity.PatientsEntity;
import entity.UsersEntity;
import org.hibernate.sql.ast.tree.update.UpdateStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Registration {
    private final DatabaseConnection databaseConnection;

    public Registration(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public Registration() throws SQLException {
        this.databaseConnection = new DatabaseConnection();
    }


    public void addUserToDataBase(String name, String surname, String login, Password password) throws SQLException {
        if (!checkLogin(login)) {
            int nextId = lastID() + 1;
            databaseConnection.addUser("INSERT INTO users(userID,name,surname,login,password) VALUES (" + nextId + ",'" +
                    name + "','" + surname + "','" + login + "','" + password.getPassword() + "')");
            databaseConnection.addUser("INSERT INTO patients(userID,adres) VALUES (" + nextId + ",'" + "W-11 Wydział śledczy"+ "')");
        } else {
            // źle podany login, istnieje już taki w bazie
            System.out.println("Jest juz taki login");
        }
    }

    public void deleteUser(String login,String password) throws SQLException{
        Authentication authentication = new Authentication();
        UsersEntity user;
        user = authentication.authenticate(login,password);
        int idtoDelete = findIDofUser(login);
        if (user instanceof PatientsEntity){
            databaseConnection.addUser("DELETE from patients WHERE userID = '" + idtoDelete + "'");
            databaseConnection.addUser("DELETE FROM users WHERE login = '" + login + "'");
        }
        databaseConnection.addUser("DELETE from doctors WHERE userID = '" + idtoDelete + "'");
        databaseConnection.addUser("DELETE FROM users WHERE login = '" + login + "'");
    }


    /**
     * //TODO TO W OGÓLE POTRZEBNE?
     * Metoda, która zwraca id szukanego użytkownika według podanego loginu
     * @param login
     * @return
     * @throws SQLException
     */
    public int findIDofUser(String login) throws SQLException{
        ResultSet id = databaseConnection.result("SELECT userID FROM users WHERE login = '" + login + "'");
        if(!id.next()) return -1;
        return id.getInt(1);
    }



    /**
     * Metoda, która wypluwa ostatnie ID w tabeli users
     *
     * @return INT największe id w tabeli users
     */
    private int lastID() throws SQLException {
        ResultSet id = databaseConnection.result("SELECT MAX(userID) from users;");
        if (id.next()) {
            return id.getInt(1);
        } else {
            return 0;
        }
    }


    /**
     * Metoda sprawdzająca, czy znajduje się już taki login w BD
     *
     * @param login podany przez użytkownika przy rejestracji
     * @return boolean
     * @throws SQLException exception
     */
    private boolean checkLogin(String login) throws SQLException {
        ResultSet logins = databaseConnection.result("SELECT login from users");
        List<String> logs = new ArrayList<>();
        while (logins.next()) {
            String log = logins.getString("login");
            logs.add(log);
        }
        return logs.contains(login);
    }
//    private String passValidator(String password){
//        String validate = null;
//        int minPasswordLength = 8;
//
//
//        return null;
//    }
}
