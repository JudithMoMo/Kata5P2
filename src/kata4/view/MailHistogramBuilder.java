package kata4.view;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;


public class MailHistogramBuilder {
    public static Histogram <String> build(List<Mail> mailList){
        Histogram <String> mailHistogram = new Histogram();
        
        for (Mail mail : mailList) {
            mailHistogram.increment(mail.getDom());
        }
        return mailHistogram;
    }
}