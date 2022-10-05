package com.test.customs_dragger2;

//依赖注册的标准
public interface MembersInjector<T> {
  void injectMembers(T instance);
}
