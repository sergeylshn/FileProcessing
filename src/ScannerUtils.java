import java.io.IOException;
import java.util.Scanner;

public class ScannerUtils {

    public static String checkTheChoose() throws FileCopyFailedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        switch (choose) {
            case "1", "копировать":
                System.out.println("Введите путь к исходному файлу:");
                String source = scanner.nextLine();
                System.out.println("Введите путь куда хотите скопировать файл");
                String destination = scanner.nextLine();
                FileUtils.copyFile(source, destination);
                break;

            case "2", "создать":
                FileUtils.createTextFile();
                break;

            case "3", "переименовать":
                FileUtils.renameYourFile();
                break;

            case "4", "вывести":
                FileUtils.outputTextFileToConsole();
                break;

            case "5", "найти":
            case "0", "выйти": break;
            default:
                System.out.println("\033[1;31mТакого пункта меню нет, попробуйте заново\n");
        }
        return choose;
    }

}
