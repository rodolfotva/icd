package com.tva.icd.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tva.icd.model.Category;

@Repository
public class CategoryDapImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		sessionFactory.getCurrentSession().delete(getCategory(categoryId));
	}

	@Override
	public Category updateCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return category;
	}

	@Override
	public Category getCategory(Integer categoryId) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryByGroup(Integer groupId) {
		return sessionFactory.getCurrentSession().createQuery("from Category where groupId = :groupId").setParameter("groupId", groupId).list();

	}

	@Override
	public List<Category> getCategoryLike(String column, String value) {
		Criteria query = sessionFactory.getCurrentSession().createCriteria(Category.class);
		query.add(Restrictions.like(column, value, MatchMode.ANYWHERE));
		List<Category> resultList = query.list();
		return resultList;
	}
}
