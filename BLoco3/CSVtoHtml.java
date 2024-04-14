import org.stringtemplate.v4.*;
import java.io.*;

public class CSVtoHtml {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java CSVtoHtml <csv-file>");
            System.exit(1);
        }
        File ficheiroCSV = new File(args[0]);
        STGroup group = new STGroupFile("html.stg");
        ST table = group.getInstanceOf("table");
        ST row = group.getInstanceOf("row");
        ST header = group.getInstanceOf("header");
        ST data = group.getInstanceOf("data");
        

        

        /* 
        STGroup group = new STGroupFile("csv.stg");
        ST st = group.getInstanceOf("csv");
        st.add("rows", new String[] { "a,b,c", "1,2,3", "4,5,6" });
        System.out.println(st.render());

        */
    }
}
 
 // Path: csv.stg