package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "analysis_word_data")
public class AnalysisWordData extends BaseModel {
	private static final long serialVersionUID = 1L;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="wordsId")
	private String wordsId;
	/*访客数**/
	@io.swagger.annotations.ApiModelProperty(value="访客数",name="peopleCounts")
	private Integer peopleCounts;
	/*买家数**/
	@io.swagger.annotations.ApiModelProperty(value="买家数",name="payCounts")
	private Integer payCounts;
	/*转化率**/
	@io.swagger.annotations.ApiModelProperty(value="转化率",name="cr")
	private Double cr;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="createBy")
	private String createBy;
	/*[GTE][LTE]**/
	@io.swagger.annotations.ApiModelProperty(value="[GTE][LTE]",name="createTime")
	private Date createTime;
	@Transient
	private Date createTimeGte;
	@Transient
	private Date createTimeLte;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="updateBy")
	private String updateBy;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="updateTime")
	private Date updateTime;
	/*产品编号**/
	@io.swagger.annotations.ApiModelProperty(value="产品编号",name="productId")
	private String productId;
	/*[LIKE]关键词名称**/
	@io.swagger.annotations.ApiModelProperty(value="[LIKE]关键词名称",name="wordsName")
	private String wordsName;
	@Transient
	private String wordsNameLike;
	public String  getWordsId() {
		return wordsId;
	}
	public void setWordsId(String _wordsId) {
		wordsId = _wordsId;
	}
	public Integer  getPeopleCounts() {
		return peopleCounts;
	}
	public void setPeopleCounts(Integer _peopleCounts) {
		peopleCounts = _peopleCounts;
	}
	public Integer  getPayCounts() {
		return payCounts;
	}
	public void setPayCounts(Integer _payCounts) {
		payCounts = _payCounts;
	}
	public Double  getCr() {
		return cr;
	}
	public void setCr(Double _cr) {
		cr = _cr;
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
	public String  getProductId() {
		return productId;
	}
	public void setProductId(String _productId) {
		productId = _productId;
	}
	public String  getWordsName() {
		return wordsName;
	}
	public void setWordsName(String _wordsName) {
		wordsName = _wordsName;
	}
	public String  getWordsNameLike() {
		return wordsNameLike;
	}
	public void setWordsNameLike( String _wordsNameLike) {
		wordsNameLike = _wordsNameLike;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,WordsId_ASC("`wordsId` ASC"),WordsId_DESC("`wordsId` DESC")
			,PeopleCounts_ASC("`people_counts` ASC"),PeopleCounts_DESC("`people_counts` DESC")
			,PayCounts_ASC("`pay_counts` ASC"),PayCounts_DESC("`pay_counts` DESC")
			,Cr_ASC("`cr` ASC"),Cr_DESC("`cr` DESC")
			,CreateBy_ASC("`createBy` ASC"),CreateBy_DESC("`createBy` DESC")
			,CreateTime_ASC("`create_time` ASC"),CreateTime_DESC("`create_time` DESC")
			,UpdateBy_ASC("`updateBy` ASC"),UpdateBy_DESC("`updateBy` DESC")
			,UpdateTime_ASC("`update_time` ASC"),UpdateTime_DESC("`update_time` DESC")
			,ProductId_ASC("`productId` ASC"),ProductId_DESC("`productId` DESC")
			,WordsName_ASC("`wordsName` ASC"),WordsName_DESC("`wordsName` DESC")
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
	
	public void setSortColumns(AnalysisWordData.Field... fields)
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
