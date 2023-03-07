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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link shop.service.http.ElectronicsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ElectronicsSoap implements Serializable {

	public static ElectronicsSoap toSoapModel(Electronics model) {
		ElectronicsSoap soapModel = new ElectronicsSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setETypeId(model.getETypeId());
		soapModel.setPrice(model.getPrice());
		soapModel.setCount(model.getCount());
		soapModel.setIsInStock(model.isIsInStock());
		soapModel.setIsArchive(model.isIsArchive());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ElectronicsSoap[] toSoapModels(Electronics[] models) {
		ElectronicsSoap[] soapModels = new ElectronicsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ElectronicsSoap[][] toSoapModels(Electronics[][] models) {
		ElectronicsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ElectronicsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ElectronicsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ElectronicsSoap[] toSoapModels(List<Electronics> models) {
		List<ElectronicsSoap> soapModels = new ArrayList<ElectronicsSoap>(
			models.size());

		for (Electronics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ElectronicsSoap[soapModels.size()]);
	}

	public ElectronicsSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getETypeId() {
		return _eTypeId;
	}

	public void setETypeId(long eTypeId) {
		_eTypeId = eTypeId;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public boolean getIsInStock() {
		return _isInStock;
	}

	public boolean isIsInStock() {
		return _isInStock;
	}

	public void setIsInStock(boolean isInStock) {
		_isInStock = isInStock;
	}

	public boolean getIsArchive() {
		return _isArchive;
	}

	public boolean isIsArchive() {
		return _isArchive;
	}

	public void setIsArchive(boolean isArchive) {
		_isArchive = isArchive;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _id;
	private String _name;
	private long _eTypeId;
	private long _price;
	private int _count;
	private boolean _isInStock;
	private boolean _isArchive;
	private String _description;

}