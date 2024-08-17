package net.burndev.caselab;

import java.util.Base64;

/**
 * DTO(Data Transfer Object) для передачи данных между клиентом и сервером
 * @apiNote Если честно он нахер не сдался, тк он тупо будет жрать память но я хотел сделать красиво
 * Если что можно декодировать и кодировать файл прямо при получении / отправке что сэкономит место, но это больше кода писать, а мне лень, мне за это не платят ахах
 */
public class FileDto {
	private String title;
	private String creationDate;
	private String description;
	private String data; // Base64 закодированные данные файла
	public FileDto() {}
	public FileDto(Long id, String title, String creationDate, String description, String fileData) {
		this.title = title;
		this.creationDate = creationDate;
		this.description = description;
		this.data = fileData;
	}

	// И нахера он мне?
	public FileDto(FileEntity fileEntity) {
		this.title = fileEntity.getTitle();
		this.creationDate = fileEntity.getCreationDate();
		this.description = fileEntity.getDescription();
		this.data = new String(Base64.getEncoder().encode(fileEntity.getData()));
	}

	public String getTitle() 				{ return title; }
	public String getCreationDate() { return creationDate; }
	public String getDescription() 	{ return description; }
	public String getData() 				{ return data; }

	public void setTitle(String title) 							{ this.title = title; }
	public void setCreationDate(String creationDate){ this.creationDate = creationDate; }
	public void setDescription(String description)  { this.description = description; }
	public void setData(String data) 								{ this.data = data; }
}