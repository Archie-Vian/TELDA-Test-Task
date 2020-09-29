package ru.telda.teldatesttask.repository.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.telda.teldatesttask.model.Region;

import java.util.List;

public interface RegionMapper {

	@Insert("Insert into regions (name, code) values (#{name}, #{code})")
	void createRegion(@Param("name") String name, @Param("code") Integer code);

	@Select("Select * from Regions where id = #{id}")
	Region getRegionById(@Param("id") Long id);

	@Select("Select * from Regions")
	List<Region> getRegion();

	@Update("Update regions set name = #{name}, code = #{code} where id = #{id}")
	void updateRegion(@Param("name") String name, @Param("code") Integer code, @Param("id") Long id);

	@Delete("Delete from regions where id = #{id}")
	boolean deleteRegion(@Param("id") Long id);

}
