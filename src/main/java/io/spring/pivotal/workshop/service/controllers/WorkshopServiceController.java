package io.spring.pivotal.workshop.service.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.spring.pivotal.workshop.service.domain.Content;
import io.spring.pivotal.workshop.service.domain.Workshop;
import io.spring.pivotal.workshop.service.domain.Workshop.Session.Topic;
import io.spring.pivotal.workshop.service.repositories.ContentRepository;

@Configuration
@EnableAutoConfiguration
@RestController
public class WorkshopServiceController {

	@Autowired
	ContentRepository repository;
	
	@Autowired
	Workshop workshop;
		
	HashMap<String, Workshop.Session> workshopSessions = new HashMap<String, Workshop.Session>();
		
	@PostConstruct
	public void initd() throws Exception {
		//cacheEnablementContent();		
	}
	
	@RequestMapping("/workshop")
	public WorkshopDetails workshop() {

		WorkshopDetails w = new WorkshopDetails(workshop.getTitle(), workshop.getDescription(), workshop.getDate(), workshop.getCustomerLogo(), workshop.getContentURL());

		return w;
	}
	
	@RequestMapping("/workshopSessions")
	public Iterable<Workshop.Session> workshopSessions() {
		
		cacheEnablementContent();
		
		ArrayList<Workshop.Session> ws = new ArrayList<Workshop.Session>();

		for (String key : workshopSessions.keySet()) {
			ws.add(0,workshopSessions.get(key));
		}
		
		return ws;
	}
	
	@RequestMapping("/content")
	public Iterable<Content> content() {
		return repository.findAll();
	}
	
	@RequestMapping("/instructor")
	public List<Workshop.Instructor> instructor() {
		return workshop.getInstructors();
	}
	
	@RequestMapping("/resources")
	public List<Workshop.Resource> resources() {
		return workshop.getResources();
	}
	
	@RequestMapping("/dailyContent")
	public Workshop.Session dailyContent(@RequestParam(value="id", defaultValue="0") String id) {
		return workshopSessions.get(id);
	}
	
	private void cacheEnablementContent() {
		HashMap<String, Content> enablementHash = new HashMap<String, Content>();
		
	    Iterable<Content> enablementContent = repository.findAll();
	    
	    Iterator<Content> it = enablementContent.iterator();
	    if (it != null) {
	    	while(it.hasNext()) {
	            Content c = it.next();
	            enablementHash.put(c.getCourseID(),  c);
	            System.out.println(" #### data from table = " + c);
	     	}
	    }    
	    
		List<io.spring.pivotal.workshop.service.domain.Workshop.Session> s = workshop.getSessions();
		
		for (io.spring.pivotal.workshop.service.domain.Workshop.Session s1 : s) {	
			System.out.println("#### s.desc=" + s1.getDescription());
			System.out.println("#### s.id=" + s1.getId());
			
			workshopSessions.put(s1.getId(),s1);	
		}
	    
	    for (String key : workshopSessions.keySet())
	    {
	    	if (enablementHash.size() > 0) {
	    		
	    		workshopSessions.get(key).getTopics();
	    		
				for (Topic topic: workshopSessions.get(key).getTopics()) {
					
					System.out.println("topic id " + topic.getId());
					Content content = enablementHash.get(topic.getId());
					
					System.out.println("#### content = " + content);
					
					if (content == null) {
						for (String s1 : enablementHash.keySet())
						{
							System.out.println("^^^^^ key from enablement =" + s1 + "^^^^^match=" + topic.getId() +"^^^" );
						}
					}
					
					if (content != null) {
						if (StringUtils.isEmpty(topic.getTitle())) {
							topic.setTitle(content.getTitle());
						}
						
						if (StringUtils.isEmpty(topic.getDescription())) {
							topic.setDescription(content.getDescription());
						}
						
						if (StringUtils.isEmpty(topic.getSlideURL())) {
							if (!StringUtils.isEmpty(content.getSlideURL())) {
								topic.setSlideURL(workshop.getContentURL() + "/" + content.getSlideURL());
							}
						}
						
						if (StringUtils.isEmpty(topic.getLabURL())) {
							if (!StringUtils.isEmpty(content.getLabURL())) {
								topic.setLabURL(workshop.getContentURL() + "/" + content.getLabURL());
							}
						}
					}
				}
			}
	    }
	}


	class WorkshopDetails {

		private String title;
		private String description;
		private String date;
		private String customerLogo;
		private String contentURL;

		public WorkshopDetails(String title, String description, String date, String customerLogo, String contentURL) {
			this.title = title;
			this.date = date;
			this.customerLogo = customerLogo;
			this.description = description;
			this.contentURL = contentURL;
		}

		public WorkshopDetails() {
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

	}

	}