package net.burndev.caselab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class FileController {
	@Autowired
	private FileService fileService;

	// Метод для загрузки файла
	@PostMapping
	public ResponseEntity<Long> uploadFile(@RequestBody FileDto fileDto) {
		FileEntity file = new FileEntity(fileDto);
		file = fileService.saveFile(file);
		System.out.println(file.getId());		
		return ResponseEntity.ok(file.getId());
	}

	// Метод для получения файла по его ID
	@GetMapping("/{id}")
	public ResponseEntity<FileDto> downloadFile(@PathVariable Long id) {
		Optional<FileEntity> file = fileService.getFile(id);
		if (file.isPresent()) {
			FileDto fileDto = new FileDto(file.get());
			return ResponseEntity.ok(fileDto);
		} 
		return ResponseEntity.notFound().build();
	}

	// Метод для получения списка всех файлов с пагинацией и сортировкой
	@GetMapping
	public ResponseEntity<Page<FileDto>> getAllFiles(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
		// Создаём объект Pageable для пагинации и сортировки
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		Page<FileEntity> filePage = fileService.getAllFiles(pageable);
		Page<FileDto> dtoPage = filePage.map(FileDto::new);
		return ResponseEntity.ok(dtoPage);
	}
}
