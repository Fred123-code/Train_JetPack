package com.test.dagger2.example2.apt_create_dragger2;

import com.test.customs_dragger2.Factory;
import com.test.customs_dragger2.Preconditions;
import com.test.dagger2.example2.Student;
import com.test.dagger2.example2.StudentModule;
//@Module @Provide
public final class StudentModule_GetStudentFactory implements Factory<Student> {
  private StudentModule studentModule;

  public StudentModule_GetStudentFactory(StudentModule studentModule) {
    this.studentModule = studentModule;
  }

  @Override
  public Student get() {
    return Preconditions.checkNotNull(studentModule.getStudent(),"无法得到");
  }

  public static StudentModule_GetStudentFactory create(StudentModule module) {
    return new StudentModule_GetStudentFactory(module);
  }

  public static Student getStudent(StudentModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.getStudent());
  }
}
