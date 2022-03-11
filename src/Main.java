import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class Main {

    public static StringBuilder logs = new StringBuilder();

    public static void main(String[] args) {

        File dirRes = new File("C:\\Games\\res");
        File dirSavegames = new File("C:\\Games\\savegames");
        File dirTemp = new File("C:\\Games\\temp");
        File dirMain = new File("src\\main");
        File dirTest = new File("src\\test");
        File fileMain = new File(dirMain, "Main.java");
        File fileUtils = new File(dirMain, "Utils.java");
        File dirDrawables = new File(dirRes, "drawables");
        File dirVectors = new File(dirRes, "vectors");
        File dirIcons = new File(dirRes, "icons");
        File fileTemp = new File(dirTemp, "temp.txt");

        createDir(dirRes);
        createDir(dirSavegames);
        createDir(dirTemp);
        createDir(dirMain);
        createDir(dirTest);
        createFile(fileMain);
        createFile(fileUtils);
        createDir(dirDrawables);
        createDir(dirVectors);
        createDir(dirIcons);
        createFile(fileTemp);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileTemp))) {
            writer.write(logs.toString());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void createDir(File dir) {
        if (dir.mkdir()) {
            logs.append(LocalDateTime.now()).append(" Директория ")
                    .append(dir.getName()).append(" создана!\n");
        } else {
            logs.append(LocalDateTime.now()).append(" Произошла ошибка при создании директории ")
                    .append(dir.getName()).append("!\n");
        }
    }

    public static void createFile(File file) {
        try {
            if (file.createNewFile()) {
                logs.append(LocalDateTime.now()).append(" Файл ").append(file.getName()).append(" успешно создан!\n");
            } else {
                logs.append(LocalDateTime.now()).append(" Произошла ошибка при создании файла ")
                        .append(file.getName()).append("!\n");
            }
        } catch (IOException exception) {
            logs.append(LocalDateTime.now()).append(" Произошла ошибка при создании файла ").append(file.getName())
                    .append(" - ").append(exception.getMessage()).append("!\n");
        }
    }
}
