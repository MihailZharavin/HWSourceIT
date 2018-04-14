package HW9;

import java.io.*;

public class TextEditorMet {
    public static void Zapis(){
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ed.txt",true)))
        {
            // Запись данных в файл
            String text;
            while(!(text=br.readLine()).equals("exit")){

                bw.write(text + "\n");
                bw.flush();
            }
        }
        catch(IOException ex){

            ex.printStackTrace();
        }
    }
}
