public class Vetrogon extends AbstractCharacter {

    public Vetrogon(String name, Opinion opinion, Mood mood, Printer printer) {
        super(name, opinion, mood, printer);
    }

    @Override
    public void performDuty() {
        getPrinter().print("Ветрогон " + getName() + " устраивает беспорядок на улице.");
    }

    @Override
    public void useItem(AbstractItem item, Emotionable target) {
        try {
            super.useItem(item, target);
            item.use(target);
        } catch (InvalidItemException e) {
            getPrinter().print(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Ветрогон " + getName();
    }
}