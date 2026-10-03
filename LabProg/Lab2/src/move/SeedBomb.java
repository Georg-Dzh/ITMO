package move;
import ru.ifmo.se.pokemon.*;
public final class SeedBomb extends PhysicalMove {
    public SeedBomb(){
        super(Type.GRASS,80,1.0);
    }
    @Override
    protected String describe(){
        return "Использует SeedBomb";
    }
}