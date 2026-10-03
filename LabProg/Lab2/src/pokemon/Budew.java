package pokemon;
import ru.ifmo.se.pokemon.*;
import move.*;
public class Budew extends Pokemon {
    public Budew(String name,int level){
        super(name,level);
        setType(Type.GRASS,Type.POISON);
        setStats(40,30,35,50,70,55);
        addMove(new DoubleTeam());
        addMove(new SwordsDance());
    }
}