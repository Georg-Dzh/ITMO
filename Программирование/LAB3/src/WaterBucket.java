public class WaterBucket extends AbstractItem {
    public WaterBucket(String title) {
        super(title);
    }
    @Override
    public String toString() {
        return "Ведро: " + getTitle();
    }
}
