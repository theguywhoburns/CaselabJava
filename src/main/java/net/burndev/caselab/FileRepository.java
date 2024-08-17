package net.burndev.caselab;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
	// JpaRepository предоставляет базовые CRUD-операции для сущности FileEntity
}
