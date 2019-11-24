package com.etapa1.main;

import java.util.List;

public class GameInput {
    final Character[][] map;
    final List<Character> heroes;
    final Integer[][] heroesPosition;
    final Character[][] moves;
    final int noRounds;

    GameInput() {
        map = null;
        heroes = null;
        heroesPosition = null;
        moves = null;
        noRounds = -1;
    }

    public GameInput(final int mNoRounds, final Character[][] mMap, final List<Character> mHeroes,
                     final Integer[][] mHeroesPosition, final Character[][] mMoves) {
        noRounds = mNoRounds;
        map = mMap;
        heroes = mHeroes;
        heroesPosition = mHeroesPosition;
        moves = mMoves;
    }

    public Character[][] getMap() {
        return map;
    }

    public List<Character> getHeroes() {
        return heroes;
    }

    public Integer[][] getHeroesPosition() {
        return heroesPosition;
    }

    public Character[][] getMoves() {
        return moves;
    }

    public int getNoRounds() {
        return noRounds;
    }

    public final boolean isValidInput() {
        boolean hartaDescrisa = map != null;
        boolean jucatoriInstantiati = heroes != null && heroesPosition != null;
        boolean jucatoriExistenta = heroes.size() > 0;

        return hartaDescrisa && jucatoriInstantiati && jucatoriExistenta;
    }
}

