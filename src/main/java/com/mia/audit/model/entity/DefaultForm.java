package com.mia.audit.model.entity;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(schema = "mia_audit")
public class DefaultForm {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String fieldsJson;

	@Transient
	private List<String> fields; // mapped from JSON

	@PostLoad
	@PostPersist
	public void fromJson() throws IOException {
	    if (fieldsJson != null) {
	        ObjectMapper mapper = new ObjectMapper();
	        fields = mapper.readValue(fieldsJson, new TypeReference<List<String>>() {});
	    }
	}

	@PrePersist
	@PreUpdate
	public void toJson() throws IOException {
	    if (fields != null) {
	        ObjectMapper mapper = new ObjectMapper();
	        fieldsJson = mapper.writeValueAsString(fields);
	    }
	}
	private String  zone;
	
	
   	public DefaultForm() {
	}
   		public DefaultForm(Long id, List<String> fields, String zone) {
		this.id = id;
		this.fields = fields;
		this.zone = zone;
	}
   			public Long getId() {
		return id;
	}
   			public void setId(Long id) {
		this.id = id;
	}
    		public List<String> getFields() {
		return fields;
	}
   			public void setFields(List<String> fields) {
		this.fields = fields;
	}
   		    public String getZone() {
		return zone;
	}
  		    public void setZone(String zone) {
		this.zone = zone;
	}
   								
   								
}
