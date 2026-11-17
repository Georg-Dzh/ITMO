public class WaterBucket extends AbstractItem implements Pourable {
    public WaterBucket(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Ведро: " + getTitle();
    }

    @Override
    public void pour() {
        ConsolePrinter printer = new ConsolePrinter();
        printer.print(new Printable() {
            @Override
            public String getPrintText() {
                return "Вода с плеском выливается из ведра!";
            }
        });
    }
}