package br.com.jogoforca;

import java.io.*;
import java.util.Random;

public class WordService {

    public Word getRandonWord() {
        BufferedWriter writer;
        File output = new File("output.txt");

        {
            try {
                writer = new BufferedWriter(new FileWriter(output));
                writer.write("Batatinha");
                writer.write("\nEclipse");
                writer.write("\nLaranja");
                writer.write("\nProgramador");
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader reader;

        {
            try {
                reader = new BufferedReader(new FileReader("output.txt"));
                String[] linhas = new String[4];
                for (int i = 0; i < linhas.length; i++) {
                    linhas[i] = reader.readLine();
                }
                String palavraAleatoria;

                int random = (int) (Math.floor(Math.random() * 4 ));
                palavraAleatoria = linhas[random];
                Word word = new Word(palavraAleatoria);
                reader.close();
                output.delete();
                return word;

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}

