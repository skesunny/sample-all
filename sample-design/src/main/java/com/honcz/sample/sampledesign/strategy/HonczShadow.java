package com.honcz.sample.sampledesign.strategy;

import com.honcz.sample.sampledesign.strategy.strategyimpl.StrategyOneImpl;
import com.honcz.sample.sampledesign.strategy.strategyimpl.StrategyTwoImpl;

/**
 * @author honc.z
 * @date 2019/4/18
 */
public class HonczShadow {
    private Strategy strategy;

    public HonczShadow(Strategy strategy){
        this.strategy = strategy;
    }

    public String excute(String id){
        return strategy.execute(id);
    }

    public static void main(String[] args){
        Strategy strategyOne = new StrategyOneImpl();
        Strategy strategyTwo = new StrategyTwoImpl();
        HonczShadow shadow = new HonczShadow(strategyTwo);
        System.out.println(shadow.excute("1"));
    }
}
