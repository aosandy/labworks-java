package lab4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Method[] allMethods = myClass.getClass().getDeclaredMethods();
        List<Method> annotatedMethods = Arrays.stream(allMethods)
                .filter(m -> m.getAnnotation(MyAnnotation.class) != null)
                .collect(Collectors.toList());
        for (Method method : annotatedMethods) {
            try {
                method.setAccessible(true);
                for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                    method.invoke(myClass);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
