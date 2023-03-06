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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
public class PurchaseWrapper
        extends BaseModelWrapper<Purchase>
        implements ModelWrapper<Purchase>, Purchase {

    public PurchaseWrapper(Purchase purchase) {
        super(purchase);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("purchaseDate", getPurchaseDate());
        attributes.put("eTypeId", getETypeId());
        attributes.put("employeeId", getEmployeeId());
        attributes.put("electroId", getElectroId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Date purchaseDate = (Date) attributes.get("purchaseDate");

        if (purchaseDate != null) {
            setPurchaseDate(purchaseDate);
        }

        Long eTypeId = (Long) attributes.get("eTypeId");

        if (eTypeId != null) {
            setETypeId(eTypeId);
        }

        Long employeeId = (Long) attributes.get("employeeId");

        if (employeeId != null) {
            setEmployeeId(employeeId);
        }

        Long electroId = (Long) attributes.get("electroId");

        if (electroId != null) {
            setElectroId(electroId);
        }
    }

    /**
     * Returns the electro ID of this purchase.
     *
     * @return the electro ID of this purchase
     */
    @Override
    public long getElectroId() {
        return model.getElectroId();
    }

    /**
     * Sets the electro ID of this purchase.
     *
     * @param electroId the electro ID of this purchase
     */
    @Override
    public void setElectroId(long electroId) {
        model.setElectroId(electroId);
    }

    /**
     * Returns the employee ID of this purchase.
     *
     * @return the employee ID of this purchase
     */
    @Override
    public long getEmployeeId() {
        return model.getEmployeeId();
    }

    /**
     * Sets the employee ID of this purchase.
     *
     * @param employeeId the employee ID of this purchase
     */
    @Override
    public void setEmployeeId(long employeeId) {
        model.setEmployeeId(employeeId);
    }

    /**
     * Returns the e type ID of this purchase.
     *
     * @return the e type ID of this purchase
     */
    @Override
    public long getETypeId() {
        return model.getETypeId();
    }

    /**
     * Sets the e type ID of this purchase.
     *
     * @param eTypeId the e type ID of this purchase
     */
    @Override
    public void setETypeId(long eTypeId) {
        model.setETypeId(eTypeId);
    }

    /**
     * Returns the ID of this purchase.
     *
     * @return the ID of this purchase
     */
    @Override
    public long getId() {
        return model.getId();
    }

    /**
     * Sets the ID of this purchase.
     *
     * @param id the ID of this purchase
     */
    @Override
    public void setId(long id) {
        model.setId(id);
    }

    /**
     * Returns the primary key of this purchase.
     *
     * @return the primary key of this purchase
     */
    @Override
    public long getPrimaryKey() {
        return model.getPrimaryKey();
    }

    /**
     * Sets the primary key of this purchase.
     *
     * @param primaryKey the primary key of this purchase
     */
    @Override
    public void setPrimaryKey(long primaryKey) {
        model.setPrimaryKey(primaryKey);
    }

    /**
     * Returns the purchase date of this purchase.
     *
     * @return the purchase date of this purchase
     */
    @Override
    public Date getPurchaseDate() {
        return model.getPurchaseDate();
    }

    /**
     * Sets the purchase date of this purchase.
     *
     * @param purchaseDate the purchase date of this purchase
     */
    @Override
    public void setPurchaseDate(Date purchaseDate) {
        model.setPurchaseDate(purchaseDate);
    }

    @Override
    public void persist() {
        model.persist();
    }

    @Override
    protected PurchaseWrapper wrap(Purchase purchase) {
        return new PurchaseWrapper(purchase);
    }

}