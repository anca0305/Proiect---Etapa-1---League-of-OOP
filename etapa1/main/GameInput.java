package com.etapa1.main;

import java.util.List;

public class GameInput {
    final Character[][] harta;
    final List<Character> jucatori;
    final Integer[][] pozitiiJucatori;
    final Character[][] mutari;
    final int nrRunde;

    GameInput() {
        harta = null;
        jucatori = null;
        pozitiiJucatori = null;
        mutari = null;
        nrRunde = -1;
    }

    public GameInput(final int iNrRunde, final Character[][] iHarta, final List<Character> iJucatori,
                     final Integer[][] iPozitiiJucatori, final Character[][] iMutari) {
        nrRunde = iNrRunde;
        harta = iHarta;
        jucatori = iJucatori;
        pozitiiJucatori = iPozitiiJucatori;
        mutari = iMutari;
    }

    public Character[][] getHarta() {
        return harta;
    }

    public List<Character> getJucatori() {
        return jucatori;
    }

    public Integer[][] getPozitiiJucatori() {
        return pozitiiJucatori;
    }

    public Character[][] getMutari() {
        return mutari;
    }

    public int getNrRunde() {
        return nrRunde;
    }

    public final boolean isValidInput() {
        boolean hartaDescrisa = harta != null;
        boolean jucatoriInstantiati = jucatori != null && pozitiiJucatori != null;
        boolean jucatoriExistenta = jucatori.size() > 0;

        return hartaDescrisa && jucatoriInstantiati && jucatoriExistenta;
    }
}

