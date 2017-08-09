package nextzero.spring.demo.ioc.moattack;

/**
 * 墨攻剧情类
 * 将进行城口叩问这一剧情
 */
public class MoAttack {
    protected Geli geli;

    /**
     * 通过构造函数参数，将Geli注入到剧情里
     * 依赖于Geli接口，而不关注实际的饰演者
     * @param geli
     */
    public MoAttack(Geli geli){
        this.geli = geli;
    }

    /**
     * 城门叩问剧情
     */
    public void cityGateAsk(){
        geli.responeAsk("墨者革离！");
    }
}
