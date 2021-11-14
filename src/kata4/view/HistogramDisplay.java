package kata4.view;
import javax.swing.JPanel;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame{
    private final Histogram<String> histogram;
    
    public HistogramDisplay( Histogram<String> histogram){
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel cp= new ChartPanel(createChart(createDataset()));
        return cp;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart jfc = ChartFactory.createBarChart("Histograma JFreeChart",
                "Dominios email", "Nº de emails",dataSet, PlotOrientation.VERTICAL, false, false,
                rootPaneCheckingEnabled);
        return jfc;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key)," ", key);
        }
        return dataSet;
        
    }
    
}
