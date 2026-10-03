package move;
import ru.ifmo.se.pokemon.*;
public final class Hurricane extends SpecialMove {
    public Hurricane(){
        super(Type.FLYING,110,0.7);
    }
    @Override
    protected void applyOppEffects(Pokemon def){
        if (Math.random()<0.3){
            Effect.confuse(def);
        }
    }
    @Override
    protected String describe(){
        return "Использует Hurricane";
    }
}