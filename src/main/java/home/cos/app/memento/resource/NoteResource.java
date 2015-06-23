package home.cos.app.memento.resource;

import java.util.List;

import home.cos.app.memento.dao.NoteDAO;
import home.cos.app.memento.model.Note;
import home.cos.app.memento.model.Tag;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("note")
public class NoteResource {

	NoteDAO noteDAO = new NoteDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Note> getNote(@QueryParam("tag") String tagName) {
		
		
		List<Note> notes = noteDAO.getNoteByTag(tagName);
		return notes;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON})
	public void createNote(Note note) {
		noteDAO.create(note);
	}
}
