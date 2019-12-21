package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "shouhou_bujian")
public class ShouhouBujian extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*订单号或者旺旺号[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="订单号或者旺旺号[LIKE]",name="orderNo")
	private String orderNo;
	@Transient
	private String orderNoLike;
	/*哪个店[LIST]**/
	@io.swagger.annotations.ApiModelProperty(value="哪个店[LIST]",name="shop")
	private String shop;
	@Transient
	private List<String> shops;
	/*是否邮政 1-是 2否**/
	@io.swagger.annotations.ApiModelProperty(value="是否邮政 1-是 2否",name="ems")
	private Integer ems;
	/*收件人姓名[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="收件人姓名[LIKE]",name="cusName")
	private String cusName;
	@Transient
	private String cusNameLike;
	/*物件内容**/
	@io.swagger.annotations.ApiModelProperty(value="物件内容",name="content")
	private String content;
	/*原因**/
	@io.swagger.annotations.ApiModelProperty(value="原因",name="reason")
	private String reason;
	/*创建时间[GTE][LTE]**/
	@io.swagger.annotations.ApiModelProperty(value="创建时间[GTE][LTE]",name="createTime")
	private Date createTime;
	@Transient
	private Date createTimeGte;
	@Transient
	private Date createTimeLte;
	/*创建人**/
	@io.swagger.annotations.ApiModelProperty(value="创建人",name="createBy")
	private String createBy;
	/*更新时间**/
	@io.swagger.annotations.ApiModelProperty(value="更新时间",name="updateTime")
	private Date updateTime;
	/*更新人**/
	@io.swagger.annotations.ApiModelProperty(value="更新人",name="updateBy")
	private String updateBy;
	/*补发单号**/
	@io.swagger.annotations.ApiModelProperty(value="补发单号",name="transNo")
	private String transNo;
	/*是否有揽收信息 1-有 2-没有**/
	@io.swagger.annotations.ApiModelProperty(value="是否有揽收信息 1-有 2-没有",name="transInfo")
	private Integer transInfo;
	/*处理备注**/
	@io.swagger.annotations.ApiModelProperty(value="处理备注",name="dealRemark")
	private String dealRemark;
	/*收件人电话[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="收件人电话[LIKE]",name="cusPhone")
	private String cusPhone;
	@Transient
	private String cusPhoneLike;
	/*收件人地址**/
	@io.swagger.annotations.ApiModelProperty(value="收件人地址",name="cusAddr")
	private String cusAddr;
	public String  getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String _orderNo) {
		orderNo = _orderNo;
	}
	public String  getOrderNoLike() {
		return orderNoLike;
	}
	public void setOrderNoLike( String _orderNoLike) {
		orderNoLike = _orderNoLike;
	}
	public String  getShop() {
		return shop;
	}
	public void setShop(String _shop) {
		shop = _shop;
	}
	public List<String>  getShops() {
		return shops;
	}
	public void setShops( List<String> _shops) {
		shops = _shops;
	}
	public Integer  getEms() {
		return ems;
	}
	public void setEms(Integer _ems) {
		ems = _ems;
	}
	public String  getCusName() {
		return cusName;
	}
	public void setCusName(String _cusName) {
		cusName = _cusName;
	}
	public String  getCusNameLike() {
		return cusNameLike;
	}
	public void setCusNameLike( String _cusNameLike) {
		cusNameLike = _cusNameLike;
	}
	public String  getContent() {
		return content;
	}
	public void setContent(String _content) {
		content = _content;
	}
	public String  getReason() {
		return reason;
	}
	public void setReason(String _reason) {
		reason = _reason;
	}
	public Date  getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date _createTime) {
		createTime = _createTime;
	}
	public Date getCreateTimeGte() {
		return createTimeGte;
	}
	public void setCreateTimeGte( Date _createTimeGte) {
		createTimeGte = _createTimeGte;
	}
	public Date getCreateTimeLte() {
		return createTimeLte;
	}
	public void setCreateTimeLte( Date _createTimeLte) {
		createTimeLte = _createTimeLte;
	}
	public String  getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String _createBy) {
		createBy = _createBy;
	}
	public Date  getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date _updateTime) {
		updateTime = _updateTime;
	}
	public String  getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String _updateBy) {
		updateBy = _updateBy;
	}
	public String  getTransNo() {
		return transNo;
	}
	public void setTransNo(String _transNo) {
		transNo = _transNo;
	}
	public Integer  getTransInfo() {
		return transInfo;
	}
	public void setTransInfo(Integer _transInfo) {
		transInfo = _transInfo;
	}
	public String  getDealRemark() {
		return dealRemark;
	}
	public void setDealRemark(String _dealRemark) {
		dealRemark = _dealRemark;
	}
	public String  getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(String _cusPhone) {
		cusPhone = _cusPhone;
	}
	public String  getCusPhoneLike() {
		return cusPhoneLike;
	}
	public void setCusPhoneLike( String _cusPhoneLike) {
		cusPhoneLike = _cusPhoneLike;
	}
	public String  getCusAddr() {
		return cusAddr;
	}
	public void setCusAddr(String _cusAddr) {
		cusAddr = _cusAddr;
	}

	@HoldBegin
	/*閺勵垰鎯侀張澶婂礋閸欏嚖绱濇笟娑欑叀鐠囶澀濞囬悽锟�**/
	@Transient
	private Integer transnohave;
	public Integer getTransnohave() {
		return transnohave;
	}
	public void setTransnohave(Integer transnohave) {
		this.transnohave = transnohave;
	}

	@HoldEnd



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,OrderNo_ASC("`order_no` ASC"),OrderNo_DESC("`order_no` DESC")
			,Shop_ASC("`shop` ASC"),Shop_DESC("`shop` DESC")
			,Ems_ASC("`ems` ASC"),Ems_DESC("`ems` DESC")
			,CusName_ASC("`cus_name` ASC"),CusName_DESC("`cus_name` DESC")
			,Content_ASC("`content` ASC"),Content_DESC("`content` DESC")
			,Reason_ASC("`reason` ASC"),Reason_DESC("`reason` DESC")
			,CreateTime_ASC("`create_time` ASC"),CreateTime_DESC("`create_time` DESC")
			,CreateBy_ASC("`create_by` ASC"),CreateBy_DESC("`create_by` DESC")
			,UpdateTime_ASC("`update_time` ASC"),UpdateTime_DESC("`update_time` DESC")
			,UpdateBy_ASC("`update_by` ASC"),UpdateBy_DESC("`update_by` DESC")
			,TransNo_ASC("`trans_no` ASC"),TransNo_DESC("`trans_no` DESC")
			,TransInfo_ASC("`trans_info` ASC"),TransInfo_DESC("`trans_info` DESC")
			,DealRemark_ASC("`deal_remark` ASC"),DealRemark_DESC("`deal_remark` DESC")
			,CusPhone_ASC("`cus_phone` ASC"),CusPhone_DESC("`cus_phone` DESC")
			,CusAddr_ASC("`cus_addr` ASC"),CusAddr_DESC("`cus_addr` DESC")
	;
		private String value;
		Field(String value){
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setCol(String value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return this.getValue();
		}
	}
	
	public void setSortColumns(ShouhouBujian.Field... fields)
	{
		if (fields == null || fields.length == 0) {
			return;
		}
		for (int k = 0; k < fields.length; k++) {
			if (fields[k] == null) {
				return;
			}
		}
		StringBuilder sb = new StringBuilder(fields[0].toString());
		for (int k = 1; k < fields.length; k++) {
			sb.append(",");
			sb.append(fields[k].toString());
		}
		super.setSortColumns(sb.toString());
	}
	
	@Override
	public void setSortColumns(String sortColumns)
	{
		if (sortColumns == null || "".equals(sortColumns.trim())) {
			return;
		}
		if (sortColumns.contains(",")) {
			String[] cols = sortColumns.split(",");
			java.util.List<Field> fList = new java.util.ArrayList();
			for (int k = 0; k < cols.length; k++) {
				fList.add(Field.valueOf(cols[k]));
			}
			this.setSortColumns(fList.toArray(new Field[fList.size()]));
		} else {
			this.setSortColumns(Field.valueOf(sortColumns));
		}
	}
}
