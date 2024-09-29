package com.SpringSecurityDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.SpringSecurityDemo.entity.User;
import com.SpringSecurityDemo.repo.UserRepo;

@RestController
@RequestMapping("/")

public class UserController {

	@Autowired
	UserRepo exit;

	@PreAuthorize("hasRole('UserDolly')")
	@GetMapping("/users")
	public List<User> getuser() {
		return exit.findAll();
	}

	@PreAuthorize("hasRole('UserDolly')")
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		return exit.findById(id).orElse(null);
	}

	@PreAuthorize("hasRole('AdminMinnu')")
	@PostMapping("/users/add")
	public User getadd(@RequestBody User obj) {
		return exit.save(obj);
	}

	@PreAuthorize("hasRole('AdminMinnu')")

	@PutMapping("/users/{id}")
	public User getUpdate(@PathVariable int id, @RequestBody User obj) {
		User newuser = exit.findById(id).orElse(null);
		newuser.setName(obj.getName());
		return exit.save(newuser);
	}

	@PreAuthorize("hasRole('AdminMinnu')")

	@DeleteMapping("/users/{id}")
	public void getdelete(@PathVariable int id) {
		User obj = exit.findById(id).orElse(null);
		exit.delete(obj);

	}
}
