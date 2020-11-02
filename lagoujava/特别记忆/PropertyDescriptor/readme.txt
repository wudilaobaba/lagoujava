Student student = new Student();
student.setAge(1);
student.setId(1);
student.setName("Mike");

//相当于保留该类Student.class中name属性的get/set方法
PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", Student.class);
Method getMethod = propertyDescriptor.getReadMethod();//获取该类name的get方法
Method setMethod = propertyDescriptor.getWriteMethod();//获取该类name的set方法
String name = (String)getMethod.invoke(student, null);
System.out.println(name);