package nextzero.spring.demo.ioc.moattack;

/**
 * 导演类
 * 将Geli角色，Liudehua演员，MoAttack剧情组装起来
 */
public class Director {

    public void direct(){
        Geli geli = new Liudehua();
        MoAttack moAttack = new MoAttack(geli);
        moAttack.cityGateAsk();
    }
}
