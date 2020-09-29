package ru.telda.teldatesttask.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.telda.teldatesttask.model.Region;

import java.util.List;

/**
 * Интерфейс CRUD контроллера сущности Region
 */
public interface RegionCRUDController extends AbstractCRUDController<Region> {

	String BASE_URL = AbstractCRUDController.BASE_URL + "/region";

	/**
	 * Создать регион.
	 *
	 * @param region 	Регион, который должен быть создан
	 *
	 * @return 			Ответ от сервера.
	 * 					В случае, если запрашиваемый к созданию регион недопустим -
	 * 					возвращает ответ со статусом UNPROCESSABLE_ENTITY
	 */
	@Override
	ResponseEntity create(@RequestBody Region region);

	/**
	 * Найти регион по указаному Id
	 *
	 * @param id 	Id запрашиваемого региона
	 * @return		Ответ сервера, содержащий запрашиваемый регион.
	 * 				В случае, если регион не был найден - возвращает ответ со статусом NOT_FOUND
	 */
	@Override
	ResponseEntity<Region> getById(@PathVariable Long id);

	/**
	 * Найти все регионы в базе данных.
	 *
	 * @return 	Ответ сервера, содержащий список всех регионов в БД.
	 * 			В случае отсутствия регионов в БД - возвращает ответ со статусом NOT_FOUND
	 */
	@Override
	ResponseEntity<List<Region>> getAll();

	/**
	 * Обновить данные региона. Допускается выборочное обновление параметров.
	 *
	 * @param region 	Сущность региона. Может иметь null-поля.
	 * @param id 		Id обновляемого региона
	 *
	 * @return 			Ответ сервера.
	 * 					В случае, если регион не был найден - возвращает ответ со статусом NOT_FOUND
	 */
	@Override
	ResponseEntity update(@RequestBody Region region, @PathVariable Long id);

	/**
	 * Удаляет регион с выбраным Id.
	 *
	 * @param id	Id региона, который должен быть удалён
	 *
	 * @return 		Ответ сервера.
	 * 				В случае, если регион не был найден, возвращает ответ со статусом NOT_FOUND
	 */
	@Override
	ResponseEntity delete(@PathVariable Long id);

}
