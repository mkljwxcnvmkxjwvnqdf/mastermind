package mastermind.Controller;
import java.sql.Connection;
import java.sql.DriverManager;

public class Bdd {
    private static Bdd instance = new Bdd();

    public static Bdd getInstance() {
        return instance;
    }

    private final String url = "jdbc:mysql://localhost:3306/mastermind";
    private final String user = "root";
    private final String passwd = "";
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    private Bdd() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connecter");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur");
            }
        }
    }
}