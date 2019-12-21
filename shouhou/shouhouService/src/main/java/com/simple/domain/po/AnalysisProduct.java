package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "analysis_product")
public class AnalysisProduct extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*[LIKE]产品名称**/
	@io.swagger.annotations.ApiModelProperty(value="[LIKE]产品名称",name="productName")
	private String productName;
	@Transient
	private String productNameLike;
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
	public String  getProductName() {
		return productName;
	}
	public void setProductName(String _productName) {
		productName = _productName;
	}
	public String  getProductNameLike() {
		return productNameLike;
	}
	public void setProductNameLike( String _productNameLike) {
		productNameLike = _productNameLike;
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
			,ProductName_ASC("`productName` ASC"),ProductName_DESC("`productName` DESC")
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
	
	public void setSortColumns(AnalysisProduct.Field... fields)
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
