package com.nienluancoso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nienluancoso.dto.ClassDTO;
import com.nienluancoso.dto.pagination.ClassOutput;
import com.nienluancoso.service.ClassService;

@RestController
@CrossOrigin
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@PostMapping("/classroom/create")
	public void create_update(@RequestBody ClassDTO classDTO) {
		classService.save(classDTO);
		return;
	}
	
	@PostMapping("/classroom/get-classrooms")
	public List<ClassDTO> getClassroomsByTeacherId(@RequestBody Long teacher_id,
						@RequestParam(value = "name", defaultValue = "none") String name) 
	{
		List<ClassDTO> classrooms = new ArrayList<>();
		if (!name.equals("none")) {
			classrooms = classService.findByTeacheridAndName(teacher_id, name);
		} else {
			classrooms = classService.findByTeacherid(teacher_id);			
		}
		return classrooms;
	}
	
	@DeleteMapping("/classroom/delete/{id}")
	public void create(@PathVariable Long id) {
		classService.delete(id);
		return;
	}
	
	@GetMapping("/classroom/get-class/{id}")
	public ClassDTO findById(@PathVariable Long id) {
		ClassDTO result = classService.findById(id);
		return result;
	}
	
	@DeleteMapping("/classroom/remove-student")
	public void removeStudent(@RequestParam(value = "class_id") Long class_id,
			@RequestParam(value = "student_id") Long student_id)
	{
		classService.removeStudent(student_id, class_id);
		return;
	}
	
	@GetMapping("/classroom/get-classrooms-by-student/{student_id}")
	public ClassOutput getClassroomsByStudentId(@PathVariable(name = "student_id") Long id,
						@RequestParam(name = "page") int page, @RequestParam(name = "limit") int limit,
						@RequestParam(name = "name", defaultValue = "none") String name) {
		ClassOutput result = new ClassOutput();
		result.setPage(page);
		if (!name.equals("none")) {
			result.setListResult(classService.findByStudentId(id, page - 1, limit, name));
			result.setTotalPage((int) Math.ceil((double) classService.totalItem(id, name) / limit));
		} else {
			result.setListResult(classService.findByStudentId(id, page - 1, limit));
			result.setTotalPage((int) Math.ceil((double) classService.totalItem(id) / limit));
		}
		return result;
	}
	
	@PostMapping("/classroom/join-class/{id_class}/{id_student}")
	public void joinClass(@PathVariable Long id_class, @PathVariable Long id_student) {
		classService.joinClass(id_class, id_student);
	}
	
	@GetMapping("/classroom/get-joined-classes-by-student/{student_id}")
	public List<ClassDTO> findJoinedClassByStudentId(@PathVariable(name = "student_id") Long id) {
		List<ClassDTO> result = classService.findJoinedClassByStudentId(id);
		return result;
	}
	

}
