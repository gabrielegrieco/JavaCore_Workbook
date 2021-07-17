package part2.GiocoInterfacce.Planeswalkers;

import part2.GiocoInterfacce.CreatureTypes.Horror;
import part2.GiocoInterfacce.Character.Character;

public class Vampire extends Character implements Horror {

        // prop
        private String VampireName;
        private int BloodLust;
        private int VampireThoughness;

        // getter and setter
        private String getVampireName() {
            return VampireName;
        }
        private void setVampireName(String vampireName) {
            VampireName = vampireName;
        }
        private int getBloodLust() {
            return BloodLust;
        }
        private void setBloodLust(int bloodLust) {
            BloodLust = bloodLust;
        }
        public int getVampireThoughness(){return VampireThoughness;}
        public void setVampireThoughness(int vampireThoughness){VampireThoughness = vampireThoughness;}

        // methods for the vampire
        @Override
        public void bites() {
            System.out.println( getVampireName() +  " deals "  + getBloodLust() +  " damages to the opponent");
        }
        @Override
        public String getStrenght() {
            return getVampireName() + " life: " + getVampireThoughness();
        }
        private Vampire(String name, int bloodLust, int thoughness){
            setVampireName(name);
            setBloodLust(bloodLust);
            setVampireThoughness(thoughness);
        }
        public static Vampire generateVampire(String vampireName, int bloodLust, int thoughness){
            return new Vampire(vampireName, bloodLust, thoughness);
        }
}
