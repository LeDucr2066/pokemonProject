import java.util.Scanner;
import java.util.Random;

public class poke {
    //Declaring Variables
    //I don't know if this is the correct way to do this, but I don't know of any other way, and it works
    public static Random rand = new Random();
    public static String chosenPokemon;
    public static Scanner userInput = new Scanner(System.in);
    public static int damage;
    public static int hp;
    public static int level;
    public static double attack;
    public static double defence;
    public static double spAttack;
    public static double spDefence;
    public static double speed;

    public static void main(String[] args) {
        //Calling
        battleStart();
        damage();
        statsTable();
    }

    public static String battleStart(){
        System.out.println("Another trainer is issuing a challenge");
        System.out.println("Zebstrika has appeared");
        System.out.println("What pokemon do you choose?");
        //Getting input for chosen pokemon name
        chosenPokemon = userInput.next();

        System.out.println("You chose " + chosenPokemon);

        //It wanted me to return the name on the paper, so I did
        //"battleStart() should also return the name of the pokemon chosen."
        //It doesn't actually do anything nor do I ever use it, I just wanted to do it right
        return chosenPokemon;

    }

    public static int damage(){
        //Getting the stats of the pokemon chosen
        //There is probably a much better and neater way to do this but it works
        System.out.println("Input the base stats of your pokemon");
        System.out.println("What is the level?: ");
        level = userInput.nextInt();

        System.out.println("What is the attack?: ");
        attack = userInput.nextDouble();
        System.out.println("What is the special attack?: ");
        spAttack= userInput.nextDouble();

        System.out.println("What is the defence?: ");
        defence = userInput.nextDouble();
        System.out.println("What is the special defence?: ");
        spDefence = userInput.nextDouble();

        System.out.println("What is the base?: ");
        double base = userInput.nextDouble();

        System.out.println("What is the STAB?: ");
        double stab = userInput.nextDouble();

        System.out.println("What is the speed?: ");
        speed = userInput.nextDouble();

        System.out.println("What is the hp?: ");
        hp = userInput.nextInt();

        //Math for the damage
        //Should be noted that this doesn't seem to work right, it always does >1000 damage
        //I also don't know anything about pokemon, so I may be entering stats wrong
        double mod = stab * (0.85 + (1.0 - 0.85) * rand.nextDouble());
        damage = (int)((((2.0 * level + 10.0) / 250.0)) + (attack/defence) * (base + 2.0) * mod);
        hp -= damage;

        //Displaying the damage done
        System.out.println("Zebstrika used Lightningbolt");
        System.out.println(chosenPokemon + " sustained " + damage + " points of damage");
        System.out.println("Your pokemon has " + hp + " hp");

        //Once again it wanted me to return something
        //and once again I never do anything with it
        return hp;
    }

    public static void statsTable(){
        //Saying the stats of the chosen pokemon, once again there is probably a better way
        System.out.println("Name:     " + chosenPokemon);
        System.out.println("Level:    " + level);
        System.out.println("__________________");
        System.out.println("Hp:       " + hp);
        System.out.println("Attack:   " + attack);
        System.out.println("Defence:  " + defence);
        System.out.println("Sp. Atk:  " + spAttack);
        System.out.println("Sp. Def:  " + spDefence);
        System.out.println("Speed:    " + speed);
        System.out.println("__________________");
        System.out.println("Known Moves: Thunder Wave, Hidden Power, Psycho Cut, Recover");
    }
}
