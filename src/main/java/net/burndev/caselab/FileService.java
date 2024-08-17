package net.burndev.caselab;

import net.burndev.caselab.FileEntity; 		// Потому что я сказал
import net.burndev.caselab.FileRepository;// Потому что я сказал

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("unused") // Потому что я сказал
@Service
public class FileService {
	@Autowired
	private FileRepository fileRepository;

	// Сохранение файла в базу данных

	public FileEntity saveFile(FileEntity fileEntity) {
		return fileRepository.save(fileEntity);
	}

	// Получение файла по его ID
	public Optional<FileEntity> getFile(Long id) {
		return fileRepository.findById(id);
	}

	// Получение списка всех файлов с пагинацией
	public Page<FileEntity> getAllFiles(Pageable pageable) {
		return fileRepository.findAll(pageable);
	}

}
