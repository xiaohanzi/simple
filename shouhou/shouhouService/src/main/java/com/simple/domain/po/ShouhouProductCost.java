package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "shouhou_product_cost")
public class ShouhouProductCost extends BaseModel {
	private static final long serialVersionUID = 1L;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="productCode")
	private String productCode;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="cost")
	private Double cost;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="realCost")
	private Double realCost;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="createBy")
	private String createBy;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="createTime")
	private Date createTime;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="updateBy")
	private String updateBy;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="updateTime")
	private Date updateTime;
	public String  getProductCode() {
		return productCode;
	}
	public void setProductCode(String _productCode) {
		productCode = _productCode;
	}
	public Double  getCost() {
		return cost;
	}
	public void setCost(Double _cost) {
		cost = _cost;
	}
	public Double  getRealCost() {
		return realCost;
	}
	public void setRealCost(Double _realCost) {
		realCost = _realCost;
	}
	public String  getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String _createBy) {
		createBy = _createBy;
	}
	public Date  getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date _createTime) {
		createTime = _createTime;
	}
	public String  getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String _updateBy) {
		updateBy = _updateBy;
	}
	public Date  getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date _updateTime) {
		updateTime = _updateTime;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,ProductCode_ASC("`productCode` ASC"),ProductCode_DESC("`productCode` DESC")
			,Cost_ASC("`cost` ASC"),Cost_DESC("`cost` DESC")
			,RealCost_ASC("`realCost` ASC"),RealCost_DESC("`realCost` DESC")
			,CreateBy_ASC("`createBy` ASC"),CreateBy_DESC("`createBy` DESC")
			,CreateTime_ASC("`createTime` ASC"),CreateTime_DESC("`createTime` DESC")
			,UpdateBy_ASC("`updateBy` ASC"),UpdateBy_DESC("`updateBy` DESC")
			,UpdateTime_ASC("`updateTime` ASC"),UpdateTime_DESC("`updateTime` DESC")
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
	
	public void setSortColumns(ShouhouProductCost.Field... fields)
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
