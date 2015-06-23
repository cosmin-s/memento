package home.cos.app.memento.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Note {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
		      name="NOTE_TAG",
		      joinColumns={@JoinColumn(name="NOTE_ID", referencedColumnName="ID")},
		      inverseJoinColumns={@JoinColumn(name="TAG_ID", referencedColumnName="ID")})
	
	private List<Tag> tags;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
