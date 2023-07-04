package org.exercicio;

import org.exercicio.entities.Produto;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Produto> products = new ArrayList<>();

        String stringSubDir = "C:\\Users\\vitor\\OneDrive\\Documentos\\repositors\\curso-java\\ExercicioModuloArquivos\\src\\main\\java\\org\\exercicio";
        String strPath = "C:\\Users\\vitor\\OneDrive\\Documentos\\repositors\\curso-java\\ExercicioModuloArquivos\\src\\main\\java\\org\\exercicio\\in\\in.txt";
        String strOut = "C:\\Users\\vitor\\OneDrive\\Documentos\\repositors\\curso-java\\ExercicioModuloArquivos\\src\\main\\java\\org\\exercicio\\out\\summary.csv";
        File file = new File(strPath);


        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();

            while(line != null){
                String[] arrInfoProduct = line.split(",",3);
                Produto product = new Produto(arrInfoProduct[0],Double.parseDouble(arrInfoProduct[1]),Integer.parseInt(arrInfoProduct[2]));
                products.add(product);
                line = br.readLine();
            }
            if(products.size() > 0){
                System.out.println("Products saved successfully");
                boolean success = new File(stringSubDir + "\\out").mkdir();
                System.out.println("Directory created success "+ success);
            }else{
                System.out.println("the products were not engraved");
            }
            try ( BufferedWriter bw = new BufferedWriter(new FileWriter(strOut) )){

                for (Produto p : products){
                    String lineOut = p.getName()+","+(p.getPrice() * p.getQuantity())+"";
                    bw.write(lineOut);
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (IOException e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }

}
