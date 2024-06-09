package tr.com.sample.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tr.com.sample.entity.Student;
import tr.com.sample.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Cacheable(cacheNames = {"students"}, key = "#id")
    public Student findStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.isPresent() ? student.get() : null;
    }

    @CachePut(cacheNames = "students", key = "#student.id")
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @CacheEvict(cacheNames = {"students"}, key = "#id")
    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Kayit basariyla silindi.";
    }

    @Cacheable(cacheNames = "students" , key = "#name")
    public Student getStudentName(String name) {
        Student student = studentRepository.findStudentByName(name);
//        return student != null ? student : new Student();
        return student;
    }
}
