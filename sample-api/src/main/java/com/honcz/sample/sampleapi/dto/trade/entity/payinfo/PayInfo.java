package com.honcz.sample.sampleapi.dto.trade.entity.payinfo;

import com.honcz.sample.sampleapi.dto.trade.entity.platforminfo.PlatformInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author honc.z
 * @date 2019/5/14
 */
@Data
public class PayInfo {
    /**
     * 0:默认值,未支付; 1:微信自有支付; 2:支付宝wap; 3:支付宝wap;5:财付通;7:代付;
     * 8:联动优势; 9:货到付款; 10:大账号代销; 11:受理模式; 12:百付宝; 13:sdk支付;
     * 14:合并付货款; 15:赠品; 16:优惠兑换; 17:自动付货款; 18:爱学贷; 19:微信wap;
     * 20:微信红包支付; 21:返利; 22:ump红包;24:易宝支付; 25:储值卡;27:qq支付;
     * 28:有赞E卡支付; 29:微信条码; 30:支付宝条码; 33:礼品卡支付; 35:会员余额;
     * 36:银行卡支付;37:银行卡支付;72:微信扫码二维码支付;80:店铺余额支付;
     * 90:礼品卡支付;100:代收账户; 300:储值账户; 400:保证金账户; 101:收款码;
     * 102:微信; 103:支付宝; 104:刷卡; 105:二维码台卡; 106:储值卡; 107:有赞E卡;
     * 110:标记收款-自有微信支付; 111:标记收款-自有支付宝; 112:标记收款-自有POS刷卡;
     * 113:通联刷卡支付; 114:标记收款-自定义;200:记账账户; 201:现金; 202:组合支付;203:外部支付;40:分期支付
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payType;

    @ApiModelProperty(value = "支付状态：订单状态 0：未支付 1：支付成功 2：支付失败 3：已过期 4.已取消 5：已确认(异步通知)")
    private Integer payStatus;

    /**
     * 交易类型
     */
    @ApiModelProperty(value = "订单唯一识别码")
    private String bookKey;

    /**
     * 优惠前订单总价
     */
    @ApiModelProperty(value = "优惠前订单总价")
    private BigDecimal totalFee;

    /**
     * 最终支付价格
     */
    @ApiModelProperty(value = "最终支付价格")
    private BigDecimal tradePayment;

    /**
     * 最终收到金额
     */
    @ApiModelProperty(value = "最终收到金额")
    private BigDecimal receivePayment;

    /**
     * 是否包邮
     */
    @ApiModelProperty(value = "是否包邮")
    private Boolean hasPostFee;

    /**
     * 是否包税
     */
    @ApiModelProperty(value = "是否包税")
    private BigDecimal hasTaxFee;

    /**
     * 邮费
     */
    @ApiModelProperty(value = "总邮费")
    private BigDecimal postFee;

    /**
     * 总关税
     */
    @ApiModelProperty(value = "总关税")
    private BigDecimal totalTaxFee;

    /**
     * 支付单流水号
     */
    @ApiModelProperty(value = "支付单流水号")
    private Long transaction;

    /**
     * 外部支付单流水号
     */
    @ApiModelProperty(value = "外部支付单流水号")
    private Long outerTransaction;

    public static void main(String[] args){
        Field[] fields = PayInfo.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|--"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }
}
