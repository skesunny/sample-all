package com.honcz.sample.sampleapi.dto.trade.entity.tradeinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author honc.z
 * @date 2019/5/20
 */
@Data
public class TradeInfo {
    /**
     * 主订单状态 WAIT_BUYER_PAY （等待买家付款，定金预售描述：定金待付、等待尾款支付开始、尾款待付）；
     * TRADE_PAID（订单已支付 ）；
     * WAIT_CONFIRM（待确认，包含待成团、待接单等等。即：买家已付款，等待成团或等待接单）；
     * WAIT_SELLER_SEND_GOODS（等待卖家发货，即：买家已付款）；
     * WAIT_BUYER_CONFIRM_GOODS (等待买家确认收货，即：卖家已发货) ；
     * TRADE_SUCCESS（买家已签收以及订单成功）；
     * TRADE_CLOSED（交易关闭）
     */
    @ApiModelProperty(value = "交易状态")
    private Integer tradeStatus;

    /**
     * 主订单类型 0:普通订单; 1:送礼订单; 2:代付; 3:分销采购单; 4:赠品; 5:心愿单;
     * 6:二维码订单; 7:合并付货款; 8:1分钱实名认证; 9:品鉴; 10:拼团; 15:返利; 35:酒店; 40:外卖;
     * 41:堂食点餐; 46:外卖买单; 51:全员开店; 61:线下收银台订单; 71:美业预约单; 72:美业服务单; 75:知识付费; 81:礼品卡; 100:批发
     */
    @ApiModelProperty(value = "交易类型")
    private Integer tradeType;

    /**
     * 交易创建时间
     */
    @ApiModelProperty(value = "交易创建时间")
    private Date createTime;

    /**
     * 交易修改时间
     */
    @ApiModelProperty(value = "交易修改时间")
    private Date modifyTime;

    /**
     * 交易过期时间
     */
    @ApiModelProperty(value = "交易过期时间")
    private Date expiredTime;

    /**
     * 交易成功时间
     */
    @ApiModelProperty(value = "交易成功时间")
    private Date successTime;

    /**
     * 交易支付时间
     */
    @ApiModelProperty(value = "交易支付时间")
    private Date payTime;

    /**
     * 交易退款状态
     */
    @ApiModelProperty(value = "交易退款状态")
    private Date refundState;

    /**
     *关闭类型 0:未关闭; 1:过期关闭; 2:标记退款; 3:订单取消; 4:买家取消; 5:卖家取消;
     * 6:部分退款; 10:无法联系上买家; 11:买家误拍或重拍了; 12:买家无诚意完成交易; 13:已通过银行线下汇款;
     * 14:已通过同城见面交易; 15:已通过货到付款交易; 16:已通过网上银行直接汇款; 17:已经缺货无法交易
     */
    @ApiModelProperty(value = "关闭类型")
    private Integer closeType;

    /**
     * 物流类型 0:快递发货; 1:到店自提; 2:同城配送; 9:无需发货（虚拟商品订单）
     */
    @ApiModelProperty(value = "物流类型")
    private Integer expressType;

    /**
     * 交易标签
     */
    @ApiModelProperty(value = "交易标签")
    private TradeTag tradeTag;

    /**
     * 交易拓展
     */
    @ApiModelProperty(value = "交易拓展")
    private TradeExtra tradeExtra;
}
