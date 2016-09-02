package io.spring.pivotal.workshop.service.domain;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "workshop")
@Component
public class Workshop {
	
	private String title;
	private String description;
	private String date;
	private String customerLogo;
	private String contentURL;
	private List<Resource> resources;
	private List<Instructor> instructors;
	private List<Session> sessions;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerLogo() {
		return customerLogo;
	}

	public void setCustomerLogo(String customerLogo) {
		this.customerLogo = customerLogo;
	}
	
	public String getContentURL() {
		return contentURL;
	}

	public void setContentURL(String contentURL) {
		this.contentURL = contentURL;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public static class Resource {

		private String title;
		private String url;

		public Resource(String title, String url) {
			this.title = title;
			this.url = url;
		}

		public Resource() {
		}


		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

	public static class Instructor {

		private String name;
		private String title;
		private String phone;
		private String email;

		public Instructor(String name, String title, String phone, String email) {
			this.name = name;
			this.title = title;
			this.phone = phone;
			this.email = email;
		}

		public Instructor() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

	public static class Session {

		private String id;
		private String name;
		private String description;
		private List<Topic> topics;

		public Session(String id, String name, String description) {
			this.id = id;
			this.name = name;
			this.description = description;
		}

		public Session() {
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Topic> getTopics() {
			return topics;
		}

		public void setTopics(List<Topic> topics) {
			this.topics = topics;
		}

		public static class Topic {

			private String id;
			private String title;
			private String description;
			private String slideURL;
			private String labURL;

			public Topic() {
			}

			public Topic(String id, String title, String description, String slideURL, String labURL) {
				super();
				this.id = id;
				this.title = title;
				this.description = description;
				this.slideURL = slideURL;
				this.labURL = labURL;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public String getSlideURL() {
				return slideURL;
			}

			public void setSlideURL(String slideURL) {
				this.slideURL = slideURL;
			}

			public String getLabURL() {
				return labURL;
			}

			public void setLabURL(String labURL) {
				this.labURL = labURL;
			}

		}

	}

}
