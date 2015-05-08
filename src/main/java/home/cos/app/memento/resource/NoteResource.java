package home.cos.app.memento.resource;


import home.cos.app.memento.model.Note;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("note")
public class NoteResource {

	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public Note getNote()
	{
		Note note = new Note();
		note.setContent("test - mock storage");
		
		return note;
	}
}
