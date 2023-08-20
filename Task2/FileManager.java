import java.io.*;

public class FileManager {
    // Метод для чтения содержимого файла
    public String read(String filePath) throws FileNotFoundException, IOException {
        // Создаем объект для чтения файла
        FileReader fileReader = new FileReader(filePath);
        // Создаем буфер для чтения данных из файла
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // Строка для хранения считанного содержимого файла
        String content = "";
        try {
            // Построчно считываем содержимое файла
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content += line + "n";
            }
        } finally {
            // Закрываем файловые потоки
            bufferedReader.close();
            fileReader.close();
        }
        return content;
    }

    // Метод для записи данных в файл
    public void write(String filePath, String content) throws IOException {
        // Создаем объект для записи в файл
        FileWriter fileWriter = new FileWriter(filePath);
        try {
            // Записываем содержимое в файл
            fileWriter.write(content);
        } finally {
            // Закрываем файловый поток
            fileWriter.close();
        }
    }

    // Метод для копирования файла
    public void copy(String sourceFilePath, String destinationFilePath) throws IOException {
        // Создаем объекты для чтения и записи файлов
        FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath);
        // Буфер для чтения и записи данных
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            // Постепенно считываем и записываем данные, пока не достигнем конца файла
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } finally {
            // Закрываем файловые потоки
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}