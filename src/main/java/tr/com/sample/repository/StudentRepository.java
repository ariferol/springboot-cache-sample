    package tr.com.sample.repository;

    import org.springframework.stereotype.Repository;
    import tr.com.sample.common.base.IBaseRepository;
    import tr.com.sample.entity.Student;

    @Repository
    public interface StudentRepository extends IBaseRepository<Student,Integer> {

        Student findStudentByName(String name);

    }
