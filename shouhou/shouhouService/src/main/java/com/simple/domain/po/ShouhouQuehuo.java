package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "shouhou_quehuo")
public class ShouhouQuehuo extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*订单编号[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="订单编号[LIKE]",name="orderId")
	private String orderId;
	@Transient
	private String orderIdLike;
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
	/*仓库备注**/
	@io.swagger.annotations.ApiModelProperty(value="仓库备注",name="ckRemark")
	private String ckRemark;
	/*客服备注**/
	@io.swagger.annotations.ApiModelProperty(value="客服备注",name="kfRemark")
	private String kfRemark;
	/*是否已完成**/
	@io.swagger.annotations.ApiModelProperty(value="是否已完成",name="finished")
	private Integer finished;
	/*处理状态**/
	@io.swagger.annotations.ApiModelProperty(value="处理状态",name="handleStatus")
	private Integer handleStatus;
	public String  getOrderId() {
		return orderId;
	}
	public void setOrderId(String _orderId) {
		orderId = _orderId;
	}
	public String  getOrderIdLike() {
		return orderIdLike;
	}
	public void setOrderIdLike( String _orderIdLike) {
		orderIdLike = _orderIdLike;
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
	public String  getCkRemark() {
		return ckRemark;
	}
	public void setCkRemark(String _ckRemark) {
		ckRemark = _ckRemark;
	}
	public String  getKfRemark() {
		return kfRemark;
	}
	public void setKfRemark(String _kfRemark) {
		kfRemark = _kfRemark;
	}
	public Integer  getFinished() {
		return finished;
	}
	public void setFinished(Integer _finished) {
		finished = _finished;
	}
	public Integer  getHandleStatus() {
		return handleStatus;
	}
	public void setHandleStatus(Integer _handleStatus) {
		handleStatus = _handleStatus;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,OrderId_ASC("`order_id` ASC"),OrderId_DESC("`order_id` DESC")
			,CreateTime_ASC("`create_time` ASC"),CreateTime_DESC("`create_time` DESC")
			,CreateBy_ASC("`create_by` ASC"),CreateBy_DESC("`create_by` DESC")
			,UpdateTime_ASC("`update_time` ASC"),UpdateTime_DESC("`update_time` DESC")
			,UpdateBy_ASC("`update_by` ASC"),UpdateBy_DESC("`update_by` DESC")
			,CkRemark_ASC("`ckRemark` ASC"),CkRemark_DESC("`ckRemark` DESC")
			,KfRemark_ASC("`kfRemark` ASC"),KfRemark_DESC("`kfRemark` DESC")
			,Finished_ASC("`finished` ASC"),Finished_DESC("`finished` DESC")
			,HandleStatus_ASC("`handle_status` ASC"),HandleStatus_DESC("`handle_status` DESC")
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
	
	public void setSortColumns(ShouhouQuehuo.Field... fields)
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
