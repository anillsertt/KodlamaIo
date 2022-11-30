package kodlama.io.KodlamaIo.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technologies")
@Entity

public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;


	@ManyToOne
	@JoinColumn(name = "language_id")
	@JsonIgnore
	private Language language;
	
	public Technology(String name, Language language) {
		this.name = name;
		this.language = language;
	}
	
}
