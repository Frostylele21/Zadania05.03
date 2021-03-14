import java.util.Locale;
import java.util.Scanner;

public class MainBankException {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Czy chcesz założyć konto?");
        boolean doCreateAccount = getYesNoAnswer();

        if (!doCreateAccount) {
            endProgram();
        }
        Account account = createNewAccount();
        System.out.println("Czy chcesz wypłacić pieniądze?");
        boolean WithdrawMoney = getYesNoAnswer();

        if (!WithdrawMoney) {
            endProgram();
        }
        System.out.println("Ile pieniędzy chcesz wypłacić?");
        int amount = getAmount();

        try {
            InsufficientFundsException(amount, account.getBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            endProgram();
        }

        account.withdraw(amount);
        System.out.printf("Transakcja potwierdzona. Stan konta wynosi teraz: %.2f $", account.getBalance());

    }

    private static Account createNewAccount() {
        System.out.println("Podaj imię: ");
        String name = scanner.nextLine();

        try {
            nameCheck(name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            endProgram();
        }

        System.out.println("Ile środków chcesz wpłacić na swoje konto?");
        int initialAmount = getAmount();
        return new Account(name, initialAmount);
    }

    private static void endProgram() {
        System.out.println("Proces zakończony, dziękujemy za skorzystanie z naszych usług.");
        System.exit(0);
    }

    private static int getAmount() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static boolean getYesNoAnswer() {
        String userAnswer = scanner.nextLine();

        if (userAnswer.toLowerCase().contains("tak")) {
            return true;
        } else if (userAnswer.toLowerCase().contains("nie")) {
            return false;
        } else {
            System.out.println("Wpisz tak lub nie");
            return getYesNoAnswer();
        }
    }

    private static void nameCheck(String name) throws Exception {
        if (name == null || name.equals("")) {
            throw new Exception("Błędne imię.");
        }
    }

    private static void InsufficientFundsException(int amount, double balance) throws Exception {
        if (amount > balance) {
            throw new Exception("Nie możesz wypłacić więcej niż masz na koncie.");
        }
        if (amount < 0) {
            throw new Exception("Podana kwota jest nieprawidłowa.");
        }
    }
}