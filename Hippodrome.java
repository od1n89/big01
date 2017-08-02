package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by о_О on 17.01.2016.
 */
public class Hippodrome {
    private static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException ignored) {}
        }
    }

    public void move()
    {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print()
    {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        Horse winner = new Horse("", 0, 0);
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > winner.getDistance()) winner = horse;
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main (String[] args)
    {
        game = new Hippodrome();

        Horse firstHorse = new Horse("MrWhite", 3, 0);
        Horse secondHorse = new Horse("MrBlue", 3, 0);
        Horse thirdHorse = new Horse("MrBrown", 3, 0);

        game.getHorses().add(firstHorse);
        game.getHorses().add(secondHorse);
        game.getHorses().add(thirdHorse);

        game.run();
        game.printWinner();
    }
}
