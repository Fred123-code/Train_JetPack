package com.test.dagger2.example2.apt_create_dragger2;

import com.test.customs_dragger2.MembersInjector;
import com.test.customs_dragger2.Provider;
import com.test.dagger2.example2.MainActivity2;
import com.test.dagger2.example2.Student;


import dagger.internal.InjectedFieldSignature;
//@Inject
public final class MainActivity2_MembersInjector implements MembersInjector<MainActivity2> {
  private final Provider<Student> studentProvider;

  private final Provider<Student> student2Provider;

  public MainActivity2_MembersInjector(Provider<Student> studentProvider,
                                       Provider<Student> student2Provider) {
    this.studentProvider = studentProvider;
    this.student2Provider = student2Provider;
  }

  public static MembersInjector<MainActivity2> create(Provider<Student> studentProvider,
                                                             Provider<Student> student2Provider) {
    return new MainActivity2_MembersInjector(studentProvider, student2Provider);
  }

  @Override
  public void injectMembers(MainActivity2 instance) {
    injectStudent(instance, studentProvider.get());
    injectStudent2(instance, student2Provider.get());
  }

  @InjectedFieldSignature("com.test.dagger2.example2.MainActivity2.student")
  public static void injectStudent(MainActivity2 instance, Student student) {
    instance.student = student;
  }

  @InjectedFieldSignature("com.test.dagger2.example2.MainActivity2.student2")
  public static void injectStudent2(MainActivity2 instance, Student student2) {
    instance.student2 = student2;
  }
}
