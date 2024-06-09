package tr.com.sample.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import tr.com.sample.common.base.IBaseEntity;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student implements IBaseEntity<Integer> , Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 150)
    private String name;

    @Size(max = 150)
    private String surname;

    @NotNull
    @Size(max = 15)
    private String mobile;

    @NotNull
    @Column(columnDefinition = "char(1) default 'N'")
    private Character active;
}
