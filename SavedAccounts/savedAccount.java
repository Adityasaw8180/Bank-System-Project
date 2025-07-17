package SavedAccounts;
import java.io.FileWriter;
import java.io.IOException;

 public class savedAccount {
        public static void saveAccounts(String accountNo, int pin, double balance) {
            try {
                FileWriter writer = new FileWriter("accounts.txt", true);
 // true = append mode
                writer.write("Account Number : "+accountNo + ",Pin : " + pin + ", Balance : "+ balance + "\n");
                writer.close();
                System.out.println("Account data saved successfully!");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        }
    }