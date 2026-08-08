import java.util.Scanner;

public class CSVStudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0];
        String rollNo = fields[1];
        String department = fields[2];

        System.out.println("Name: " + name
                + " | Roll No: " + rollNo
                + " | Dept: " + department);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        parseStudentRecord(scanner.nextLine());
    }
}
