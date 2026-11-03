public class WaterBucket extends AbstractItem implements Pourable {
     public WaterBucket(String title) {
        super(title);
    }
    @Override
    public String toString() {
        return "Ведро: " + getTitle();
    }
    @Override
    public void pour(){
        System.out.println("Вода с плеском выливается из ведра!");
    }
}
    
