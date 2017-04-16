package com.app1;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/student")
class StudentService {

	// add a user
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Student addStudent(@RequestParam(value = "name") String name,
			@RequestParam(value = "subject", defaultValue = "unkown") String subject) {
		Student student = new Student(name, subject);
		BootnrestApplication.hmStudent.put(student.getId(), student);
		return student;
	}

	// This is for obtaining all the students.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<Long, Student> getAllStudents() {
		return BootnrestApplication.hmStudent;
	}

	/*
	 * @RequestMapping(value="/update", method = RequestMethod.PUT) public
	 * Student updateStudent(@RequestBody String jsonText) throws Exception{
	 * if(BootnrestApplication.hmStudent.containsKey(new
	 * Long(student.getId()))){
	 * BootnrestApplication.hmStudent.put(student.getId(),student); }else{ throw
	 * new Exception("Student "+student.getId()+" does not exists"); } return
	 * student; System.out.println(jsonText); return null; }
	 */

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) throws Exception {

		if (BootnrestApplication.hmStudent.containsKey(new Long(student.getId()))) {
			BootnrestApplication.hmStudent.put(student.getId(), student);
		} else {
			throw new Exception("Student " + student.getId() + " does not exists");
		}
		return student;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable long id) {
		return BootnrestApplication.hmStudent.get(id);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Student deleteStudent(@PathVariable long id) throws Exception {

		Student student;

		if (BootnrestApplication.hmStudent.containsKey(id)) {
			student = BootnrestApplication.hmStudent.get(id);
			BootnrestApplication.hmStudent.remove(id);
		} else {
			throw new Exception("Student " + id + " does not exists");
		}
		return student;
	}
}
