package pokemon;
import ru.ifmo.se.pokemon.*;
import move.*;
public class Eevee extends Pokemon {
    public Eevee(String name,int level){
        super(name,level);
        setType(Type.NORMAL);
        setStats(55,55,50,45,65,55);
        addMove(new Facade());
        addMove(new Confide());
        addMove(new SandAttack());
    }
}
