package move;
import ru.ifmo.se.pokemon.*;
public final class Facade extends PhysicalMove {
    public Facade(){
        super(Type.NORMAL,70,1.0);
    }
    @Override
    protected double calcBaseDamage(Pokemon p,Pokemon def){
        if (p.getCondition()==Status.BURN||p.getCondition()==Status.POISON||p.getCondition()==Status.PARALYZE){
            return 2*super.calcBaseDamage(p,def);
        } else {
            return super.calcBaseDamage(p,def);
        }
    }
    @Override
    protected String describe(){
        return "Использует Facade";
    }
}