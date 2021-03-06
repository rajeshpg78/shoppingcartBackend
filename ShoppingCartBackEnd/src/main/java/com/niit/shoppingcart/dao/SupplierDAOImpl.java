package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Supplier> list() {
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession()
				.createCriteria("supplier.class").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;

	}

	@Transactional
	public Supplier get(String id) {
		String hql = "from Supplier where id=" + "'" + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listSupplier = (List<Supplier>) query.list();

		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Supplier supplier) {
		System.out.println("save or upadte");
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		System.out.println("supplier is saved***");

	}

	@Transactional
	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(id);

	}

}
