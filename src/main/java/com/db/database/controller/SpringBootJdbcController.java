package com.db.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.database.entity.Change;
import com.db.database.entity.Task;

@Controller
public class SpringBootJdbcController {
	
	@Autowired
	JdbcTemplate jdbc;
	

	@RequestMapping("/insert")
	public String index()
	{
//		jdbc.execute("insert into books(title,author, price)values('bestBook1','Arnav Prabhale', 300)");  
//		return "data inserted Successfully";
		
		String sql = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
        int result = jdbc.update(sql, "Head First Java", "Kathy Sierra", 18.55f);
         
        if (result > 0) {
            return "Insert successfully.";
        } 
        
        return "Failed";
	}
	
	@GetMapping("/page")
	public String homePage(Model model)
	{
		System.out.println("Inside homepage function");
		model.addAttribute("taskInfo", new Task());
		return "home";
	}
	
	@GetMapping("/view")
	public String list(Model model)
	{
		System.out.println("Inside list function");
		String sql = "SELECT * FROM tasks";
	     
	    List<Task> listTask = jdbc.query(sql,
	                BeanPropertyRowMapper.newInstance(Task.class));
	     
//	    for (Task task : listTask) {
//	        System.out.println(task);
//	    }
	    model.addAttribute("list", listTask);
//	    model.addAttribute("change", new Change());
		return "index";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute("taskInfo") Task task)
	{
		System.out.println("Add function called");
		System.out.println(task);
		
		String sql = "INSERT INTO tasks (task, priority, duration, assigne, status) VALUES (?, ?, ?, ?, ?)";
        int result = jdbc.update(sql, task.getTask(), task.getPriority(),
        		task.getDuration(), task.getAssigne(), task.getStatus());
         
        if (result > 0) {
            return "home";
        } 
        
        return "view";
		
		
	}
	
	@GetMapping("/delete")
	public String deleteTask(@RequestParam String id,Model model)
	{
		
		System.out.println("the delete id of the button clicked is " + id);
		String sql = "DELETE FROM tasks WHERE id=" + id;
		int result = jdbc.update(sql);
		 
		if (result > 0) {
		    System.out.println("Delete successfully.");
		}
		return list(model);
		 
	}
	@GetMapping("/update")
	public String updateTask(@RequestParam String id, Model model)
	{
		
		System.out.println("the update id of the button clicked is " + id);
		String sql = "SELECT * FROM tasks WHERE id=" + id;
	     
	    List<Task> task = jdbc.query(sql,
	                BeanPropertyRowMapper.newInstance(Task.class));
	    System.out.println(task);

	    model.addAttribute("t", task);
		
		
		return "udp"; 
	}


	@PostMapping("/updateConfirm")
	public String updateConfirmation(@ModelAttribute("taskInfo") Task task, Model model)
	{
		System.out.println("updation successful "+ task);
		String sql = "UPDATE tasks SET priority=?, duration=?, assigne=?, status=? WHERE id=?";
	    Object[] params = {task.getPriority(), task.getDuration(), task.getAssigne(), task.getStatus(), task.getId()};
	    int result = jdbc.update(sql, params);
	     
	    if (result > 0) {
	        System.out.println("Update successfully.");
	    }
		return list(model);
		
	}
	
	@PostMapping("/error")
	public String error() {
	System.out.println("An error occured");
	
		return "page";
	}
}












