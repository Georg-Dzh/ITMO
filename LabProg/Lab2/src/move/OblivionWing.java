package move;
import ru.ifmo.se.pokemon.*;
public final class OblivionWing extends SpecialMove {
    public OblivionWing(){
        super(Type.FLYING,80,1.0);
    }
    @Override
    protected void applySelfDamage(Pokemon p,double damage){
        if (damage > 0){
            super.applySelfDamage(p,-(int)(damage*0.75));
        }
    }
    @Override
    protected String describe(){
        return "Использует OblivionWing";
    }
}