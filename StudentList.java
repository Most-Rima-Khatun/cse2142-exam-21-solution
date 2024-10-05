import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    //Create Reader methods for simpify this code by removing dublicates
    public static String Reader(){
    String line  = Constants.EMPTY;
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constants.STUDENT_TEXT_FILE)));
             line = bufferedReader.readLine();
        } catch (Exception e) {
        }
        return line;
    }
    //Create Writer methods for simpify this code by removing dublicates
    public static void Writer(String substring, String formatdate)
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(Constants.STUDENT_TEXT_FILE, true));
            bufferedWriter.write(Constants.SPLIT + substring + Constants.LIST_LAST_UPDATED + formatdate);
            bufferedWriter.close();
        } catch (Exception e) {
        }

    }
    public static void main(String[] args) {
        if(args == null || args.length !=1){
            System.out.println(Constants.USAGE_WORD);
        }
        if(args.length>1){
            System.out.println("greater than 1");
        }
//		Check arguments
        else if (args[0].equals(Constants.ALL_STUDENT_LIST_SHAW)) {
            System.out.println(Constants.LOADING_DATA);
            Reader(); // Call Reader methods
                String students[] = Reader().split(Constants.SPLIT);
                for (String student : students) {
                    System.out.println(student);
                }

            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].equals(Constants.RANDOM_STUDENT_LIST_SHAW)) {
            System.out.println(Constants.LOADING_DATA);
            Reader(); // Call Reader methods
                System.out.println(Reader());
                String students[] = Reader().split(Constants.SPLIT);
                Random random = new Random();
                int next = random.nextInt();
                System.out.println(students[next]);
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].contains(Constants.ADD)) {
            System.out.println(Constants.LOADING_DATA);

                String substring = args[0].substring(1);
                Date date = new Date();
                String dateformat = Constants.DATEFORMAT;
                DateFormat dateFormat = new SimpleDateFormat(dateformat);
                String formatdate = dateFormat.format(date);
            Writer(substring,formatdate); // Call Writer methods passing arguments values
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].contains(Constants.QUREY)) {
            System.out.println(Constants.LOADING_DATA);
            Reader(); // Call Reader methods
                String students[] = Reader().split(Constants.SPLIT);

                String substring = args[0].substring(1);
                for (int idx = 0; idx < students.length ; idx++) {
                    if (students[idx].equals(substring)) {
                        System.out.println(Constants.FINDOUT);

                    }
                }
            System.out.println(Constants.DATA_LOADED);
        } else if (args[0].contains(Constants.COUNT_STUDENT)) {
            System.out.println(Constants.LOADING_DATA);
            Reader(); // Call Reader methods
                char words[] = Reader().toCharArray();

                int count = 0;
                //This for loop use for counting the number of students in list
                for (char letter : words) {
                    if (letter == Constants.SPACE) {

                            count++;

                    }
                }
                System.out.println(count/2 + Constants.WORD_FOUND + words.length);
            System.out.println(Constants.DATA_LOADED);
        }else {
            System.out.println(Constants.INVALID_ARGUMENTS);
        }
    }
}