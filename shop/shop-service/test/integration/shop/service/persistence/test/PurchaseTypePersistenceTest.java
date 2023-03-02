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

import shop.exception.NoSuchPurchaseTypeException;

import shop.model.PurchaseType;

import shop.service.PurchaseTypeLocalServiceUtil;
import shop.service.persistence.PurchaseTypePersistence;
import shop.service.persistence.PurchaseTypeUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PurchaseTypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "shop.service"));

	@Before
	public void setUp() {
		_persistence = PurchaseTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PurchaseType> iterator = _purchaseTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType purchaseType = _persistence.create(pk);

		Assert.assertNotNull(purchaseType);

		Assert.assertEquals(purchaseType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		_persistence.remove(newPurchaseType);

		PurchaseType existingPurchaseType = _persistence.fetchByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertNull(existingPurchaseType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPurchaseType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType newPurchaseType = _persistence.create(pk);

		newPurchaseType.setName(RandomTestUtil.randomString());

		_purchaseTypes.add(_persistence.update(newPurchaseType));

		PurchaseType existingPurchaseType = _persistence.findByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertEquals(
			existingPurchaseType.getId(), newPurchaseType.getId());
		Assert.assertEquals(
			existingPurchaseType.getName(), newPurchaseType.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		PurchaseType existingPurchaseType = _persistence.findByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertEquals(existingPurchaseType, newPurchaseType);
	}

	@Test(expected = NoSuchPurchaseTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PurchaseType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SHOP_PurchaseType", "id", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		PurchaseType existingPurchaseType = _persistence.fetchByPrimaryKey(
			newPurchaseType.getPrimaryKey());

		Assert.assertEquals(existingPurchaseType, newPurchaseType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType missingPurchaseType = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPurchaseType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PurchaseType newPurchaseType1 = addPurchaseType();
		PurchaseType newPurchaseType2 = addPurchaseType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchaseType1.getPrimaryKey());
		primaryKeys.add(newPurchaseType2.getPrimaryKey());

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, purchaseTypes.size());
		Assert.assertEquals(
			newPurchaseType1,
			purchaseTypes.get(newPurchaseType1.getPrimaryKey()));
		Assert.assertEquals(
			newPurchaseType2,
			purchaseTypes.get(newPurchaseType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(purchaseTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PurchaseType newPurchaseType = addPurchaseType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchaseType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, purchaseTypes.size());
		Assert.assertEquals(
			newPurchaseType,
			purchaseTypes.get(newPurchaseType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(purchaseTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchaseType.getPrimaryKey());

		Map<Serializable, PurchaseType> purchaseTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, purchaseTypes.size());
		Assert.assertEquals(
			newPurchaseType,
			purchaseTypes.get(newPurchaseType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PurchaseTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PurchaseType>() {

				@Override
				public void performAction(PurchaseType purchaseType) {
					Assert.assertNotNull(purchaseType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newPurchaseType.getId()));

		List<PurchaseType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PurchaseType existingPurchaseType = result.get(0);

		Assert.assertEquals(existingPurchaseType, newPurchaseType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<PurchaseType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PurchaseType newPurchaseType = addPurchaseType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newPurchaseType.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PurchaseType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected PurchaseType addPurchaseType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PurchaseType purchaseType = _persistence.create(pk);

		purchaseType.setName(RandomTestUtil.randomString());

		_purchaseTypes.add(_persistence.update(purchaseType));

		return purchaseType;
	}

	private List<PurchaseType> _purchaseTypes = new ArrayList<PurchaseType>();
	private PurchaseTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}