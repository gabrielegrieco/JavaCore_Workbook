package part2.GiocoInterfacce.Planeswalkers;

import part2.GiocoInterfacce.CreatureTypes.Human;
import part2.GiocoInterfacce.Character.Character;

public class Hero extends Character implements Human {

    // prop
    private String HeroName;
    private int StrenghtOfThePride;
    private int ArmorOfTheHero;


    // getter and setter
    private String getHeroName() {return HeroName;}
    private void setHeroName(String heroName) {HeroName = heroName;}
    private int getStrenghtOfThePride() {return StrenghtOfThePride;}
    private void setStrenghtOfThePride(int strenghtOfThePride) { StrenghtOfThePride = strenghtOfThePride;}
    public int getArmorOfTheHero(){return ArmorOfTheHero;}
    public void setArmorOfTheHero(int armorOfTheHero){ArmorOfTheHero = armorOfTheHero;}

    // methods, for the hero
    @Override
    public void attack() {
        System.out.println(getHeroName() + " deals " + getStrenghtOfThePride() + " damages to the opponent ");
    }
    @Override
    public String getStrenght() {
        return getHeroName() +"life: " + getArmorOfTheHero();
    }
    private Hero(String name, int strenghtOfThePride, int thoughnessOfTheHero){
        setHeroName(name);;
        setStrenghtOfThePride(strenghtOfThePride);
        setArmorOfTheHero(thoughnessOfTheHero);
    }
    public static Hero generateNewHero(String nameOfTheHero, int strenghtOfTheHero, int thoughnessOfTheHero){
        return new Hero(nameOfTheHero, strenghtOfTheHero, thoughnessOfTheHero);
    }
    // fremo per implementare all'eroe il metodo secondSunrise :D !!!!
}
