package ru.telda.teldatesttask.crud;

import ru.telda.teldatesttask.model.Region;

import java.util.List;

/**
 * Сервис, описывающий CRUD сервис региона.
 */
public interface RegionService extends AbstractService<Region> {

	String NOT_FOUND_MESSAGE = "Региона с указаным Id не существует!";

	/**
	 * Сохранить регион в базе данных.
	 *
	 * @param newEntity объект региона
	 */
	@Override
	void create(Region newEntity);

	/**
	 * Найти регион с указанным id в базе данных.
	 *
	 * @param id Id искомого региона
	 * @return Регион, найденный по Id
	 */
	@Override
	Region getById(Long id);

	/**
	 * Найти все регионы в базе данных.
	 * @return Список всех регионов, содержащихся в базе данных
	 */
	@Override
	List<Region> getAll();

	/**
	 * Обновить записть региона с указанным Id в базе данных.
	 *
	 * @param updatedEntity обновленное состояние региона
	 * @param id Id региона для обновления
	 */
	@Override
	void update(Region updatedEntity, Long id);

	/**
	 * Удалить запись о регионе с указаным Id из базы данных.
	 * @param id Id региона для удаления
	 */
	@Override
	void delete(Long id);

	/**
	 * Является ли строка пустой.
	 * @param param Строка (имя региона)
	 * @return Результат условия
	 */
	Boolean isNotBlank(String param);

	/**
	 * Проверка числа на null.
	 * @param param Число (код региона)
	 * @return Результат условия
	 */
	Boolean isNotBlank(Integer param);
}
