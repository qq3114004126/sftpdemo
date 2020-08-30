package com.example.sftp.sftpservice.pojo;

import lombok.Data;
import org.elasticsearch.client.ml.EvaluateDataFrameRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Data
public class JavaListUtil {

    private static final Logger LOG = LoggerFactory.getLogger(JavaListUtil.class);


    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<Student>();
        Date date01 = new Date(2014-1900, 6-1, 12);
        Student stu1 = new Student(03,"lihua",170,date01,"河南");
        Student stu2 = new Student(01,"liuxing",180,date01,"河南");
        Student stu3 = new Student(02,"wangdahai",176,date01,"河南");
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);
        Collections.sort(stuList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = o1.getHeight()- o2.getHeight();

                return num;
            }
        });
        System.out.println(stuList);
        stuList.forEach(vo->{
//            for (Student stu:stuList) {
//                vo.getSid().compareTo(stu.getSid());
//            }
            stuList.forEach(v1->{
                if (vo.getSid()==v1.getSid()) {
                    Integer height = v1.getHeight();
                }
            });

        });


    }


}



class  Student{
    private Integer sid;
    private String name;
    private Integer height;
    private Date birth;
    private String birthPlace;

    public Student(Integer sid, String name, Integer height, Date birth, String birthPlace) {
        this.sid = sid;
        this.name = name;
        this.height = height;
        this.birth = birth;
        this.birthPlace = birthPlace;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getSid(), student.getSid()) &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getHeight(), student.getHeight()) &&
                Objects.equals(getBirth(), student.getBirth()) &&
                Objects.equals(getBirthPlace(), student.getBirthPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSid(), getName(), getHeight(), getBirth(), getBirthPlace());
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", birth=" + birth +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }

    public Student() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


}
