import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileUtils {
    public static void copyFile(String source, String destination) throws FileCopyFailedException, FileAlreadyExistsException {
        File destinationFile = new File(destination);
        if (destinationFile.exists()) {
            throw new FileAlreadyExistsException("Файл уже существует: " + destination);
        }

        Path copied = Paths.get(destination);
        Path originalPath = Paths.get(source);
        try {
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\033[1;32mФайл скопирован!");
        } catch (IOException e) {
            throw new FileCopyFailedException(e.getMessage());
        }
    }

    public static void createTextFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь, где хотите создать файл:");
        String destination = scanner.nextLine();
        try {
            // Создаем буферизованный  символьный входной поток
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));
            // Используем класс PrintWriter для вывода
            PrintWriter out = new PrintWriter(new FileWriter(destination));
            // Записываем строки, пока не введем строку "stop"
            System.out.println("Введите необходимый текст, нажмите Enter, чтобы он добавился в файл; Введите stop и " +
                    "нажмите enter чтобы закончить создание файла");
            while (true) {
                String s = in.readLine();
                if (s.equals("stop"))
                    break;
                out.println(s);
            }
            out.close();
            System.out.println("\033[1;32mФайл создан!");
        } catch (IOException ex) {
            // Обработать исключение
            System.out.println("\033[1;31mВы ввели некорректный путь, попробуйте заново");
            System.out.println();
        }
    }

    public static void renameYourFile() throws FileAlreadyExistsException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь файла, который хотите переименовать:");
        try {
            Path source = Paths.get(scanner.nextLine());
            System.out.println("Введите новое название файла");
            Files.move(source, source.resolveSibling(scanner.nextLine() + ".txt"));
            System.out.println("\033[1;32mФайл переименован!\n");
        } catch (FileAlreadyExistsException e){
            System.out.println("\033[1;31mФайл с таким названием уже существует\n");
        }
    }
    public static void outputTextFileToConsole() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь файла, который хотите вывести в консоль:\033[0m");
        try {
            BufferedReader in = new BufferedReader(new FileReader(scanner.nextLine()));
            System.out.println();
            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
            in.close();
        } catch (IOException e){
            System.out.println("\033[1;31mПрозошла ошибка вывода файла в консоль");
        }
    }
}


