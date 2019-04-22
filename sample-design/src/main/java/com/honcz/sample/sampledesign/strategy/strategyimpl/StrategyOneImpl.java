package com.honcz.sample.sampledesign.strategy.strategyimpl;

import com.honcz.sample.sampledesign.strategy.Strategy;

/**
 * @author honc.z
 * @date 2019/4/18
 *
 * 策略一
 */
public class StrategyOneImpl extends Strategy {
    @Override
    public String execute(String id) {
        return "this is strategy one";
    }
}
