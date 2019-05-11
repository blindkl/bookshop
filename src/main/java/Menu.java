import java.util.Scanner;

public class Menu {
    static Scanner in = new Scanner( System.in );

    static void showListOfBooks()
    {
        System.out.println( "Wyświetl listę książek" );
    }

    static void exit()
    {
        System.out.println( "Wyjdź" );
    }

    static void showMenu()
    {
        System.out.print( "Menu:\n 1. Wyświetl listę książek \n 2. Wyjdź " );
    }

    static void menu()
    {
        int numberOfOption;
        do
        {
            showMenu();
            numberOfOption = in.nextInt();
            switch( numberOfOption )
            {
                case 1 : showListOfBooks();
                    break;
                case 2 : exit();
                    break;
            }
        }
        while( numberOfOption != 2 );
    }
    public static void main(String[] args)
    {
        menu();
    }
}
