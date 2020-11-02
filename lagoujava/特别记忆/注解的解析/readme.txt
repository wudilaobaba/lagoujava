以下是注解的定义 ：
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE,ElementType.METHOD})//将注解使用在哪里，这里我们可以使用在类上面 和 方法上面 和 字段上面
  public @interface Service {
      String value() default "";
  }
以下是注解的解析：
  该注解如果放在了类上:
    Service service = cls.getAnnotation(Service.class);
    service.xxx();//获取当前注解中xxx属性的值
    Boolean bool = A.isAnnotationPresent(B.class); //B类型的注解是否在A类上。

  该注解如果放在了字段上:
    Service service = field.getAnnotation(Service.class);
    Boolean bool = field.isAnnotationPresent(Service.class) //Service注解是否在字段field上。

Field[] fields = cls.getDeclaredFields();//cls类中的所有字段
