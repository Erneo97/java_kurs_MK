package homework;

import homework.generator.HoldingGenerator;
import homework.model.*;
import homework.model.Currency;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercises {

    private static final List<Holding> holdings = new HoldingGenerator().generate();

    public static void main(String[] args) {
        System.out.println("liczbę holdingów company > 1: " + getHoldingsWhereAreCompanies());
        System.out.println("Lista nazw holdingów: " + getHoldingNames());
        System.out.println("Nazwa holdingów: " + getHoldingNamesAsString());
        System.out.println("Liczba firm w holdingach: " + getCompaniesAmount());
        System.out.println("Liczba pracowników w firmach: " + getAllUserAmount());
        System.out.println("Lista firm LinkedList " + getAllCompaniesNamesAsLinkedList());

        System.out.println("\nLista firm LinkedList " + getUsersForPredicate(user -> user.getSex() == Sex.MAN));
        System.out.println("Lista firm LinkedList " + getUsersForPredicate(user -> user.getFirstName().charAt(0) == 'M'));
        System.out.println("Lista firm LinkedList " + getUsersForPredicate(user -> user.getSex() == Sex.WOMAN));

        System.out.println("executeForEachCompany println nazwa ");
        executeForEachCompany(company -> System.out.println("\t " + company.getName()));

        Map<String, Account> mapAcounts = createAccountsMap();
        System.out.printf("%10s %12s\n", "nr. rachunku", "Rachunek");
        for (String acount : mapAcounts.keySet()) {
            System.out.printf("\t%10s %12s\n", acount, mapAcounts.get(acount).getAmount().toString());
        }
        System.out.println("getUserNames: " + getUserNames());
        showAllUser();
    }

    /**
     * Napisz metodę, która zwróci liczbę holdingów, w których jest przynajmniej jedna firma.
     */
    public static long getHoldingsWhereAreCompanies() {
        return holdings.stream()
                .filter(holding -> holding.getCompanies().size() > 1)
                .count();
    }

    /**
     * Napisz metodę, która zwróci nazwy wszystkich holdingów pisane z wielkiej litery w formie listy.
     */
    public static List<String> getHoldingNames() {
        return holdings.stream()
                .map(holding -> holding.getName().toUpperCase())
                .toList();
    }

    /**
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    public static String getHoldingNamesAsString() {
        String holdingStr = holdings.stream()
                .map(Holding::getName)
                .sorted()
                .collect(Collectors.joining(", "));
        return String.format("(%s)", holdingStr);
    }

    /**
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    public static long getCompaniesAmount() {
        return holdings.stream()
                .mapToLong(holding -> holding.getCompanies().size())
                .sum();
    }


    /**
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    public static long getAllUserAmount() {
        return getCompanyStream()
                .mapToLong(companies -> companies.getUsers().size())
                .sum();
    }

    /**
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    public static LinkedList<String> getAllCompaniesNamesAsLinkedList() {
        return holdings.stream()
                .map(Holding::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LinkedList::new));
    }

    /**
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    public static BigDecimal getAccountAmountInPLN(Account account) {
        return account
                .getAmount()
                .multiply(BigDecimal.valueOf(account.getCurrency().rate))
                .round(new MathContext(4, RoundingMode.HALF_UP));
    }

    /**
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    public static Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {
        return getUserStream()
                .filter(userPredicate)
                .map(User::getFirstName)
                .collect(Collectors.toSet());
    }

    /**
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    public static void executeForEachCompany(Consumer<Company> consumer) {
        getCompanyStream()
                .forEach(consumer);
    }

    /**
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    public static Optional<User> getRichestWoman() {
        return Optional.empty();
    }

    private static BigDecimal getUserAmountInPLN(final User user) {
        return null;
    }

    /**
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    private static Set<String> getFirstNCompany(final int n) {
        return null;
    }

    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    public static Map<String, List<User>> getUserPerCompany() {
        return null;
    }

    /**
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika, wyrzuca
     * wyjątek IllegalArgumentException.
     */
    public static User getUser(final Predicate<User> predicate) {
        return null;
    }

    /**
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    public static Map<String, Account> createAccountsMap() {
        return getAccoutStream()
                .collect(Collectors.toMap(
                        Account::getNumber,
                        account -> account
                ));
    }

    /**
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    public static String getUserNames() {
        return getUserStream()
                .map(User::getFirstName)
                .distinct()
                .collect(Collectors.joining(" "));
    }

    /**
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    public static void showAllUser() {
        getUserStream()
                .sorted(Comparator.comparing(User::getFirstName, Comparator.reverseOrder()))
                .forEach(user ->  System.out.printf("%s %s, ", user.getFirstName(), user.getLastName()));
    }

    /**
     * Zwraca zbiór walut w jakich są rachunki.
     */
    public static Set<Currency> getCurenciesSet() {
        return null;
    }

    /**
     * Zwraca strumień wszystkich firm.
     */
    private static Stream<Company> getCompanyStream() {
        return holdings.stream()
                .flatMap(holding -> holding.getCompanies().stream());
    }

    /**
     * Tworzy strumień użytkowników.
     */
    private static Stream<User> getUserStream() {
        return getCompanyStream()
                .flatMap(company -> company.getUsers().stream());
    }

    /**
     * Tworzy strumień rachunków.
     */
    private static Stream<Account> getAccoutStream() {
        return getUserStream()
                .flatMap(user -> user.getAccounts().stream());
    }

}
