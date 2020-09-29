package ru.telda.teldatesttask.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;


/**
 * Интерфейс, описывающий абстрактный CRUD контроллер.
 * @param <Entity> Сущность, обрабатываемая в контроллере, наследующем данный интерфейс
 */
public interface AbstractCRUDController<Entity> {
	String BASE_URL = "/api";

	/**
	 * Сохранить сущность в БД.
	 *
	 * @param entity 	Сущность для вохранения в БД
	 * @return 			Ответ от сервера
	 */
	@PostMapping
	ResponseEntity create(Entity entity);

	/**
	 * Найти сущность по указаному Id.
	 *
	 * @param id 	Id запрашиваемой сущности
	 * @return 		Ответ сервера, содержащий сущность с запрашиваемым Id
	 */
	@GetMapping("/{id}")
	ResponseEntity<Entity> getById(Long id);

	/**
	 * Найти все сущности запрашиваемого типа в БД.
	 *
	 * @return Ответ сервера, содержащий список всех сущностей указанного типа, находящихся в БД
	 */
	@GetMapping
	ResponseEntity<List<Entity>> getAll();

	/**
	 * Одновить состояние сущности c указаным Id в БД.
	 *
	 * @param entity 	Обновлённое состояние сущности
	 * @param id 		Id обновляемой сущности
	 *
	 * @return 			Ответ сервера
	 */
	@PutMapping("/{id}")
	ResponseEntity update(Entity entity, Long id);

	/**
	 * Удалить сущность с указаным Id.
	 *
	 * @param id 	Id сущности, которую требуется удалить
	 * @return 		Ответ сервера, содержащий
	 */
	@DeleteMapping("/{id}")
	ResponseEntity delete(Long id);

}
