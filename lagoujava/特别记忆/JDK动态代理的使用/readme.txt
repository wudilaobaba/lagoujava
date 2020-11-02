public class TestProjex {
    /**
     * JDK动态代理
     * @param mapperClass 接口A的Class
     * @return 返回接口A的实例
     * 使用方式:
     * TestProjex testProjx = new TestProjex();
     * Iinterface iInterface = testProjx.getMapper(Iinterface.class);//返回接口Iinterface的实例
     * String str = iInterface.interfaceMethod(1,2,3); //本例子中返回了String
     */
    public <T> T getMapper(Class<?> mapperClass) {
        //使用JDK动态代理来为DAO接口生成代理对象，并返回
        Object proxyInstance = Proxy.newProxyInstance(TestProjex.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            /**
             * 当接口A的实例调用了接口A的方法，就会执行invoke方法Fun
             * @param proxy 不要使用
             * @param method 方法Fun
             * @param args 方法Fun的参数列表
             * @return 返回值自行定义
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //接口全路径
                String className = method.getDeclaringClass().getName();

                //接口中的某个方法名
                String methodName = method.getName();

                //接口中的某个方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();

                //接口中的某个方法的返回值是否有泛型
                boolean xx = genericReturnType instanceof ParameterizedType;

                return "你好吗？";
            }
        });
        return (T) proxyInstance;
    }
}
