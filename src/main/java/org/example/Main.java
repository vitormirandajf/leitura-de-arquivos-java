package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] lines = new String[] {"Good morning","Good afternoon","Good night" };
        String path = "c:\\temp\\outSaida.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) { //Acrescentando um segundo parametro true, ele não recriará o arquivo e sim inserir apos as linhas
            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e ) {
            e.printStackTrace();
        }

    }
}