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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(schema = "mia_audit")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auditor;

    @Column(columnDefinition = "TEXT")
    private String fieldsJson;

    @Column(columnDefinition = "TEXT")
    private String answersJson;
    
	private String zone;

    @Transient
    private List<String> fields;

    @Transient
    private List<String> answers;

    private static final ObjectMapper mapper = new ObjectMapper();

    // Convert JSON -> Objects after loading
    @PostLoad
    @PostPersist
    public void loadJson() throws IOException {
        if (fieldsJson != null) {
            fields = mapper.readValue(fieldsJson, new TypeReference<List<String>>() {});
        }
        if (answersJson != null) {
            answers = mapper.readValue(answersJson, new TypeReference<List<String>>() {});
        }
    }

    // Convert Objects -> JSON before saving
    @PrePersist
    @PreUpdate
    public void saveJson() throws IOException {
        if (fields != null) {
            fieldsJson = mapper.writeValueAsString(fields);
        }
        if (answers != null) {
            answersJson = mapper.writeValueAsString(answers);
        }
    }

   
    public Form() {}
    public Form(Long id, String auditor, List<String> fields, List<String> answers) {
        this.id = id;
        this.auditor = auditor;
        this.fields = fields;
        this.answers = answers;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuditor() { return auditor; }
    public void setAuditor(String auditor) { this.auditor = auditor; }

    public List<String> getFields() { return fields; }
    public void setFields(List<String> fields) { this.fields = fields; }

    public List<String> getAnswers() { return answers; }
    public void setAnswers(List<String> answers) { this.answers = answers; }

    public String getFieldsJson() { return fieldsJson; }
    public void setFieldsJson(String fieldsJson) { this.fieldsJson = fieldsJson; }

    public String getAnswersJson() { return answersJson; }
    public void setAnswersJson(String answersJson) { this.answersJson = answersJson; }
    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }
}
