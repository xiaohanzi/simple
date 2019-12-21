package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "sys_user_role")
public class SysUserRole extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*用户ID**/
	@io.swagger.annotations.ApiModelProperty(value="用户ID",name="uid")
	private String uid;
	/*角色ID**/
	@io.swagger.annotations.ApiModelProperty(value="角色ID",name="roleId")
	private String roleId;
	public String  getUid() {
		return uid;
	}
	public void setUid(String _uid) {
		uid = _uid;
	}
	public String  getRoleId() {
		return roleId;
	}
	public void setRoleId(String _roleId) {
		roleId = _roleId;
	}



	public static enum Field
	{
		Uid_ASC("`uid` ASC"),Uid_DESC("`uid` DESC")
			,RoleId_ASC("`roleId` ASC"),RoleId_DESC("`roleId` DESC")
			,Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
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
	
	public void setSortColumns(SysUserRole.Field... fields)
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
