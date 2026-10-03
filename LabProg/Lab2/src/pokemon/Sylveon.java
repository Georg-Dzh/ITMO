package pokemon;
import ru.ifmo.se.pokemon.*;
import move.*;
public final class Sylveon extends Eevee {
    public Sylveon(String name,int level){
        super(name,level);
        setType(Type.FAIRY);
        setStats(95,65,65,110,130,60);
        addMove(new FairyWind());
    }
}