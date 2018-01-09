package com.thymeleaf.demo.conf;

import java.util.List;
import java.util.Map;

public class AuditSpec {
	private Boolean enabled = true;
	
	private Boolean hide;
	
	private Boolean flat;
	
	private String key;

	private String name;

	private String info;
	
	private String icon;
	
	private Boolean category;
	
	private String grouping;	
	
	private List<AuditSpec> sub;
	
	private String focus;
	
	private List<ScopeSpec> scopes;
	
	public AuditSpec() {
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

	public List<AuditSpec> getSub() {
		return sub;
	}
	
	public void setSub(List<AuditSpec> sub) {
		this.sub = sub;
	}
	
	
	public String getGrouping() {
		return grouping;
	}

	public void setGrouping(String grouping) {
		this.grouping = grouping;
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

	public List<ScopeSpec> getScopes() {
		return scopes;
	}

	public void setScopes(List<ScopeSpec> scopes) {
		this.scopes = scopes;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[enabled=" + enabled 
				+ ", hide=" + hide 
				+ ", key=" + key 
				+ ", name=" + name 
				+ ", info=" + info 
				+ ", icon=" + icon
				+ ", category=" + category 
				+ ", grouping=" + grouping 
				+ ", sub=" + sub 
				+ ", focus=" + focus + "]";
	}
	
	
	public AuditSpec find(String key) {
		if (key!=null) {
			if (key.equals(this.key)) {
				return this;
			}
			if (sub!=null) {
				for (AuditSpec spec: sub) {
					AuditSpec spec2 = spec.find(key);
					if (spec2!=null) {
						return spec2;
					}
				}
			}			
		}
		return null;
	}
	
	public void assignSub() {
		if (sub!=null) {
			for (AuditSpec spec: sub) {
				if (spec.icon==null) {
					spec.icon = icon;
				}
				if (spec.info==null) {
					spec.info = info;
				}
				if (spec.grouping==null) {
					spec.grouping = grouping;
				}
				spec.assignSub();
			}
		}
	}

	public void assignScopes(Map<String, List<ScopeSpec>> scopes) {
		if (grouping!=null) {
			this.scopes = scopes.get(grouping);
			//System.out.println("assignScopes:" + key + " " + grouping + " " + this.scopes);
		} else  {
			if (!Boolean.TRUE.equals(category)) {
				//System.out.println("assignScopes:" + key + " MISSING SCOPE GROUPING");				
			}
			
		}
		if (sub!=null) {
			for (AuditSpec spec: sub) {
				spec.assignScopes(scopes);
			}
		}
	}
}
 