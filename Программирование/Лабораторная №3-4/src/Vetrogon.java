public class Vetrogon extends Personage {
    public Vetrogon(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }
    @Override
    public void performDuty(){
        System.out.println("Ветрогон " + getName() + " устраивает беспорядок на улице.");
    }
    @Override
    public String toString() {
        return "Ветрогон " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
    @Override
    public void useItem(Item item, Personage target) {
        super.useItem(item, target); // Вызов проверки на "сломанность"

        if (item instanceof WaterBucket) {
            System.out.println("Ветрогон " + getName() + " обливает персонажа " + target.getName() + " из объекта: " + item.getTitle());
            target.becomeAngry();
        }
    }


}