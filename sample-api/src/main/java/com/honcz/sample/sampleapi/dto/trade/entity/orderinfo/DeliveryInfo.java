package com.honcz.sample.sampleapi.dto.trade.entity.orderinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author honc.z
 * @date 2019/5/14
 *
 * 订单物流详细信息
 */
@Data
public class DeliveryInfo {
    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    /**
     * 快递类型(free(卖家包邮),post(平邮),express(快递),ems(EMS),virtual(虚拟发货)，25(次日必达)，26(预约配送)。)
     */
    @ApiModelProperty(value = "快递类型(free(卖家包邮),post(平邮),express(快递),ems(EMS),virtual(虚拟发货)，25(次日必达)，26(预约配送)。)")
    private Integer shippingType;

    /**
     * 物流类型(顺丰等)
     */
    @ApiModelProperty(value = "物流类型（顺丰等）")
    private Integer deliveryType;


    /**
     * 物流状态（未发货，已派件等）
     */
    @ApiModelProperty(value = "物流状态（未发货，已派件等）")
    private Integer deliveryStatus;

    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    private BigDecimal deliveryFee;

    /**
     * 包裹ID
     */
    @ApiModelProperty(value = "包裹ID")
    private String distId;

    /**
     * 物流编号
     */
    @ApiModelProperty(value = "物流编号")
    private String expressNo;

    /**
     * 到店自提信息
     */
    @ApiModelProperty(value = "到店自提信息")
    private String selfFetchInfo;

    /**
     * 物流开始时间
     */
    @ApiModelProperty(value = "发货时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "揽收时间")
    private Date collectTime;

    @ApiModelProperty(value = "派送时间")
    private Date dispatchTime;

    @ApiModelProperty(value = "签收时间")
    private Date signTime;

    public static void main(String[] args){
        Field[] fields = DeliveryInfo.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|--"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }

}
