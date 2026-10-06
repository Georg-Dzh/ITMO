import ru.ifmo.se.pokemon.*;
import pokemon.*;
public class Main {
    public static void main (String[] args){
        Battle b = new Battle();
        Pokemon p1 = new Yveltal("Ивэльтал",70);
        Pokemon p2 = new Eevee("Иви",5);
        Pokemon p3 =new Sylveon("Сильвеон",9);
        Pokemon p4 = new Budew("Бюдев",1);
        Pokemon p5 =new Roselia("Розелия",1);
        Pokemon p6 = new Roserade("Роузрейд",1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
