package com.thymeleaf.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.greenfence.bpm.common.model.EntityBase;
import com.thymeleaf.demo.conf.ScopeSpec;

@Entity
public class Scope extends EntityBase<Long>{

	@Column(name="name")
	private String key;

	@Column(name="sub")
	private String sub;

	@Column(name="subsub")
	private String subsub;


	@Transient
	private Boolean selected;
	
	@Transient
	private ScopeSpec spec;

	@Transient
	private ScopeSpec subspec;

	@Transient
	private ScopeSpec subsubspec;

	@Transient
	private List<Scope> subList;
	
	public Scope() {
	}

	public Scope(ScopeSpec scopeSpec) {
		this.key = scopeSpec.getKey();
		this.spec = scopeSpec;
	}

	public Scope(String key, String sub, String subsub) {
		this(key, sub, subsub, null);
	}
	
	public Scope(String key, String sub, String subsub, ScopeSpec spec) {
		super();
		this.key = key;
		this.sub = sub;
		this.subsub = subsub;
		this.spec = spec;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getSubsub() {
		return subsub;
	}

	public void setSubsub(String subsub) {
		this.subsub = subsub;
	}

	public ScopeSpec getSubspec() {
		return subspec;
	}

	public void setSubspec(ScopeSpec subspec) {
		this.subspec = subspec;
	}

	public ScopeSpec getSubsubspec() {
		return subsubspec;
	}

	public void setSubsubspec(ScopeSpec subsubspec) {
		this.subsubspec = subsubspec;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public ScopeSpec getSpec() {
		return spec;
	}

	public void setSpec(ScopeSpec spec) {
		this.spec = spec;
	}

	public List<Scope> getSubList() {
		return subList;
	}

	public void setSubList(List<Scope> subList) {
		this.subList = subList;
	}

	public static Scope parseKey(String key) {
		String[] a = key.split(":");
		String scopeKey = a[0];
		String sub = a.length > 1 ? a[1] : null;
		String subsub = a.length > 2 ? a[2] : null;
		return new Scope(scopeKey, sub, subsub);
	}

	public boolean matches(String key) {
		if (key!=null) {
			if (key.equals(subsub)) {
				return true;
			}
			if (key.equals(sub)) {
				return true;
			}
			if (key.equals(this.key)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Scope [" 
				+ (getId() != null ? "id=" + getId() + ", ": "")
				+ (key != null ? "key=" + key + ", " : "")
				+ (sub != null ? "sub=" + sub + ", " : "")
				+ (subsub != null ? "subsub=" + subsub + ", " : "")				
				+ (selected != null ? "selected=" + selected + ", " : "")
				+ (spec != null ? "spec=" + spec + ", " : "")
				+ (subspec != null ? "subspec=" + subspec + ", " : "")
				+ (subsubspec != null ? "subsubspec=" + subsubspec + ", " : "")
				//+ (subList != null ? "subList=" + subList + ", " : "")
				+ "]";
	}
	
}
