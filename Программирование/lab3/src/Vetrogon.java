public class Vetrogon extends AbstractCharacter {

    public Vetrogon(String name, Opinion opinion, Mood mood, Printer printer) {
        super(name, opinion, mood, printer);
    }

    @Override
    public void performDuty() {
        getPrinter().print("Ветрогон " + getName() + " устраивает беспорядок на улице.");
    }

    @Override
    public String toString() {
        return "Ветрогон " + getName();
    }
}
