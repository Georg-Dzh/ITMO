package pokemon;
import ru.ifmo.se.pokemon.*;
import move.*;
public final class Yveltal extends Pokemon {
    public Yveltal(String name,int level){
        super(name,level);
        setType(Type.DARK,Type.FLYING);
        setStats(126,131,95,131,98,99);
        addMove(new Confide());
        addMove(new OblivionWing());
        addMove(new Hurricane());
        addMove(new DreamEater());
    }
}