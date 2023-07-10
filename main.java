import java.io.*;
import java.util.Scanner;

class assignment {
    String day;
    String description;
    String month;
    Integer dayAsInt;
    int monthAsInt;
}

public class Main {

    public static assignment[] monthFormat(assignment[] arr, int numAssignments){
        for(int i = 0; i < numAssignments; i++){
            if(arr[i].month.equals("January")){
                arr[i].monthAsInt = 1;
            } else if (arr[i].month.equals("February")) {
                arr[i].monthAsInt = 2;
            } else if (arr[i].month.equals("March")) {
                arr[i].monthAsInt = 3;
            } else if (arr[i].month.equals("April")) {
                arr[i].monthAsInt = 4;
            } else if (arr[i].month.equals("May")) {
                arr[i].monthAsInt = 5;
            } else if (arr[i].month.equals("June")) {
                arr[i].monthAsInt = 6;
            } else if (arr[i].month.equals("July")) {
                arr[i].monthAsInt = 7;
            } else if (arr[i].month.equals("August")) {
                arr[i].monthAsInt = 8;
            } else if (arr[i].month.equals("September")) {
                arr[i].monthAsInt = 9;
            } else if (arr[i].month.equals("October")) {
                arr[i].monthAsInt = 10;
            } else if (arr[i].month.equals("November")) {
                arr[i].monthAsInt = 11;
            } else if (arr[i].month.equals("December")) {
                arr[i].monthAsInt = 12;
            }
            else{
                arr[i].monthAsInt = -1;
            }
        }
        return arr;
    }

    public static assignment[] sortDay(assignment[] arr, int numAssignments)
    {
        for(int i = 0; i < numAssignments; i++){
            arr[i].dayAsInt = convertToInt(arr[i]);
        }

        int n = numAssignments;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].dayAsInt < arr[min_idx].dayAsInt) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            assignment temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static assignment[] sortMonth(assignment[] arr, int numAssignments)
    {
        for(int i = 0; i < numAssignments; i++){
            arr[i].dayAsInt = convertToInt(arr[i]);
        }

        int n = numAssignments;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].monthAsInt < arr[min_idx].monthAsInt) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            assignment temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static Integer convertToInt(assignment ass){
        return Integer.parseInt(ass.day);
    }

    public static void main(String[] args) throws Exception {

        String input = "";
        Scanner in = new Scanner(System.in);
        System.out.print("**SYLLABUS APP**\n'!' to end\n'file' to scan new file\n'print' to print assignments\n 'sort' to sort assignments\n******************\n\n");
        input = in.nextLine();
        int numOfAssignments = 0;
        assignment[] listOfAssignments = new assignment[50];
        //initializing all class assignments
        for (int i = 0; i < 50; i++) {
            listOfAssignments[i] = new assignment();
        }
        while (!input.equals("!")) {
            //declaring all necessary variables
            String line;

            //allocating memory in the heap for assignment classes

            if (input.equals("file")) {

                System.out.print("File name: ");
                in.useDelimiter("\n");
                String fileName = in.nextLine();
                //System.out.println();
                //setting the filename
                String path = "/Users/markjosephs/IdeaProjects/syllabusReader/";

                //attempting to open the file
                File syll = new File(path + fileName);

                //checking if file is open and readable
                try {
                    if (!syll.canRead()) {
                        //throws exeption if file is not found
                        throw new FileNotFoundException();
                    }
                } catch (FileNotFoundException a) {
                    System.out.println("File Not Found: " + a);
                }

                //declaring and initializing scanner, named sc
                Scanner sc = new Scanner(syll);

                //setting the delimeter as the newline character
                //sc.useDelimiter("\n");


                //skipping everything in file up to the schedule
                while (!(line = sc.nextLine()).equals("Schedule")) {
                    continue;
                }


                //getting all the date for each assigment, and storing it in respective spot in listOfAssignment array
                while (sc.hasNextLine()) {
                    //System.out.println("inside sc.hasNextLine() loop");
                    //sets the delimeter as the space character so that it grabs just the words
                    sc.useDelimiter(" ");

                    //takes the data from file, will be the month assigment is due
                    line = sc.next();
                    //stores it in correct index of listOfAssignment array
                    listOfAssignments[numOfAssignments].month = line;

                    //takes next data from the file, will be the day assignment is due
                    line = sc.next();
                    listOfAssignments[numOfAssignments].day = line;

                    //sets the delimiter back to the newline character because we want all the data up to the newline for the description
                    //sc.useDelimiter("\n");

                    //gets the description of assigment from the file
                    line = sc.nextLine();
                    //stores description in listOfAssignment array
                    listOfAssignments[numOfAssignments].description = line;

                    //increments numberOfAssignments
                    numOfAssignments++;
                    //System.out.println("incrementing assingments");
                }
                System.out.println("File is read\n");
            }

            if (input.equals("sort")){
                listOfAssignments = sortDay(listOfAssignments, numOfAssignments);
                listOfAssignments = monthFormat(listOfAssignments, numOfAssignments);
                listOfAssignments = sortMonth(listOfAssignments, numOfAssignments);
            }

            if (input.equals("print")) {

                //prints all data collected from the file to the console
                for (int k = 0; k < numOfAssignments; k++) {
                    System.out.println("Month: " + listOfAssignments[k].month);
                    System.out.println("Day: " + listOfAssignments[k].day);
                    System.out.println("Description: " + listOfAssignments[k].description);
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.print("\n");
                }

                System.out.println("Number of assignments: " + numOfAssignments);
                System.out.println("------------------------------------------------");
            }

            input = in.nextLine();

        }
    }
}

