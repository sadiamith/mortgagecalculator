import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final byte Months_In_Year = 12;
        final byte Percent = 100;

        int principal;
        float monthlyInterest;
        int numberOfPayments;

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Total Loan Amount: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 & 1000000");
        }
        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if(annualInterest >= 1 && annualInterest <=30) {
                monthlyInterest = annualInterest / Percent / Months_In_Year;
                break;
            }
            System.out.println("Enter a value between 1 & 30");
        }
        while(true) {
            System.out.print("Period(years): ");
            byte years = scanner.nextByte();
            if(years >= 1 && years <=30) {
                numberOfPayments = years * Months_In_Year;
                break;
            }
            System.out.println("Enter a value between 1 to 30");
        }

        double mortgage = principal * (monthlyInterest*Math.pow((1+monthlyInterest), numberOfPayments))
                / Math.pow(1+monthlyInterest, (numberOfPayments-1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}