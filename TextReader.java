package sk.kosickaakademia.matorudolf;

import java.io.*;

public class TextReader {
    public void repair(String fileName) {
        BufferedReader reader;
        try {
            if (!new File(fileName).exists()) {
                System.out.println("This file not found!");
                return;
            }
            FileReader fr = new FileReader(fileName);
            File repairedFile = new File("resource/repairedtext.txt");
            repairedFile.createNewFile();
            FileWriter fw = new FileWriter(repairedFile);
            reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                char[] originalLine = new char[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    char c;
                    c = line.charAt(i);
                    if (c == 'I') c = 'Y';
                    else if (c == 'Y') c = 'I';
                    else if (c == 'i') c = 'y';
                    else if (c == 'y') c = 'i';
                    else if (c == '?') continue;
                    fw.write(c);
                }
                fw.write("\n");
            }
            fr.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
