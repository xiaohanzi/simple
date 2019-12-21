package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "shouhou_alibaba")
public class ShouhouAlibaba extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*订单日期[GTE][LTE]**/
	@io.swagger.annotations.ApiModelProperty(value="订单日期[GTE][LTE]",name="orderDate")
	private Date orderDate;
	@Transient
	private Date orderDateGte;
	@Transient
	private Date orderDateLte;
	/*客户姓名[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="客户姓名[LIKE]",name="cusName")
	private String cusName;
	@Transient
	private String cusNameLike;
	/*客户手机号[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="客户手机号[LIKE]",name="cusPhone")
	private String cusPhone;
	@Transient
	private String cusPhoneLike;
	/*货品**/
	@io.swagger.annotations.ApiModelProperty(value="货品",name="goodsDes")
	private String goodsDes;
	/*颜色**/
	@io.swagger.annotations.ApiModelProperty(value="颜色",name="goodsColor")
	private String goodsColor;
	/*尺码**/
	@io.swagger.annotations.ApiModelProperty(value="尺码",name="goodsSize")
	private String goodsSize;
	/*数量**/
	@io.swagger.annotations.ApiModelProperty(value="数量",name="goodsCount")
	private Integer goodsCount;
	/*成本金额**/
	@io.swagger.annotations.ApiModelProperty(value="成本金额",name="goodsCost")
	private BigDecimal goodsCost;
	/*快递费用**/
	@io.swagger.annotations.ApiModelProperty(value="快递费用",name="transFee")
	private BigDecimal transFee;
	/*是否已经给老板娘打钱 1-未打 2-打了**/
	@io.swagger.annotations.ApiModelProperty(value="是否已经给老板娘打钱 1-未打 2-打了",name="payStatus")
	private Integer payStatus;
	/*创建用户**/
	@io.swagger.annotations.ApiModelProperty(value="创建用户",name="createBy")
	private String createBy;
	/*创建时间**/
	@io.swagger.annotations.ApiModelProperty(value="创建时间",name="createTime")
	private Date createTime;
	/*更新用户**/
	@io.swagger.annotations.ApiModelProperty(value="更新用户",name="updateBy")
	private String updateBy;
	/*更新时间**/
	@io.swagger.annotations.ApiModelProperty(value="更新时间",name="updateTime")
	private Date updateTime;
	public Date  getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date _orderDate) {
		orderDate = _orderDate;
	}
	public Date getOrderDateGte() {
		return orderDateGte;
	}
	public void setOrderDateGte( Date _orderDateGte) {
		orderDateGte = _orderDateGte;
	}
	public Date getOrderDateLte() {
		return orderDateLte;
	}
	public void setOrderDateLte( Date _orderDateLte) {
		orderDateLte = _orderDateLte;
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
	public String  getGoodsDes() {
		return goodsDes;
	}
	public void setGoodsDes(String _goodsDes) {
		goodsDes = _goodsDes;
	}
	public String  getGoodsColor() {
		return goodsColor;
	}
	public void setGoodsColor(String _goodsColor) {
		goodsColor = _goodsColor;
	}
	public String  getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(String _goodsSize) {
		goodsSize = _goodsSize;
	}
	public Integer  getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer _goodsCount) {
		goodsCount = _goodsCount;
	}
	public BigDecimal  getGoodsCost() {
		return goodsCost;
	}
	public void setGoodsCost(BigDecimal _goodsCost) {
		goodsCost = _goodsCost;
	}
	public BigDecimal  getTransFee() {
		return transFee;
	}
	public void setTransFee(BigDecimal _transFee) {
		transFee = _transFee;
	}
	public Integer  getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer _payStatus) {
		payStatus = _payStatus;
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
			,OrderDate_ASC("`orderDate` ASC"),OrderDate_DESC("`orderDate` DESC")
			,CusName_ASC("`cusName` ASC"),CusName_DESC("`cusName` DESC")
			,CusPhone_ASC("`cusPhone` ASC"),CusPhone_DESC("`cusPhone` DESC")
			,GoodsDes_ASC("`goodsDes` ASC"),GoodsDes_DESC("`goodsDes` DESC")
			,GoodsColor_ASC("`goodsColor` ASC"),GoodsColor_DESC("`goodsColor` DESC")
			,GoodsSize_ASC("`goodsSize` ASC"),GoodsSize_DESC("`goodsSize` DESC")
			,GoodsCount_ASC("`goodsCount` ASC"),GoodsCount_DESC("`goodsCount` DESC")
			,GoodsCost_ASC("`goodsCost` ASC"),GoodsCost_DESC("`goodsCost` DESC")
			,TransFee_ASC("`transFee` ASC"),TransFee_DESC("`transFee` DESC")
			,PayStatus_ASC("`payStatus` ASC"),PayStatus_DESC("`payStatus` DESC")
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
	
	public void setSortColumns(ShouhouAlibaba.Field... fields)
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
