package ru.telda.teldatesttask.crud.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.telda.teldatesttask.crud.RegionService;
import ru.telda.teldatesttask.model.Region;
import ru.telda.teldatesttask.repository.mapper.RegionMapper;

import java.util.List;

@Slf4j
@Service
public class RegionServiceImpl implements RegionService {

	private final RegionMapper regionMapper;

	/**
	 * Конструктор.
	 *
	 * @param regionMapper Маппер, предоставляющий доступ к записям в таблице region.
	 */
	public RegionServiceImpl(RegionMapper regionMapper) {
		this.regionMapper = regionMapper;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(Region newEntity) {
		try {
			if (newEntity != null && isNotBlank(newEntity.getCode()) && isNotBlank(newEntity.getName())) {
				regionMapper.createRegion(newEntity.getName(), newEntity.getCode());
				log.info("Произведена запись в таблице region");
			}
			else {
				throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
						"Имя и код региона не могут быть пустыми!");
			}
		} catch (DuplicateKeyException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
					"Регион с указаным именем или ключом уже существует!");
		} catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
					"Код региона должен содержать не более трёх символов!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Region getById(Long id) throws EmptyResultDataAccessException {
		var region = regionMapper.getRegionById(id);

		if (region == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}

		return regionMapper.getRegionById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Region> getAll() throws EmptyResultDataAccessException {
		var regions = regionMapper.getRegion();

		if(regions.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}

		return regionMapper.getRegion();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Region updatedEntity, Long id) throws EmptyResultDataAccessException{
		boolean isUpdated = false;

		var regionOnUpdate = getById(id);

		if (regionOnUpdate == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}

		if(isNotBlank(updatedEntity.getName())) {
			isUpdated = true;
			regionOnUpdate.setName(updatedEntity.getName());
		}

		if(isNotBlank(updatedEntity.getCode())) {
			isUpdated = true;
			regionOnUpdate.setCode(updatedEntity.getCode());
		}

		regionMapper.updateRegion(regionOnUpdate.getName(), regionOnUpdate.getCode(), regionOnUpdate.getId());

		if (isUpdated) {
			log.info("Произведено обновление записи с Id {} в таблице region", id);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Long id) {
		if (!regionMapper.deleteRegion(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE);
		}
		log.info("Произведено удаление записи с Id {} в таблице region", id);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean isNotBlank(String param) {
		return param != null && param.trim().length() != 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean isNotBlank(Integer param) {
		return param != null;
	}
}
