package com.honcz.sample.sampleapi.dto.trade.req;

import com.honcz.sample.sampleapi.dto.trade.entity.addressinfo.AddressInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.orderinfo.DeliveryInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.orderinfo.OrderInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.orderinfo.RefundInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.payinfo.PayInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.platforminfo.PlatformInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.tradeinfo.TradeInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.userinfo.BuyerInfo;
import com.honcz.sample.sampleapi.dto.trade.entity.userinfo.SellerInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author honc.z
 * @date 2019/5/21
 *
 * 创建订单dto
 */
@Data
public class TradeCreateReqDTO extends TradeReqDTO{

    /**
     * 交易信息结构体
     */
    @ApiModelProperty(value = "交易信息结构体")
    private TradeInfo tradeInfo;

    /**
     * 支付信息
     */
    @ApiModelProperty(value = "交易支付信息结构体")
    private PayInfo payInfo;

    /**
     * 买家信息结构体
     */
    @ApiModelProperty(value = "买家信息结构体")
    private BuyerInfo buyerInfo;

    /**
     * 卖家信息结构体
     */
    @ApiModelProperty(value = "卖家信息结构体")
    private SellerInfo sellerInfo;

    /**
     * 买/卖家信息结构体
     */
    @ApiModelProperty(value = "平台信息结构体")
    private PlatformInfo platformInfo;

    /**
     * 地址信息结构体
     */
    @ApiModelProperty(value = "地址信息结构体")
    private AddressInfo addressInfo;

    /**
     * 子订单信息
     */
    @ApiModelProperty(value = "交易子订单信息结构体")
    private List<OrderInfo> orderInfo;

}
