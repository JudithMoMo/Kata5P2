/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Mail;

/**
 *
 * @author jmm
 */
public class MailListReaderBD {

    public static List<Mail> read(ResultSet resultSet) throws SQLException {

        List<Mail> list = new ArrayList<>();

        while (resultSet.next()) {
            String email = resultSet.getString("email");
            list.add(new Mail(email));
        }

        return list;

    }

}
