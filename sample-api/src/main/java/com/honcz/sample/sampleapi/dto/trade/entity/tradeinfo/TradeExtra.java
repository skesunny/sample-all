package com.honcz.sample.sampleapi.dto.trade.entity.tradeinfo;

import com.honcz.sample.sampleapi.dto.trade.entity.orderinfo.OrderInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author honc.z
 * @date 2019/5/21
 */
@Data
public class TradeExtra {
    @ApiModelProperty(value = "enable前扩展标识位")
    private Integer beforeEnableFlag;
    @ApiModelProperty(value = "关闭订单前扩展标识位")
    private Integer beforeCloseFlag;
    @ApiModelProperty(value = "付款前扩展标识位")
    private Integer beforePayFlag;
    @ApiModelProperty(value = "发货前扩展标识位")
    private Integer beforeShipFlag;
    @ApiModelProperty(value = "确认收货前扩展标识位")
    private Integer beforeConfirmFlag;
    @ApiModelProperty(value = "评价前扩展标识位")
    private Integer beforeRateFlag;
    @ApiModelProperty(value = "退款前扩展标识位")
    private Integer beforeRefundFlag;
    @ApiModelProperty(value = "修改前扩展标识位")
    private Integer beforeModifyFlag;
    @ApiModelProperty(value = "第三方状态，第三方自由定义")
    private Integer thirdPartyStatus;
    @ApiModelProperty(value = "第三方个性化数据")
    private Integer extraData;
    @ApiModelProperty(value = "attributes标记")
    private Integer extAttributes;

    public static void main(String[] args){
        Field[] fields = TradeExtra.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|----"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }

}
