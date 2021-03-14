public class Osoba
{
    String name;
    String lastName;
    int year;

    public Osoba(String name, String lastName, int year) throws Exception {
        try {
            checkPersonData(name, lastName, year);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        this.name = name;
        this.lastName = lastName;
        this.year = year;
    }

    public static void checkPersonData(String imie, String nazwisko, int rok) throws Exception
    {
        if (imie = null || imie.equals(""))
        {
            throw new Exception("Błędne imię.");
        }

        if (nazwisko == null || nazwisko.equals(""))
        {
            throw new Exception("Błędne nazwisko.");
        }

        if (rok < 1900 || rok > 2020)
        {
            throw new Exception("Podano nieprawidłowy rok.");
        }
    }

    @Override
    public String toString() {
        return "Imię: " +name+ "\nNazwisko: " +lastName+ "\nRok urodzenia: " +year;
    }
}