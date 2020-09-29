package ru.telda.teldatesttask.repository.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.telda.teldatesttask.model.Region;

import java.util.List;

/**
 * Маппер, взаимодействующий с таблицей region в базе данных.
 */
public interface RegionMapper {

	/**
	 * Добавление записи таблицу.
	 *
	 * @param name Имя региона
	 * @param code Код региона
	 */
	@Insert("Insert into regions (name, code) values (#{name}, #{code})")
	void createRegion(@Param("name") String name, @Param("code") Integer code);

	/**
	 * Поиск записи по уникальному идентификатору.
	 *
	 * @param id 	Id записи
	 * @return 		Сущность региона
	 */
	@Select("Select * from Regions where id = #{id}")
	Region getRegionById(@Param("id") Long id);

	/**
	 * Поиск всех записей в таблице region
	 *
	 * @return Список всех записей в таблице
	 */
	@Select("Select * from Regions")
	List<Region> getRegion();

	/**
	 * Обновление записи с указанным уникальным инднтификатором.
	 *
	 * @param name 	Имя региона
	 * @param code 	Код региона
	 * @param id	Уникальный идентификатор записи
	 */
	@Update("Update regions set name = #{name}, code = #{code} where id = #{id}")
	void updateRegion(@Param("name") String name, @Param("code") Integer code, @Param("id") Long id);

	/**
	 * Удаление записи из таблицы.
	 *
	 * @param id 	Уникальлный идентификатор записи, подлежащей удалению
	 * @return		Была ли удалена запись
	 */
	@Delete("Delete from regions where id = #{id}")
	boolean deleteRegion(@Param("id") Long id);

}
