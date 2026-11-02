public class Vetrogon extends AbstractCharacter {
    public Vetrogon(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }

    @Override
    public void performDuty() {
        System.out.println("Ветрогон " + getName() + " устраивает беспорядок на улице.");
    }

    @Override
    public String toString() {
        return "Ветрогон " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }

    @Override
    public void useItem(AbstractItem item, Emotionable target) {
        super.useItem(item, target);

        if (item instanceof WaterBucket) {
            String targetName = (target instanceof AbstractCharacter p) ? p.getName() : "неизвестного";
            System.out.println("Ветрогон " + getName() + " обливает персонажа " + targetName + " из объекта: " + item.getTitle());
            target.changeMood(Mood.ANGRY);
        }
    }
}
