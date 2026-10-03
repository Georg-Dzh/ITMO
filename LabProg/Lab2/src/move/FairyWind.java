package move;
import ru.ifmo.se.pokemon.*;
public final class FairyWind extends SpecialMove{
    public FairyWind(){
        super(Type.FAIRY,40,1.0);
    }
    @Override
    protected String describe(){
        return "Использует FairyWind";
    }
}