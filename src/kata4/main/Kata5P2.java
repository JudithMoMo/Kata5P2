package kata4.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import kata4.model.*;
import kata4.view.*;

public class Kata5P2  {

    private List<Mail> mailList;
    private Histogram<String> mailHistogram;
    private HistogramDisplay histogramDisplay;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet ;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();

    }

    private void input() throws ClassNotFoundException, SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:data/email.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT direccion FROM direcc_email");
    }

    private void output() throws ClassNotFoundException, SQLException{
        this.histogramDisplay.execute();

    }

    private void process() throws ClassNotFoundException, SQLException{
        this.mailList = MailListReaderBD.read(resultSet);
        this.mailHistogram = MailHistogramBuilder.build(mailList);
        this.histogramDisplay = new HistogramDisplay(mailHistogram);

    }

    private void execute()throws ClassNotFoundException, SQLException {
        input();
        process();
        output();

    }

}
