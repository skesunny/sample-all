package com.honcz.sample.sampleapi.dto.trade.resp;

import lombok.Data;

/**
 * @author honc.z
 * @date 2019/5/21
 *
 * 创建订单返回参数
 */
@Data
public class TradeCreateRespDTO extends TradeRespDTO{
    private Long outerTradeId;

    private Long tradeId;
}
