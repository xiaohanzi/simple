package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "shouhou_type")
public class ShouhouType extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*类型**/
	@io.swagger.annotations.ApiModelProperty(value="类型",name="type")
	private String type;
	/*名称**/
	@io.swagger.annotations.ApiModelProperty(value="名称",name="name")
	private String name;
	/*值**/
	@io.swagger.annotations.ApiModelProperty(value="值",name="value")
	private String value;
	/*状态 1-有效 2-无效**/
	@io.swagger.annotations.ApiModelProperty(value="状态 1-有效 2-无效",name="status")
	private Integer status;
	/*排序**/
	@io.swagger.annotations.ApiModelProperty(value="排序",name="tsort")
	private Integer tsort;
	public String  getType() {
		return type;
	}
	public void setType(String _type) {
		type = _type;
	}
	public String  getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public String  getValue() {
		return value;
	}
	public void setValue(String _value) {
		value = _value;
	}
	public Integer  getStatus() {
		return status;
	}
	public void setStatus(Integer _status) {
		status = _status;
	}
	public Integer  getTsort() {
		return tsort;
	}
	public void setTsort(Integer _tsort) {
		tsort = _tsort;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,Type_ASC("`type` ASC"),Type_DESC("`type` DESC")
			,Name_ASC("`name` ASC"),Name_DESC("`name` DESC")
			,Value_ASC("`value` ASC"),Value_DESC("`value` DESC")
			,Status_ASC("`status` ASC"),Status_DESC("`status` DESC")
			,Tsort_ASC("`tsort` ASC"),Tsort_DESC("`tsort` DESC")
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
	
	public void setSortColumns(ShouhouType.Field... fields)
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
