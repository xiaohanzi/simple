package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "shouhou_list")
public class ShouhouList extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*哪个店[LIST]**/
	@io.swagger.annotations.ApiModelProperty(value="哪个店[LIST]",name="shop")
	private String shop;
	@Transient
	private List<String> shops;
	/*创建时间[GTE][LTE]**/
	@io.swagger.annotations.ApiModelProperty(value="创建时间[GTE][LTE]",name="createTime")
	private Date createTime;
	@Transient
	private Date createTimeGte;
	@Transient
	private Date createTimeLte;
	/*更新时间[GTE][LTE]**/
	@io.swagger.annotations.ApiModelProperty(value="更新时间[GTE][LTE]",name="updateTime")
	private Date updateTime;
	@Transient
	private Date updateTimeGte;
	@Transient
	private Date updateTimeLte;
	/*创建人**/
	@io.swagger.annotations.ApiModelProperty(value="创建人",name="createBy")
	private String createBy;
	/*更新人**/
	@io.swagger.annotations.ApiModelProperty(value="更新人",name="updateBy")
	private String updateBy;
	/*订单号/旺旺号[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="订单号/旺旺号[LIKE]",name="orderNo")
	private String orderNo;
	@Transient
	private String orderNoLike;
	/*客户名称**/
	@io.swagger.annotations.ApiModelProperty(value="客户名称",name="cusName")
	private String cusName;
	/*物流单号**/
	@io.swagger.annotations.ApiModelProperty(value="物流单号",name="transNo")
	private String transNo;
	/*金额**/
	@io.swagger.annotations.ApiModelProperty(value="金额",name="fee")
	private BigDecimal fee;
	/*原因**/
	@io.swagger.annotations.ApiModelProperty(value="原因",name="reason")
	private String reason;
	/*事件类型**/
	@io.swagger.annotations.ApiModelProperty(value="事件类型",name="eventType")
	private String eventType;
	/*状态 1-处理中 2-处理完成**/
	@io.swagger.annotations.ApiModelProperty(value="状态 1-处理中 2-处理完成",name="dealStatus")
	private Integer dealStatus;
	/*处理备注**/
	@io.swagger.annotations.ApiModelProperty(value="处理备注",name="dealRemark")
	private String dealRemark;
	/*是否丢件 1-已丢件 2-未丢件**/
	@io.swagger.annotations.ApiModelProperty(value="是否丢件 1-已丢件 2-未丢件",name="miss")
	private Integer miss;
	/*订单金额**/
	@io.swagger.annotations.ApiModelProperty(value="订单金额",name="orderFee")
	private BigDecimal orderFee;
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
	public Date  getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date _updateTime) {
		updateTime = _updateTime;
	}
	public Date getUpdateTimeGte() {
		return updateTimeGte;
	}
	public void setUpdateTimeGte( Date _updateTimeGte) {
		updateTimeGte = _updateTimeGte;
	}
	public Date getUpdateTimeLte() {
		return updateTimeLte;
	}
	public void setUpdateTimeLte( Date _updateTimeLte) {
		updateTimeLte = _updateTimeLte;
	}
	public String  getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String _createBy) {
		createBy = _createBy;
	}
	public String  getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String _updateBy) {
		updateBy = _updateBy;
	}
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
	public String  getCusName() {
		return cusName;
	}
	public void setCusName(String _cusName) {
		cusName = _cusName;
	}
	public String  getTransNo() {
		return transNo;
	}
	public void setTransNo(String _transNo) {
		transNo = _transNo;
	}
	public BigDecimal  getFee() {
		return fee;
	}
	public void setFee(BigDecimal _fee) {
		fee = _fee;
	}
	public String  getReason() {
		return reason;
	}
	public void setReason(String _reason) {
		reason = _reason;
	}
	public String  getEventType() {
		return eventType;
	}
	public void setEventType(String _eventType) {
		eventType = _eventType;
	}
	public Integer  getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(Integer _dealStatus) {
		dealStatus = _dealStatus;
	}
	public String  getDealRemark() {
		return dealRemark;
	}
	public void setDealRemark(String _dealRemark) {
		dealRemark = _dealRemark;
	}
	public Integer  getMiss() {
		return miss;
	}
	public void setMiss(Integer _miss) {
		miss = _miss;
	}
	public BigDecimal  getOrderFee() {
		return orderFee;
	}
	public void setOrderFee(BigDecimal _orderFee) {
		orderFee = _orderFee;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,Shop_ASC("`shop` ASC"),Shop_DESC("`shop` DESC")
			,CreateTime_ASC("`createTime` ASC"),CreateTime_DESC("`create_time` DESC")
			,UpdateTime_ASC("`updateTime` ASC"),UpdateTime_DESC("`update_time` DESC")
			,CreateBy_ASC("`createBy` ASC"),CreateBy_DESC("`create_by` DESC")
			,UpdateBy_ASC("`updateBy` ASC"),UpdateBy_DESC("`update_by` DESC")
			,OrderNo_ASC("`orderNo` ASC"),OrderNo_DESC("`order_no` DESC")
			,CusName_ASC("`cusName` ASC"),CusName_DESC("`cus_name` DESC")
			,TransNo_ASC("`transNo` ASC"),TransNo_DESC("`trans_no` DESC")
			,Fee_ASC("`fee` ASC"),Fee_DESC("`fee` DESC")
			,Reason_ASC("`reason` ASC"),Reason_DESC("`reason` DESC")
			,EventType_ASC("`eventType` ASC"),EventType_DESC("`event_type` DESC")
			,DealStatus_ASC("`dealStatus` ASC"),DealStatus_DESC("`deal_status` DESC")
			,DealRemark_ASC("`dealRemark` ASC"),DealRemark_DESC("`deal_remark` DESC")
			,Miss_ASC("`miss` ASC"),Miss_DESC("`miss` DESC")
			,OrderFee_ASC("`orderFee` ASC"),OrderFee_DESC("`order_fee` DESC")
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
	
	public void setSortColumns(ShouhouList.Field... fields)
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
