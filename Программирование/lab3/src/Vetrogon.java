// Vetrogon.java
public class Vetrogon extends AbstractCharacter {
    public Vetrogon(String name, Opinion opinion, Mood mood, Printer printer) {
        super(name, opinion, mood, printer);
    }

    @Override
    public String getPrintText() {
        return "Ветрогон " + getName() + " устраивает беспорядок на улице.";
    }

    @Override
    public void performDuty() {
        getPrinter().print(this);
    }

    @Override
    public void useItem(AbstractItem item, Emotionable target) {
        try {
            super.useItem(item, target); // проверка на null
            item.use(target);            // предмет сам решает, что делать
        } catch (InvalidItemException e) {
            getPrinter().print(e);
        }
    }

    @Override
    public String toString() {
        return "Ветрогон " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}