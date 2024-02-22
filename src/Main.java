import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("\033[1;34m-----------Работа с файлом------------");
        System.out.println("1 - копировать файл");
        System.out.println("2 - создать текстовый файл");
        System.out.println("3 - переименовать файл");
        System.out.println("4 - вывести текстовый файл на консоль");
        System.out.println("5 - найти сколько раз встречается слово в выбранном файле");
        System.out.println("0 - выйти из программы");
        System.out.println();

        System.out.println("Введите пункт меню или первое слово пункта для работы с программой");
        try {
           String choose = ScannerUtils.checkTheChoose();
           if (!choose.equals("0"))
               if (!choose.equalsIgnoreCase("выйти"))
                   main(args);
        } catch (FileCopyFailedException e){
            System.out.println("\033[1;31mОшибка создания файла");;
        } catch (IOException e){

        }




    }
}