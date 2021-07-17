package part2.GiocoInterfacce.Arena;

import part2.GiocoInterfacce.Planeswalkers.Hero;
import part2.GiocoInterfacce.Planeswalkers.Vampire;
import part2.GiocoInterfacce.Planeswalkers.Werewolf;
import part2.GiocoInterfacce.Character.Character;

public class Battlefield {
    public static void main(String[] args) {
         /* 1.qui istanzierò 3 oggetti: umano vampiro e licantropo;
            1.1 l'eroe combatte 3 volte;
            1.2 il vampiro combatte 1 volta;
            1.3 il licantropo combatte 2 volte;
            1.4 stampo la forza fisica rimasta a fine combattimento;
         */
        // potrei inserire delle costanti visto che le forza in verità son fisse nell' esercizio ma diciamo che le inserisco a mano

        // flippo la luna piena
        int coin = (int)(Math.random()*10);
        boolean bloodMoon = false;

        if(coin % 2 == 0){
            bloodMoon = true;
        }

        Vampire myVampire = Vampire.generateVampire("Sorin Markov of Innistrad", 2, 15);
        Hero myHero = Hero.generateNewHero("Gideon Jura the Martial Paradigm ", 3, 10);
        Werewolf myWereWolf = Werewolf.generateWereWolf("Ulrich, Ulvenwald Hunter ", bloodMoon);

        // arena;
        Character[] myCharacters = new Character[]{myVampire, myHero, myWereWolf};
        for(int i = 0; i < myCharacters.length; i++){
            String s = myCharacters[i].getStrenght();
            System.out.println(s);
        }
        for(int j = 0; j <= 2; j++){
            myHero.attack();
        }
        for(int j = 0; j < 1; j++){
            myVampire.bites();
        }
        // da implementare bene il cambio del flip;
        for(int k = 0; k < 2; k++){
            if(coin % 2 == 0){
                myWereWolf.bites();
            }
            else if(coin % 2 != 0){
                myWereWolf.attack();
            }
        }
        // da implemento una logica per far combattere tra loro i personaggi;
    }
}
