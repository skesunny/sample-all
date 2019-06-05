package com.honcz.sample.sampleapi.dto.trade.entity.platforminfo;

import com.honcz.sample.sampleapi.dto.trade.entity.orderinfo.PromotionInfo;
import com.honcz.sample.sampleapi.dto.trade.req.TradeCreateReqDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * @author honc.z
 * @date 2019/5/21
 */
@Data
public class PlatformInfo {
    @ApiModelProperty(value = "来源平台名称")
    private String sourceName;

    @ApiModelProperty(value = "来源平台id")
    private Long sourceId;

    public static void main(String[] args){
        Field[] fields = PlatformInfo.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|--"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }
}
