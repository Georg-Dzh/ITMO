public class ConsolePrinter implements Printer {
    @Override
    public void print(Printable printable) {
        System.out.println(printable.getPrintText());
    }
}