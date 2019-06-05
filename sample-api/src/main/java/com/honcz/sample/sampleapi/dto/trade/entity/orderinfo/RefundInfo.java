package com.honcz.sample.sampleapi.dto.trade.entity.orderinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author honc.z
 * @date 2019/5/14
 *
 * 订单退款详细信息
 */
@Data
public class RefundInfo {
    @ApiModelProperty(value = "订单ID")
    private Long orderId;
    /**
     * 退款类型 1:退款 - 买家申请退款; 2:退款 - 商家主动退款; 3:退款 - 一键退款
     */
    @ApiModelProperty(value = "退款类型 1:退款 - 买家申请退款; 2:退款 - 商家主动退款; 3:退款 - 一键退款")
    private Integer refundType;

    /**
     * 退款金额
     */
    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundFee;

    /**
     * 退款ID
     */
    @ApiModelProperty(value = "退款ID")
    private Long refundId;

    /**
     * 退款状态 1:买家已经申请退款，等待卖家同意; 10:卖家拒绝退款;
     * 20:卖家已经同意退货，等待买家退货; 30:买家已经退货，等待卖家确认收货;
     * 40:卖家未收到货,拒绝退款; 50:退款关闭; 60:退款成功;
     */
    @ApiModelProperty(value = "退款状态 1:买家已经申请退款，等待卖家同意; 10:卖家拒绝退款;20:卖家已经同意退货，等待买家退货; 30:买家已经退货，等待卖家确认收货;" +
            "40:卖家未收到货,拒绝退款; 50:退款关闭; 60:退款成功;")
    private Integer refundStatus;

    public static void main(String[] args){
        Field[] fields = RefundInfo.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|--"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }

}
