package ru.telda.teldatesttask.crud.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.telda.teldatesttask.crud.RegionCRUDController;
import ru.telda.teldatesttask.crud.RegionService;
import ru.telda.teldatesttask.model.Region;

import java.util.List;

/**
 * Реализация CRUD контроллера региона.
 */
@RestController
@RequestMapping(RegionCRUDController.BASE_URL)
public class RegionCRUDControllerImpl implements RegionCRUDController {

	private  final RegionService regionService;

	/**
	 * Конструктор.
	 *
	 * @param regionService CRUD сервис региона
	 */
	public RegionCRUDControllerImpl(RegionService regionService) {
		this.regionService = regionService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResponseEntity create(Region region) {
		regionService.create(region);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Cacheable(value = "region", key = "#id")
	public ResponseEntity<Region> getById(Long id) {
		return ResponseEntity.ok(regionService.getById(id));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Cacheable(value = "regions")
	public ResponseEntity<List<Region>> getAll() {
		return ResponseEntity.ok(regionService.getAll());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@CachePut(value = "region")
	public ResponseEntity update(Region region, Long id) {
		regionService.update(region, id);
		return new ResponseEntity(HttpStatus.OK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@CacheEvict(value = "region", key = "#id")
	public ResponseEntity delete(Long id) {
		regionService.delete(id);
		evictGetAllCache();
		return new ResponseEntity(HttpStatus.OK);

	}

	/**
	 * Удалить кэш для резльтата вызова метода getAll.
	 */
	@CacheEvict(value = "regions")
	public void evictGetAllCache() {}

}
