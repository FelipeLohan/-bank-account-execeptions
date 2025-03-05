import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Account Number: ");
                int accountNumber = sc.nextInt();
                    sc.nextLine();
            System.out.println("Holder Name: ");
                String holderName = sc.nextLine();
            System.out.println("Balance: ");
                Double balance = sc.nextDouble();
                    sc.nextLine();
            System.out.println("Withdraw limit: ");
                Double withdrawLimit = sc.nextDouble();
                    sc.nextLine();

            Account account = new Account(accountNumber, holderName, withdrawLimit, balance);

            System.out.println("Withdraw Amount: ");
                Double withdrawAmount = sc.nextDouble();
                    sc.nextLine();
                        account.withdraw(withdrawAmount);
        }
        catch(RuntimeException e){
            System.out.println("Unknown Error");
            System.out.println(e.getMessage());
        }
        catch(DomainException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}