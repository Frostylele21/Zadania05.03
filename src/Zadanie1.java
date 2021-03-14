import java.util.Scanner;

public class Zadanie1
{
    public static void main(String[] args) throws Exception
    {
        boolean x = true;

        while (x)
        {
            try{
                Scanner scan = new Scanner(System.in);

                System.out.println("Podaj imię: ");
                String imie = scan.nextLine();

                System.out.println("Podaj nazwisko: ");
                String nazwisko = scan.nextLine();

                System.out.println("Podaj rok urodzenia: ");
                int rok = scan.nextLine();

                Osoba person1 = new Osoba(imie, nazwisko, rok);

                System.out.println(person1.toString());

                x = false;
            }
            catch (Exception e)
            {
                System.out.println("Podałaś/eś nieprawidłowe dane.");
            }
        }
    }
}
