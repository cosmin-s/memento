package home.cos.app.memento.dao;

import java.util.ArrayList;
import java.util.List;

import home.cos.app.memento.model.Note;
import home.cos.app.memento.model.Tag;
import home.cos.app.memento.util.PersistenceHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class NoteDAO {

	EntityManagerFactory emf;

	public NoteDAO() {
		emf = PersistenceHelper.getEntityManagerFactory();
	}

	public void create(Note note) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();

			List<Tag> newTags = new ArrayList<Tag>();
			for (Tag tag : note.getTags()) {
				List<Tag> tags = getTagByName(tag.getName());
				if (tags == null || tags.size() == 0) {
					newTags.add(tag);
				} else {
					Tag newTag = em
							.getReference(Tag.class, tags.get(0).getId());
					newTags.add(newTag);
				}
			}
			note.setTags(newTags);
			em.persist(note);

			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	public List<Note> getNoteByTag(String tag) {
		EntityManager em = emf.createEntityManager();
		List<Note> notes;
		try {
			Query q = em.createQuery("SELECT n FROM Note n JOIN n.tags t WHERE t.name = :tag").setParameter("tag",
																tag);
			notes = q.getResultList();
		} finally {
			em.close();
		}
		return notes;
	}

	public List<Tag> getTagByName(String name) {
		EntityManager em = emf.createEntityManager();
		List<Tag> tags;
		try {
			Query q = em
					.createQuery("SELECT t FROM Tag t WHERE t.name=:name  ")
					.setParameter("name", name);
			tags = q.getResultList();
		} finally {
			em.close();
		}
		return tags;
	}

}
