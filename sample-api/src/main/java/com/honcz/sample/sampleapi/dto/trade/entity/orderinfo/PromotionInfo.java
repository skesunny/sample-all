package com.honcz.sample.sampleapi.dto.trade.entity.orderinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author honc.z
 * @date 2019/5/14
 *
 * 订单优惠详细信息
 */
@Data
public class PromotionInfo {
    /**
     * 订单优惠金额
     */
    @ApiModelProperty(value = "订单优惠金额")
    private BigDecimal discountFee;

    /**
     * 订单优惠方式
     */
    @ApiModelProperty(value = "订单优惠方式")
    private Integer discountType;

    public static void main(String[] args){
        Field[] fields = PromotionInfo.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|--"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }
}
