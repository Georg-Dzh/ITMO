package move;
import ru.ifmo.se.pokemon.*;
public final class SandAttack extends StatusMove {
    public SandAttack(){
        super(Type.GROUND,0,1.0);
    }
    @Override
    protected void applyOppEffects(Pokemon def){
        def.setMod(Stat.ACCURACY,-1);
    }
    @Override
    protected String describe(){
        return "Использует SandAttack";
    }
}