package part2.GiocoInterfacce.Character;

public abstract class Character {

    // character name + get and set
    private String CharacterName;
    private String getCharacterName(){return CharacterName;}
    private void setCharacterName(String characterName){CharacterName = characterName;}

    // character strenght method
    public abstract String getStrenght();

    //public abstract String getName();
}
