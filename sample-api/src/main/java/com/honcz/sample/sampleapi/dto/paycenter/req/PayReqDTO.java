package com.honcz.sample.sampleapi.dto.paycenter.req;

import com.honcz.sample.sampleapi.dto.trade.entity.platforminfo.PlatformInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author honc.z
 * @date 2019/5/28
 */
@Data
public class PayReqDTO {
    @ApiModelProperty(value = "支付ID")
    private Long payId;

    @ApiModelProperty(value = "交易ID")
    private Long tradeId;

    @ApiModelProperty(value = "外部支付单流水号")
    private Long outerTransaction;

    @ApiModelProperty(value = "支付单总金额")
    private BigDecimal orderAmt;

    @ApiModelProperty(value = "实际收款")
    private BigDecimal receivedAmt;

    @ApiModelProperty(value = "来源平台名称")
    private String sourceName;

    @ApiModelProperty(value = "来源平台id")
    private Long sourceId;

    /**
     * 支付类型 WEIXIN (微信支付)ALIPAY (支付宝支付)BANKCARDPAY (银行卡支付)PEERPAY
     * (代付)CODPAY (货到付款)BAIDUPAY (百度钱包支付)PRESENTTAKE (直接领取赠品)COUPONPAY（优惠券/码全额抵扣）
     * BULKPURCHASE（来自分销商的采购）
     */
    @ApiModelProperty(value = "支付方式")
    private Integer payType;

    @ApiModelProperty(value = "支付平台")
    private Integer payPlatform;

    @ApiModelProperty(value = "支付状态：订单状态 0：未支付 1：支付成功 2：支付失败 3：已过期 4.已取消 5：已确认(异步通知)")
    private Integer payStatus;

    @ApiModelProperty(value = "支付状态信息")
    private Long payMsg;

    @ApiModelProperty(value = "支付单类型")
    private Integer orderType;

    @ApiModelProperty(value = "银行流水号（银行打款专用）")
    private String bankSerialNumber;

    @ApiModelProperty(value = "支付（打款）用户id")
    private Integer userId;

    @ApiModelProperty(value = "支付用户名")
    private String userName;

    @ApiModelProperty(value = "收款用户id")
    private Integer receiveUserId;

    @ApiModelProperty(value = "收款用户名")
    private String receiveUserName;

    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @ApiModelProperty(value = "订单更新时间")
    private Date updateTime;

    public static void main(String[] args){
        Field[] fields = PayReqDTO.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }
}
