package com.honcz.sample.sampledesign.strategy;

import com.honcz.sample.sampledesign.strategy.strategyimpl.StrategyOneImpl;
import com.honcz.sample.sampledesign.strategy.strategyimpl.StrategyTwoImpl;

import java.util.Date;

/**
 * @author honc.z
 * @date 2019/4/18
 *
 * 如果我们要封装的算法适合于提供给用户任意使用,是"一整个算法",那么用Strategy模式较好;
 * 如果要封装的变化是一个算法中的部分(换言之,大算法的步骤是固定的),而且我们不希望用户直接使用这些方法,那么应该使用Template Method模式。
 */
public class HonczStrategyShadow {
    /**
     * 影分身持有一个策略，不管这个策略究竟是一还是二
     */
    private Strategy strategy;

    public HonczStrategyShadow(Strategy strategy){
        this.strategy = strategy;
    }

    public String excute(String id){
        return strategy.execute(id);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Strategy strategyOne = new StrategyOneImpl();
        Strategy strategyTwo = new StrategyTwoImpl();
        HonczStrategyShadow shadow = new HonczStrategyShadow(strategyTwo);
        System.out.println(shadow.excute("1"));
        long startTime = System.currentTimeMillis();
        for (int i = 0;i<20000000;i++){
                            Strategy strategyOne2 = StrategyTwoImpl.class.newInstance();
//            Strategy strategy1 = new StrategyOneImpl();
        }

        System.out.println("时间为"+(System.currentTimeMillis()-startTime));
    }
}
