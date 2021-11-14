package kata4.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail {

    public final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getDom() {
        String splitSecond = this.mail.substring(this.mail.indexOf("@") + 1);
        String res = this.mail.substring(this.mail.indexOf("@") + 1);
        return res;
    }

    public static boolean isMail(String line) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return true;
        }else{
            return false;
        }
    }

}
