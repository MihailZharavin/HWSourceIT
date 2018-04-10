package HW9;

import java.io.*;
import java.util.*;
import java.io.File;
import java.io.IOException;

public class TextEditor {
    public static void main(String[] args) throws IOException {
        String s = "";//нужна, для подсчета символов
        //------------------------------------Записываем в файл----------------------------------------
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("Ed.txt", true))) {
            String text;
            while (!(text = br.readLine()).equals("exit")) {

                bw.write(text + "\n");
                bw.flush();
            }
        } catch (IOException ex) {

            ex.printStackTrace();
        }

        //---------------------------------Чтение файла и кол-во слов------------------------------------------------
        try (FileReader rf = new FileReader("Ed.txt")) {
            int i;
            int k = 0;
            System.out.println("Файл: ");
            while ((i = rf.read()) != -1) {
                System.out.print((char) i);
                if ((i) == ' ') {
                    k++;
                }
            }
            System.out.println("Количество слов: " + (k + 1));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //------------------------------подсчет кол-ва символов--------------------------------------------------------
        try (Scanner in = new Scanner(new File("Ed.txt"))) {
            while (in.hasNext()) {
                s += in.nextLine();
            }
            s = s.replaceAll(" ", "");
            System.out.println("Кол-во символов: " + s.length());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
