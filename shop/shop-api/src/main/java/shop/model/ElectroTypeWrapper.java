/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
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
 * This class is a wrapper for {@link ElectroType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroType
 * @generated
 */
public class ElectroTypeWrapper
        extends BaseModelWrapper<ElectroType>
        implements ElectroType, ModelWrapper<ElectroType> {

    public ElectroTypeWrapper(ElectroType electroType) {
        super(electroType);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    /**
     * Returns the ID of this electro type.
     *
     * @return the ID of this electro type
     */
    @Override
    public long getId() {
        return model.getId();
    }

    /**
     * Sets the ID of this electro type.
     *
     * @param id the ID of this electro type
     */
    @Override
    public void setId(long id) {
        model.setId(id);
    }

    /**
     * Returns the name of this electro type.
     *
     * @return the name of this electro type
     */
    @Override
    public String getName() {
        return model.getName();
    }

    /**
     * Sets the name of this electro type.
     *
     * @param name the name of this electro type
     */
    @Override
    public void setName(String name) {
        model.setName(name);
    }

    /**
     * Returns the primary key of this electro type.
     *
     * @return the primary key of this electro type
     */
    @Override
    public long getPrimaryKey() {
        return model.getPrimaryKey();
    }

    /**
     * Sets the primary key of this electro type.
     *
     * @param primaryKey the primary key of this electro type
     */
    @Override
    public void setPrimaryKey(long primaryKey) {
        model.setPrimaryKey(primaryKey);
    }

    @Override
    public void persist() {
        model.persist();
    }

    @Override
    protected ElectroTypeWrapper wrap(ElectroType electroType) {
        return new ElectroTypeWrapper(electroType);
    }

}