package nextzero.spring.demo.ioc.moattack;


/**
 * nextzero.spring.demo.ioc.moattack
 * 参考《Spring 3.x 企业应用开发实战-陈雄华 林开雄》
 * 电影墨攻-初步理解IoC
 */
public class TestMoAttackMain {

    public static void main(String[] args){
        Director director = new Director();
        director.direct();
    }
}
