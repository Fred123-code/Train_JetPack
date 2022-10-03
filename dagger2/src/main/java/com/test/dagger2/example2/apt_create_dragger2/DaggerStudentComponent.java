package com.test.dagger2.example2.apt_create_dragger2;

import com.test.customs_dragger2.Preconditions;
import com.test.dagger2.example2.MainActivity2;
import com.test.dagger2.example2.StudentComponent;
import com.test.dagger2.example2.StudentModule;
//@Component
public class DaggerStudentComponent {
    private DaggerStudentComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static StudentComponent create() {
        return new Builder().build();
    }

    public static final class Builder {
        private StudentModule studentModule;

        private Builder() {
        }

        public Builder studentModule(StudentModule studentModule) {
            this.studentModule = Preconditions.checkNotNull(studentModule);
            return this;
        }

        public StudentComponent build() {
            if (studentModule == null) {
                this.studentModule = new StudentModule();
            }
            return new StudentComponentImpl(studentModule);
        }
    }

    private static final class StudentComponentImpl implements StudentComponent {
        private final StudentModule studentModule;

        private final StudentComponentImpl studentComponentImpl = this;

        private StudentComponentImpl(StudentModule studentModuleParam) {
            this.studentModule = studentModuleParam;

        }

        @Override
        public void injetMainActivity(MainActivity2 activity) {
            injectMainActivity2(activity);
        }

        private MainActivity2 injectMainActivity2(MainActivity2 instance) {
            MainActivity2_MembersInjector.injectStudent(instance, StudentModule_GetStudentFactory.getStudent(studentModule));
            MainActivity2_MembersInjector.injectStudent2(instance, StudentModule_GetStudentFactory.getStudent(studentModule));
            return instance;
        }
    }
}
