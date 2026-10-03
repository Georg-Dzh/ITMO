package pokemon;
import ru.ifmo.se.pokemon.*;
import move.*;
public class Roselia extends Budew{
    public Roselia(String name,int level){
        super(name,level);
        setType(Type.GRASS, Type.POISON);
        setStats(50,60,45,100,80,65);
        addMove(new SeedBomb());
    }
}