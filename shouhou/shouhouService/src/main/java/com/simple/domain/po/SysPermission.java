package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "sys_permission")
public class SysPermission extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*权限名称[LIKE]**/
	@io.swagger.annotations.ApiModelProperty(value="权限名称[LIKE]",name="name")
	private String name;
	@Transient
	private String nameLike;
	/*是否可用 Y/N**/
	@io.swagger.annotations.ApiModelProperty(value="是否可用 Y/N",name="available")
	private String available;
	/*父编号**/
	@io.swagger.annotations.ApiModelProperty(value="父编号",name="parentId")
	private String parentId;
	/*父编号列表**/
	@io.swagger.annotations.ApiModelProperty(value="父编号列表",name="parentIds")
	private String parentIds;
	/*权限字符串[LIST]**/
	@io.swagger.annotations.ApiModelProperty(value="权限字符串[LIST]",name="permission")
	private String permission;
	@Transient
	private List<String> permissions;
	/*资源类型0菜单  1，按钮**/
	@io.swagger.annotations.ApiModelProperty(value="资源类型0菜单  1，按钮",name="resourceType")
	private String resourceType;
	/*资源路径**/
	@io.swagger.annotations.ApiModelProperty(value="资源路径",name="url")
	private String url;
	/*排序[FROM][TO][GTE][GT][LTE][LT]**/
	@io.swagger.annotations.ApiModelProperty(value="排序[FROM][TO][GTE][GT][LTE][LT]",name="sort")
	private Integer sort;
	@Transient
	private Integer sortFrom;
	@Transient
	private Integer  sortTo;
	@Transient
	private Integer sortGte;
	@Transient
	private Integer sortGt;
	@Transient
	private Integer sortLte;
	@Transient
	private Integer sortLt;
	public String  getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public String  getNameLike() {
		return nameLike;
	}
	public void setNameLike( String _nameLike) {
		nameLike = _nameLike;
	}
	public String  getAvailable() {
		return available;
	}
	public void setAvailable(String _available) {
		available = _available;
	}
	public String  getParentId() {
		return parentId;
	}
	public void setParentId(String _parentId) {
		parentId = _parentId;
	}
	public String  getParentIds() {
		return parentIds;
	}
	public void setParentIds(String _parentIds) {
		parentIds = _parentIds;
	}
	public String  getPermission() {
		return permission;
	}
	public void setPermission(String _permission) {
		permission = _permission;
	}
	public List<String>  getPermissions() {
		return permissions;
	}
	public void setPermissions( List<String> _permissions) {
		permissions = _permissions;
	}
	public String  getResourceType() {
		return resourceType;
	}
	public void setResourceType(String _resourceType) {
		resourceType = _resourceType;
	}
	public String  getUrl() {
		return url;
	}
	public void setUrl(String _url) {
		url = _url;
	}
	public Integer  getSort() {
		return sort;
	}
	public void setSort(Integer _sort) {
		sort = _sort;
	}
	public Integer getSortFrom() {
		return sortFrom;
	}
	public void setSortFrom( Integer _sortFrom) {
		sortFrom = _sortFrom;
	}
	public Integer getSortTo() {
		return sortTo;
	}
	public void setSortTo( Integer _sortTo) {
		sortTo = _sortTo;
	}
	public Integer getSortGte() {
		return sortGte;
	}
	public void setSortGte( Integer _sortGte) {
		sortGte = _sortGte;
	}
	public Integer getSortGt() {
		return sortGt;
	}
	public void setSortGt( Integer _sortGt) {
		sortGt = _sortGt;
	}
	public Integer getSortLte() {
		return sortLte;
	}
	public void setSortLte( Integer _sortLte) {
		sortLte = _sortLte;
	}
	public Integer getSortLt() {
		return sortLt;
	}
	public void setSortLt( Integer _sortLt) {
		sortLt = _sortLt;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,Name_ASC("`name` ASC"),Name_DESC("`name` DESC")
			,Available_ASC("`available` ASC"),Available_DESC("`available` DESC")
			,ParentId_ASC("`parentId` ASC"),ParentId_DESC("`parentId` DESC")
			,ParentIds_ASC("`parentIds` ASC"),ParentIds_DESC("`parentIds` DESC")
			,Permission_ASC("`permission` ASC"),Permission_DESC("`permission` DESC")
			,ResourceType_ASC("`resourceType` ASC"),ResourceType_DESC("`resourceType` DESC")
			,Url_ASC("`url` ASC"),Url_DESC("`url` DESC")
			,Sort_ASC("`sort` ASC"),Sort_DESC("`sort` DESC")
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
	
	public void setSortColumns(SysPermission.Field... fields)
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
