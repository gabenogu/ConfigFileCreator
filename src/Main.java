
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

/*
THIS IS A GENERAL CONFIG CREATOR FOR YCSB FORMAT USING CLI
this  takes in user input such as record count, operation count, etc.
if a user inputs no value, it has a default,
otherwise it takes in user input
uploads it in a similar format as used in workloads for YCSB

 */


public class Main {
    //these create the command line arguments and sets their default value
    @Option(name="-rc", usage="set record count")
    private int recordREC=1000;
    @Option(name="-oc", usage="set operation record")
    private int operationREC=1000;
    @Option(name="-rp", usage = "set read proportion")
    private double readPROP=0.5;
    @Option(name="-up", usage="set update proportion")
    private double updatePROP=0.5;
    @Option(name="-sp", usage="set scan proportion")
    private double scanPROP=0.0;
    @Option(name="-ip", usage="set insert proportion")
    private double insertPROP=0.0;
    @Option(name="-rq", usage = "set request distribution")
    private String requestDIST="zipfian";


    public static void main(String[] args) throws IOException, CmdLineException {
        Main instance = new Main();

        //create the line parser obj
        CmdLineParser parser = new CmdLineParser(instance);
        //this is a debugging line just in case a parsed value fails
        System.out.println("arguments passed: " + String.join(" ", args));

        //parses the arguments
        parser.parseArgument(args);

        //This prints out the values parsed to the consol for readability
        System.out.println("record count " + instance.recordREC);
        System.out.println("operation count " + instance.operationREC);
        System.out.println("read proportion " + instance.readPROP);
        System.out.println("update proportion " + instance.updatePROP);
        System.out.println("scan proportion " + instance.scanPROP);
        System.out.println("insert proportion " + instance.insertPROP);
        System.out.println("request distribution " + instance.requestDIST);

        //calls the function to create the config file
        instance.createConfigFile();

    }
    private void createConfigFile(){
        /*
        This creates the user config file
        will prompt user for a file path name
        User MUST input full path name
            -Ex. C:\\Users\\your\\Path.txt
        once entered correctly it will create the extra config file with YourName.txt
        Important to note that this simply creates a general structure to the config file and if you
        run it using a YCSB you must remember the location

         */

        //this is used to ensure the errors are met with specifically FileWrite however if there is an error it will let us catch it here
        try {
            //prompts user for file and stores full path as string then stored as File object
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter a config file path name");
            String fileName = scn.nextLine();
            //parse input to file
            File file = new File(fileName);

            //check to see if file is created already
            if (file.createNewFile()) {
                System.out.println("File has been created");
            } else {
                System.out.println("File has already been created");
            }

            //try catch for FileWriter
            try (FileWriter write = new FileWriter(file)) {
                //This is the general structure-output for the config file
                write.write("# This is a user generated config file");
                write.write("# Default data size: 1 KB records (10 fields, 100 bytes each, plus key)");
                write.write("\n");
                write.write("recordcount=" + recordREC + "\n");
                write.write("operationcount=" + operationREC + "\n");
                write.write("workload=site.ycsb.workloads.CoreWorkload" + System.lineSeparator());
                write.write("\n");
                write.write("readallfields=true" + System.lineSeparator());
                write.write("\n");
                write.write("readproportion=" + readPROP + System.lineSeparator());
                write.write("updateproportion=" + updatePROP + System.lineSeparator());
                write.write("scanproportion=" + scanPROP + System.lineSeparator());
                write.write("insertproportion=" + insertPROP + System.lineSeparator());
                write.write("\n");
                write.write("requestdistribution=" + requestDIST + System.lineSeparator());

                write.flush();//always flush or close file after you write to it to ensure data protection
            } catch (IOException e) {
                e.printStackTrace();//prints out an error of the stacktrace in case something goes wrong
            }
        } catch (
                Exception e) {
            e.printStackTrace();//same error trace
        }

    }
}