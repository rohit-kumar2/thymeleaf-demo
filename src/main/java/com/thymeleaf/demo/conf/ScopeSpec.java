package com.thymeleaf.demo.conf;

import java.util.List;

import com.thymeleaf.demo.entity.Scope;


public class ScopeSpec {

	private Boolean enabled = true;
	
	private Boolean hide;
	
	private Boolean flat;
	
	private String key;

	private String name;

	private String info;
	
	private String icon;
	
	private Boolean category;
	
	private String grouping;
	
	private String focus;
	
	private List<ScopeSpec> sub;
	
	public ScopeSpec() {
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getCategory() {
		return category;
	}

	public void setCategory(Boolean category) {
		this.category = category;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public Boolean getHide() {
		return hide;
	}

	public void setHide(Boolean hide) {
		this.hide = hide;
	}

	
	public Boolean getFlat() {
		return flat;
	}

	public void setFlat(Boolean flat) {
		this.flat = flat;
	}
	
	public String getGrouping() {
		return grouping;
	}

	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}

	public List<ScopeSpec> getSub() {
		return sub;
	}

	public void setSub(List<ScopeSpec> sub) {
		this.sub = sub;
	}
	
	
	public ScopeSpec find(String key) {
		if (key!=null) {
			if (key.equals(this.key)) {
				return this;
			}
			if (sub!=null) {
				for (ScopeSpec spec: sub) {
					ScopeSpec spec2 = spec.find(key);
					if (spec2!=null) {
						return spec2;
					}
				}
			}			
		}
		return null;
	}
	
	public ScopeSpec findFor(Scope scope) {
		if (scope.getSubsub()!=null) {
			ScopeSpec spec = find(scope.getSubsub());
			if (spec!=null) {
				return spec;
			}
		}
		if (scope.getSub()!=null) {
			ScopeSpec spec = find(scope.getSub());
			if (spec!=null) {
				return spec;
			}
		}
		return find(scope.getKey());
	}
	
	
	public void assignSub() {
		if (sub!=null) {
			for (ScopeSpec spec: sub) {
				if (spec.icon==null) {
					spec.icon = icon;
				}
				if (spec.info==null) {
					spec.info = info;
				}
				spec.assignSub();
			}
		}
	}

	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[enabled=" + enabled 
				+ ", hide=" + hide 
				+ ", key=" + key 
				+ ", name=" + name 
				+ ", info=" + info 
				+ ", icon=" + icon
				+ ", grouping=" + grouping
				+ ", category=" + category 
				+ ", sub=" + sub 
				+ ", focus=" + focus + "]";
	}

}
