package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 退保受理
 *
 * @author auto create
 * @since 1.0, 2017-11-30 13:56:46
 */
public class AlipayInsScenePolicySurrenderApplyModel extends AlipayObject {

	private static final long serialVersionUID = 2846125375347637473L;

	/**
	 * 退保扩展参数 ;标准json格式
	 */
	@ApiField("biz_data")
	private String bizData;

	/**
	 * 蚂蚁保险平台生成的保单号
	 */
	@ApiField("policy_no")
	private String policyNo;

	public String getBizData() {
		return this.bizData;
	}
	public void setBizData(String bizData) {
		this.bizData = bizData;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

}
