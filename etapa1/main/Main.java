package com.etapa1.main;

public class Main {

    private Main() {
        // just to trick checkstyle
    }

    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        //System.out.println(gameInput.getNrRunde());
        Character[][] harta;
        harta = gameInput.getHarta();
        System.out.println(harta[0][1]);
    }
}
