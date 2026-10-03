package move;
import ru.ifmo.se.pokemon.*;
public final class PoisonSting extends PhysicalMove {
    public PoisonSting(){
        super(Type.POISON,15,1.0);
    }
    @Override
    protected void applyOppEffects(Pokemon def){
        if (Math.random()<0.3){
            Effect.poison(def);
        }
    }
    @Override
    protected String describe(){
        return "Использует PoisonSting";
    }
}