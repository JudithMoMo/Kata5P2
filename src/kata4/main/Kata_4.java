package kata4.main;

import java.util.List;
import kata4.model.*;
import kata4.view.*;

public class Kata_4 {

    private List<Mail> mailList;
    private Histogram<String> mailHistogram;
    private HistogramDisplay histogramDisplay;
    private String filename;

    public static void main(String[] args) {
        Kata_4 kata4 = new Kata_4();
        kata4.execute();

    }

    private void input() {
        filename = new String("C:\\Users\\anime\\OneDrive\\Documentos\\NetBeansProjects\\Kata_4\\email.txt");

    }

    private void output() {
        this.histogramDisplay.execute();

    }

    private void process() {
        this.mailList = MailListReader.read(filename);
        this.mailHistogram = MailHistogramBuilder.build(mailList);
        this.histogramDisplay = new HistogramDisplay(mailHistogram);

    }

    private void execute() {
        input();
        process();
        output();

    }

}
