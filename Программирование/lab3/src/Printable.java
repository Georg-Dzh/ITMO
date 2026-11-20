public interface Printable {
    String getPrintText();

    default void printTo(Printer printer) {
        printer.print(getPrintText());
    }
}