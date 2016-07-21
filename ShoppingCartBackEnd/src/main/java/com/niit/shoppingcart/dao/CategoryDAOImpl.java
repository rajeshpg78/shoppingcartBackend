package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
				.createCriteria("category.class").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;

	}

	@Transactional
	public Category get(String id) {
		String hql = "from Category where id=" + "'" + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listCategory = (List<Category>) query.list();

		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		return null;
	}

	@Transactional
	public void saveOrUpdate(Category category) {
		System.out.println("save or upadte");
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		System.out.println("category is saved***");

	}

	@Transactional
	public void delete(String id) {
		sessionFactory.getCurrentSession().delete(id);

	}

}
