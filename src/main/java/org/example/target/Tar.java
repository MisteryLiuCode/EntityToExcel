package org.example.target;

import org.example.bei.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @author liushuaibiao
 * @date 2023/7/5 12:03
 */
public class Tar {
    @ApiModelProperty("申请流水号")
    private String applyId;

    @ApiModelProperty("业务单号")
    private String loanBizNo;

    @ApiModelProperty("业务状态 P-处理中、S-业务申请成功、F-业务申请失败")
    private String bizStatus;

    @ApiModelProperty("业务状态描述")
    private String bizStatusRemark;

    @ApiModelProperty("申请结果响应类型 1:URL、2:form表单")
    private String bankRespType;

    @ApiModelProperty("申请结果响应内容")
    private String bankRespContent;

    @ApiModelProperty("还款状态 C初始化 S还款成功 F还款失败 P处理中")
    private String repayStatus;

    @ApiModelProperty("还款状态描述")
    private String repayStsRemark;

    @ApiModelProperty("是否结清标志 Y 结清  N 未结清")
    private String isSettleFlag;

    /********************* 融资结果信息（来源资金方,若数据为空，前端会显示："以银行实际业务为准"） *****************************/

    @ApiModelProperty("融资结果信息：银行融资单号（注：银企连对外统称【银行融资编号】，对应资方具体业务的单号，可为空）")
    private String bankLoanNo;

    @ApiModelProperty("融资结果信息：放款金额(元)")
    private BigDecimal bankPayAmt;

    @ApiModelProperty("融资结果信息：放款日")
    private String bankLoanBegDt;

    @ApiModelProperty("融资结果信息：到期日")
    private String bankLoanDueDt;

    @ApiModelProperty("融资结果信息：融资天数(天)")
    private String bankLoanDayNum;

    @ApiModelProperty("融资结果信息：融资利率(%)")
    private BigDecimal bankLoanRate;

    @ApiModelProperty("融资结果信息：利息金额(元)")
    private BigDecimal bankInterestAmt;

    @ApiModelProperty("融资结果信息：手续费利率(%)")
    private BigDecimal bankServiceRate;

    @ApiModelProperty("融资结果信息：手续费金额(元)")
    private BigDecimal bankServiceAmt;
}
