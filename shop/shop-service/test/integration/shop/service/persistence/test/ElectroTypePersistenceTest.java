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

package shop.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import shop.exception.NoSuchElectroTypeException;

import shop.model.ElectroType;

import shop.service.ElectroTypeLocalServiceUtil;
import shop.service.persistence.ElectroTypePersistence;
import shop.service.persistence.ElectroTypeUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ElectroTypePersistenceTest {

    @ClassRule
    @Rule
    public static final AggregateTestRule aggregateTestRule =
            new AggregateTestRule(
                    new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
                    new TransactionalTestRule(Propagation.REQUIRED, "shop.service"));
    private List<ElectroType> _electroTypes = new ArrayList<ElectroType>();
    private ElectroTypePersistence _persistence;
    private ClassLoader _dynamicQueryClassLoader;

    @Before
    public void setUp() {
        _persistence = ElectroTypeUtil.getPersistence();

        Class<?> clazz = _persistence.getClass();

        _dynamicQueryClassLoader = clazz.getClassLoader();
    }

    @After
    public void tearDown() throws Exception {
        Iterator<ElectroType> iterator = _electroTypes.iterator();

        while (iterator.hasNext()) {
            _persistence.remove(iterator.next());

            iterator.remove();
        }
    }

    @Test
    public void testCreate() throws Exception {
        long pk = RandomTestUtil.nextLong();

        ElectroType electroType = _persistence.create(pk);

        Assert.assertNotNull(electroType);

        Assert.assertEquals(electroType.getPrimaryKey(), pk);
    }

    @Test
    public void testRemove() throws Exception {
        ElectroType newElectroType = addElectroType();

        _persistence.remove(newElectroType);

        ElectroType existingElectroType = _persistence.fetchByPrimaryKey(
                newElectroType.getPrimaryKey());

        Assert.assertNull(existingElectroType);
    }

    @Test
    public void testUpdateNew() throws Exception {
        addElectroType();
    }

    @Test
    public void testUpdateExisting() throws Exception {
        long pk = RandomTestUtil.nextLong();

        ElectroType newElectroType = _persistence.create(pk);

        newElectroType.setName(RandomTestUtil.randomString());

        _electroTypes.add(_persistence.update(newElectroType));

        ElectroType existingElectroType = _persistence.findByPrimaryKey(
                newElectroType.getPrimaryKey());

        Assert.assertEquals(
                existingElectroType.getId(), newElectroType.getId());
        Assert.assertEquals(
                existingElectroType.getName(), newElectroType.getName());
    }

    @Test
    public void testFindByPrimaryKeyExisting() throws Exception {
        ElectroType newElectroType = addElectroType();

        ElectroType existingElectroType = _persistence.findByPrimaryKey(
                newElectroType.getPrimaryKey());

        Assert.assertEquals(existingElectroType, newElectroType);
    }

    @Test(expected = NoSuchElectroTypeException.class)
    public void testFindByPrimaryKeyMissing() throws Exception {
        long pk = RandomTestUtil.nextLong();

        _persistence.findByPrimaryKey(pk);
    }

    @Test
    public void testFindAll() throws Exception {
        _persistence.findAll(
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
    }

    protected OrderByComparator<ElectroType> getOrderByComparator() {
        return OrderByComparatorFactoryUtil.create(
                "SHOP_ElectroType", "id", true, "name", true);
    }

    @Test
    public void testFetchByPrimaryKeyExisting() throws Exception {
        ElectroType newElectroType = addElectroType();

        ElectroType existingElectroType = _persistence.fetchByPrimaryKey(
                newElectroType.getPrimaryKey());

        Assert.assertEquals(existingElectroType, newElectroType);
    }

    @Test
    public void testFetchByPrimaryKeyMissing() throws Exception {
        long pk = RandomTestUtil.nextLong();

        ElectroType missingElectroType = _persistence.fetchByPrimaryKey(pk);

        Assert.assertNull(missingElectroType);
    }

    @Test
    public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
            throws Exception {

        ElectroType newElectroType1 = addElectroType();
        ElectroType newElectroType2 = addElectroType();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(newElectroType1.getPrimaryKey());
        primaryKeys.add(newElectroType2.getPrimaryKey());

        Map<Serializable, ElectroType> electroTypes =
                _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertEquals(2, electroTypes.size());
        Assert.assertEquals(
                newElectroType1, electroTypes.get(newElectroType1.getPrimaryKey()));
        Assert.assertEquals(
                newElectroType2, electroTypes.get(newElectroType2.getPrimaryKey()));
    }

    @Test
    public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
            throws Exception {

        long pk1 = RandomTestUtil.nextLong();

        long pk2 = RandomTestUtil.nextLong();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(pk1);
        primaryKeys.add(pk2);

        Map<Serializable, ElectroType> electroTypes =
                _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertTrue(electroTypes.isEmpty());
    }

    @Test
    public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
            throws Exception {

        ElectroType newElectroType = addElectroType();

        long pk = RandomTestUtil.nextLong();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(newElectroType.getPrimaryKey());
        primaryKeys.add(pk);

        Map<Serializable, ElectroType> electroTypes =
                _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertEquals(1, electroTypes.size());
        Assert.assertEquals(
                newElectroType, electroTypes.get(newElectroType.getPrimaryKey()));
    }

    @Test
    public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        Map<Serializable, ElectroType> electroTypes =
                _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertTrue(electroTypes.isEmpty());
    }

    @Test
    public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
        ElectroType newElectroType = addElectroType();

        Set<Serializable> primaryKeys = new HashSet<Serializable>();

        primaryKeys.add(newElectroType.getPrimaryKey());

        Map<Serializable, ElectroType> electroTypes =
                _persistence.fetchByPrimaryKeys(primaryKeys);

        Assert.assertEquals(1, electroTypes.size());
        Assert.assertEquals(
                newElectroType, electroTypes.get(newElectroType.getPrimaryKey()));
    }

    @Test
    public void testActionableDynamicQuery() throws Exception {
        final IntegerWrapper count = new IntegerWrapper();

        ActionableDynamicQuery actionableDynamicQuery =
                ElectroTypeLocalServiceUtil.getActionableDynamicQuery();

        actionableDynamicQuery.setPerformActionMethod(
                new ActionableDynamicQuery.PerformActionMethod<ElectroType>() {

                    @Override
                    public void performAction(ElectroType electroType) {
                        Assert.assertNotNull(electroType);

                        count.increment();
                    }

                });

        actionableDynamicQuery.performActions();

        Assert.assertEquals(count.getValue(), _persistence.countAll());
    }

    @Test
    public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
        ElectroType newElectroType = addElectroType();

        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
                ElectroType.class, _dynamicQueryClassLoader);

        dynamicQuery.add(
                RestrictionsFactoryUtil.eq("id", newElectroType.getId()));

        List<ElectroType> result = _persistence.findWithDynamicQuery(
                dynamicQuery);

        Assert.assertEquals(1, result.size());

        ElectroType existingElectroType = result.get(0);

        Assert.assertEquals(existingElectroType, newElectroType);
    }

    @Test
    public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
                ElectroType.class, _dynamicQueryClassLoader);

        dynamicQuery.add(
                RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

        List<ElectroType> result = _persistence.findWithDynamicQuery(
                dynamicQuery);

        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testDynamicQueryByProjectionExisting() throws Exception {
        ElectroType newElectroType = addElectroType();

        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
                ElectroType.class, _dynamicQueryClassLoader);

        dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

        Object newId = newElectroType.getId();

        dynamicQuery.add(
                RestrictionsFactoryUtil.in("id", new Object[]{newId}));

        List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

        Assert.assertEquals(1, result.size());

        Object existingId = result.get(0);

        Assert.assertEquals(existingId, newId);
    }

    @Test
    public void testDynamicQueryByProjectionMissing() throws Exception {
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
                ElectroType.class, _dynamicQueryClassLoader);

        dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

        dynamicQuery.add(
                RestrictionsFactoryUtil.in(
                        "id", new Object[]{RandomTestUtil.nextLong()}));

        List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

        Assert.assertEquals(0, result.size());
    }

    protected ElectroType addElectroType() throws Exception {
        long pk = RandomTestUtil.nextLong();

        ElectroType electroType = _persistence.create(pk);

        electroType.setName(RandomTestUtil.randomString());

        _electroTypes.add(_persistence.update(electroType));

        return electroType;
    }

}