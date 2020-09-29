package ru.telda.teldatesttask.model;

/**
 * Класс абстрактной сущности. Предоставляет поле Id.
 */
public abstract class BaseEntity {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
