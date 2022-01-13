package com.spring.esAPI.beans;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.spring.esAPI.Constants;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Data
@Document(indexName = Constants.MITRE_INDEX)




public class TechniqueBean {
	
	@Id
	public String id;
	public String techniquename;
	
	@Field(name = "tactic")
	public String tactic; 
	public List<String> subtechniques;
	public List<String> platforms;
	public String version;
	public String created;
	public String lastmodified;
	public String detection;
	public String description;
	public Object mitigations;
	public String subtechniqueof;
	public Object datasources;
	public String impacttype;
	public String contributors;
	public Object procedureexamples;

}