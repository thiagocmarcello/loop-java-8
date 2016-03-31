package loop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 30/03/16.
 */
public class Main {

    public static void main(String... args) {
        long start = System.currentTimeMillis();
        lerArquivo().stream().forEach(a -> naoFazerNada());
        long elapsed = System.currentTimeMillis() - start;
        System.out.println(elapsed);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long start2 = System.currentTimeMillis();
        for (String s : lerArquivo()) {
            naoFazerNada();
        }
        long elapsed2 = System.currentTimeMillis() - start2;
        System.out.println(elapsed2);

    }

    private static List<String> lerArquivo() {
        List<String> arquivoList = new ArrayList<>();
        try {
            FileReader arquivo = new FileReader(new File("um-milhao.txt"));
            BufferedReader arquivoLeitura = new BufferedReader(arquivo);
            arquivoList = getStringList(arquivoLeitura);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arquivoList;
    }

    private static List<String> getStringList(BufferedReader lerArquivo) throws IOException {
        List<String> arquivoList = new ArrayList<>();
        String linha;
        while ((linha = lerArquivo.readLine()) != null) {
            arquivoList.add(linha);
        }
        return arquivoList;
    }

    private static void naoFazerNada() {
    }
}
