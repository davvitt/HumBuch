package de.dhbw.humbuch.model.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="setting")
public class SettingsEntry implements Map.Entry<String, String>, de.dhbw.humbuch.model.entity.Entity, Serializable  {
	private static final long serialVersionUID = -2998393509203242955L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String settingKey;
	private String settingValue;
	
	/**
	 * Required by Hibernate.<p>
	 * Use the {@link Builder} instead.
	 * 
	 * @see Builder
	 */
	@Deprecated
	public SettingsEntry() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSettingKey() {
		return settingKey;
	}

	public void setSettingKey(String settingKey) {
		this.settingKey = settingKey;
	}

	public String getSettingValue() {
		return settingValue;
	}

	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}

	@Override
	public String getKey() {
		return settingKey;
	}

	@Override
	public String getValue() {
		return settingValue;
	}

	@Override
	public String setValue(String value) {
		return this.settingValue = value;
	}
	
	public static class Builder {
		private String key;
		private String value;
		
		public Builder(String key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public SettingsEntry build() {
			return new SettingsEntry(this);
		}
	}
	
	public SettingsEntry(Builder builder) {
		this.settingKey = builder.key;
		this.settingValue = builder.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((settingKey == null) ? 0 : settingKey.hashCode());
		result = prime * result + ((settingValue == null) ? 0 : settingValue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SettingsEntry))
			return false;
		SettingsEntry other = (SettingsEntry) obj;
		if (settingKey == null) {
			if (other.settingKey != null)
				return false;
		} else if (!settingKey.equals(other.settingKey))
			return false;
		if (settingValue == null) {
			if (other.settingValue != null)
				return false;
		} else if (!settingValue.equals(other.settingValue))
			return false;
		return true;
	}
}
