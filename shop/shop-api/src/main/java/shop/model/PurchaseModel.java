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

import com.liferay.portal.kernel.model.BaseModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;

/**
 * The base model interface for the Purchase service. Represents a row in the &quot;SHOP_Purchase&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>shop.model.impl.PurchaseModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>shop.model.impl.PurchaseImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
@ProviderType
public interface PurchaseModel extends BaseModel<Purchase> {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a purchase model instance should use the {@link Purchase} interface instead.
     */

    /**
     * Returns the primary key of this purchase.
     *
     * @return the primary key of this purchase
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this purchase.
     *
     * @param primaryKey the primary key of this purchase
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this purchase.
     *
     * @return the ID of this purchase
     */
    public long getId();

    /**
     * Sets the ID of this purchase.
     *
     * @param id the ID of this purchase
     */
    public void setId(long id);

    /**
     * Returns the purchase date of this purchase.
     *
     * @return the purchase date of this purchase
     */
    public Date getPurchaseDate();

    /**
     * Sets the purchase date of this purchase.
     *
     * @param purchaseDate the purchase date of this purchase
     */
    public void setPurchaseDate(Date purchaseDate);

    /**
     * Returns the e type ID of this purchase.
     *
     * @return the e type ID of this purchase
     */
    public long getETypeId();

    /**
     * Sets the e type ID of this purchase.
     *
     * @param eTypeId the e type ID of this purchase
     */
    public void setETypeId(long eTypeId);

    /**
     * Returns the employee ID of this purchase.
     *
     * @return the employee ID of this purchase
     */
    public long getEmployeeId();

    /**
     * Sets the employee ID of this purchase.
     *
     * @param employeeId the employee ID of this purchase
     */
    public void setEmployeeId(long employeeId);

    /**
     * Returns the electro ID of this purchase.
     *
     * @return the electro ID of this purchase
     */
    public long getElectroId();

    /**
     * Sets the electro ID of this purchase.
     *
     * @param electroId the electro ID of this purchase
     */
    public void setElectroId(long electroId);

}