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

package shop.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import org.osgi.annotation.versioning.ProviderType;
import shop.exception.NoSuchElectronicsException;
import shop.model.Electronics;

/**
 * The persistence interface for the electronics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicsUtil
 * @generated
 */
@ProviderType
public interface ElectronicsPersistence extends BasePersistence<Electronics> {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ElectronicsUtil} to access the electronics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
     * Caches the electronics in the entity cache if it is enabled.
     *
     * @param electronics the electronics
     */
    public void cacheResult(Electronics electronics);

    /**
     * Caches the electronicses in the entity cache if it is enabled.
     *
     * @param electronicses the electronicses
     */
    public void cacheResult(java.util.List<Electronics> electronicses);

    /**
     * Creates a new electronics with the primary key. Does not add the electronics to the database.
     *
     * @param id the primary key for the new electronics
     * @return the new electronics
     */
    public Electronics create(long id);

    /**
     * Removes the electronics with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the electronics
     * @return the electronics that was removed
     * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
     */
    public Electronics remove(long id) throws NoSuchElectronicsException;

    public Electronics updateImpl(Electronics electronics);

    /**
     * Returns the electronics with the primary key or throws a <code>NoSuchElectronicsException</code> if it could not be found.
     *
     * @param id the primary key of the electronics
     * @return the electronics
     * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
     */
    public Electronics findByPrimaryKey(long id)
            throws NoSuchElectronicsException;

    /**
     * Returns the electronics with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the electronics
     * @return the electronics, or <code>null</code> if a electronics with the primary key could not be found
     */
    public Electronics fetchByPrimaryKey(long id);

    /**
     * Returns all the electronicses.
     *
     * @return the electronicses
     */
    public java.util.List<Electronics> findAll();

    /**
     * Returns a range of all the electronicses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electronicses
     * @param end the upper bound of the range of electronicses (not inclusive)
     * @return the range of electronicses
     */
    public java.util.List<Electronics> findAll(int start, int end);

    /**
     * Returns an ordered range of all the electronicses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electronicses
     * @param end the upper bound of the range of electronicses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of electronicses
     */
    public java.util.List<Electronics> findAll(
            int start, int end,
            com.liferay.portal.kernel.util.OrderByComparator<Electronics>
                    orderByComparator);

    /**
     * Returns an ordered range of all the electronicses.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
     * </p>
     *
     * @param start the lower bound of the range of electronicses
     * @param end the upper bound of the range of electronicses (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @param useFinderCache whether to use the finder cache
     * @return the ordered range of electronicses
     */
    public java.util.List<Electronics> findAll(
            int start, int end,
            com.liferay.portal.kernel.util.OrderByComparator<Electronics>
                    orderByComparator,
            boolean useFinderCache);

    /**
     * Removes all the electronicses from the database.
     */
    public void removeAll();

    /**
     * Returns the number of electronicses.
     *
     * @return the number of electronicses
     */
    public int countAll();

}