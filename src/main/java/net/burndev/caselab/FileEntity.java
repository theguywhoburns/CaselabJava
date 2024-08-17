package net.burndev.caselab;

import jakarta.persistence.*;
import java.util.Base64;

@Entity
@Table(name = "files")
public class FileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String creationDate;
	private String description;

	@Lob
	private byte[] data;

	public FileEntity() {}

	public FileEntity(FileDto fileDto) {
		this.title = fileDto.getTitle();
		this.creationDate = fileDto.getCreationDate();
		this.description = fileDto.getDescription();
		this.data = Base64.getDecoder().decode(fileDto.getData());
	}

	public Long getId() 						{ return id; }
	public String getTitle() 				{ return title; }
	public String getCreationDate()	{ return creationDate; }
	public String getDescription() 	{ return description; }
	public byte[] getData() 				{ return data; }

	public void setId(Long id) 											{ this.id = id; }
	public void setTitle(String title) 							{ this.title = title; }
	public void setCreationDate(String creationDate){ this.creationDate = creationDate; }
	public void setDescription(String description)	{ this.description = description; }
	public void setData(byte[] data) 								{ this.data = data; }
}
