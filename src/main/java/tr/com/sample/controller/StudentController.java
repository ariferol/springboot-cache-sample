package tr.com.sample.controller;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;
import tr.com.sample.common.base.IBaseRestController;
import tr.com.sample.common.base.ResponseDTO;
import tr.com.sample.entity.Student;
import tr.com.sample.service.StudentService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/student")
public class StudentController implements IBaseRestController {
    private final StudentService studentService;
    private final CacheManager cacheManager;

    public StudentController(StudentService studentService, CacheManager cacheManager) {
        this.studentService = studentService;
        this.cacheManager = cacheManager;
    }

    @GetMapping("clearAllCaches")
    public ResponseDTO<?> clearAllCaches() {
        cacheManager.getCacheNames().stream()
                .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
        return ResponseDTO.Builder.newInstance()
                .data("Tum cacheler temizlendi")
                .description("Tum cacheler temizlendi")
                .build();
    }

    @PostMapping("/addStudent")
    public ResponseDTO<?> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.addNewStudent(student);
        return ResponseDTO.Builder.newInstance()
                .data(newStudent)
                .description(newStudent.getId() + " id li kullanici basariyla eklendi.")
                .build();
    }

    @GetMapping("/find/{id}")
    public ResponseDTO<?> findStudentById(@PathVariable int id) {
        Student findStudent = studentService.findStudentById(id);
        return ResponseDTO.Builder.newInstance()
                .data(findStudent)
                .description(findStudent != null ? "1 adet kayıt bulundu.": " Kayıt bulunamadı!")
                .build();
    }

    @PutMapping("/updateStudent")
    public ResponseDTO<?> updateStudent(@RequestBody Student student) {
        return ResponseDTO.Builder.newInstance()
                .data(studentService.updateStudent(student))
                .description("Kayıt başarıyla guncellendi.")
                .build();
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseDTO<?> deleteStudent(@PathVariable int id) {
        return ResponseDTO.Builder.newInstance()
                .data(studentService.deleteStudent(id))
                .description(id + "li kayıt başarıyla silindi.")
                .build();
    }

    @GetMapping("/name/{name}")
    public ResponseDTO<?> getName(@PathVariable("name") String name) {
        Student student = studentService.getStudentName(name);
        String returnMsg = "Kullanici " + (student != null && student.getId() != null ? "bulundu." : "bulunamadı!");
        return ResponseDTO.Builder.newInstance()
                .data(student)
                .description(returnMsg)
                .build();
    }
}
