package kodlama.io.KodlamaIo.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor


@Table(name = "language")
@Entity

public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	@Column(name =" name")
	String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
	private List<Technology> technologies;
	
	public Language() {

		technologies = new ArrayList<>();
	}
	
	public Language(String name) {

		this.name = name;
	}
	

}
