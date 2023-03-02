/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package shop.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Electronics}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electronics
 * @generated
 */
public class ElectronicsWrapper
	extends BaseModelWrapper<Electronics>
	implements Electronics, ModelWrapper<Electronics> {

	public ElectronicsWrapper(Electronics electronics) {
		super(electronics);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("eTypeId", getETypeId());
		attributes.put("price", getPrice());
		attributes.put("count", getCount());
		attributes.put("isInStock", isIsInStock());
		attributes.put("isArchive", isIsArchive());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long eTypeId = (Long)attributes.get("eTypeId");

		if (eTypeId != null) {
			setETypeId(eTypeId);
		}

		Long price = (Long)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Boolean isInStock = (Boolean)attributes.get("isInStock");

		if (isInStock != null) {
			setIsInStock(isInStock);
		}

		Boolean isArchive = (Boolean)attributes.get("isArchive");

		if (isArchive != null) {
			setIsArchive(isArchive);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the count of this electronics.
	 *
	 * @return the count of this electronics
	 */
	@Override
	public int getCount() {
		return model.getCount();
	}

	/**
	 * Returns the description of this electronics.
	 *
	 * @return the description of this electronics
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the e type ID of this electronics.
	 *
	 * @return the e type ID of this electronics
	 */
	@Override
	public long getETypeId() {
		return model.getETypeId();
	}

	/**
	 * Returns the ID of this electronics.
	 *
	 * @return the ID of this electronics
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is archive of this electronics.
	 *
	 * @return the is archive of this electronics
	 */
	@Override
	public boolean getIsArchive() {
		return model.getIsArchive();
	}

	/**
	 * Returns the is in stock of this electronics.
	 *
	 * @return the is in stock of this electronics
	 */
	@Override
	public boolean getIsInStock() {
		return model.getIsInStock();
	}

	/**
	 * Returns the name of this electronics.
	 *
	 * @return the name of this electronics
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the price of this electronics.
	 *
	 * @return the price of this electronics
	 */
	@Override
	public long getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this electronics.
	 *
	 * @return the primary key of this electronics
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this electronics is is archive.
	 *
	 * @return <code>true</code> if this electronics is is archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsArchive() {
		return model.isIsArchive();
	}

	/**
	 * Returns <code>true</code> if this electronics is is in stock.
	 *
	 * @return <code>true</code> if this electronics is is in stock; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsInStock() {
		return model.isIsInStock();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the count of this electronics.
	 *
	 * @param count the count of this electronics
	 */
	@Override
	public void setCount(int count) {
		model.setCount(count);
	}

	/**
	 * Sets the description of this electronics.
	 *
	 * @param description the description of this electronics
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the e type ID of this electronics.
	 *
	 * @param eTypeId the e type ID of this electronics
	 */
	@Override
	public void setETypeId(long eTypeId) {
		model.setETypeId(eTypeId);
	}

	/**
	 * Sets the ID of this electronics.
	 *
	 * @param id the ID of this electronics
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets whether this electronics is is archive.
	 *
	 * @param isArchive the is archive of this electronics
	 */
	@Override
	public void setIsArchive(boolean isArchive) {
		model.setIsArchive(isArchive);
	}

	/**
	 * Sets whether this electronics is is in stock.
	 *
	 * @param isInStock the is in stock of this electronics
	 */
	@Override
	public void setIsInStock(boolean isInStock) {
		model.setIsInStock(isInStock);
	}

	/**
	 * Sets the name of this electronics.
	 *
	 * @param name the name of this electronics
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the price of this electronics.
	 *
	 * @param price the price of this electronics
	 */
	@Override
	public void setPrice(long price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this electronics.
	 *
	 * @param primaryKey the primary key of this electronics
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ElectronicsWrapper wrap(Electronics electronics) {
		return new ElectronicsWrapper(electronics);
	}

}