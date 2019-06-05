package com.honcz.sample.sampleapi.dto.trade.entity.orderinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * @author honc.z
 * @date 2019/5/14
 */
@Data
public class OrderInfo {
    @ApiModelProperty(value = "订单ID")
    private Long orderId;

    @ApiModelProperty(value = "外部订单id")
    private Long outerOrderId;

    @ApiModelProperty(value = "订单状态(TRADE_NO_CREATE_PAY(没有创建支付宝交易)WAIT_BUYER_PAY(等待买家付款)" +
            "WAIT_SELLER_SEND_GOODS(等待卖家发货,即:买家已付款)" +
            "WAIT_BUYER_CONFIRM_GOODS(等待买家确认收货,即:卖家已发货)" +
            "TRADE_BUYER_SIGNED(买家已签收,货到付款专用)TRADE_FINISHED(交易成功) " +
            "TRADE_CLOSED(付款以后用户退款成功，交易自动关闭)" +
            "TRADE_CLOSED_BY_USER(付款以前，卖家或买家主动关闭交易)PAY_PENDING(国际信用卡支付付款确认中))")
    private Integer orderStatus;

    /**
     * 订单原金额
     */
    @ApiModelProperty(value = "订单原金额")
    private BigDecimal orderPrice;

    /**
     * 订单关税
     */
    @ApiModelProperty(value = "订单关税")
    private BigDecimal orderTaxFee;

    /**
     * 运费
     */
    @ApiModelProperty(value = "运费")
    private BigDecimal deliveryFee;

    /**
     * 订单优惠金额
     */
    @ApiModelProperty(value = "订单优惠金额")
    private BigDecimal discountFee;

    /**
     * 订单优惠金额
     */
    @ApiModelProperty(value = "手工调整金额")
    private BigDecimal adjustFee;

    /**
     * 子订单最终价，子订单实付金额。精确到2位小数，单位:元。如:200.07，表示:200元7分。
     * 对于多子订单的交易，计算公式如下：payment = price * num + adjust_fee - discount_fee ；
     * 单子订单交易，payment与主订单的payment一致，对于退款成功的子订单，由于主订单的优惠分摊金额，会造成该字段可能不为0.00元。建议使用退款前的实付金额减去退款单中的实际退款金额计算。
     */
    @ApiModelProperty(value = "子订单最终价")
    private BigDecimal totalFee;

    @ApiModelProperty(value = "订单标题")
    private String title;

    /**
     * 商品原单价
     */
    @ApiModelProperty(value = "商品原单价")
    private BigDecimal itemPrice;


    /**
     * 商品原单价
     */
    @ApiModelProperty(value = "商品最终分摊价")
    private BigDecimal itemPayment;

    /**
     * 商品现价
     */
    @ApiModelProperty(value = "商品现价")
    private BigDecimal itemSalePrice;

    @ApiModelProperty(value = "商品数量")
    private Integer num;

    @ApiModelProperty(value = "商品类型0：普通商品;10：分销商品;")
    private Integer itemType;

    @ApiModelProperty(value = "中台skuId")
    private String skuId;

    @ApiModelProperty(value = "中台itemId")
    private String itemId;

    @ApiModelProperty(value = "外部skuid")
    private String outerSkuId;

    @ApiModelProperty(value = "外部itemid")
    private String outerItemId;

    @ApiModelProperty(value = "商品规格信息")
    private String skuPropertiesName;

    @ApiModelProperty(value = "商品品牌")
    private String brand;

    @ApiModelProperty(value = "商品品牌id")
    private String brandId;

    @ApiModelProperty(value = "商品类目")
    private String catName;

    @ApiModelProperty(value = "商品类目id")
    private String catId;

    @ApiModelProperty(value = "商品图片地址")
    private String picPath;

    @ApiModelProperty(value = "商品详情链接")
    private String goodsUrl;

    @ApiModelProperty(value = "0:普通商品；1：全款预售，2：定金预售")
    private Integer saleType;

    @ApiModelProperty(value = "是否超卖")
    private Boolean isOverSold;

    @ApiModelProperty(value = "是否为跨境商品")
    private Integer isCrossBorder;

    @ApiModelProperty(value = "海关编号")
    private String customsCode;

    @ApiModelProperty(value = "订单优惠结构体")
    private PromotionInfo promotionInfo;

    public static void main(String[] args){
        Field[] fields = OrderInfo.class.getDeclaredFields();
        for (Field field : fields){
            System.out.println("|--"+field.getName()+"|是|"+field.getType().getName()+"|"+field.getAnnotation(ApiModelProperty.class).value()+"|");
        }
    }

}
