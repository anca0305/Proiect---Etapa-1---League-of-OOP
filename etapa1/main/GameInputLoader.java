package com.etapa1.main;

import fileio.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    /**
     * Sa inceapa jocul!
     */
    public GameInput load() {
        List<Character> jucatori = new ArrayList<>();
        Character[][] mutari = new Character[0][];
        Character[][] harta = new Character[0][];
        Integer[][] pozitiiJucatori = new Integer[0][];
        String liniaCurenta;
        String mutariRundaCurenta;
        int linii = 0;
        int coloane = 0;
        int nrJucatori = 0;
        int nrRunde = 0;
        int i, j;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            linii = fs.nextInt();
            coloane = fs.nextInt();
            harta = new Character[linii][coloane];

            for (i = 0; i < linii; i++) {
                liniaCurenta = fs.nextWord();
                for (j = 0; j < coloane; j++) {
                    harta[i][j] = liniaCurenta.charAt(j);
                }
            }

            nrJucatori = fs.nextInt();
            pozitiiJucatori = new Integer[nrJucatori][2];

            for (i = 0; i < nrJucatori; ++i) {
                jucatori.add(fs.nextWord().charAt(0));
                pozitiiJucatori[i][0] = fs.nextInt();
                pozitiiJucatori[i][1] = fs.nextInt();
            }

            nrRunde = fs.nextInt();
            mutari = new Character[nrRunde][nrJucatori];

            for (i = 0; i < nrRunde; i++) {
                mutariRundaCurenta = fs.nextWord();
                for (j = 0; j < nrJucatori; j++) {
                    mutari[i][j] = mutariRundaCurenta.charAt(j);
                }
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(nrRunde, harta, jucatori, pozitiiJucatori, mutari);
    }
}
