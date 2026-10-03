package move;
import ru.ifmo.se.pokemon.*;
public final class DreamEater extends SpecialMove {
    public DreamEater() {
        super(Type.PSYCHIC, 100, 1.0);
    }
    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        if (def.getCondition() == Status.SLEEP) {
            super.applyOppDamage(def, damage);
        } else {
            super.applyOppDamage(def, 0);
        }
    }
    @Override
    protected void applySelfDamage(Pokemon p,double damage){
        if (damage>0){
            super.applySelfDamage(p,-(int)(damage/2));
        }
    }
    @Override
    protected String describe() {
        return "Использует DreamEater";
    }
}