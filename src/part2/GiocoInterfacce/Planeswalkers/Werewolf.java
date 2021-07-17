package part2.GiocoInterfacce.Planeswalkers;

import part2.GiocoInterfacce.CreatureTypes.Human;
import part2.GiocoInterfacce.CreatureTypes.Horror;
import part2.GiocoInterfacce.Character.Character;

public class Werewolf extends Character implements Horror, Human {
    // prop
    private boolean BloodMoon;
    private String WereWolfName;
    private int DarknessPower;
    private int LightStrenght;
    private int Thoughness;

    // getter and setter
    private boolean getBloodMoon() {
        return BloodMoon;
    }

    private void setBloodMoon(boolean bloodMoon) {
        BloodMoon = bloodMoon;
    }

    private String getWereWolfName() {
        return WereWolfName;
    }

    private void setWereWolfName(String weewWolfName) {
        WereWolfName = weewWolfName;
    }

    private int getDarknessPower() {
        return DarknessPower;
    }

    private void setDarknessPower(int darknessPower) {
        DarknessPower = darknessPower;
    }

    private int getLightStrenght() {
        return LightStrenght;
    }

    private void setLightStrenght(int lightStrenght) {
        LightStrenght = lightStrenght;
    }

    public int getThoughness() {
        return Thoughness;
    }

    public void setThoughness(int thoughness) {
        Thoughness = thoughness;
    }

    // methods and behavoiurs
    @Override
    public void bites() {
        setDarknessPower(2);
        System.out.println(getWereWolfName() + " deals " + getDarknessPower() + " damages to the opponent ");
    }

    @Override
    public void attack() {
        setLightStrenght(3);
        //if(!BloodMoon){
        System.out.println(getWereWolfName() + " deals " + getLightStrenght() + " damages to the opponent ");
        //}
    /*else if(BloodMoon){
        setDarknessPower(2);
        System.out.println(getWereWolfName() + " deals " + getDarknessPower() + " damages to the opponent ");
    }
     */
    }

    @Override
    public String getStrenght() {
        if (BloodMoon) {
            setThoughness(15);
        } else {
            setThoughness(10);
        }
        return getWereWolfName() + "life: " + getThoughness();
    }

    private Werewolf(String name, boolean bloodMoon) {
        setWereWolfName(name);
        setBloodMoon(bloodMoon);
    }

    public static Werewolf generateWereWolf(String WereWolfName, boolean bloodMoon) {
        return new Werewolf(WereWolfName, bloodMoon);
    }
}
