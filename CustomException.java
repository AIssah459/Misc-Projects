import java.util.InputMismatchException;
import java.util.Scanner;

class NegativeWithdrawalException extends Exception {
    String message;
    public NegativeWithdrawalException() {
        this.message = "NegativeWithdrawalException: Attempted to withdraw a negative amount.\n";
    }
    public String getMessage() {
        return this.message;
    }
}

class NegativeDepositException extends Exception {
    String message;
    public NegativeDepositException() {
        this.message = "NegativeDepositException: Attempted to deposit a negative amount.\n";
    }
    public String getMessage() {
        return this.message;
    }
}

class ZeroBalanceException extends Exception {
    String message;
    public ZeroBalanceException() {
        this.message = "ZeroBalanceException: Attempted to open an account with a balance of zero.\n";
    }
    public String getMessage() {
        return this.message;
    }
}

class OverdraftException extends Exception {
    String message;
    public OverdraftException() {
        this.message = "OverdraftException: Attempted to withdraw over you current balance\n";
    }
    public String getMessage() {
        return this.message;
    }
}

class BankAccount {
    double balance;
    
    public BankAccount() {
        this.balance = 100.00;
    }
    public BankAccount(double d) throws ZeroBalanceException{
        if(d <= 0) {
            throw new ZeroBalanceException();
        }
        this.balance = d;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws NegativeWithdrawalException, OverdraftException{
        if(amount < 0) {
            throw new NegativeWithdrawalException();
        }
        if((this.balance - amount) < 0) {
            throw new OverdraftException();
        }
        else {
            this.balance -= amount;
        }
    }

    public void deposit(double amount) throws NegativeDepositException{
        if(amount < 0) {
            throw new NegativeDepositException();
        }
        else {
            this.balance += amount;
        }
    }
}




public class CustomException {
    public static void main(String[] args) {
        int initial, deposit, withdraw;
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter an amount to start your account with: ");
            initial = s.nextInt();
            BankAccount account = new BankAccount(initial);

            System.out.println("Enter an amount to deposit into your account: ");
            deposit = s.nextInt();
            account.deposit(deposit);

            System.out.println("Enter an amount to withdraw from your account: ");
            withdraw = s.nextInt();
            account.withdraw(withdraw);

            System.out.println("Initial amount: " + initial + "\nDeposit: " + deposit + "\nWithdrawal: " + withdraw + "\nBalance: " + account.getBalance());
        }
        catch(NegativeDepositException e) {
            System.out.println(e.getMessage());
            s.close();
        }
        catch(NegativeWithdrawalException e) {
            System.out.println(e.getMessage());
            s.close();
        }
        catch(ZeroBalanceException e) {
            System.out.println(e.getMessage());
            s.close();
        }
        catch(OverdraftException e) {
            System.out.println(e.getMessage());
            s.close();
        }
        catch(InputMismatchException e) {
            System.out.println("Bad input!!!");
            s.close();
        }
        finally {
            System.out.println("Exiting...***");
        }
        s.close();
    } 
}
